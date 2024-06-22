package Wars;


import java.util.*;

class GFG {

	static int arr[];
	static int n;
	public static int interpolationSearch(int arr[], int lo,
										int hi, int x)
	{
		int pos;
		if (lo <= hi && x >= arr[lo] && x <= arr[hi]) {

			// Probing the position with keeping
			// uniform distribution in mind.
			pos = lo
				+ (((hi - lo) / (arr[hi] - arr[lo]))
					* (x - arr[lo]));

			// Condition of target found
			if (arr[pos] == x)
				return pos;

			// If x is larger, x is in right sub array
			if (arr[pos] < x)
				return interpolationSearch(arr, pos + 1, hi,
										x);

			// If x is smaller, x is in left sub array
			if (arr[pos] > x)
				return interpolationSearch(arr, lo, pos - 1,
										x);
		}
		return -1;
	}

	public static void main(String[] args)
	{

		
		System.out.println("Enter the order:\n");
		Scanner input=new Scanner(System.in);
		n=input.nextInt();
		arr=new int[n];
		System.out.println("Enter the array:\n");
		for(int i=0;i<n;i++)
		{
			arr[i]=input.nextInt();
		}
		System.out.println("Enter the search element:");
		int x=input.nextInt();
		int index = interpolationSearch(arr, 0, n - 1, x);

		
		if (index != -1)
			System.out.println("Element found at index "
							+ index);
		else
			System.out.println("Element not found.");
	}
}


