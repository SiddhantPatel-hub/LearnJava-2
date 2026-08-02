# Multithreaded Programming -- Complete Notes

## 1. What is Multithreading?

Multithreading is the ability of a program to execute multiple threads
concurrently. A **thread** is the smallest unit of execution inside a
process.

### Benefits

-   Better CPU utilization
-   Improved responsiveness
-   Parallel task execution
-   Efficient resource sharing

------------------------------------------------------------------------

## 2. Process vs Thread

Process                   Thread
  ------------------------- -------------------------------
Independent program       Lightweight unit of execution
Own memory                Shares process memory
Expensive to create       Cheaper to create
Communication is slower   Communication is faster

------------------------------------------------------------------------

# 3. Creating Threads

## A. Extending `Thread`

``` java
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Running...");
    }
}

new MyThread().start();
```

## B. Implementing `Runnable` (Preferred)

``` java
class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Task running");
    }
}

Thread t = new Thread(new Task());
t.start();
```

## C. Lambda

``` java
new Thread(() -> System.out.println("Hello")).start();
```

## D. Callable + Future

Returns a value and can throw checked exceptions.

``` java
ExecutorService executor = Executors.newSingleThreadExecutor();

Future<Integer> future =
    executor.submit(() -> 42);

System.out.println(future.get());

executor.shutdown();
```

------------------------------------------------------------------------

# 4. Thread Lifecycle

``` text
NEW
 │
 ▼
RUNNABLE
 │
 ▼
RUNNING
 │
 ├── BLOCKED
 ├── WAITING
 ├── TIMED_WAITING
 ▼
TERMINATED
```

------------------------------------------------------------------------

# 5. Common Thread Methods

``` java
start();
run();
join();
sleep(1000);
interrupt();
isAlive();
currentThread();
```

------------------------------------------------------------------------

# 6. Synchronization

Synchronization prevents multiple threads from corrupting shared data.

## Problem

``` java
count++;
```

This is **not atomic**.

## Synchronized Method

``` java
public synchronized void increment() {
    count++;
}
```

## Synchronized Block

``` java
synchronized(lock) {
    count++;
}
```

### Advantages

-   Prevents race conditions
-   Ensures mutual exclusion

### Disadvantages

-   Slower due to locking
-   Can lead to deadlocks

------------------------------------------------------------------------

# 7. Deadlock

Occurs when two threads wait forever for each other.

``` text
Thread A -> Lock1 -> waiting for Lock2

Thread B -> Lock2 -> waiting for Lock1
```

### Prevention

-   Acquire locks in a fixed order
-   Keep lock scope small
-   Use `tryLock()` where appropriate

------------------------------------------------------------------------

# 8. Volatile

Ensures visibility of updates across threads.

``` java
private volatile boolean running = true;
```

Use when multiple threads read/write a simple variable.

------------------------------------------------------------------------

# 9. Atomic Classes

Lock-free thread-safe operations.

``` java
AtomicInteger counter = new AtomicInteger();

counter.incrementAndGet();
counter.decrementAndGet();
counter.get();
```

------------------------------------------------------------------------

# 10. Executors Framework

Instead of manually creating threads, use thread pools.

``` java
ExecutorService executor =
    Executors.newFixedThreadPool(4);
```

## Common Factory Methods

``` java
Executors.newFixedThreadPool(5);
Executors.newCachedThreadPool();
Executors.newSingleThreadExecutor();
Executors.newScheduledThreadPool(2);
```

### Submit Task

``` java
executor.submit(() -> System.out.println("Task"));
```

### Shutdown

``` java
executor.shutdown();
```

Always shut down an ExecutorService.

------------------------------------------------------------------------

# 11. Future

Represents the result of an asynchronous computation.

``` java
Future<Integer> future =
executor.submit(() -> 100);

int result = future.get();
```

Useful methods

``` java
get();
isDone();
cancel(true);
```

------------------------------------------------------------------------

# 12. Collections and Thread Safety

## Not Thread-Safe

-   ArrayList
-   HashMap
-   HashSet

## Legacy Thread-Safe

-   Vector
-   Hashtable

## Synchronized Wrappers

``` java
List<Integer> list =
Collections.synchronizedList(new ArrayList<>());
```

``` java
Map<Integer,String> map =
Collections.synchronizedMap(new HashMap<>());
```

## Concurrent Collections

### ConcurrentHashMap

``` java
ConcurrentHashMap<String,Integer> map =
new ConcurrentHashMap<>();
```

Supports concurrent reads and writes.

### CopyOnWriteArrayList

``` java
CopyOnWriteArrayList<String> list =
new CopyOnWriteArrayList<>();
```

Good when reads greatly outnumber writes.

### BlockingQueue

``` java
BlockingQueue<Integer> queue =
new LinkedBlockingQueue<>();
```

Useful for Producer--Consumer problems.

------------------------------------------------------------------------

# 13. Fail-Fast vs Fail-Safe

## Fail-Fast

-   ArrayList
-   HashMap

Throws `ConcurrentModificationException`.

## Fail-Safe

-   CopyOnWriteArrayList
-   ConcurrentHashMap

Iterates over a safe snapshot or weakly consistent view.

------------------------------------------------------------------------

# 14. Best Practices

-   Prefer `Runnable` or `Callable` over extending `Thread`.
-   Prefer `ExecutorService` instead of manually managing threads.
-   Minimize shared mutable state.
-   Use concurrent collections when multiple threads access data.
-   Prefer `AtomicInteger` for simple counters.
-   Avoid unnecessary synchronization.

------------------------------------------------------------------------

# 15. Interview Questions

1.  Thread vs Process
2.  Runnable vs Callable
3.  start() vs run()
4.  synchronized method vs block
5.  volatile vs synchronized
6.  HashMap vs ConcurrentHashMap
7.  ExecutorService vs Thread
8.  Future vs CompletableFuture
9.  Deadlock and prevention
10. AtomicInteger vs synchronized

------------------------------------------------------------------------

# 16. Summary

-   **Thread**: Lightweight execution unit.
-   **Synchronization**: Protects shared data.
-   **ExecutorService**: Efficient thread management.
-   **ConcurrentHashMap**: Thread-safe map.
-   **CopyOnWriteArrayList**: Thread-safe list for read-heavy workloads.
-   **AtomicInteger**: Lock-free counter.