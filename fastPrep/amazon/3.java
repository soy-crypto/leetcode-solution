public int maximizeNegativePnLMonths(int[] PnL) 
{
  //Base Check
  if(PnL == null || PnL[0] <= 0)
  {
    return 0;
  }

  //Init
  int value;

  //Compute
  int count = 0, prevSum = PnL[0];
  PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
  for(int i = 1; i < PnL.length; i++)
  {
    //current sum
    int currentSum = prevSum + PnL[i];
    if(prevSum - PnL[i] > 0)
    {
        currentSum = prevSum - PnL[i];
        pq.offer(PnL[i]);
        count++;
    }
    else 
    {
        if(!pq.isEmpty())
        {
            if((prevSum + pq.peek() * 2 - PnL[i] > 0) && (pq.peek() - PnL[i] > 0))
            {
              currentSum = prevSum + pq.peek() * 2 - PnL[i];
              pq.poll();
              pq.offer(PnL[i]);
              
            }// if
          
        }// if
      
    }// else
    
    //update currentSum
    prevSum = currentSum;
    
  }// for

  /** update velue */
  value = count;

  //Return
  return value;
  
}


/*
 * 
 * Maximize Negative PnL Months
🔥 FULLTIME
📚
RELATED PROBLEMS
You are analyzing the market trends of Amazon stocks. An AWS financial service model returned an array of integers, PnL (Profit and Loss), for your portfolio representing that in the ith month, you will either gain or lose PnL[i]. All reported PnL values are positive, representing gains.

As part of the analysis, you will perform the following operation on the PnL array any number of times:

Choose any month (0 ≤ i < n) and multiply PnL[i] by -1
Find the maximum number of months you can afford to face a loss, i.e., have a negative PnL, such that the cumulative PnL for each of the n months remains strictly positive i.e. remains greater than 0.

Note: The cumulative PnL for the ith month is defined as the sum of PnL from the starting month up to the ith month. For example, the cumulative PnL for the PnL = [3, -2, 5, -6, 1] is [3, 1, 6, 0, 1].

Function Description

Complete the function maximizeNegativePnLMonths in the editor.

maximizeNegativePnLMonths has the following parameter:

int[] PnL: an array of integers representing the Profit and Loss for each month
Returns

int: the maximum number of months with a negative PnL such that the cumulative PnL remains positive
 */
