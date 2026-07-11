# 189. Rotate Array

## Problem
Given an integer array `nums`, rotate the array to the **right** by `k` steps.

**Example:**

```text
Input:
nums = [1,2,3,4,5,6,7]
k = 3

Output:
[5,6,7,1,2,3,4]
```

---

## Approach (Reverse Algorithm)

Instead of moving elements one by one, we rotate the array using **3 reverse operations**.

### Step 1: Reverse the entire array

```text
[1,2,3,4,5,6,7]

↓

[7,6,5,4,3,2,1]
```

---

### Step 2: Reverse the first `k` elements

```text
[7,6,5,4,3,2,1]

↓

[5,6,7,4,3,2,1]
```

---

### Step 3: Reverse the remaining elements

```text
[5,6,7,4,3,2,1]

↓

[5,6,7,1,2,3,4]
```

---

## Code Explanation

```java
int n = nums.length;
```

- Find the size of the array.

---

```java
k = k % n;
```

- Handles cases where `k` is greater than the array length.
- Example:
  - `k = 10`
  - `n = 7`
  - `10 % 7 = 3`

So rotating 10 times is the same as rotating 3 times.

---

```java
reverse(nums, 0, n - 1);
```

- Reverse the entire array.

---

```java
reverse(nums, 0, k - 1);
```

- Reverse the first `k` elements.

---

```java
reverse(nums, k, n - 1);
```

- Reverse the remaining elements.

---

## Reverse Function

```java
private void reverse(int[] nums, int left, int right)
```

This function reverses the array between the given indices.

### Logic

```java
while (left < right)
```

- Continue until both pointers meet.

```java
int temp = nums[left];
nums[left] = nums[right];
nums[right] = temp;
```

- Swap the left and right elements.

```java
left++;
right--;
```

- Move both pointers toward the center.

---

## Time Complexity

```text
O(n)
```

- Three reverse operations.
- Each reverse takes **O(n)**.
- Overall complexity is **O(n)**.

---

## Space Complexity

```text
O(1)
```

- No extra array is used.
- Rotation is performed **in-place**.

---

## Key Takeaway

The Reverse Algorithm rotates the array efficiently by:

1. Reverse the entire array.
2. Reverse the first `k` elements.
3. Reverse the remaining elements.

This achieves the required rotation in **O(n)** time and **O(1)** extra space.
