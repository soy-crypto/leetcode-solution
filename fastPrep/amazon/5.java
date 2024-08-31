/* 
Get Minimum Boxes
🔥 FULLTIME
📚
RELATED PROBLEMS
The supply chain manager at one of Amazon's warehouses is shipping the last container of the day. All n boxes have been loaded into the truck with their sizes represented in the array boxes. The truck may not have enough capacity to store all the boxes though, so some of the boxes may have to be unloaded. The remaining boxes must satisfy the condition max(boxes) ≤ capacity * min(boxes).

Given the array, boxes, and capacity, find the minimum number of boxes that need to be unloaded.

Function Description

Complete the function getMinimumBoxes in the editor.

getMinimumBoxes has the following parameters:

1. int[] boxes: an array of integers representing the sizes of the boxes
2. int capacity: the capacity of the truck
Returns

int: the minimum number of boxes that need to be unloaded
*/

//brute force
public int getMinimumBoxes(int[] boxes, int capacity) 
{
  //Base Check
  if(boxes == null)
  {
    return 0;
  }

  //Init
  int value;

  //Compute
  /** sort the given array */
  Arrays.sort(boxes);

  /** find the maximum number of boxes to be loaded */
  int longest = Integer.MIN_VALUE;
  for(int i = 0; i < boxes.length - 1; i++)
  {
    for(int j = i; j < boxes.length; j++)
    {
      //current pair (min, max)
      int localLen = Integer.MIN_VALUE;
      if(boxes[j] <= capacity * boxes[i])
      {
        localLen = j - i + 1;
      }

      //Update longest
      longest = Math.max(longest, localLen);
      
    }// for
    
  }// for

  /** update value */
  value = boxes.length - longest;

  //Return
  return value;
}
