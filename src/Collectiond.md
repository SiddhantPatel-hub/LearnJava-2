# Java Collections Framework -- Complete Notes

## 1. What is the Java Collections Framework (JCF)?

The Java Collections Framework (JCF) is a set of interfaces and classes
used to store, manipulate, and process groups of objects efficiently.

**Benefits** - Dynamic resizing - Reusable data structures - Built-in
algorithms (sorting, searching) - Type safety with Generics

------------------------------------------------------------------------

## 2. Collection Hierarchy

``` text
Iterable
   │
Collection
├── List
│   ├── ArrayList
│   ├── LinkedList
│   └── Vector
│       └── Stack
├── Set
│   ├── HashSet
│   ├── LinkedHashSet
│   └── TreeSet
└── Queue
    ├── PriorityQueue
    ├── ArrayDeque
    └── LinkedList

Map (Separate hierarchy)
├── HashMap
├── LinkedHashMap
├── TreeMap
├── Hashtable
└── ConcurrentHashMap
```

------------------------------------------------------------------------

## 3. Core Interfaces

### Collection

Base interface for List, Set, and Queue.

Common methods:

``` java
add()
remove()
contains()
size()
isEmpty()
clear()
iterator()
```

### List

-   Ordered
-   Allows duplicates
-   Index-based access

Examples:

``` java
List<String> list = new ArrayList<>();
```

#### ArrayList

-   Backed by dynamic array
-   Fast random access: O(1)
-   Insert/Delete middle: O(n)

#### LinkedList

-   Doubly linked list
-   Fast insert/delete at ends
-   Random access: O(n)

#### Vector

-   Synchronized
-   Slower than ArrayList

#### Stack

-   LIFO

``` java
push();
pop();
peek();
```

------------------------------------------------------------------------

### Set

-   No duplicates

#### HashSet

-   Unordered
-   Average O(1)

#### LinkedHashSet

-   Maintains insertion order

#### TreeSet

-   Sorted
-   O(log n)

------------------------------------------------------------------------

### Queue

#### PriorityQueue

-   Natural/comparator ordering
-   peek() returns highest-priority element

#### ArrayDeque

-   Faster than Stack for stack/queue operations

------------------------------------------------------------------------

## 4. Map

Stores key-value pairs.

### HashMap

-   Unordered
-   One null key, multiple null values
-   Average O(1)

### LinkedHashMap

-   Preserves insertion order

### TreeMap

-   Sorted by keys
-   O(log n)

### Hashtable

-   Thread-safe
-   No null keys or values

### ConcurrentHashMap

-   Thread-safe
-   Better concurrency than Hashtable

------------------------------------------------------------------------

## 5. Iteration

Enhanced for-loop

``` java
for(String s : list){
    System.out.println(s);
}
```

Iterator

``` java
Iterator<String> it = list.iterator();
while(it.hasNext()){
    System.out.println(it.next());
}
```

Stream

``` java
list.stream().forEach(System.out::println);
```

------------------------------------------------------------------------

## 6. Collections Utility Class

``` java
Collections.sort(list);
Collections.reverse(list);
Collections.shuffle(list);
Collections.max(list);
Collections.min(list);
Collections.binarySearch(list, value);
Collections.frequency(list, value);
```

------------------------------------------------------------------------

## 7. Comparable vs Comparator

### Comparable

``` java
class Student implements Comparable<Student>{
    public int compareTo(Student s){
        return this.id - s.id;
    }
}
```

### Comparator

``` java
students.sort(Comparator.comparing(Student::getName));
```

------------------------------------------------------------------------

## 8. Time Complexity

Structure      Search     Insert     Delete    Random Access
  ------------ ---------- ---------- ---------- ---------------
ArrayList       O(n)      O(1)\*      O(n)         O(1)
LinkedList      O(n)     O(1)\*\*   O(1)\*\*       O(n)
HashSet         O(1)       O(1)       O(1)          \-
TreeSet       O(log n)   O(log n)   O(log n)        \-
HashMap         O(1)       O(1)       O(1)          \-
TreeMap       O(log n)   O(log n)   O(log n)        \-

\* Amortized at end, \*\* when node position is known.

------------------------------------------------------------------------

## 9. Common Interview Questions

-   ArrayList vs LinkedList
-   HashMap vs Hashtable
-   HashMap vs TreeMap
-   HashSet vs LinkedHashSet vs TreeSet
-   Comparable vs Comparator
-   fail-fast vs fail-safe iterator
-   Why equals() and hashCode() matter?
-   Why is HashMap O(1)?
-   Why is TreeMap O(log n)?

------------------------------------------------------------------------

## 10. Best Practices

-   Use interfaces (`List`, `Set`, `Map`) as variable types.
-   Prefer `ArrayList` unless frequent middle insertions/deletions.
-   Use `HashSet` for uniqueness.
-   Use `TreeSet` or `TreeMap` for sorted data.
-   Use `ArrayDeque` instead of `Stack`.
-   Use `ConcurrentHashMap` in concurrent code.

------------------------------------------------------------------------

## 11. Collections vs Collection

Collection                     Collections
  ------------------------------ ------------------------------------
Interface                      Utility class
Stores elements                Provides helper algorithms
Extended by List, Set, Queue   sort(), reverse(), shuffle(), etc.

------------------------------------------------------------------------

## 12. Key Methods to Remember

-   add()
-   remove()
-   contains()
-   get()
-   set()
-   put()
-   putIfAbsent()
-   computeIfAbsent()
-   merge()
-   keySet()
-   values()
-   entrySet()
-   offer()
-   poll()
-   peek()
-   push()
-   pop()
-   iterator()
-   sort()
-   binarySearch()