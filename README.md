# Fibonacci Sequence Client-Server Application

**Author:** Julio Lopez  
**Course:** Advanced Java Programming – COP-2805C-34013  
**CRN:** 202430  

---

## 📌 Project Overview

This project is a Java-based client-server application that demonstrates network communication and graphical user interface (GUI) integration. It allows a user to input a positive number and receive the corresponding Fibonacci sequence value, calculated on a server and displayed on the client GUI.

---

## 🛠️ Key Technologies and Concepts

- **Java Sockets:** Used for TCP communication between the client and the server over `localhost`.
- **Multithreading:** The server handles each client request in a separate thread using a `ServerThread` class.
- **Swing GUI:** The client-side uses `JFrame`, `JTextField`, `JButton`, and `JLabel` for interactive input and output.
- **Error Handling:** Handles invalid input (non-integer or negative values) gracefully using `try/catch` blocks.
- **Modular Design:** Organized into separate client and server packages for clarity and maintainability.

---

## ▶️ How It Works

1. The server starts and listens for client connections on port `5050`.
2. The client presents a GUI where the user inputs a number.
3. Upon clicking "Calculate", the number is sent to the server.
4. The server calculates the corresponding Fibonacci value and sends it back.
5. The client displays the result in a label below the button.

> Note: Entering `shutdown` as input will gracefully stop the server.

---

## 🧾 Sample Application Output

![Sample App Screenshot](https://github.com/donlopez/Fibonacci/blob/main/images/FinalProjectOutput.png)

---

## 🧮 Input/Output

- **Expected Input:** A positive integer (e.g., `9`) or the word `shutdown`
- **Expected Output:** The Fibonacci number for the given position (e.g., `34` for `9`), or a shutdown confirmation message

---


---

## ✅ How to Run

1. Compile both `.java` files from the project root:
   ```bash
   javac -d . server/FibonacciServer.java client/FibonacciClient.java
2. In one terminal, run the server:
   ```bash
   java cop2805.FibonacciServer
3. In another terminal, run the client:
   ```bash
   java cop2805.FibonacciClient
