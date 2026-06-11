# 🏦 Business Requirement: Resilient Ledger Ingestion Engine

## 📊 Context & Objective

You are building the core domain engine for a financial platform. Your task is to implement the `FinancialTransaction` domain model and its internal `Builder` from scratch, ensuring complete data integrity before any object is allowed to exist in memory.

---

## 📋 Core System Invariants

### 1. Data Schema Specs

An Financial transaction record consists of the following attributes:

- **Identification:** Unique Transaction Identifier (Alphanumeric Token) — _Mandatory_
- **Source:** Originating Account Number string — _Mandatory_
- **Destination:** Target Account Number string — _Mandatory_
- **Value:** Absolute financial transaction value — _Mandatory_
- **Currency:** Three-letter ISO banking asset code — _Optional_ (System fallback: `EGP`)
- **Metadata:** Unstructured verification string note — _Optional_ (System fallback: `N/A`)
- **Routing Flag:** Cross-border operational indicator — _Optional_ (System fallback: `false`)

### 2. Operational Rule Guardrails

The domain entity must evaluate incoming states against the following operational compliance frameworks at the exact moment of initialization. If a violation is detected, instantiation must immediately fail before the reference is allocated in application space:

- **Completeness Clause:** transaction id, source account id, and destination account id must be populated. Blank fields, null values, or empty spaces are explicit violations.
- **Financial Precision Clause:** the amount of to be transacted can't be 0 or negative , it must be apositive value.
- **Compliance Routing Clause:** if the transaction is a cross-border transaction currency can't be local, "EGP" currency should not be allowed withing a cross-border transactions.

---

## 🎯 Technical Mandate

- Implement the execution layer from scratch without using secondary processing tools or external boilerplate engines (e.g., Lombok).
- Ensure objects are entirely modification-proof once they clear boundary validation.
- Expose an entry methodology that supports highly expressive, step-by-step configuration.
- Provide a verification suite executing distinct edge cases to prove execution blocks illicit values cleanly via predictable runtime exceptions.
