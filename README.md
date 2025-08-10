# SEP-6011-Calci-project
# Sinh(x) Calculator – Java Swing Application

## 📌 Overview
This project is a Java Swing-based GUI application that calculates the **hyperbolic sine (sinh)** of a given value using a manual mathematical approximation (Taylor series expansion).  
It includes:
- **Custom Exception Handling** for invalid inputs
- **Accessible GUI Design** using Java Swing
- **Manual implementation** of `exp(x)`, factorial, and power functions

---

## 🚀 Features
- User-friendly graphical interface with **input validation**
- Computes `sinh(x)` using a Taylor series approximation
- Clear button to reset inputs and results
- Custom error messages for invalid data
- Manual mathematical computation (no reliance on `Math.sinh()`)

---

## 🖥️ GUI Layout
- **Title**: "Sinh(x) Calculator"
- **Input Field**: Enter a numeric value for `x`
- **Buttons**:
  - **Calculate** → Computes `sinh(x)`
  - **Clear** → Resets the input and output
- **Output Area**: Displays the result or error message

---

## 🧮 Formula Used
The hyperbolic sine is computed using:
\[
\sinh(x) = \sum_{n=0}^{\infty} \frac{x^{2n+1}}{(2n+1)!}
\]
The app uses a finite number of terms (default: 10) for approximation.

---

## 🛠️ How to Run
1. **Clone or Download** the repository containing `SinhCalculatorGUI.java`
2. Compile the program:
   ```bash
   javac SinhCalculatorGUI.java
   ```
3. Run the program:
   ```bash
   java SinhCalculatorGUI
   ```

## Technologies Used
- Language: Java (JDK 8+)
- GUI Framework: Swing
- Styling & Quality Checks: Checkstyle (Google Java Style Guide)
- Debugging: JDB (Java Debugger)
- Static Code Analysis: PMD / SonarQube IDE

## Usage
1. Enter a numeric value for x in the input field.
2. Click Calculate to see the computed value of sinh(x).
3. Use Clear to reset input and output fields.

## Code Quality & Tools Used
- Checkstyle: Ensures Google Java Style Guide compliance
- PMD / SonarLint: Static code analysis to detect bugs and code smells
- JDB: Debugging runtime behavior

