# Java Control Statements

## Overview

Control statements determine the **flow of execution** of a Java program.

By default, Java executes statements **sequentially** (top to bottom). Control statements allow us to:

- Make decisions
- Repeat tasks
- Change the flow of execution

There are three categories of control statements:

- Selection Statements
- Iteration Statements (Loops)
- Jump Statements

```text
Control Statements
│
├── Selection
│     ├── if
│     ├── if-else
│     ├── else-if
│     ├── Nested if
│     └── switch
│
├── Iteration (Loops)
│     ├── for
│     ├── while
│     └── do-while
│
└── Jump Statements
      ├── break
      ├── continue
      └── return
```

---

# Selection Statements

Selection statements execute different blocks of code based on a condition.

---

# if Statement

Executes a block only if the condition is **true**.

### Syntax

```java
if (condition) {
    // code
}
```

### Example

```java
int age = 20;

if (age >= 18) {
    System.out.println("Eligible to vote");
}
```

Output:

```text
Eligible to vote
```

---

# if-else Statement

Executes one block if the condition is true; otherwise, executes another block.

### Syntax

```java
if (condition) {
    // true block
} else {
    // false block
}
```

### Example

```java
int marks = 45;

if (marks >= 50) {
    System.out.println("Pass");
} else {
    System.out.println("Fail");
}
```

Output:

```text
Fail
```

---

# else-if Ladder

Used when multiple conditions need to be checked.

### Syntax

```java
if (condition1) {

} else if (condition2) {

} else if (condition3) {

} else {

}
```

### Example

```java
int marks = 85;

if (marks >= 90) {
    System.out.println("Grade A");
} else if (marks >= 75) {
    System.out.println("Grade B");
} else if (marks >= 50) {
    System.out.println("Grade C");
} else {
    System.out.println("Fail");
}
```

Output:

```text
Grade B
```

---

# Nested if

An `if` statement inside another `if`.

### Example

```java
int age = 22;
boolean hasLicense = true;

if (age >= 18) {

    if (hasLicense) {
        System.out.println("Can drive");
    }

}
```

Output:

```text
Can drive
```

---

# switch Statement

The `switch` statement selects one block of code from multiple options.

### Syntax

```java
switch (expression) {

    case value1:
        // code
        break;

    case value2:
        // code
        break;

    default:
        // code
}
```

### Example

```java
int day = 3;

switch (day) {

    case 1:
        System.out.println("Monday");
        break;

    case 2:
        System.out.println("Tuesday");
        break;

    case 3:
        System.out.println("Wednesday");
        break;

    default:
        System.out.println("Invalid Day");
}
```

Output:

```text
Wednesday
```

---

# Why break is Needed

Without `break`, execution continues into the next case.

Example:

```java
int day = 1;

switch (day) {

    case 1:
        System.out.println("Monday");

    case 2:
        System.out.println("Tuesday");

    case 3:
        System.out.println("Wednesday");
}
```

Output:

```text
Monday
Tuesday
Wednesday
```

This behavior is called **fall-through**.

---

# Modern Switch Expression (Java 14+)

```java
int day = 2;

switch (day) {
    case 1 -> System.out.println("Monday");
    case 2 -> System.out.println("Tuesday");
    case 3 -> System.out.println("Wednesday");
    default -> System.out.println("Invalid");
}
```

---

# Iteration Statements (Loops)

Loops repeat a block of code multiple times.

Java provides three loops:

- for
- while
- do-while

---

# for Loop

Used when the number of iterations is known.

### Syntax

```java
for (initialization; condition; update) {

    // code
}
```

### Example

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

Output:

```text
1
2
3
4
5
```

---

# Flow of for Loop

```text
Initialization
      │
      ▼
 Condition
   │     │
True   False
 │        │
 ▼        ▼
Body     Exit
 │
 ▼
Update
 │
 └────────────► Condition
```

---

# while Loop

Used when the number of iterations is unknown.

### Syntax

```java
while (condition) {

    // code
}
```

### Example

```java
int i = 1;

while (i <= 5) {

    System.out.println(i);

    i++;
}
```

Output:

```text
1
2
3
4
5
```

---

# Flow of while Loop

```text
Condition
   │
True
   │
   ▼
Loop Body
   │
Update
   │
   └────────► Condition
```

---

# do-while Loop

Executes the loop body **at least once**, even if the condition is false.

### Syntax

```java
do {

    // code

} while (condition);
```

### Example

```java
int i = 1;

do {

    System.out.println(i);

    i++;

} while (i <= 5);
```

Output:

```text
1
2
3
4
5
```

---

# do-while Executes Once

```java
int i = 10;

do {

    System.out.println(i);

} while (i < 5);
```

Output:

```text
10
```

---

# Comparison of Loops

| Feature | for | while | do-while |
|---------|------|--------|-----------|
| Condition Checked | Before | Before | After |
| Executes At Least Once | ❌ | ❌ | ✅ |
| Best For | Known iterations | Unknown iterations | Menu-driven programs |

---

# Nested Loops

A loop inside another loop.

Example:

```java
for (int i = 1; i <= 3; i++) {

    for (int j = 1; j <= 3; j++) {

        System.out.print("* ");
    }

    System.out.println();
}
```

Output:

```text
* * *
* * *
* * *
```

---

# Jump Statements

Jump statements change the normal flow of execution.

They are:

- break
- continue
- return

---

# break Statement

Immediately exits the loop or switch.

Example:

```java
for (int i = 1; i <= 10; i++) {

    if (i == 5) {
        break;
    }

    System.out.println(i);
}
```

Output:

```text
1
2
3
4
```

---

# break in switch

```java
int day = 1;

switch (day) {

    case 1:
        System.out.println("Monday");
        break;

    case 2:
        System.out.println("Tuesday");
}
```

Output:

```text
Monday
```

---

# continue Statement

Skips the current iteration and moves to the next iteration.

Example:

```java
for (int i = 1; i <= 5; i++) {

    if (i == 3) {
        continue;
    }

    System.out.println(i);
}
```

Output:

```text
1
2
4
5
```

---

# return Statement

Terminates a method and optionally returns a value.

Example:

```java
public static int square(int number) {

    return number * number;
}
```

Usage:

```java
System.out.println(square(5));
```

Output:

```text
25
```

---

# Difference Between break, continue, and return

| Statement | Purpose |
|-----------|----------|
| break | Exits the loop or switch |
| continue | Skips the current iteration |
| return | Exits the current method |

---

# Best Practices

- Use `if` for simple decision-making.
- Use `switch` when checking multiple fixed values.
- Use `for` when the number of iterations is known.
- Use `while` when iterations depend on a condition.
- Use `do-while` when the loop must execute at least once.
- Avoid excessive nested loops and nested `if` statements.
- Use `break` and `continue` sparingly to keep code readable.

---

# Interview Questions

## 1. What are control statements?

Control statements determine the flow of execution of a Java program.

---

## 2. What is the difference between `if` and `switch`?

| if | switch |
|----|---------|
| Can evaluate complex conditions | Compares a single expression against multiple constant values |
| Supports relational and logical operators | Uses `case` labels |
| More flexible | Better readability for fixed choices |

---

## 3. Difference between `for`, `while`, and `do-while`?

| for | while | do-while |
|------|--------|-----------|
| Known iterations | Unknown iterations | Executes at least once |

---

## 4. What is fall-through in a switch statement?

If `break` is omitted, execution continues into the next `case`. This behavior is called **fall-through**.

---

## 5. What is the difference between `break` and `continue`?

- `break` exits the loop or switch completely.
- `continue` skips the current iteration and proceeds with the next one.

---

## 6. What does the `return` statement do?

The `return` statement exits a method and can optionally return a value to the caller.

---

## 7. Which loop always executes at least once?

The **do-while** loop.

---

# Quick Revision

## Selection Statements

- `if`
- `if-else`
- `else-if`
- `Nested if`
- `switch`

---

## Iteration Statements

- `for`
- `while`
- `do-while`

---

## Jump Statements

- `break`
- `continue`
- `return`

---

## Loop Selection

- **for** → Known number of iterations
- **while** → Unknown number of iterations
- **do-while** → Must execute at least once

---

# One-Line Summary

> **Control statements determine the flow of a Java program by making decisions (`if`, `switch`), repeating code (`for`, `while`, `do-while`), and changing execution (`break`, `continue`, `return`).**