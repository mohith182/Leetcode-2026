# 🚀 Day 01 - Reverse Integer

## 📌 Problem

Given a signed 32-bit integer `x`, return `x` with its digits reversed.

If reversing the integer causes the value to go outside the signed 32-bit integer range `[-2³¹, 2³¹ - 1]`, return `0`.

**LeetCode Link:** https://leetcode.com/problems/reverse-integer/

---

## 💡 Approach

1. Determine whether the number is positive or negative.
2. Convert the number to its absolute value.
3. Reverse the digits by:
   - Extracting the last digit using `% 10`
   - Appending it to the reversed number
   - Removing the last digit using `/ 10`
4. Check for integer overflow.
5. Restore the original sign and return the result.

---

## 📝 Algorithm

```
Store the sign of the number.

Convert x to its absolute value.

Initialize:
reverse = 0

While x > 0:
    digit = x % 10
    reverse = reverse * 10 + digit
    x = x / 10

If reverse exceeds Integer range:
    return 0

If original number was negative:
    return -reverse

Return reverse
```

---

## 💻 Java Solution

```java
class Solution {
    public int reverse(int x) {
        boolean sign = true;

        if (x < 0) {
            sign = false;
        }

        x = Math.abs(x);

        long total = 0;

        while (x > 0) {
            total = total * 10 + (x % 10);
            x = x / 10;

            if (total > Integer.MAX_VALUE || total < Integer.MIN_VALUE)
                return 0;
        }

        if (!sign)
            return -1 * (int) total;

        return (int) total;
    }
}
```

---

## 🧪 Example

### Input

```
123
```

### Output

```
321
```

---

### Input

```
-120
```

### Output

```
-21
```

---

## ⏱️ Complexity Analysis

| Complexity | Value |
|------------|-------|
| Time Complexity | O(log₁₀ n) |
| Space Complexity | O(1) |

---

## 📚 Key Learnings

- Reversing an integer using modulo (`%`) and division (`/`).
- Handling positive and negative numbers.
- Detecting integer overflow.
- Using `long` during computation to avoid overflow while reversing.
- Understanding time and space complexity.

---

## 🎯 Status

- ✅ Solved
- ☕ Language: Java
- 📅 Day: 01
- 🔥 Difficulty: Medium
