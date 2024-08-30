/* 
Reduce Gifts
🔥 FULLTIME
📚
RELATED PROBLEMS
New Year's Day is around the corner and Amazon is having a sale. They have a list of items they are considering but they may need to remove some of them. Determine the minimum number of items to remove from an array of prices so that the sum of prices of any k items does not exceed a threshold.

Note: If the number of items in the list is less than k, then there is no need to remove any more items.

Function Description

Complete the function reduceGifts in the editor.

reduceGifts has the following parameters:

1. int prices[n]: the prices of each item
2. int k: the number of items to sum
3. int threshold: the maximum price of k items
Returns

int: the minimum number of items to remove

🌷ଓ༉｡ﾟCredit to ꒰ა buddi ໒꒱

Example 1:

Input:  prices = [3, 2, 1, 4, 6, 5], k = 3, threshold = 14
Output: 1 
Explanation:



The sum of prices for every k = 3 items must not be more than threshold = 14. The sum of the prices of the last three items is 6 + 5 + 4 = 15. The item priced $6 can be removed leaving:
  


No 3 items' prices sum to greater than 14. Only 1 item needs to be removed.
      
Example 2:

Input:  prices = [9, 6, 7, 2, 7, 2], k = 2, threshold = 13
Output: 2 
Explanation:

Items with prices 9 and 7 have a sum larger than 13. After removing these two items, prices' = [6, 2, 7, 2].

No k items have a sum of prices greater than threshold.
      
Example 3:

Input:  prices = [9, 6, 3, 2, 9, 10, 10, 11], k = 4, threshold = 1
Output: 5 
Explanation:

Since no price is less than or equal to threshold, the sum of any k elements will always be greater than threshold.

The threshold only applies to goups of k items. Now the goal is to reduce the arr length to k - 1 which requires the removal of 5 elements.
      
Constraints:
1 <= k <= n <= 105
1 <= threshold <= 109
1 <= prices[i] <= 100

*/

public int reduceGifts(int[] prices, int k, int threshold) 
{
  //Base Check
  if(prices == null || prices.length < k)
  {
    return 0;
  }

  //Init
  int value;

  //Compute
  /** Sort the given array */
  Arrays.sort(prices);

  /** Find the minimum number of elements to be removed */
  int prevSum = 0;
  for(int i = prices.length - 1; i >= prices.length - (k - 1); i--)
  {
    prevSum += prices[i];
  }

  int index = k - 2;
  for(int i = prices.length - 1; i >= k - 1; i --)
  {
    //current subaray of size k
    /** compute the sum of elements in the current subarray */
    int currentSum = prevSum;
    currentSum -= i + 1 == prices.length ? 0 : prices[i + 1];
    currentSum += prices[i - (k - 1)];

    /** check if the current subarray satisfies the requirement */
    if(currentSum <= threshold)
    {
      index = i;
      break;
    }

    //update prevSum
    prevSum = currentSum;
    
  }

  /** update value */
  value = (prices.length - 1) - index;

  //Return
  return value;
  
}


