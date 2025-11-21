package dev.amirgolmoradi.atlas.residency_context.lease.domain.model;

import dev.amirgolmoradi.atlas.identity_context.user.domain.value_object.Id;
import dev.amirgolmoradi.atlas.residency_context.apartments.domain.value_object.ApartmentId;
import dev.amirgolmoradi.atlas.residency_context.lease.domain.enums.LeaseStatus;
import dev.amirgolmoradi.atlas.residency_context.lease.domain.enums.PaymentFrequency;
import dev.amirgolmoradi.atlas.residency_context.lease.domain.exception.InvalidLeaseDatesException;
import dev.amirgolmoradi.atlas.residency_context.lease.domain.exception.LeaseStatusException;
import dev.amirgolmoradi.atlas.residency_context.lease.domain.value_object.LeaseId;
import dev.amirgolmoradi.atlas.residency_context.lease.domain.value_object.RentAmount;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Lease {
    private final LeaseId id;
    private final Id tenantId;
    private final ApartmentId apartmentId;
    private LocalDate signedDate;
    private LocalDate expiryDate;
    private LocalDate moveInDate;
    private RentAmount rentAmount;
    private PaymentFrequency paymentFrequency;
    private LeaseStatus status;
    private String pdfUrl;

    private Lease(Id tenantId, ApartmentId apartmentId, RentAmount rentAmount, PaymentFrequency paymentFrequency, LeaseStatus status, String pdfUrl) {
        this.id = LeaseId.generateNew();
        this.tenantId = tenantId;
        this.apartmentId = apartmentId;
        this.signedDate = LocalDate.now();
        this.expiryDate = signedDate.plusYears(1);
        this.moveInDate = signedDate.plusDays(10);
        this.rentAmount = rentAmount;
        this.paymentFrequency = Objects.requireNonNullElse(paymentFrequency, PaymentFrequency.MONTHLY);
        this.status = status;
        this.pdfUrl = Objects.requireNonNullElse(pdfUrl, "No PDF URL specified");

        validateChronologicalDates();

    }


    public static Lease create(long tenantId, long apartmentId, BigDecimal rentAmount, PaymentFrequency initialPaymentFrequency, LeaseStatus status, String pdfUrl) {
        return new Lease(
            Id.of(tenantId),
            ApartmentId.of(apartmentId),
            RentAmount.of(rentAmount),
            initialPaymentFrequency,
            LeaseStatus.ACTIVE,
            pdfUrl
        );
    }

    private void validateChronologicalDates() {
        if (signedDate.isAfter(expiryDate)) {
            throw new InvalidLeaseDatesException("Signed date cannot be after the expiry date.");
        }

        if (moveInDate.isBefore(signedDate)) {
            throw new InvalidLeaseDatesException("Move-in date cannot be before the signed date.");
        }
    }


    // === DOMAIN METHODS (BEHAVIOR) ===


    /**
     * Activates a pending lease, typically after the initial deposit is paid.
     */
    public void activate() {
        switch (status) {
            case TERMINATED:
                throw new LeaseStatusException("Cannot activate a terminated lease.");
            case ACTIVE:
                return;
            case PENDING:
                status = LeaseStatus.ACTIVE;
                return;
            default:
                throw new LeaseStatusException("Lease status cannot be activated from: " + status);

        }
    }

    public void terminate() {
        if (status == LeaseStatus.TERMINATED){
            return;
        }


        status = LeaseStatus.TERMINATED;
    }

    /**
     * Changes the rent amount for renewal or mid-contract amendment.
     */
    public void changeRentAmount (RentAmount newRentAmount) {
        if (status == LeaseStatus.TERMINATED) {
            throw new LeaseStatusException("Cannot change rent on a terminated lease.");
        }
        rentAmount = newRentAmount;
    }


    /**
     * Extends the lease to a new expiry date.
     */
    public void extend(LocalDate newExpiryDate) {
        if (newExpiryDate.isBefore(expiryDate)) {
            throw new InvalidLeaseDatesException("New expiry date must be after the current one.");
        }
        expiryDate = newExpiryDate;
    }

}
