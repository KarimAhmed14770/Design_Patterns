# 🏦 Challenge: The Immutable Transaction Engine

You are building the core domain engine for a financial platform. Your task is to implement the `FinancialTransaction` domain model and its internal `Builder` from scratch, ensuring complete data integrity before any object is allowed to exist in memory.

---

## 🛠️ Solution plan:

### 1. The Domain Model (`FinancialTransaction.java`)

- **Strict Immutability:** Every single field must be `private final`.
- **Encapsulation:** No setters allowed, and no public constructors. The only way to instantiate this class is through its builder.
- **Fields to track:**
  - `transactionId` (String) -> **Required**
  - `sourceAccountId` (String) -> **Required**
  - `destinationAccountId` (String) -> **Required**
  - `amount` (BigDecimal) -> **Required** _(Never use double/float for financial calculations)_
  - `currency` (String) -> **Optional** _(Defaults to "EGP")_
  - `unstructuredNotes` (String) -> **Optional** _(Defaults to "N/A")_
  - `isCrossBorder` (boolean) -> **Optional** _(Defaults to false)_

### 2. The Gatekeeper (`Builder` Class)

- Create a nested `public static class Builder` inside `FinancialTransaction`.
- Provide clean, fluent chaining methods to set each property step-by-step.

---

## 🛑 Business Validation Rules

Your `.build()` method must act as the absolute guardian of the domain. It must evaluate the collected state and throw explicit exceptions if any of these rules are violated:

1. **Missing Data Check:** If `transactionId`, `sourceAccountId`, or `destinationAccountId` are null, empty, or contain only whitespace, throw an `IllegalStateException`.
2. **Financial Math Check:** If `amount` is null, or if it is less than or equal to zero, throw an `IllegalArgumentException`.
3. **Cross-Border Compliance Check:** If `isCrossBorder` is set to `true` but the `currency` is set to `"EGP"`, throw an `IllegalStateException` _(Cross-border transactions cannot utilize local currency)_.

---

## 📝 Your Task

1. Go offline and open your IDE.
2. Build `FinancialTransaction.java` with its inner static builder enforcing the rules above entirely from scratch (no Lombok!).
3. Write a `Main.java` class to test your creation:
   - Build a valid local transaction successfully.
   - Attempt to build an invalid transaction (e.g., negative amount or invalid cross-border currency) and use `try-catch` blocks to prove your validation guardrails block it.
