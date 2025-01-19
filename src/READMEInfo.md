1.Generics: 
2.Bounded type Parameters
3.Fail Fast and Fail Safe:  to solve Concurrent modification using CopuOnWrite Type Variables
4.Atomicity : We use Atomic Variables to keep the data synchronize in multi threaded env 
means if two or more threads reading/ accessing and modifying the variable concurrently the updated value from one 
thread doesn't visible to another thread as while operation result is cached and updated later to variable
using atomicity against variable make sure the updated value to visible and read after one thread execution got over
we can solve Race condition 
5.DeadLock: