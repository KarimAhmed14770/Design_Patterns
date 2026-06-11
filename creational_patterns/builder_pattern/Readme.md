# 🏗️ Creational Pattern: Builder Pattern

## 🎯 Core Purpose
The **Builder Pattern** is a creational design pattern engineered to solve the "Telescoping Constructor" anti-pattern and the safety vulnerabilities of mutable setter methods. It decouples the complex step-by-step assembly of an object from its actual structural representation, allowing the same construction process to create different representations.

---

## ⚖️ The Architectural Problem: Life Without Builder

When an entity grows to have many optional and mandatory fields, developers traditionally rely on two flawed methodologies:

1. **Telescoping Constructors:** Writing multiple overloaded constructors with varying parameter lengths.
   * *The Danger:* Code becomes highly unreadable. Developers easily mix up adjacent arguments of the same type (e.g., swapping `sourceAccountId` and `destinationAccountId`), leading to silent, catastrophic runtime bugs.
2. **JavaBeans Pattern (No-Arg Constructor + Setters):** Instantiating an empty object and filling it via setters.
   * *The Danger:* The object is completely mutable. It can be passed around the application in a half-baked, invalid, or unstable state before all required setters are executed, breaking thread safety entirely.

---

## 🛠️ The Two Architectural Approaches

Depending on the domain requirements, the pattern is implemented in one of two ways:

### 1. The Static Inner Builder (Single Class Implementation)
The builder is nested as a `public static class` directly inside the target domain model. The domain model locks down its constructor to `private`. 
* **Best Used For:** Enforcing ironclad immutability and data encapsulation on uniform domain records where multiple variant formats are not needed.



### 2. The Abstract Interface Approach (Multiple Concrete Builders)
An abstract `Builder` interface defines the operational steps, and multiple concrete classes implement this interface to assemble different variations of a product.
* **Best Used For:** Complex polymorphic objects where the exact same assembly steps must yield different structural outputs (e.g., generating an identical system report in `PdfReport` format vs. `ExcelReport` format).

---

## 🚀 Practical Coding Challenges

To demonstrate mastery over both structural approaches, this module contains hands-on enterprise-grade challenges implemented from scratch (without Lombok framework magic).

### 🏆 Challenge 1: The Immutable Ingestion Engine (Static Inner Approach)
This challenge implements a strict, thread-safe, immutable financial ledger record. It utilizes an internal static gatekeeper to run validation invariants before allowing an object to occupy memory space.
* 📋 [View Challenge 1 Specifications & Business Rules](./Challenge1_specs.md)
* 🛠️ [View Solution Architecture & Deep-Dive Breakdown of challenge 1](./Challenge1_solution.md)
* 📋 [View Challenge 2 Specifications](./Challenge2_specs.md)
* 🛠️ [View Solution notes of challenge 2](./Challenge1_solution.md)
* 💻 [Solution Source Code of challenge 1](./src/main/java/com/karim/builder/FinancialTransaction.java)

### ⏳ Challenge 2: [Coming Soon] (Multiple Builders Interface Approach)
*This section will hold the requirements, specification tickets, and polymorphic interface-driven solutions for variant representations.*
