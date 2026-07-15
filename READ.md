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


when you see:
    When it works
        Condition must be:
            If valid for K → also valid for K+1

    eg->
        Typical valid cases
        distinct elements
        number of unique chars
        sum ≤ K
        at most K odd numbers
    
    exact(K) = atMost(K) - atMost(K-1)


    (subarrays(k) => j-i+1 (subarrays that ends at j from i) how?:->
        (j,j), (j-1, j), (j-2, j), ..., (i, j)
        therefore: j-i+1
        )

        Why subtraction works
            atMost(K)     → includes all ≤ K
            atMost(K-1)   → includes all ≤ K-1

            Subtract:
            only exactly K remains


If unsure → use long
If multiplying → use 1L

Sorting pattern
    Subarray starting or ending at an index
 