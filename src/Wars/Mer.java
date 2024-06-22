package Wars;

import java.util.Random;
import java.util.Scanner;

public class Mer {
	 static final int MAX=10005;
	 static int a[]=new int [MAX];
	 public static void main(String[] args)
	 {
		 Scanner input=new Scanner(System.in);
		 System.out.println("Enter the order:");
		 int n=input.nextInt();
		 Random random=new Random();
		 System.out.println("Enter the array elemrents:");
		 for(int i=0;i<n;i++)
		 {
			 a[i]=random.nextInt(1000);
		 }
		 long startTime=System.nanoTime();
		 QuickSortAlgo(0,n-1);
		 long stopTime=System.nanoTime();
		 long elapsedTime=stopTime-startTime;
		 System.out.println("Time complexity:"+n+(double)elapsedTime/1000000);
		 System.out.println("Sorted array(Merge Sort:");
		 for(int i=0;i<n;i++)
		 {
			 System.out.print(a[i]+" ");
		 }
		 input.close();
	 }
	 
	
	public static void QuickSortAlgo(int p,int r)
	 {
		int i,j,temp;
		i=p; j=r;
	   int pivot=a[p];
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
