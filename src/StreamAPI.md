# Java Stream API -- Complete Notes

## 1. What is Stream API?

A **Stream** is a sequence of objects that supports functional-style
operations to process data.

-   Introduced in **Java 8**
-   Does **not** store data
-   Processes data from collections, arrays, or other sources

``` java
List<Integer> numbers = List.of(1,2,3,4,5);
numbers.stream();
```

------------------------------------------------------------------------

## 2. Why Stream API?

Without Streams:

``` java
List<String> result = new ArrayList<>();
for (String name : names) {
    if (name.startsWith("A")) {
        result.add(name.toUpperCase());
    }
}
```

With Streams:

``` java
List<String> result = names.stream()
        .filter(name -> name.startsWith("A"))
        .map(String::toUpperCase)
        .toList();
```

### Advantages

-   Less code
-   More readable
-   Functional programming style
-   Easy filtering and grouping
-   Supports parallel processing

------------------------------------------------------------------------

## 3. Stream Pipeline

    Source
      ↓
    Intermediate Operations
      ↓
    Terminal Operation

Example:

``` java
numbers.stream()
       .filter(n -> n % 2 == 0)
       .map(n -> n * 2)
       .collect(Collectors.toList());
```

------------------------------------------------------------------------

## 4. Creating Streams

### From List

``` java
list.stream();
```

### From Array

``` java
Arrays.stream(arr);
```

### From Values

``` java
Stream.of(1,2,3,4);
```

### Infinite Stream

``` java
Stream.iterate(1, n -> n + 1);
```

### Random Stream

``` java
Stream.generate(Math::random);
```

------------------------------------------------------------------------

## 5. Intermediate Operations

### `filter()`

``` java
numbers.stream().filter(n -> n % 2 == 0);
```

### `map()`

``` java
names.stream().map(String::toUpperCase);
```

### `flatMap()`

``` java
list.stream().flatMap(List::stream);
```

### `distinct()`

``` java
numbers.stream().distinct();
```

### `sorted()`

``` java
numbers.stream().sorted();
```

### `limit()`

``` java
Stream.of(1,2,3,4,5).limit(3);
```

### `skip()`

``` java
Stream.of(1,2,3,4,5).skip(2);
```

### `peek()`

``` java
numbers.stream().peek(System.out::println);
```

------------------------------------------------------------------------

## 6. Terminal Operations

### `collect()`

``` java
.collect(Collectors.toList())
```

### `forEach()`

``` java
numbers.stream().forEach(System.out::println);
```

### `count()`

``` java
numbers.stream().count();
```

### `min()` / `max()`

``` java
numbers.stream().min(Integer::compare);
numbers.stream().max(Integer::compare);
```

### `reduce()`

``` java
numbers.stream().reduce(0, Integer::sum);
```

### `findFirst()`

``` java
numbers.stream().findFirst();
```

### `findAny()`

``` java
numbers.stream().findAny();
```

### Match Operations

``` java
.anyMatch(...)
.allMatch(...)
.noneMatch(...)
```

------------------------------------------------------------------------

## 7. Collectors

### `toList()`

``` java
.collect(Collectors.toList())
```

### `toSet()`

``` java
.collect(Collectors.toSet())
```

### `joining()`

``` java
.collect(Collectors.joining(", "));
```

### `groupingBy()`

``` java
employees.stream()
.collect(Collectors.groupingBy(Employee::getDepartment));
```

### `partitioningBy()`

``` java
numbers.stream()
.collect(Collectors.partitioningBy(n -> n % 2 == 0));
```

### `mapping()`

``` java
Collectors.mapping(Employee::getName, Collectors.toList())
```

------------------------------------------------------------------------

## 8. Method References

Instead of:

``` java
x -> x.length()
```

Use:

``` java
String::length
```

Examples:

``` java
System.out::println
String::toUpperCase
Integer::parseInt
Math::sqrt
```

------------------------------------------------------------------------

## 9. Optional

``` java
Optional<String> name = names.stream().findFirst();

name.orElse("Unknown");
name.orElseGet(...);
name.orElseThrow();
```

------------------------------------------------------------------------

## 10. Parallel Stream

``` java
numbers.parallelStream();
```

Best for large CPU-intensive workloads.

------------------------------------------------------------------------

## 11. Lazy Evaluation

Intermediate operations do nothing until a terminal operation executes.

``` java
numbers.stream()
       .filter(n -> {
           System.out.println(n);
           return true;
       })
       .count();
```

------------------------------------------------------------------------

## 12. Important Differences

### Collection vs Stream

Collection    Stream
  ------------- -----------------------
Stores data   Processes data
Reusable      One-time use
Mutable       Doesn't modify source

### `filter()` vs `map()`

-   **filter()** → Removes elements
-   **map()** → Transforms elements

### `map()` vs `flatMap()`

-   **map()** → One-to-one transformation
-   **flatMap()** → Flattens nested structures

------------------------------------------------------------------------

## 13. Stream Execution Flow

    Collection
       │
    stream()
       │
    filter()
       │
    map()
       │
    sorted()
       │
    collect()
       │
    Result

------------------------------------------------------------------------

## 14. Must-Know Methods

-   stream()
-   filter()
-   map()
-   flatMap()
-   distinct()
-   sorted()
-   limit()
-   skip()
-   peek()
-   collect()
-   reduce()
-   forEach()
-   count()
-   findFirst()
-   findAny()
-   anyMatch()
-   allMatch()
-   noneMatch()
-   min()
-   max()
-   groupingBy()
-   partitioningBy()
-   joining()
-   toMap()
-   Comparator.comparing()
-   Comparator.comparingInt()
-   Comparator.comparingDouble()
-   Map.computeIfAbsent()