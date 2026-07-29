# Data Types & Variables

## Overview

In Java, a **variable** is a named memory location used to store data. Every variable must have a **data type**, which determines:

- What kind of value it can store
- How much memory it uses
- What operations can be performed on it

Example:

```java
int age = 25;
String name = "Siddhant";
double salary = 45000.50;
```

---

# Variables

## Variable Declaration

Syntax:

```java
dataType variableName = value;
```

Example:

```java
int marks = 95;
String city = "Bangalore";
boolean isPassed = true;
```

---

## Rules for Naming Variables

### ✅ Valid

```java
int age;
String firstName;
double salary;
int _count;
```

### ❌ Invalid

```java
int 1age;
int first name;
int class;
```

### Rules

- Must begin with a letter, `_`, or `$`
- Cannot start with a number
- Cannot contain spaces
- Cannot use Java keywords
- Variable names are case-sensitive

Example:

```java
int age = 20;
int Age = 30;
```

`age` and `Age` are two different variables.

---

# Types of Variables

## 1. Local Variable

Declared inside a method.

```java
public class Demo {

    public static void main(String[] args) {

        int number = 10;

        System.out.println(number);
    }
}
```

Characteristics:

- Created when the method starts
- Destroyed when the method ends
- Must be initialized before use

---

## 2. Instance Variable

Declared inside a class but outside methods.

```java
class Student {

    String name;
    int age;
}
```

Characteristics:

- Belongs to an object
- Each object has its own copy
- Stored in Heap memory

---

## 3. Static Variable

Declared using `static`.

```java
class Student {

    static String college = "MountBlue";
}
```

Characteristics:

- Shared among all objects
- Created only once
- Stored in Method Area

---

# Java Data Types

Java data types are divided into two categories.

```text
Data Types
│
├── Primitive
└── Reference (Non-Primitive)
```

---

# Primitive Data Types

Primitive types store **actual values**.

Java provides **8 primitive data types**.

| Data Type | Size | Example |
|-----------|------|---------|
| byte | 1 byte | 100 |
| short | 2 bytes | 20000 |
| int | 4 bytes | 100000 |
| long | 8 bytes | 999999999L |
| float | 4 bytes | 12.5f |
| double | 8 bytes | 15.75 |
| char | 2 bytes | 'A' |
| boolean | JVM dependent | true |

---

## byte

Stores small integers.

Range:

```text
-128 to 127
```

Example:

```java
byte age = 25;
```

---

## short

Stores larger integers than byte.

Example:

```java
short salary = 30000;
```

---

## int

Most commonly used integer type.

Example:

```java
int population = 100000;
```

---

## long

Stores very large integers.

Suffix:

```text
L
```

Example:

```java
long distance = 9876543210L;
```

---

## float

Stores decimal numbers.

Suffix:

```text
f
```

Example:

```java
float price = 12.5f;
```

---

## double

Default decimal data type.

Example:

```java
double pi = 3.1415926535;
```

---

## char

Stores a single Unicode character.

Example:

```java
char grade = 'A';
```

---

## boolean

Stores only two values.

```java
boolean isPassed = true;
```

Possible values:

- true
- false

---

# Reference Data Types

Reference types store the **memory address (reference)** of an object.

Examples:

- String
- Arrays
- Classes
- Objects
- Interfaces
- Enums

Example:

```java
String name = "Java";
```

The variable `name` stores a reference to the String object.

---

# Primitive vs Reference Types

| Primitive | Reference |
|------------|-----------|
| Stores actual value | Stores object reference |
| Fixed size | Variable size |
| Faster | Slightly slower |
| Cannot be null | Can be null |
| Examples: int, double | Examples: String, Array |

Example:

```java
int age = 20;

String name = "Java";
```

---

# Type Conversion

Type conversion means converting one data type into another.

Two types:

- Widening Conversion (Implicit)
- Narrowing Conversion (Explicit)

---

# Widening Conversion (Implicit)

Automatically converts a smaller data type into a larger one.

Example:

```java
int number = 100;

double value = number;

System.out.println(value);
```

Output:

```text
100.0
```

No data is lost.

---

## Widening Hierarchy

```text
byte
  ↓
short
  ↓
int
  ↓
long
  ↓
float
  ↓
double
```

Example:

```java
byte a = 10;

int b = a;

double c = b;
```

---

# Narrowing Conversion (Explicit Casting)

Converts a larger data type into a smaller one.

Syntax:

```java
(targetType) value
```

Example:

```java
double number = 25.75;

int value = (int) number;

System.out.println(value);
```

Output:

```text
25
```

The decimal part is discarded.

---

Another Example

```java
int number = 130;

byte b = (byte) number;

System.out.println(b);
```

Output:

```text
-126
```

This happens because the value exceeds the `byte` range.

---

# Type Casting

Type casting is the manual conversion of one data type into another.

Example:

```java
double salary = 50000.99;

int amount = (int) salary;

System.out.println(amount);
```

Output:

```text
50000
```

---

# Automatic Type Promotion

During arithmetic operations, Java promotes `byte`, `short`, and `char` to `int`.

Example:

```java
byte a = 10;
byte b = 20;

int result = a + b;
```

The result is `int`.

---

# Arrays

An array stores multiple values of the same data type.

Instead of:

```java
int mark1 = 90;
int mark2 = 85;
int mark3 = 95;
```

Use:

```java
int[] marks = {90, 85, 95};
```

---

# Creating Arrays

## Method 1

```java
int[] numbers = {10, 20, 30, 40};
```

---

## Method 2

```java
int[] numbers = new int[5];
```

Creates an array of size 5.

Default values:

```text
[0, 0, 0, 0, 0]
```

---

# Accessing Array Elements

Array indexing starts from **0**.

```java
int[] marks = {80, 90, 95};

System.out.println(marks[0]);
```

Output:

```text
80
```

---

# Updating Array Elements

```java
marks[1] = 100;
```

Array becomes:

```text
80
100
95
```

---

# Array Length

```java
System.out.println(marks.length);
```

Output:

```text
3
```

---

# Traversing Arrays

## Using for Loop

```java
int[] numbers = {10, 20, 30, 40};

for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

---

## Using Enhanced for Loop

```java
int[] numbers = {10, 20, 30, 40};

for (int number : numbers) {
    System.out.println(number);
}
```

---

# Multidimensional Arrays

Example:

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};
```

Access an element:

```java
System.out.println(matrix[1][2]);
```

Output:

```text
6
```

---

# Common Array Exceptions

## ArrayIndexOutOfBoundsException

Occurs when accessing an invalid index.

Example:

```java
int[] arr = {10, 20, 30};

System.out.println(arr[5]);
```

---

## NullPointerException

Occurs when an array reference is `null`.

Example:

```java
int[] arr = null;

System.out.println(arr.length);
```

---

# Best Practices

- Use meaningful variable names.
- Initialize variables before use.
- Choose the appropriate data type.
- Prefer `double` over `float` unless memory is critical.
- Use enhanced `for` loops when only reading array elements.
- Always validate array indices before accessing them.

---

# Interview Questions

## 1. What is a variable?

A variable is a named memory location used to store data.

---

## 2. What is the difference between primitive and reference data types?

- Primitive types store actual values.
- Reference types store references (memory addresses) to objects.

---

## 3. What is widening conversion?

Automatic conversion from a smaller data type to a larger data type.

Example:

```java
int a = 10;
double b = a;
```

---

## 4. What is narrowing conversion?

Manual conversion from a larger data type to a smaller one using explicit casting.

Example:

```java
double d = 20.5;

int i = (int) d;
```

---

## 5. What is an array?

An array is a fixed-size collection of elements of the same data type.

---

## 6. What is the difference between `length` and `length()`?

- `length` → Used with arrays.
- `length()` → Used with `String`.

Example:

```java
int[] arr = {1, 2, 3};
System.out.println(arr.length);

String str = "Java";
System.out.println(str.length());
```

---

# Quick Revision

## Primitive Data Types

- byte
- short
- int
- long
- float
- double
- char
- boolean

---

## Reference Types

- String
- Arrays
- Classes
- Objects
- Interfaces
- Enums

---

## Type Conversion

- Widening → Automatic
- Narrowing → Manual (Casting)

---

## Arrays

- Store multiple values of the same type
- Index starts from 0
- Fixed size
- Use `.length` to get the size

---

# One-Line Summary_

> **Variables store data, primitive types store actual values, reference types store object references, type conversion changes data types, and arrays store multiple values of the same type in a fixed-size collection.**