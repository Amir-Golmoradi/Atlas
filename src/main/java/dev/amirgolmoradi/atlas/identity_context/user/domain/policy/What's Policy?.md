باشه، این‌بار دو نسخه جدا می‌دم.
همون بحث Domain Policy، تمیز و قابل‌هضم.
هیچ ترکیب زبانی هم نمی‌کنم.

---

# **English Version**

A Domain Policy is a **domain rule that decides whether an action is allowed or not**, based on the business logic of the bounded context.

It is not validation, not permissions in the infrastructure sense, and not a rule engine.
It is simply a **decision object** inside the domain layer.

There are three common forms:

### 1. **Policy as a simple specification (isSatisfiedBy)**

Used when the rule checks a single entity.

Example:
A user must be 18+ to sign up.

```java
public interface Policy<T> {
    boolean isSatisfiedBy(T subject);
}
```

This keeps rules clean, reusable, and testable.

---

### 2. **Policy as a Domain Service**

Used when the rule involves multiple domain objects.

Example:
A customer can apply for a loan only if:

* they have no active debts
* their credit score is high enough
* their account is not frozen
* the loan type matches their profile

```java
public class LoanEligibilityPolicy {
    public boolean canApply(User user, CreditScore score, LoanType type) {
        return score.value() >= 650
            && !user.hasFrozenAccount()
            && user.noOpenLoans()
            && type.isAllowedFor(user.profile());
    }
}
```

This keeps the aggregate from becoming bloated.

---

### 3. **Policy that controls domain behavior**

Used to check authorization *inside* the domain.

Example:
Only an admin may adjust account balance.

```java
public void changeBalance(User actor, Money amount) {
    if (!balanceChangePolicy.canChange(actor, this)) {
        throw new DomainException("Not allowed");
    }

    this.balance = this.balance.add(amount);
}
```

The aggregate executes the behavior;
the policy decides whether the behavior is allowed.

---

### **What a Policy is NOT**

* Not input validation
* Not business logic calculations
* Not an infrastructure permission check
* Not a rule engine

---

### **One sentence to memorize forever**

**Aggregates perform actions;
Policies decide whether actions are allowed.**

That's the whole point.

---

# **Persian Version**

Domain Policy یعنی **قانون دامنه‌ای که تصمیم می‌گیرد یک رفتار مجاز هست یا نه**.
نه اعتبارسنجی است، نه rule engine، نه logic فنی.
فقط یک شیء تصمیم‌گیر داخل لایه دامنه.

سه حالت معروف دارد:

---

### ۱. **Policy به صورت Specification (isSatisfiedBy)**

وقتی قانون فقط یک موجودیت را بررسی می‌کند.

مثال:
کاربر باید بالای ۱۸ سال باشد.

```java
public interface Policy<T> {
    boolean isSatisfiedBy(T subject);
}
```

تمیز، قابل تست، قابل استفاده دوباره.

---

### ۲. **Policy به عنوان Domain Service**

وقتی قانون نیاز دارد چند موجودیت را بررسی کند.

مثال:
مشتری فقط وقتی می‌تواند وام بگیرد که:

* بدهی فعال ندارد
* امتیاز اعتباری کافی دارد
* حسابش فریز نشده باشد
* نوع وام با پروفایلش سازگار باشد

```java
public class LoanEligibilityPolicy {
    public boolean canApply(User user, CreditScore score, LoanType type) {
        return score.value() >= 650
            && !user.hasFrozenAccount()
            && user.noOpenLoans()
            && type.isAllowedFor(user.profile());
    }
}
```

این‌طوری aggregate چاق و بدشکل نمی‌شود.

---

### ۳. **Policy برای کنترل رفتار دامنه**

وقتی قبل از اجرای رفتار باید چک شود که مجاز است یا نه.

مثال:
فقط مدیر می‌تواند موجودی حساب را تغییر دهد.

```java
public void changeBalance(User actor, Money amount) {
    if (!balanceChangePolicy.canChange(actor, this)) {
        throw new DomainException("Not allowed");
    }

    this.balance = this.balance.add(amount);
}
```

Aggregate رفتار را اجرا می‌کند؛
Policy تصمیم می‌گیرد اجازه دارد یا نه.

---

### **Policy چه چیزی نیست؟**

* اعتبارسنجی ورودی
* منطق محاسباتی
* کنترل دسترسی سطح زیرساخت
* rule engine

---

### **یک جمله طلایی برای همیشه**

**Aggregate رفتار را انجام می‌دهد،
Policy تصمیم می‌گیرد که مجاز است یا نه.**

تمام.
