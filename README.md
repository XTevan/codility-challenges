# Codility Challenges Solution
The purpose of this project is to study algorithms and keep track of my solutions.

### [Alpha 2010 - PrefixSet](https://app.codility.com/programmers/task/prefix_set/)
A non-empty zero-indexed array A consisting of N integers is given. The *first covering prefix* of
array A is the smallest integer P such that 0≤P<N and such that every value that occurs in array A also occurs in
sequence A[0], A[1], ..., A[P].
For example, the first covering prefix of the following 5−element array A:
 ```
  A[0] = 2
  A[1] = 2
  A[2] = 1
  A[3] = 0
  A[4] = 1
 ```
is 3, because sequence [ A[0], A[1], A[2], A[3] ] equal to [2, 2, 1, 0], contains all values that occur in array A.

Assume that:
- N is an integer within the range [1..1,000,000];
- each element of array A is an integer within the range [0..N−1].

Complexity:

- expected worst-case time complexity is O(N);
- expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
---

### [Beta 2010 - NumberOfDescIntersections](https://app.codility.com/programmers/task/number_of_disc_intersections/)
We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:

  ```
  A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0
  ```
  
  ![discs](https://codility-frontend-prod.s3.amazonaws.com/media/task_static/number_of_disc_intersections/static/images/auto/0eed8918b13a735f4e396c9a87182a38.png)
  
  There are eleven (unordered) pairs of discs that intersect, namely:
  
  discs 1 and 4 intersect, and both intersect with all the other discs;
  disc 2 also intersects with discs 0 and 3.
  Write a function:
  
  ```class Solution { public int solution(int[] A); }```
  
  that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.
  
  Given array A shown above, the function should return 11, as explained above.
  
  Assume that:
  - N is an integer within the range [0..100,000];
  - each element of array A is an integer within the range [0..2,147,483,647].
  Complexity:
  - expected worst-case time complexity is O(N*log(N));
  - expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).