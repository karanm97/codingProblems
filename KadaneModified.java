/*
	It is a modified version of kadane's algorithm that returns the interval of the largest sum contiguous sub-array
*/
class KadaneModified
{
    public static int kadane(int[] a)
    {
        int size = a.length, max_so_far = 0, max_ending_here = 0, lower_limit = 0, upper_limit = 0;
        int startIndex = 0, maxStartIndex = 0;
        int maxEndIndex = -1;
        for(int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if(max_ending_here < 0)
            {
                max_ending_here = 0;
                startIndex = i + 1;
            }
            else if(max_so_far < max_ending_here)
            {
                max_so_far = max_ending_here;
                maxStartIndex = startIndex;
                maxEndIndex = i;
            }
        }
        System.out.println("Sub-Array Interval [" + (maxStartIndex) + ", " + maxEndIndex + "]");
        return max_so_far;
    }
    public static void main(String args[])
    {
        int [] a = { -2, 5, 4, -1, -2, 1, -9, -3};
        System.out.println("Max Sub-Array is " + kadane(a));
    }
}