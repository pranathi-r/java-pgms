package Wars;

import java.util.Scanner;

public class op {
	static int n,d,S[],soln[];
	public static void main(String args[])
	{
		int sum=0;
		Scanner in=new Scanner(System.in);
		
		System.out.println("\n Enter the n:");
		n=in.nextInt();
		
		S=new int[n+1];
		soln=new int[n+1];
		
		System.out.println("\n Enter the set values:");
		for(int i=1;i<=n;i++)
		{
			S[i]=in.nextInt();
		}
		
		System.out.println("\n Enter d:");
		d=in.nextInt();
		
		for(int i=1;i<=n;i++)
		{
			sum=sum+S[i];
		}
		
		if(sum<d || S[1]>d)
		{
			System.out.println("No subsets possible");
		}
		
		else
		{
			SumofSub(0,0,sum);
		}
		in.close();
		
	}
	
	public static void SumofSub(int i,int weight,int total)
	{
		if(promising(i,weight,total)==true)
		{
			if(weight==d)
			{
				for(int j=1;j<=n;j++)
				{
					if(soln[j]==1)
					{
						System.out.println(S[j]+"");
					}
				}
				System.out.println();
			}
			
			else
			{
				soln[i+1]=1;
				SumofSub(i+1,weight+S[i+1],total-S[i+1]);
				soln[i+1]=0;
				SumofSub(i+1,weight,total-S[i+1]);
			}
		}
	}
	
	public static boolean promising(int i,int weight,int total)
	{
		return((weight+total>=d)&&((weight==d)||(weight+S[i+1]<=d)));
	}
			

}
