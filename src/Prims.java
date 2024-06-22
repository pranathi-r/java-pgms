import java.util.Arrays;
import java.util.Scanner;

public class Prims {
	static int a[][];
	static int v;
	
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter no vertices:");
		 v=input.nextInt();
		a=new int[v][v];
		System.out.println("Enter the cost matrix\n");
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				a[i][j]=input.nextInt();	
			}
			
		}
		
		prim();
		input.close();
	}
	
	public static void prim()
	{
		int no_edge=0,sum=0;
		boolean []selected=new boolean[v];
		Arrays.fill(selected, false);
		selected[0]=true;
		System.out.println("Edge:Weight");
		while(no_edge<v-1)
		{
			int x=0,y=0,min=999;
			for(int i=0;i<v;i++)
		{
		  if(selected[i]==true)
		  {
			  for(int j=0;j<v;j++)
			  {
				  if(!selected[j]&&a[i][j]!=0)
				  {
					 if(min>a[i][j]) 
					 {
						 min=a[i][j];
						 x=i;
						 y=j;
					 }
				  }
			  }
		  }
		}
		System.out.println(x+"-"+y+":"+a[x][y]);
		sum=sum+a[x][y];
		selected[y]=true;
		no_edge++;
		}
		System.out.println("Cost of tree:"+sum);
		
	}
}
