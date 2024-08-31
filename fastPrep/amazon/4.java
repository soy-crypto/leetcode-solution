
public int calculateBeautyValues(int[] arr, int[][] pairs) 
{
  //Base Check
  if(arr.length == 0)
  {
    return 0;
  }

  //Init
  int value;

  //Compuate
  /** find the used indices */
  Set<Integer> set = new HashSet<>();
  List<Integer> bList = new ArrayList<>();
  for(int[] pair : pairs)
  {
    //update set
    set.add(pair[0]);
    set.add(pair[1]);
    
    //update bList
    if(pair[0] != pair[1])
    {
      bList.add(arr[pair[0]]);
      bList.add(arr[pair[1]]);
    }
    else 
    {
      bList.add(arr[pair[0]]);
    }
    
  }//

  /** get all the unused indicies  */
  Set<Integer> unused = new HashSet<>();
  for(int i = 0; i < arr.length; i++)
  {
    if(!set.contains(i))
    {
      unused.add(i);
    }
    
  }// for

  /** compute the freqeuncey for each element at the used index */
  Map<Integer, Integer> freqMap = new HashMap<>();
  for(int num : bList)
  {
    freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
  }
  
  /** count the total number of elements that are greater than elements at the unused indicies */
  int count = 0;
  for(int key : freqMap.keySet())
  {
    //current key
    int localCount = 0;
    for(int index : unused)
    {
      if(key < arr[index])
      {
        localCount += freqMap.get(key);
      }
      
    }// for

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