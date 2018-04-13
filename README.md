# Codility Challenges Solution
The purpose of this project is to study algorithms and keep track of my solutions.

### [Alpha 2010 - PrefixSet](https://app.codility.com/programmers/task/prefix_set/)
A non-empty zero-indexed array A consisting of N integers is given. The *first covering prefix* of
array A is the smallest integer P such that 0≤P<N and such that every value that occurs in array A also occurs in
sequence A[0], A[1], ..., A[P].
For example, the first covering prefix of the following 5−element array A:
  A[0] = 2
  A[1] = 2
  A[2] = 1
  A[3] = 0
  A[4] = 1
is 3, because sequence [ A[0], A[1], A[2], A[3] ] equal to [2, 2, 1, 0], contains all values that occur in array A.

Assume that:
- N is an integer within the range [1..1,000,000];
- each element of array A is an integer within the range [0..N−1].

Complexity:

- expected worst-case time complexity is O(N);
- expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
---

