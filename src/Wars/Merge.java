package Wars;

import java.util.Random;
import java.util.Scanner;

public class Merge {
	static final int MAX=10005;
	static int []a=new int [MAX];
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter Max array size:");
		int n=input.nextInt();
		Random random=new Random();
		System.out.println("Enter the array elements:");
		for(int i=0;i<n;i++)
		{
			a[i]=random.nextInt(1000);
		}
		long startTime=System.nanoTime();
		MergeSortAlgorithm(0,n-1);
		long stopTime=System.nanoTime();
		long elapsedTime=stopTime-startTime;
		System.out.println("Time complexity(ms)for n="+n+"is:"+(double)elapsedTime/10000000);
		System.out.println("sorted array(merge sort:)");
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}
		
		input.close();
	}
	public static void MergeSortAlgorithm(int low,int high)
	{
		int mid;
		if(low<high)
		{
			mid=(low+high)/2;
			MergeSortAlgorithm(low,mid);
			MergeSortAlgorithm(mid+1,high);
			SimpleMerge(low,mid,high);
		}
	}
	public static void SimpleMerge(int low,int mid,int high)
	{
		int []b=new int[MAX];
		int h,i,j,k;
		h=i=low;
		j=mid+1;
		
		while((h<=mid)&&(j<=high))
		{
			if(a[h]<a[j])
			{
				b[i++]=a[h++];
				
			}
			else
			{
				b[i++]=a[j++];	
			}
		}
		
		if(h>mid)
		{
			for(k=j;k<=high;k++)
			{
				b[i++]=a[k];
			}
		}
		else
		{
			for(k=h;k<=mid;k++)
			{
				b[i++]=a[k];
			}
			
		}
		for(k=low;k<=high;k++)
		{
			a[k]=b[k];
		}
		
	}
}
