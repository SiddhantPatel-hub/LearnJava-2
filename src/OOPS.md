# Object-Oriented Programming (OOP) in Java

## Overview

**Object-Oriented Programming (OOP)** is a programming paradigm that organizes software around **objects** rather than functions.

An **object** represents a real-world entity with:

- **State** (Data / Attributes)
- **Behavior** (Methods / Functions)

Example:

```java
class Car {

    String brand;      // State

    void start() {     // Behavior
        System.out.println("Car Started");
    }
}
```

Create an object:

```java
Car car = new Car();

car.start();
```

Output:

```text
Car Started
```

---

# Why OOP?

OOP makes programs:

- Easy to understand
- Easy to maintain
- Reusable
- Secure
- Scalable
- Modular

---

# Four Pillars of OOP

```text
Object-Oriented Programming
│
├── Encapsulation
├── Inheritance
├── Polymorphism
└── Abstraction
```

---

# 1. Encapsulation

## Definition

Encapsulation is the process of **wrapping data (variables) and methods into a single unit (class)** while restricting direct access to the data.

In Java, encapsulation is achieved using:

- Private variables
- Public getter methods
- Public setter methods

---

## Why Encapsulation?

Benefits:

- Data security
- Controlled access
- Better maintainability
- Better flexibility

---

## Example

```java
class Student {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

Using the class:

```java
Student student = new Student();

student.setName("Siddhant");

System.out.println(student.getName());
```

Output:

```text
Siddhant
```

---

## Without Encapsulation

```java
class Student {

    public String name;
}
```

Anyone can modify the data directly.

```java
student.name = "";
```

No validation is possible.

---

## With Encapsulation

```java
class Student {

    private int age;

    public void setAge(int age) {

        if (age > 0) {
            this.age = age;
        }

    }

    public int getAge() {
        return age;
    }
}
```

Only valid values are stored.

---

# Advantages of Encapsulation

- Protects data
- Allows validation
- Easy to modify implementation
- Better code organization

---

# 2. Inheritance

## Definition

Inheritance allows one class to acquire the properties and methods of another class.

It promotes **code reusability**.

---

## Syntax

```java
class Parent {

}

class Child extends Parent {

}
```

---

## Example

```java
class Animal {

    void eat() {
        System.out.println("Eating...");
    }

}

class Dog extends Animal {

    void bark() {
        System.out.println("Barking...");
    }

}
```

Using the classes:

```java
Dog dog = new Dog();

dog.eat();
dog.bark();
```

Output:

```text
Eating...
Barking...
```

---

# Types of Inheritance

## 1. Single Inheritance

```text
Animal
   │
   ▼
Dog
```

---

## 2. Multilevel Inheritance

```text
Animal
   │
   ▼
Dog
   │
   ▼
Puppy
```

---

## 3. Hierarchical Inheritance

```text
        Animal
       /      \
      ▼        ▼
    Dog      Cat
```

---

## Multiple Inheritance

Java **does not support multiple inheritance with classes** because it can lead to ambiguity (Diamond Problem).

Example (Not Allowed):

```java
class A {

}

class B {

}

class C extends A, B {

}
```

Instead, Java supports multiple inheritance through **interfaces**.

---

# Advantages of Inheritance

- Code reuse
- Easy maintenance
- Supports method overriding
- Reduces duplicate code

---

# 3. Polymorphism

## Definition

Polymorphism means **one interface, many implementations**.

The same method name behaves differently depending on the object or parameters.

There are two types:

- Compile-time Polymorphism
- Runtime Polymorphism

---

# Compile-Time Polymorphism

Achieved using **Method Overloading**.

Multiple methods have the same name but different parameters.

Example:

```java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

}
```

Usage:

```java
Calculator calculator = new Calculator();

System.out.println(calculator.add(5, 6));

System.out.println(calculator.add(5, 6, 7));
```

Output:

```text
11
18
```

---

# Runtime Polymorphism

Achieved using **Method Overriding**.

The child class provides its own implementation of a parent method.

Example:

```java
class Animal {

    void sound() {
        System.out.println("Animal Sound");
    }

}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Bark");
    }

}
```

Usage:

```java
Animal animal = new Dog();

animal.sound();
```

Output:

```text
Bark
```

---

# Method Overloading vs Method Overriding

| Feature | Overloading | Overriding |
|----------|-------------|------------|
| Happens In | Same class | Parent & Child |
| Parameters | Must be different | Must be the same |
| Return Type | Can differ (with different parameters) | Must be compatible |
| Binding | Compile Time | Runtime |

---

# Advantages of Polymorphism

- Flexible code
- Better readability
- Easy extension
- Reduces code duplication

---

# 4. Abstraction

## Definition

Abstraction means **hiding implementation details and exposing only essential functionality**.

The user knows **what** an object does, not **how** it does it.

Example:

You drive a car by using:

- Steering
- Brake
- Accelerator

You do not need to know how the engine works internally.

---

# Abstraction Using Abstract Class

Example:

```java
abstract class Animal {

    abstract void sound();

}
```

Child class:

```java
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Bark");
    }

}
```

Usage:

```java
Animal animal = new Dog();

animal.sound();
```

Output:

```text
Bark
```

---

# Abstraction Using Interface

Example:

```java
interface Vehicle {

    void start();

}
```

Implementation:

```java
class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car Started");
    }

}
```

Usage:

```java
Vehicle vehicle = new Car();

vehicle.start();
```

Output:

```text
Car Started
```

---

# Abstract Class vs Interface

| Feature | Abstract Class | Interface |
|----------|----------------|-----------|
| Methods | Abstract + Concrete | Abstract by default (can also have default/static methods) |
| Variables | Instance & Static | `public static final` constants |
| Constructor | Yes | No |
| Inheritance | `extends` | `implements` |
| Multiple Inheritance | No | Yes |

---

# Relationship Between OOP Concepts

```text
                 OOP
                  │
      ┌───────────┼────────────┐
      │           │            │
      ▼           ▼            ▼
Encapsulation Inheritance Abstraction
                    │
                    ▼
             Polymorphism
```

---

# Real-World Example

```text
Vehicle
│
├── Private Engine Data
│      ↑
│ Encapsulation
│
├── Start()
│      ↑
│ Abstraction
│
├── Car extends Vehicle
│      ↑
│ Inheritance
│
└── start() overridden
       ↑
  Polymorphism
```

---

# Best Practices

- Keep fields `private`.
- Expose data using getters and setters.
- Prefer composition over inheritance when appropriate.
- Use inheritance only for an **is-a** relationship.
- Use interfaces to define common behavior.
- Use polymorphism to write flexible and extensible code.
- Hide implementation details through abstraction.

---

# Interview Questions

## 1. What is Object-Oriented Programming?

Object-Oriented Programming (OOP) is a programming paradigm based on objects that contain data (state) and methods (behavior).

---

## 2. What are the four pillars of OOP?

- Encapsulation
- Inheritance
- Polymorphism
- Abstraction

---

## 3. What is Encapsulation?

Encapsulation is wrapping data and methods into a single unit (class) while restricting direct access to the data using access modifiers.

---

## 4. What is Inheritance?

Inheritance allows one class to inherit the properties and methods of another class using the `extends` keyword.

---

## 5. What is Polymorphism?

Polymorphism allows the same method name to have different behaviors.

Types:

- Compile-time (Method Overloading)
- Runtime (Method Overriding)

---

## 6. What is Abstraction?

Abstraction hides implementation details and exposes only the essential functionality using abstract classes or interfaces.

---

## 7. Why doesn't Java support multiple inheritance with classes?

To avoid ambiguity caused by the **Diamond Problem**. Java instead supports multiple inheritance through interfaces.

---

## 8. What is the difference between Method Overloading and Method Overriding?

- **Overloading**: Same method name with different parameters (compile-time polymorphism).
- **Overriding**: Child class provides a new implementation of a parent method (runtime polymorphism).

---

## Quick Revision

### Encapsulation

- Hides data
- Uses `private` fields
- Uses getters and setters

---

### Inheritance

- Reuses code
- Uses `extends`
- Models an **is-a** relationship

---

### Polymorphism

- One interface, many implementations
- Method Overloading
- Method Overriding

---

### Abstraction

- Hides implementation details
- Uses abstract classes
- Uses interfaces

---

# One-Line Summary

> **Object-Oriented Programming (OOP) organizes software using objects and is built on four core principles: Encapsulation protects data, Inheritance promotes code reuse, Polymorphism enables one interface with many implementations, and Abstraction hides implementation details while exposing only essential functionality.**