# 122. Best Time to Buy and Sell Stock II

## Problem Statement

You are given an integer array `prices`, where `prices[i]` represents the stock price on the `iᵗʰ` day.

You can:
- Buy and sell the stock multiple times.
- Hold **at most one stock** at any time.
- Buy and sell on the same day if needed.

Return the **maximum profit** that can be achieved.

**LeetCode:** Medium

---

## Intuition

Instead of finding the perfect buy and sell points, notice one simple fact:

- If tomorrow's price is higher than today's price, we should take that profit.
- Every increase contributes to the final maximum profit.

So, we simply add every positive price difference.

---

## Greedy Approach

1. Initialize `profit = 0`.
2. Traverse the array from Day 1 to Day n-1.
3. If today's price is greater than yesterday's price:
   - Add the difference to profit.
4. Return the total profit.

---

## Algorithm

```
profit = 0

for i = 1 to n-1
    if prices[i] > prices[i-1]
        profit += prices[i] - prices[i-1]

return profit
```

---

## Dry Run

### Input

```
prices = [7,1,5,3,6,4]
```

| Day | Previous Price | Current Price | Action | Profit |
|----|----|----|----|----|
|1|7|1|No Profit|0|
|2|1|5|Add (5-1)|4|
|3|5|3|No Profit|4|
|4|3|6|Add (6-3)|7|
|5|6|4|No Profit|7|

### Final Answer

```
Maximum Profit = 7
```

---

## Why Greedy Works

Every increasing sequence can be broken into smaller profitable transactions.

Example:

```
1 → 2 → 3 → 4
```

Profit by one transaction:

```
4 - 1 = 3
```

Profit by multiple transactions:

```
(2-1) + (3-2) + (4-3)
= 1 + 1 + 1
= 3
```

Both produce the same profit.

Therefore, capturing every positive difference always gives the maximum profit.

---

## Java Solution

```java
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}
```

---

## Complexity Analysis

| Complexity | Value |
|------------|-------|
| Time Complexity | **O(n)** |
| Space Complexity | **O(1)** |

---

## Key Takeaways

- Greedy Algorithm
- Add every positive difference.
- Ignore decreasing prices.
- No need to explicitly track buy/sell days.
- Single pass through the array.
- Constant extra space.

---

## Visual Idea

```
Prices

7
│
│
1 ─────── Buy
        \
         \
5 ─────── Sell (+4)

3 ─────── Buy
        \
         \
6 ─────── Sell (+3)

4

Total Profit = 4 + 3 = 7
```

---

## Pattern Recognition

This problem belongs to:

- Greedy Algorithms
- Array Traversal
- Peak-Valley Strategy

**Rule to Remember**

> Whenever the next day's price is higher than today's price, collect that profit immediately.

---
