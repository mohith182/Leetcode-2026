# 18. 4Sum

## Overview

The 4Sum problem asks us to find all unique quadruplets in an array whose sum is equal to a given target.

A quadruplet consists of four distinct indices:

```
nums[a] + nums[b] + nums[c] + nums[d] == target
```

The result should contain only unique quadruplets.

---

# Intuition

The brute force approach uses four nested loops to check every possible combination.

```
Choose i
Choose j
Choose k
Choose l
Check the sum
```

Time Complexity:

```
O(n⁴)
```

This is inefficient for large arrays.

Instead, we can optimize it by reducing the last two loops into a Two Pointer search.

---

# Key Observation

After sorting the array:

- Smaller numbers appear on the left.
- Larger numbers appear on the right.

This allows us to move pointers efficiently instead of checking every combination.

---
<div>
    <img width="1024" height="1536" alt="e6facb50-df05-4e80-8f20-bc9237128ecd" src="https://github.com/user-attachments/assets/5afc56be-41aa-4ded-845f-18a64e5db19e" />

</div>
# Approach

### Step 1

Sort the array.

Sorting makes duplicate removal easier and enables the Two Pointer technique.

---

### Step 2

Fix the first element.

```
for i
```

This selects the first number of the quadruplet.

---

### Step 3

Fix the second element.

```
for j
```

Now we have selected two numbers.

---

### Step 4

Use Two Pointers.

```
left = j + 1
right = n - 1
```

The remaining two numbers are searched using the Two Pointer technique.

---

# Pointer Movement

Calculate

```
sum =
nums[i]
+ nums[j]
+ nums[left]
+ nums[right]
```

### Case 1

If

```
sum == target
```

Store the quadruplet.

Move

```
left++
right--
```

Skip duplicates.

---

### Case 2

If

```
sum < target
```

Need a larger sum.

Move

```
left++
```

---

### Case 3

If

```
sum > target
```

Need a smaller sum.

Move

```
right--
```

---

# Duplicate Handling

Duplicate values create duplicate quadruplets.

Skip duplicates for:

- First element (`i`)
- Second element (`j`)
- Third element (`left`)
- Fourth element (`right`)

This guarantees every quadruplet appears only once.

---

# Why Sorting?

Sorting provides two important advantages.

### 1. Enables Two Pointers

Since the array is ordered,

moving left increases the sum,

moving right decreases the sum.

---

### 2. Easy Duplicate Removal

Equal numbers become adjacent.

This makes duplicate skipping simple.

---

# Why Use Long?

The array values can be as large as

```
1,000,000,000
```

Example:

```
1000000000
+1000000000
+1000000000
+1000000000
```

Result:

```
4000000000
```

This exceeds the maximum value of an `int`.

Using

```
long sum
```

prevents integer overflow.

---

# Algorithm

```
Sort the array

for each i

    Skip duplicate i

    for each j

        Skip duplicate j

        left = j + 1
        right = n - 1

        while(left < right)

            Calculate sum

            if(sum == target)

                Store answer

                left++
                right--

                Skip duplicate left
                Skip duplicate right

            else if(sum < target)

                left++

            else

                right--
```

---

# Dry Run

Input

```
nums = [1,0,-1,0,-2,2]
target = 0
```

Sorted Array

```
[-2,-1,0,0,1,2]
```

Choose

```
i = -2

j = -1

left = 0

right = 2
```

Current Sum

```
-2 + (-1) + 0 + 2

= -1
```

Less than target.

Move

```
left++
```

Now

```
-2 + (-1) + 1 + 2

= 0
```

Target found.

Store

```
[-2,-1,1,2]
```

Continue searching until all unique quadruplets are found.

---

# Complexity Analysis

Sorting

```
O(n log n)
```

Outer Loop

```
O(n)
```

Second Loop

```
O(n)
```

Two Pointer Traversal

```
O(n)
```

Overall Time Complexity

```
O(n³)
```

Space Complexity

```
O(1)
```

(Excluding the output list)

---

# Key Takeaways

- Sort the array before processing.
- Fix the first two elements.
- Use Two Pointers for the remaining two elements.
- Skip duplicates at every level.
- Use `long` to avoid integer overflow.
- Two Pointers reduce the brute force solution from **O(n⁴)** to **O(n³)**.

---

# Pattern Learned

This problem extends the Two Pointer pattern.

```
2Sum
↓
3Sum
↓
4Sum
```

The general idea is:

- Fix some elements.
- Solve the remaining part using Two Pointers.
- Skip duplicates.
- Continue until all unique combinations are found.

This pattern is commonly used in array and interview problems involving combinations and target sums.
