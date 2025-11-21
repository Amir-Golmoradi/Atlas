package dev.amirgolmoradi.atlas.identity_context.user.domain.model;

import dev.amirgolmoradi.atlas.identity_context.user.domain.value_object.Id;

public class Manager {
    private final Id id;

    public Manager(Id id) {
        this.id = id;
    }


    //TODO: MANAGER IS RESPONSIBLE FOR NOTIFY TENANT FOR BILLINGS.
    //TODO: MANAGER IS RESPONSIBLE FOR NOTIFY TENANT FOR MONTHLY MEETINGS.
    //TODO: MANAGER CAN CHECK AND ACCEPT THE MAINTENANCE PROBLEM


}
