Minimize Sum of Distances to Warehouses
🔥 FULLTIME
📚
RELATED PROBLEMS
Amazon has recently established n distribution centers in a new location. They want to set up 2 warehouses to serve these distribution centers. Note that the centers and warehouses are all built along a straight line. A distribution center has its demands met by the warehouse that is closest to it. A logistics team wants to choose the location of the warehouses such that the sum of the distances of the distribution centers to their closest warehouses is minimized.

Given an array dist_centers, that represent the positions of the distribution centers, return the minimum sum of distances to their closest warehouses if the warehouses are positioned optimally.

Function Description

Complete the function minSumDistancesToWarehouses in the editor.

minSumDistancesToWarehouses has the following parameter:

int[] dist_centers: an array of integers representing the positions of the distribution centers
Returns

int: the minimum sum of distances to their closest warehouses

Example 1:

Input:  dist_centers = [1, 6]
Output: 0 
Explanation:

      

      Optimal solution: Place one warehouse at x1 = 1 and the other at x2 = 6. The sum of distances to the nearest warehouse is 0 + 0 = 0.
      


      
Example 2:

Input:  dist_centers = [1, 2, 5, 6]
Output: 2 
Explanation:

      

      Optimal solution: Place one warehouse at x1 = 1 and the other at x2 = 6. The distances to the nearest warehouse are [0, 0, 1, 0], resulting in a total distance sum of 2.
      


//solution
public int minSumDistancesToWarehouses(int[] dist_centers) 
{
  //Base Check
  if(dist_centers == null)
  {
    return -1;
  }

  //Init
  int value;

  //Compute
  /** sort the given array */
  Arrays.sort(dist_centers);

  /** compute the global minimim distance */
  int globalMin = Integer.MAX_VALUE;
  for(int i = 0; i < dist_centers.length - 1; i++)
  {
    for(int j = i + 1; j < dist_centers.length; j++)
    {
      //Current pair {i, j}
      int localMin = minDist(i, j, dist_centers);

      //update globalMin;
      globalMin = Math.min(globalMin, localMin);

    }// for

  }// for

  /** update value */
  value = globalMin;

  //Return
  return value;

}//


public int minDist(int i, int j, int[] dist_centers)
{
  //Base check
  if(dist_centers == null)
  {
    return 0;
  }

  //Init
  int value;

  //Compute
  int sum = 0;
  for(int k = 0; k < dist_centers.length; k++)
  {
    sum += Math.min(Math.abs(dist_centers[k] - dist_centers[i]), Math.abs(dist_centers[k] - dist_centers[j]));
  }

  /** update value */
  value = sum;

  //Return
  return value;
  
}