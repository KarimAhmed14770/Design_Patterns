# 📢 Challenge 2: The Multi-Channel Notification Engine

## 📝 The Problem
Our banking app needs to send security alerts to customers whenever a transaction happens. The system collects the exact same information every time: the type of alert, the account number, the amount, and a reference code.

However, we need to format this information differently depending on how the customer wants to receive it:
1. **SMS:** Needs to be short, plain text, and fit on one line to save character limits.
2. **Email:** Needs to be formatted in HTML so it looks nice with headings and bold text in an inbox.

To keep our code clean, the core transaction system shouldn't know anything about HTML tags or SMS text formatting. We need a way to separate the *steps* of making the message from the *actual text format* it produces.

---

## 📋 The Requirements

### 1. The Final Product (`AlertMessage.java`)
* This class represents the final message ready to be sent.
* It must hold a single String called `content`.
* Once this object is made, its `content` cannot be changed (it must be immutable).
* Provide a getter or a `toString()` method so we can print the final text.

### 2. The Blueprint / Interface (`AlertBuilder.java`)
You need to define a common interface that forces all message formats to follow the exact same 4 steps:
1. **Set the Header:** Takes the alert type (e.g., "Fraud Warning").
2. **Set the Body:** Takes the account number and the transaction amount.
3. **Set the Footer:** Takes the reference tracking code.
4. **Get Result:** Returns the finalized `AlertMessage` object.

---

## 📐 The Two Formats You Need to Build

### Format A: The SMS Builder (`SmsAlertBuilder.java`)
This builder must implement the interface and format the text exactly like this on a single line:
* **Header text style:** `[ALERT: <Type>]`
* **Body text style:** `Acc: <AccountNumber> | Amt: <Amount>`
* **Footer text style:** `Ref: <ReferenceCode>`
* *Example of final SMS content:* `[ALERT: Withdrawal] Acc: 12345 | Amt: 500 EGP Ref: TXN999`

### Format B: The Email Builder (`EmailAlertBuilder.java`)
This builder must implement the interface and wrap the text inside HTML tags:
* **Header text style:** `<h1><Type></h1>`
* **Body text style:** `<p>Account: <AccountNumber></p><p>Amount: <Amount></p>`
* **Footer text style:** `<footer>Tracking Code: <ReferenceCode></footer>`

---

## 🎯 Your Task

1. Create the files above in your project folder.
2. Write the code for the product, the interface, and the two concrete builders entirely from scratch.
3. Write a `Main.java` class to test your design:
   * Create one SMS builder and one Email builder.
   * Feed the **exact same data** into both builders sequentially.
   * Print both final messages to verify that one data input generated two completely different text layouts.