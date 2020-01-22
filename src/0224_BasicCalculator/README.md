Use Stack to solve the problem.

The problem can basically be seperated to 4 parts:
  - Digits:
    ```java
    if(c <= '9' && c >= '0') {
       num = num * 10 + (c - '0');
    }
    ```
    We need to handle with the number which is more than 1 digit.
  - `+` or `-` sign:
  
    ```java
    else if(c == '+' || c == '-') {
        ans += sign * num;
        sign = stack.peek() * (c == '+' ? 1 : -1); // handle every sign in the bracket.
        num = 0;
    }
    ```
  - `(` bracket:
  
    The key point in this question is how to handle with the number in the bracket.
    
    We push the sign(last sign) to the top of the stack, so when we meet the sign in the bracket, we just need to
    multiply the last sign to the current sign, and we can then calculate the number. 
    
    For instance, `3 - (9 - 5) = 3 + (-1 * 9) + (-1 * -1 * 5) = 3 - 9 + 5`
    We first push `-`, which is `-1` here, to the top of the stack, and every time we meet the sign in the bracket, we have to 
    multiply the last sign and the current sign. That is how `sign = stack.peek() * (c == '+' ? 1 : -1)` working.
    
  - `)` bracket:
  
    Every time we meet the `(` sign means that we finish the calculation in the bracket, 
    so we have to remove the last sign in the stack. Using 
    ```java
    stack.pop()
    ```
Before return the result, **don't forget the last number!**
```java
ans += sign * num;
return ans;
```
