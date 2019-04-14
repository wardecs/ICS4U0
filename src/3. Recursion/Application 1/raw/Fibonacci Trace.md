## Fibonacci - Daniel Voznyy

##### Trace fibonacci(6)

f() is being used as the method name instead of fibonacci() for simplicity

```
f(6)
= f(5) + f(4)
= (f(4) + f(3)) + (f(3) + f(2))
= ((f(3) + f(2)) + (f(2) + f(1))) + ((f(2) + f(1)) + 1)
= ((f(2) + f(1)) + 1) + (1 + 1)) + ((1 + 1) + 1)
= ((1 + 1) + 1) + (1 + 1)) + ((1 + 1) + 1)
= 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1
= 8
```
returns 8

##### Trace fibonacci(7)

f(6) and f(5) have been spaced out with tabs to make it easier to understand visually. It would be possible to tab 
every method call like this, but this takes up far too much horizontal space.

```
f(7)
= f(6) + f(5)
= (f(5) + f(4))                                             + (f(4) + f(3))
= ((f(4) + f(3)) + (f(3) + f(2)))                           + ((f(3) + f(2)) + (f(2) + f(1)))
= (((f(3) + f(2)) + (f(2) + f(1))) + ((f(2) + f(1)) + 1))   + (((f(2) + f(1)) + 1) + (1 + 1))
= ((((f(2) + f(1)) + 1) + (1 + 1)) + ((1 + 1) + 1))         + (((1 + 1) + 1) + (1 + 1)) 
= ((((1 + 1) + 1) + (1 + 1)) + ((1 + 1) + 1))               + (((1 + 1) + 1) + (1 + 1)) 
= 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1
= 13
```
returns 13