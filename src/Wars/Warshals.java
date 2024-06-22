package Wars;

import java.util.Scanner;

public class Warshals {
	static int a[][];
	static int n;
	
	public static void main(String[] args)
	{
		System.out.println("Enter the number of vertices\n");
		Scanner input=new Scanner(System.in);
		n=input.nextInt();
		a=new int[n][n];
		System.out.println("Enter the cost matrix(0s or 1s)\n");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				a[i][j]=input.nextInt();
				}
	
		
		}
		getClosure();
		PrintMatrix();
		input.close();
		
	}
	public static void getClosure()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(a[j][i]==1)
				{
					for(int k=0;k<n;k++)
					{
						if(a[j][i]==1 && a[i][k]==1)
						{
							a[j][k]=1;
						}
					}
				}
			}
		}
	}
	public static void PrintMatrix()
	{
		System.out.println("Transitive closure:");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(a[i][j]+" ");
				
			}
			System.out.println();
		}
	}
	
	

}
