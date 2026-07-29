# Exception Handling in Java

## Overview

An **exception** is an event that occurs during the execution of a program and **disrupts the normal flow** of the program.

If an exception is not handled, the program terminates abnormally.

Example:

```java
int a = 10;
int b = 0;

System.out.println(a / b);
```

Output:

```text
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

---

# Why Exception Handling?

Exception handling helps us:

- Prevent program crashes
- Handle runtime errors gracefully
- Improve application reliability
- Separate error-handling code from business logic

---

# What is an Exception?

An exception is an **object** that represents an error or unexpected event during program execution.

Examples:

- Dividing by zero
- Accessing an invalid array index
- Accessing a null object
- Reading a missing file
- Invalid user input

---

# Exception Hierarchy

All exceptions inherit from the `Throwable` class.

```text
Object
   │
   ▼
Throwable
├── Error
│     ├── OutOfMemoryError
│     └── StackOverflowError
│
└── Exception
      ├── IOException
      ├── SQLException
      ├── ClassNotFoundException
      └── RuntimeException
             ├── ArithmeticException
             ├── NullPointerException
             ├── ArrayIndexOutOfBoundsException
             ├── NumberFormatException
             └── IllegalArgumentException
```

---

# Error vs Exception

| Error | Exception |
|--------|-----------|
| Serious problem | Recoverable problem |
| Usually cannot be handled | Can be handled |
| Caused by JVM | Caused by program or external factors |
| Example: OutOfMemoryError | Example: IOException |

---

# Checked vs Unchecked Exceptions

## Checked Exceptions

Checked exceptions are checked by the compiler.

They **must be handled** or declared using `throws`.

Examples:

- IOException
- SQLException
- ClassNotFoundException

Example:

```java
import java.io.FileReader;

public class Demo {

    public static void main(String[] args) throws Exception {

        FileReader file = new FileReader("data.txt");
    }
}
```

---

## Unchecked Exceptions

Unchecked exceptions occur during runtime.

The compiler does not force you to handle them.

Examples:

- ArithmeticException
- NullPointerException
- ArrayIndexOutOfBoundsException
- NumberFormatException

Example:

```java
int a = 10;
int b = 0;

System.out.println(a / b);
```

---

# Exception Handling

Java uses five keywords for exception handling:

- try
- catch
- finally
- throw
- throws

---

# try-catch

The `try` block contains code that may throw an exception.

The `catch` block handles the exception.

Syntax:

```java
try {

    // risky code

} catch (Exception e) {

    // handling code

}
```

Example:

```java
public class Demo {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

        } catch (ArithmeticException e) {

            System.out.println("Cannot divide by zero.");
        }

        System.out.println("Program continues...");
    }
}
```

Output:

```text
Cannot divide by zero.
Program continues...
```

---

# Multiple catch Blocks

Different exceptions can be handled separately.

Example:

```java
try {

    String text = null;

    System.out.println(text.length());

} catch (NullPointerException e) {

    System.out.println("Null reference.");

} catch (Exception e) {

    System.out.println("General Exception.");
}
```

---

# finally Block

The `finally` block always executes, whether an exception occurs or not.

It is commonly used to release resources.

Example:

```java
try {

    System.out.println("Inside try");

} finally {

    System.out.println("Finally executed");
}
```

Output:

```text
Inside try
Finally executed
```

---

# Execution Flow

```text
        try
         │
         ▼
 Exception?
   │         │
 No        Yes
 │          │
 ▼          ▼
Continue   catch
     │
     ▼
  finally
```

---

# throw Keyword

The `throw` keyword is used to explicitly throw an exception.

Syntax:

```java
throw new ExceptionType("Message");
```

Example:

```java
int age = 15;

if (age < 18) {

    throw new IllegalArgumentException("Age must be 18 or above.");

}
```

---

# throws Keyword

The `throws` keyword declares that a method may throw an exception.

Example:

```java
import java.io.IOException;

class Demo {

    void readFile() throws IOException {

    }

}
```

---

# throw vs throws

| throw | throws |
|--------|---------|
| Used to throw an exception | Used to declare exceptions |
| Used inside a method | Used in the method signature |
| Throws one exception object | Can declare multiple exceptions |

---

# NullPointerException (NPE)

A `NullPointerException` occurs when a program tries to use a reference that points to `null`.

Example:

```java
String name = null;

System.out.println(name.length());
```

Output:

```text
Exception in thread "main"
java.lang.NullPointerException
```

---

## Preventing NullPointerException

Check for `null` before using an object.

Example:

```java
if (name != null) {

    System.out.println(name.length());

}
```

---

# Array Exceptions

## ArrayIndexOutOfBoundsException

Occurs when accessing an invalid array index.

Example:

```java
int[] numbers = {10, 20, 30};

System.out.println(numbers[5]);
```

Output:

```text
Exception in thread "main"
java.lang.ArrayIndexOutOfBoundsException
```

---

## NegativeArraySizeException

Occurs when an array is created with a negative size.

Example:

```java
int[] arr = new int[-5];
```

---

# Common Runtime Exceptions

| Exception | Cause |
|-----------|-------|
| ArithmeticException | Divide by zero |
| NullPointerException | Accessing null reference |
| ArrayIndexOutOfBoundsException | Invalid array index |
| NumberFormatException | Invalid number conversion |
| ClassCastException | Invalid type casting |
| IllegalArgumentException | Invalid method argument |

---

# Try-with-Resources

Introduced in **Java 7**.

Automatically closes resources such as:

- Files
- Streams
- Database connections
- Sockets

Resources must implement the `AutoCloseable` interface.

---

## Traditional Way

```java
import java.io.BufferedReader;
import java.io.FileReader;

public class Demo {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));

        System.out.println(reader.readLine());

        reader.close();
    }
}
```

Problem:

If an exception occurs before `close()`, the resource may not be released.

---

## Try-with-Resources

```java
import java.io.BufferedReader;
import java.io.FileReader;

public class Demo {

    public static void main(String[] args) throws Exception {

        try (BufferedReader reader =
                new BufferedReader(new FileReader("data.txt"))) {

            System.out.println(reader.readLine());

        }

    }
}
```

The resource is automatically closed.

---

# Benefits of Try-with-Resources

- Automatically closes resources
- Prevents resource leaks
- Cleaner code
- Safer exception handling

---

# Best Practices

- Catch the most specific exception first.
- Avoid catching `Exception` unless necessary.
- Do not ignore exceptions.
- Use meaningful exception messages.
- Use `finally` or try-with-resources for cleanup.
- Prefer try-with-resources for `AutoCloseable` resources.
- Validate inputs to prevent exceptions.

---

# Interview Questions

## 1. What is an exception?

An exception is an event that disrupts the normal execution of a program during runtime.

---

## 2. What is the difference between checked and unchecked exceptions?

| Checked | Unchecked |
|----------|-----------|
| Checked at compile time | Occur at runtime |
| Must be handled or declared | Handling is optional |
| Example: IOException | Example: NullPointerException |

---

## 3. What is the difference between `throw` and `throws`?

- `throw` explicitly throws an exception object.
- `throws` declares that a method may throw one or more exceptions.

---

## 4. What is the purpose of the `finally` block?

The `finally` block is used for cleanup code and executes whether or not an exception occurs.

---

## 5. What causes a NullPointerException?

A `NullPointerException` occurs when a program attempts to use an object reference that is `null`.

---

## 6. What is try-with-resources?

It is a feature introduced in Java 7 that automatically closes resources implementing `AutoCloseable`.

---

## 7. Why is try-with-resources preferred?

Because it automatically closes resources, prevents resource leaks, and simplifies code.

---

## 8. What is the parent class of all exceptions?

`Throwable`

---

# Quick Revision

## Exception Hierarchy

```text
Throwable
├── Error
└── Exception
      └── RuntimeException
```

---

## Keywords

- `try`
- `catch`
- `finally`
- `throw`
- `throws`

---

## Checked Exceptions

- IOException
- SQLException
- ClassNotFoundException

---

## Unchecked Exceptions

- ArithmeticException
- NullPointerException
- ArrayIndexOutOfBoundsException
- NumberFormatException

---

## Common Array Exceptions

- ArrayIndexOutOfBoundsException
- NegativeArraySizeException

---

## Try-with-Resources

- Introduced in Java 7
- Automatically closes resources
- Uses `AutoCloseable`

---

# One-Line Summary

> **Exception handling in Java allows programs to detect, handle, and recover from runtime errors using `try`, `catch`, `finally`, `throw`, `throws`, and try-with-resources, making applications more robust and reliable.**