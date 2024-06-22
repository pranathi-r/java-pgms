import java.util.Random;
import java.util.Scanner;

public class Q {
	static final int MAX=10005;
	static int a[]=new int[MAX];
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the order:");
		int n=input.nextInt();
		Random random=new Random();
		System.out.println("Enter the array ele:");
		for(int i=0;i<n;i++)
		{
			a[i]=random.nextInt(1000);
		}
		
		long startTime=System.nanoTime();
		QuickSortAlgo(0,n-1);
		long stopTime=System.nanoTime();
		long elapsedTime=stopTime-startTime;
		System.out.println("Time complexity:"+n+"Is:"+(double)elapsedTime/1000000);
		System.out.println("Sorted Array:");
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}
		input.close();
	}
	public static void QuickSortAlgo(int p,int r)
	{
		int i,j,pivot,temp;
		if(p<r)
		{
			i=p;
			j=r;
			pivot=a[p];
			while(true)
			{
				i++;
				while(a[i]<pivot)
				{
					i++;
				}
				
				while(a[j]>pivot)
				{
					j--;
				}
					if(i<j)
					{
						temp=a[i];
						a[i]=a[j];
						a[j]=temp;
					}
					else
					{
						break;
					}
			}
			a[p]=a[j];
			a[j]=pivot;
			QuickSortAlgo(p,j-1);
			QuickSortAlgo(j+1,r);
		}
	}

}
