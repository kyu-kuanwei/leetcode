
f(n) = f(n-1) + f(n-2)
But there are some conditions to be considered,
- We can count f(n - 1) only if s(n) is not 0.
  Since 0 do not match to any letter, for instance, 10 should only count 1 way to decode.
- And we can count f(n - 2) only if the number composed of s(n-1) and s(n) is located from 10 - 26, which do match with a letter.
