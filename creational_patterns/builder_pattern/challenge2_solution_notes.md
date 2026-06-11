# 🛠️ Architectural Breakdown: The Interface Builder pattern

This document details the underlying technical design choices, architectural decoupling, and memory-optimization strategies implemented to solve the Multi-Channel Notification Engine challenge.

---

## 🧠 Core Engineering Principles

### 1. Breaking the Circular Dependency Trap

In naive builder implementations, a classic tight-coupling bug occurs when the target product and the builder interface rely on each other directly:

- **The Vulnerability:** `AlertMessage` takes the `MessageBuilder` interface into its constructor to read its state, while `MessageBuilder` depends on `AlertMessage` as its return type. This creates a circular dependency loop, making components impossible to isolate, test, or reuse independently.
- **The Solution:** We decoupled the constructor of `AlertMessage` completely. It now accepts a raw primitive `String content` payload. It has absolutely zero knowledge of the formatting layer, interfaces, or builder mechanics. It acts as a pure, independent immutable data carrier.

### 2. Eliminating String Allocation Overhead via `StringBuilder`

Using standard `String` variables with the concatenation operator (`+=`) inside a builder introduces two major production flaws:

1. **The Null Concatenation Bug:** If an object `String` is uninitialized, its default state is `null`. Performing `+=` on it causes Java to append literal `"null"` text to the front of your data payload (e.g., `"null<h1>Header</h1>"`).
2. **Memory Inefficiency:** Strings are immutable in Java. Every time you perform `+=`, Java discards the old string and allocates a brand-new string object inside the heap memory pool. In high-throughput banking systems, this creates severe heap fragmentation and triggers frequent Garbage Collection spikes.

- **The Solution:** We utilized `StringBuilder`, which maintains a single, mutable, resizable memory buffer. We initialized it at the class member level (`new StringBuilder()`), completely neutralizing the `null` pointer/text injection vulnerability while keeping memory operations highly efficient.

---

## 🔍 Structural Component Blueprint

The architecture is split into three clean, separate roles according to the **Single Responsibility Principle (SRP)**:

```text
 ┌───────────────────┐
 │  MessageBuilder   │ <─── Interface: Defines the common abstract assembly steps
 └─────────┬─────────┘
           │
     ┌─────┴──────────────────┐
     │                        │
┌────▼─────────────────┐ ┌────▼──────────────────┐
│  SmsMessageBuilder   │ │  HtmlMessageBuilder   │ <─── Concrete Builders: Handle specific string layouts
└────┬─────────────────┘ └────┬──────────────────┘
     │                        │
     └───────────┬────────────┘
                 ▼
        ┌────────────────┐
        │  AlertMessage  │ <─── Final Product: Completely isolated, holds final content
        └────────────────┘
```
