1.Generics: 
2.Bounded type Parameters
3.Fail Fast and Fail Safe:  to solve Concurrent modification using CopuOnWrite Type Variables
4.Atomicity : We use Atomic Variables to keep the data synchronize in multi threaded env 
means if two or more threads reading/ accessing and modifying the variable concurrently the updated value from one 
thread doesn't visible to another thread as while operation result is cached and updated later to variable
using atomicity against variable make sure the updated value to visible and read after one thread execution got over
we can solve Race condition 
5.DeadLock: in Multithreading diamond problems occurs when two or more threads waiting for indefinite time for other thread
to release the Resources.
6.Optional classes: Introduced in java8 ,container that  it holds nullable and non nullable values init.
return Optional.ofNullable(pass any object);
ex:  Optional<User> user = userRepo.findById(id)
user.ifPresentOrElse ( user -> sout("username"+ user.getname,
() -> sout.("user not found") 
);
7.Visibility problem in MultiThreading

8.Thread Pool: it distributes tasks amoung threads ex:  if 3 tasks executing we have Excecutors of size 2,
2 threads are created and will be in core pool , thread pool assigns incoming tasks to threads which are ideal, if extra
tasks got assigned it'll send them in Blocking queue, if any of thread got completed or waiting for other db operations 
it'll assign some other task to this thread.

9.Hashmap in Java: Stores key value pairs, initial capacity is 16, 
10.Daemon thread: Non priority thread which used for GC, background processing task, cpu don't wait for thread to compplete task

11.Anonymous and lambda class : anonymous class can implement both Abstract class and Interface where as Lambda used for functional interfaces;
12.callable vs runnable: both are Functional interfaces , both used to execute the task Asynchronously
Runnable -> run callable -> call , 
runnable -> does not return the a result and can't throw a checked exception
Callable -> returns the result and can throw an checked exception

13.Garbage collection: G1 Garbage collector
G1 has 4 phases: Phase 1: MarkLive objects Phase2: Prepare for Compaction Phase3: Adjust pointers phas4: Compact heap
it'll divide heap into 5 

14.CompletableFuture: power full way to work with asynchronous computations in java

15.Blue Green deployment : Live regions would be blue and testing will be in green after testing Traffic will be passed 
to another instance.

16.Regular expression: 

17.Producer and Consumer Problem: also known as Buffered bounded problem
Producer where is puts data/message into the buffer and consumer consumes that data
 scenario 1. where producer is putting data/message into the buffer in 


