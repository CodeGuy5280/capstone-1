# 💰 Account Ledger CLI Application

This Java-based **Account Ledger** is a command-line application that allows users to record and track financial transactions such as **deposits** and **payments**, and view summaries and reports based on those transactions.

Built in Java, the app uses:
- `ArrayList<Transaction>` to store data in memory
- CSV file for persistent storage
- Java `LocalDate` and `LocalTime` for timestamping
- Robust input validation and formatting

---

## 🚀 Features

- 📥 **Add Deposits**  
  Enter a positive amount to record income transactions in a CSV.

- 📤 **Add Payments**  
  Enter a negative amount to record outgoing payments or expenses.

- 📜 **View Ledger**  
  - View all transactions  
  - Filter by **deposits** or **payments**  
  - View **summary reports** (coming soon)

- 📊 **Current Balance**  
  Display a calculated balance based on your ledger entries (hardcoded for now)

- 💾 **Persistent Storage**  
  All transactions are saved to a `transactions.csv` file in your local project directory.

---

## 🧠 How It Works

### Transaction Structure:
Each transaction is saved with the following format:

### Transaction Types:
- **Deposits** → amount > 0  
- **Payments** → amount < 0  
- The app **infers type based on the amount sign**.

---

## 🛠 Technologies Used

- Java 17 Corretto
- Core Java libraries (`java.util`, `java.time`, `java.io`)
- No external dependencies


