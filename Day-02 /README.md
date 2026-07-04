# Day 02 - LeetCode Solutions

## 136. Single Number

### Approach

The problem states that every element in the array appears **twice** except for one unique element. The goal is to find that unique element in **O(n)** time while using **O(1)** extra space.

Instead of using a `HashMap` or `HashSet`, this solution uses the **XOR (^) operator**, which has two important properties:

- `a ^ a = 0`
- `a ^ 0 = a`

When we XOR all the elements in the array:

- Every duplicate pair cancels itself out.
- The only value left is the unique number.

### Example

```text
nums = [4, 1, 2, 1, 2]

Initial result = 0

result = 0 ^ 4 = 4
result = 4 ^ 1 = 5
result = 5 ^ 2 = 7
result = 7 ^ 1 = 6
result = 6 ^ 2 = 4

Answer = 4
```

### Algorithm

1. Initialize a variable `result = 0`.
2. Traverse the array.
3. XOR every element with `result`.
4. Return `result`.

### Why this works

Since duplicate numbers always become `0` after XOR, only the element without a duplicate remains.

### Complexity Analysis

| Complexity | Value |
|------------|-------|
| Time Complexity | **O(n)** |
| Space Complexity | **O(1)** |

---

## 70. Climbing Stairs

### Approach (Dynamic Programming)

To reach the **nth** stair, there are only two possibilities:

- Climb **1** step from `(n-1)`
- Climb **2** steps from `(n-2)`

Therefore,

```text
ways(n) = ways(n-1) + ways(n-2)
```

This follows the **Fibonacci sequence**.

Instead of storing all previous values in an array, we only keep track of the last two answers, reducing the space complexity to **O(1)**.

### Dry Run

Suppose:

```text
n = 5
```

Initially,

```text
a = 1
b = 2
```

| Iteration | c = a + b | a | b |
|-----------|-----------|---|---|
| Start | - | 1 | 2 |
| i = 3 | 3 | 2 | 3 |
| i = 4 | 5 | 3 | 5 |
| i = 5 | 8 | 5 | 8 |

Answer:

```text
8
```

### Algorithm

1. If `n <= 2`, return `n`.
2. Initialize:
   - `a = 1`
   - `b = 2`
3. Iterate from `3` to `n`.
4. Compute:

```text
c = a + b
```

5. Update:

```text
a = b
b = c
```

6. Return `c`.

### Why this works

Every stair can only be reached from one of the previous two stairs.

Therefore, the total number of ways to reach stair `n` is the sum of:

- Ways to reach `(n-1)`
- Ways to reach `(n-2)`

This is exactly the Fibonacci recurrence relation.

### Complexity Analysis

| Complexity | Value |
|------------|-------|
| Time Complexity | **O(n)** |
| Space Complexity | **O(1)** |

---

## Key Takeaways

### 136. Single Number

- Uses Bit Manipulation with the XOR operator.
- Duplicate elements cancel each other out.
- Does not require any extra data structures.
- Achieves **O(n)** time complexity and **O(1)** space complexity.

### 70. Climbing Stairs

- Classic Dynamic Programming problem.
- Based on the Fibonacci recurrence relation.
- Optimized to use constant extra space.
- Achieves **O(n)** time complexity and **O(1)** space complexity.
