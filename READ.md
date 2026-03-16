When you see:

    *Intervals
    *Profit / weight
    *Non-overlapping constraint
    *Maximize something
    ->
        *Immediate checklist:
        *Sort by start (or end)
        *Binary search next compatible
        *DP backward

        dp[i] = max(skip, take)