# Java Operators

## Overview

An **operator** is a symbol that performs an operation on one or more operands (values or variables).

Example:

```java
int a = 10;
int b = 5;

int sum = a + b;
```

Here:

- `+` → Operator
- `a` and `b` → Operands

---

# Types of Operators in Java

Java provides several types of operators:

- Arithmetic Operators
- Relational Operators
- Boolean (Logical) Operators
- Bitwise Operators
- Ternary Operator

---

# Arithmetic Operators

Arithmetic operators perform mathematical calculations.

| Operator | Description | Example |
|----------|-------------|---------|
| `+` | Addition | `a + b` |
| `-` | Subtraction | `a - b` |
| `*` | Multiplication | `a * b` |
| `/` | Division | `a / b` |
| `%` | Modulus (Remainder) | `a % b` |
| `++` | Increment | `a++` |
| `--` | Decrement | `a--` |

---

## Addition (`+`)

```java
int a = 10;
int b = 20;

System.out.println(a + b);
```

Output:

```text
30
```

---

## Subtraction (`-`)

```java
int a = 20;
int b = 10;

System.out.println(a - b);
```

Output:

```text
10
```

---

## Multiplication (`*`)

```java
int a = 5;
int b = 6;

System.out.println(a * b);
```

Output:

```text
30
```

---

## Division (`/`)

### Integer Division

```java
int a = 10;
int b = 3;

System.out.println(a / b);
```

Output:

```text
3
```

The decimal part is discarded.

### Decimal Division

```java
double a = 10;
double b = 3;

System.out.println(a / b);
```

Output:

```text
3.3333333333333335
```

---

## Modulus (`%`)

Returns the remainder after division.

```java
int a = 10;
int b = 3;

System.out.println(a % b);
```

Output:

```text
1
```

---

## Increment (`++`)

Increases a value by 1.

```java
int a = 5;

a++;

System.out.println(a);
```

Output:

```text
6
```

---

## Decrement (`--`)

Decreases a value by 1.

```java
int a = 5;

a--;

System.out.println(a);
```

Output:

```text
4
```

---

# Pre-Increment vs Post-Increment

## Pre-Increment (`++a`)

Increment happens **before** the value is used.

```java
int a = 5;

System.out.println(++a);
```

Output:

```text
6
```

---

## Post-Increment (`a++`)

Increment happens **after** the value is used.

```java
int a = 5;

System.out.println(a++);
System.out.println(a);
```

Output:

```text
5
6
```

---

# Pre-Decrement vs Post-Decrement

```java
int a = 5;

System.out.println(--a);
```

Output:

```text
4
```

```java
int b = 5;

System.out.println(b--);
System.out.println(b);
```

Output:

```text
5
4
```

---

# Relational Operators

Relational operators compare two values.

The result is always `true` or `false`.

| Operator | Description |
|----------|-------------|
| `==` | Equal to |
| `!=` | Not equal to |
| `>` | Greater than |
| `<` | Less than |
| `>=` | Greater than or equal to |
| `<=` | Less than or equal to |

---

Example:

```java
int a = 10;
int b = 20;

System.out.println(a < b);
```

Output:

```text
true
```

---

Another Example

```java
System.out.println(10 == 10);
System.out.println(10 != 5);
```

Output:

```text
true
true
```

---

# Boolean (Logical) Operators

Logical operators combine or negate boolean expressions.

| Operator | Description |
|----------|-------------|
| `&&` | Logical AND |
| `||` | Logical OR |
| `!` | Logical NOT |

---

## Logical AND (`&&`)

Returns `true` only if **both conditions are true**.

```java
int age = 25;

System.out.println(age > 18 && age < 30);
```

Output:

```text
true
```

Truth Table

| A | B | A && B |
|---|---|--------|
| true | true | true |
| true | false | false |
| false | true | false |
| false | false | false |

---

## Logical OR (`||`)

Returns `true` if **at least one condition is true**.

```java
System.out.println(10 > 20 || 5 < 10);
```

Output:

```text
true
```

Truth Table

| A | B | A \|\| B |
|---|---|-----------|
| true | true | true |
| true | false | true |
| false | true | true |
| false | false | false |

---

## Logical NOT (`!`)

Reverses a boolean value.

```java
boolean isPassed = true;

System.out.println(!isPassed);
```

Output:

```text
false
```

---

# Bitwise Operators

Bitwise operators work directly on the binary representation of integer values.

| Operator | Description |
|----------|-------------|
| `&` | Bitwise AND |
| `|` | Bitwise OR |
| `^` | Bitwise XOR |
| `~` | Bitwise Complement |
| `<<` | Left Shift |
| `>>` | Right Shift |
| `>>>` | Unsigned Right Shift |

---

## Bitwise AND (`&`)

```java
int a = 5;
int b = 3;

System.out.println(a & b);
```

Binary:

```text
5 = 0101
3 = 0011
-----------
    0001
```

Output:

```text
1
```

---

## Bitwise OR (`|`)

```java
System.out.println(5 | 3);
```

Output:

```text
7
```

Binary:

```text
0101
0011
----
0111
```

---

## Bitwise XOR (`^`)

Returns `1` when bits are different.

```java
System.out.println(5 ^ 3);
```

Output:

```text
6
```

---

## Bitwise Complement (`~`)

Flips every bit.

```java
System.out.println(~5);
```

Output:

```text
-6
```

---

## Left Shift (`<<`)

Shifts bits to the left.

```java
System.out.println(5 << 1);
```

Output:

```text
10
```

Binary:

```text
0101
1010
```

---

## Right Shift (`>>`)

Shifts bits to the right.

```java
System.out.println(20 >> 2);
```

Output:

```text
5
```

---

## Unsigned Right Shift (`>>>`)

Shifts bits to the right and fills the leftmost bits with zeros.

```java
System.out.println(20 >>> 2);
```

Output:

```text
5
```

---

# Ternary Operator

The ternary operator is a shorthand for an `if-else` statement.

Syntax:

```java
condition ? value1 : value2;
```

Example:

```java
int age = 20;

String result = age >= 18 ? "Adult" : "Minor";

System.out.println(result);
```

Output:

```text
Adult
```

Equivalent `if-else`

```java
String result;

if (age >= 18) {
    result = "Adult";
} else {
    result = "Minor";
}
```

---

# Operator Precedence

Operator precedence determines the order in which operators are evaluated.

Higher precedence operators are evaluated first.

| Precedence | Operators |
|------------|-----------|
| Highest | `()` |
| Unary | `++ -- + - ! ~` |
| Multiplicative | `* / %` |
| Additive | `+ -` |
| Shift | `<< >> >>>` |
| Relational | `< > <= >=` |
| Equality | `== !=` |
| Bitwise AND | `&` |
| Bitwise XOR | `^` |
| Bitwise OR | `|` |
| Logical AND | `&&` |
| Logical OR | `||` |
| Ternary | `?:` |
| Lowest | Assignment (`=`) |

---

## Example

```java
int result = 5 + 2 * 3;
```

Multiplication happens first.

```text
5 + (2 × 3)

5 + 6

11
```

Output:

```text
11
```

---

# Parentheses

Parentheses (`()`) have the highest precedence.

They are used to control the order of evaluation.

Example:

```java
int result = (5 + 2) * 3;

System.out.println(result);
```

Output:

```text
21
```

Without parentheses:

```java
int result = 5 + 2 * 3;
```

Output:

```text
11
```

---

# Operator Associativity

When operators have the same precedence, associativity determines the evaluation order.

### Left to Right

```java
int result = 20 / 5 * 2;
```

Evaluation:

```text
20 / 5 = 4

4 * 2 = 8
```

Output:

```text
8
```

---

### Right to Left (Assignment)

```java
int a, b, c;

a = b = c = 10;
```

Assignments are evaluated from right to left.

---

# Best Practices

- Use parentheses to improve readability.
- Avoid writing multiple increments in one expression.
- Use logical operators for conditions.
- Use bitwise operators only when working with binary data.
- Prefer meaningful expressions over clever shortcuts.

---

# Interview Questions

## 1. What is an operator?

An operator is a symbol that performs an operation on one or more operands.

---

## 2. What is the difference between `==` and `=`?

- `=` → Assignment operator
- `==` → Equality comparison operator

Example:

```java
int a = 10;

System.out.println(a == 10);
```

---

## 3. Difference between `&&` and `&`

- `&&` → Logical AND (short-circuit evaluation)
- `&` → Bitwise AND (works on bits and also evaluates both boolean operands)

---

## 4. Difference between `||` and `|`

- `||` → Logical OR (short-circuit evaluation)
- `|` → Bitwise OR (works on bits and also evaluates both boolean operands)

---

## 5. Difference between `++i` and `i++`

- `++i` → Increment first, then use the value.
- `i++` → Use the current value first, then increment.

---

## 6. What is the ternary operator?

The ternary operator (`?:`) is a shorthand for an `if-else` statement.

Syntax:

```java
condition ? valueIfTrue : valueIfFalse;
```

---

## 7. What is operator precedence?

Operator precedence determines the order in which operators are evaluated in an expression.

---

## 8. Why should parentheses be used?

Parentheses improve readability and override the default operator precedence, ensuring expressions are evaluated in the intended order.

---

# Quick Revision

## Arithmetic Operators

- `+`
- `-`
- `*`
- `/`
- `%`
- `++`
- `--`

---

## Relational Operators

- `==`
- `!=`
- `>`
- `<`
- `>=`
- `<=`

---

## Boolean (Logical) Operators

- `&&`
- `||`
- `!`

---

## Bitwise Operators

- `&`
- `|`
- `^`
- `~`
- `<<`
- `>>`
- `>>>`

---

## Ternary Operator

```java
condition ? value1 : value2;
```

---

## Highest Operator Precedence

```text
()
```

---

# One-Line Summary

> **Java operators perform arithmetic, comparison, logical, and bitwise operations. Operator precedence determines the order of evaluation, while parentheses can be used to override the default order and make expressions easier to understand.**