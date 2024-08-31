
public int calculateBeautyValues(int[] arr, int[][] pairs) 
{
  //Base Check
  if(arr.length == null)
  {
    return 0;
  }

  //Init
  int value;

  //Compuate
  /** find the used indices */
  Set<Integer> set = new HashSet<>();
  for(int[] pair : pairs)
  {
    set.add(pair[0]);
    set.add(pair[1]);
  }

  /** compute the freqeuncey for each element at the used index */
  Map<Integer, Integer> freqMap = new HashMap<>();
  Set<Integer> unused = new HashSet<>();
  for(int i = 0; i < arr.length; i++)
  {
    if(set.contains(i))
    {
      freqMap.put(arr[i], freqMap.getOrDefault(arr[0], 0) + 1);
    }
    else 
    {
      unused.add(i);
    }
    
  }// for

  /** count the total number of elements that are greater than elements at the unused indicies */
  int count = 0;
  for(int key : freqMap.keySet())
  {
    //current key
    int localCount = 0;
    for(int index : unused)
    {
      if(key < arr[i])
      {
        localCount += freqMap.get(key);
      }
      
    }

    //update count
    count += localCount;
    
  }// for

  /** update value */
  value = count;

  //Return
  return value;

}


/**
 * Calculate Beauty Values
📚
RELATED PROBLEMS
Given an array arr of size n and pairs of size m * 2, where each pair represents the starting and ending index of a subarray, we need to calculate the beauty of the array. The process of calculating the beauty involves creating a beautiful array by processing each pair and appending the subarray defined by the pair to the beautiful array. After processing all pairs, we need to return the summation of the count of values exactly lesser than the values at the unused indexes in the original array.

Function Description

Complete the function calculateBeautyValues in the editor.

calculateBeautyValues has the following parameters:

1. int arr[n]: an array of integers
2. int pairs[m][2]: an array of pairs representing subarray indexes
Returns

int: the sum of counts of values less than the values at unused indexes
 */