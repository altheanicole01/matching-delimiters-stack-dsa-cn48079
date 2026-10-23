# Stack-Based Delimiter Checker

A Java program that uses a stack to determine whether a sequence of delimiters is properly matched.

The program supports the following delimiter pairs:

- `( )`
- `[ ]`
- `{ }`

It processes the input from left to right, displays the stack operation performed for each character, and determines whether the sequence is **Valid** or **Invalid**.

## Features

- Accepts a sequence of characters from the user
- Uses `java.util.Stack` to check delimiter matching
- Recognizes `()`, `[]`, and `{}`
- Displays a step-by-step stack trace
- Shows `PUSH`, `PEEK`, `POP`, and `INVALID` operations
- Displays the reason when the sequence is invalid
- Rejects improperly nested delimiters

## How It Works

1. Every opening delimiter — `(`, `[`, or `{` — is pushed onto the stack.
2. Every closing delimiter — `)`, `]`, or `}` — is checked against the top of the stack using `peek()`.
3. If the closing delimiter matches the top opening delimiter, the opening delimiter is removed using `pop()`.
4. If the stack is empty when a closing delimiter appears, the sequence is invalid.
5. If the closing delimiter does not match the top opening delimiter, the sequence is invalid.
6. If opening delimiters remain after processing the entire input, the sequence is invalid.

## Requirements

- Java Development Kit (JDK) 8 or higher
- A terminal or command prompt

## How to Compile and Run

1. Save the program as:

```text
DelimiterChecker.java
```

2. Compile the program:

```bash
javac DelimiterChecker.java
```

3. Run the program:

```bash
java DelimiterChecker
```

4. Enter a sequence of delimiters when prompted.

## Example: Valid Input

```text
Enter a sequence of delimiters: {[()]}

Stack Trace:
Read: {
Operation: PUSH {
Stack: {
Read: [
Operation: PUSH [
Stack: { [
Read: (
Operation: PUSH (
Stack: { [ (
Read: )
Operation: PEEK -> (
Operation: POP (
Stack: { [
Read: ]
Operation: PEEK -> [
Operation: POP [
Stack: {
Read: }
Operation: PEEK -> {
Operation: POP {
Stack: (empty)

Valid
```

## Example: Invalid Input

```text
Enter a sequence of delimiters: {[(])}

Stack Trace:
Read: {
Operation: PUSH {
Stack: {
Read: [
Operation: PUSH [
Stack: { [
Read: (
Operation: PUSH (
Stack: { [ (
Read: ]
Operation: PEEK -> (
Operation: INVALID
Reason: mismatched delimiters

Invalid
```

## Invalid Cases

The program rejects a sequence when:

- A closing delimiter has no matching opening delimiter
- The closing delimiter does not match the opening delimiter at the top of the stack
- An opening delimiter remains unmatched after the entire sequence is processed

## AI Disclosure

Generative AI was used to assist in developing and formatting this program.

- **AI Tool Used:** Perplexity
- **Purpose:** Drafted, modified, and explained the Java stack-based delimiter checker, including the stack trace output and README documentation.
- **Prompt Used:** “Draft a Java program that uses a stack to determine whether a sequence of (), [], and {} delimiters is properly matched. Modify it so that it displays the stack operation performed while processing the input, including the character being examined, PUSH, PEEK, POP, or INVALID operations, the current contents of the stack, and the reason when an invalid sequence is detected.”
- **AI Contribution:** The AI provided the initial program structure, stack-checking logic, trace-output format, and README layout.
- **Human Contribution:** The program was reviewed, tested, formatted, and adapted for submission. The manual trace and explanation of the invalid sequence `{[(])}` were also verified.

## Author

**Althea Nicole C. Peñaranda**  
BSIT - CN48079  
Data Structures and Algorithms
