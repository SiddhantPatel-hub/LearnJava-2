# Java Generics - Complete Notes

> **Reference:** https://www.geeksforgeeks.org/java/generics-in-java/

---

# Table of Contents

1. Introduction
2. Why Generics?
3. Advantages of Generics
4. Generics and Object
5. Generic Classes
6. Multiple Type Parameters
7. Generic Methods
8. Type Bounds
9. Wildcards
10. Type Erasure
11. Restrictions of Generics
12. Best Practices
13. Interview Questions
14. Summary

---

# Introduction

Generics were introduced in **Java 5** to provide **compile-time type safety** and improve code reusability.

A generic class, interface, or method allows the same code to work with different data types without sacrificing type safety.

Instead of writing separate classes for different data types, Java allows us to write one generic implementation.

For example:

```java
ArrayList<String> names = new ArrayList<>();

ArrayList<Integer> numbers = new ArrayList<>();
```

Here,

- `String`
- `Integer`

are called **type arguments**.

`T` is called a **type parameter**.

---

# Why Generics?

Before Java 5, Java Collections stored everything as an `Object`.

Since every class in Java extends `Object`, collections could store any type of object.

Example:

```java
ArrayList list = new ArrayList();

list.add("Java");
list.add(100);

String language = (String) list.get(0);

String number = (String) list.get(1);
```

Output

```text
Exception in thread "main"
java.lang.ClassCastException
```

The compiler cannot detect the error because every object is stored as `Object`.

The exception occurs only during runtime.

Generics solve this problem by checking the data type during compilation.

---

# Advantages of Generics

## 1. Compile-Time Type Safety

The compiler prevents incorrect data from being inserted.

```java
ArrayList<String> list = new ArrayList<>();

list.add("Java");

// list.add(10); // Compile-time Error
```

---

## 2. No Explicit Casting

Without Generics

```java
String value = (String) list.get(0);
```

With Generics

```java
String value = list.get(0);
```

---

## 3. Eliminates Runtime ClassCastException

Most type-related errors are detected during compilation.

---

## 4. Code Reusability

One generic implementation can work with many data types.

---

## 5. Improved Readability

The code becomes cleaner and easier to understand.

---

# Generics and Object

## Without Generics

Collections store every element as an `Object`.

```java
ArrayList list = new ArrayList();

list.add("Java");
list.add(50);

String language = (String) list.get(0);

String number = (String) list.get(1);
```

Output

```text
Java

Exception in thread "main"
java.lang.ClassCastException
```

Problems

- No type checking
- Explicit casting
- Runtime exceptions
- Less readable

---

## With Generics

```java
ArrayList<String> list = new ArrayList<>();

list.add("Java");

// list.add(100);

String language = list.get(0);
```

Advantages

- Compile-time checking
- No casting
- Safer code

---

# Generic Classes

A generic class can work with different data types.

## Syntax

```java
class ClassName<T> {

}
```

`T` represents a type parameter.

---

## Example

```java
class Box<T> {

    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
```

Usage

```java
public class Main {

    public static void main(String[] args) {

        Box<String> stringBox = new Box<>();

        stringBox.set("Java");

        System.out.println(stringBox.get());

        Box<Integer> intBox = new Box<>();

        intBox.set(100);

        System.out.println(intBox.get());
    }
}
```

Output

```text
Java
100
```

---

# Multiple Type Parameters

A generic class can have multiple type parameters.

Syntax

```java
class Pair<K, V> {

}
```

Example

```java
class Pair<K, V> {

    private K key;

    private V value;

    Pair(K key, V value) {

        this.key = key;

        this.value = value;
    }

    public void print() {

        System.out.println(key + " : " + value);
    }
}
```

Usage

```java
Pair<String, Integer> student = new Pair<>("Marks", 95);

student.print();
```

Output

```text
Marks : 95
```

---

# Generic Naming Conventions

| Symbol | Meaning |
|---------|----------|
| T | Type |
| E | Element |
| K | Key |
| V | Value |
| N | Number |

---

# Generic Methods

A generic method introduces its own type parameter.

## Syntax

```java
public static <T> void print(T value)
```

Notice

The generic parameter `<T>` appears before the return type.

---

## Example

```java
public class Main {

    public static <T> void print(T value) {

        System.out.println(value);
    }

    public static void main(String[] args) {

        print("Java");

        print(100);

        print(25.5);

        print(true);
    }
}
```

Output

```text
Java
100
25.5
true
```

---

## Generic Method Returning Value

```java
public static <T> T identity(T value) {

    return value;
}
```

Usage

```java
String s = identity("Hello");

Integer n = identity(50);
```

---

# Type Bounds

Sometimes we don't want every data type.

We can restrict the allowed types.

Syntax

```java
<T extends Number>
```

Only subclasses of `Number` are accepted.

---

## Example

```java
class Calculator {

    public static <T extends Number> double square(T value) {

        return value.doubleValue() * value.doubleValue();
    }
}
```

Usage

```java
System.out.println(Calculator.square(5));

System.out.println(Calculator.square(2.5));

// Calculator.square("Java");
```

Output

```text
25.0

6.25
```

---

# Multiple Bounds

A type parameter can extend one class and multiple interfaces.

Syntax

```java
<T extends Number & Comparable<T>>
```

Example

```java
public static <T extends Number & Comparable<T>>
T max(T a, T b) {

    return a.compareTo(b) > 0 ? a : b;
}
```

---

# Wildcards

Wildcards are represented using

```java
?
```

They provide flexibility while working with generic collections.

---

# Unbounded Wildcard

Syntax

```java
List<?>
```

Accepts any data type.

Example

```java
public static void print(List<?> list) {

    for(Object item : list)

        System.out.println(item);
}
```

Usage

```java
print(List.of(1,2,3));

print(List.of("A","B","C"));
```

Output

```text
1
2
3
A
B
C
```

---

# Upper Bounded Wildcard

Syntax

```java
<? extends Number>
```

Accepts

- Number
- Integer
- Double
- Float
- Long
- Short

Example

```java
public static double sum(List<? extends Number> list) {

    double sum = 0;

    for(Number n : list)

        sum += n.doubleValue();

    return sum;
}
```

Usage

```java
List<Integer> numbers = List.of(1,2,3);

List<Double> values = List.of(2.5,3.5);

System.out.println(sum(numbers));

System.out.println(sum(values));
```

Output

```text
6.0

6.0
```

### Rule

You can safely read elements.

You cannot safely add elements.

```java
List<? extends Number> list = new ArrayList<Integer>();

// list.add(10); // Error
```

---

# Lower Bounded Wildcard

Syntax

```java
<? super Integer>
```

Accepts

- Integer
- Number
- Object

Example

```java
public static void addNumbers(List<? super Integer> list) {

    list.add(10);

    list.add(20);
}
```

Usage

```java
List<Number> list = new ArrayList<>();

addNumbers(list);

System.out.println(list);
```

Output

```text
[10, 20]
```

### Rule

You can safely add `Integer` values.

Reading returns `Object`.

```java
Object obj = list.get(0);
```

---

# PECS Rule

PECS stands for

> **Producer Extends, Consumer Super**

This is one of the most important interview concepts.

---

## Producer

If the collection only produces (returns) data,

use

```java
<? extends T>
```

Example

```java
List<? extends Number>
```

Read Only

---

## Consumer

If the collection only consumes (accepts) data,

use

```java
<? super Integer>
```

Example

```java
List<? super Integer>
```

Write Only

---

# Difference Between extends and super

| extends | super |
|----------|--------|
| Producer | Consumer |
| Read | Write |
| Cannot Add | Can Add |
| Returns Actual Type | Returns Object |

---

# Type Erasure

Generics exist only during compilation.

During compilation,

Java removes all generic information.

Example

```java
List<String>
```

becomes

```java
List
```

at runtime.

This process is called

**Type Erasure**

Reasons

- Backward compatibility
- Older JVMs understand raw types

---

# Restrictions of Generics

## Primitive Types Are Not Allowed

Wrong

```java
Box<int> box;
```

Correct

```java
Box<Integer> box;
```

---

## Cannot Instantiate Type Parameter

Wrong

```java
class Box<T>{

    T obj = new T();
}
```

---

## Cannot Create Generic Arrays

Wrong

```java
T[] array = new T[10];
```

---

## Cannot Use instanceof

Wrong

```java
if(obj instanceof T)
```

---

## Static Fields Cannot Use Type Parameters

Wrong

```java
class Box<T>{

    static T value;
}
```

Reason

Static members belong to the class rather than an individual object, so they cannot depend on the type parameter.

---

# Generic Class vs Generic Method

| Generic Class | Generic Method |
|---------------|----------------|
| Entire class is generic | Only the method is generic |
| Declared after class name | Declared before return type |
| Creates generic objects | Creates generic methods |

Example

```java
class Box<T> {

}
```

Example

```java
public static <T> void print(T value) {

}
```

---

# Best Practices

- Always prefer Generics over raw types.
- Use meaningful type parameter names.
- Avoid unchecked casts.
- Use bounded types whenever appropriate.
- Use wildcards to increase API flexibility.
- Follow the PECS rule.
- Never suppress compiler warnings unless absolutely necessary.

---

# Summary

| Feature | Purpose |
|----------|---------|
| `<T>` | Generic Type |
| Generic Class | Reusable Class |
| Generic Method | Reusable Method |
| Type Bounds | Restrict Allowed Types |
| `<?>` | Any Type |
| `<? extends T>` | Read Data |
| `<? super T>` | Write Data |
| Type Erasure | Removes Generic Information During Compilation |
| PECS | Producer Extends, Consumer Super |

---

# Frequently Asked Interview Questions

## Basic

1. What are Generics in Java?
2. Why were Generics introduced?
3. What are raw types?
4. What are the advantages of Generics?
5. Why are Generics type-safe?

---

## Intermediate

6. Explain Generic Classes.
7. Explain Generic Methods.
8. Difference between Generic Class and Generic Method.
9. What are bounded type parameters?
10. What are Wildcards?
11. Difference between `List<Object>` and `List<String>`.

---

## Advanced

12. Explain the PECS rule.
13. What is Type Erasure?
14. Why can't Generics use primitive types?
15. Why can't we create `new T()`?
16. Why can't we create generic arrays?
17. Why can't static members use generic type parameters?
18. Difference between `extends` and `super`.
19. Explain covariance and contravariance.
20. Why are Generics implemented using Type Erasure?

---

# Key Takeaways

- Generics provide compile-time type safety.
- They eliminate unnecessary type casting.
- Generic classes and methods improve code reusability.
- Type bounds restrict acceptable types.
- Wildcards make APIs more flexible.
- Remember the PECS rule:
    - **Producer → extends**
    - **Consumer → super**
- Java implements Generics using **Type Erasure**, so generic type information is not available at runtime.