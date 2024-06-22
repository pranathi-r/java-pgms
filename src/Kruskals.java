import java.util.Scanner;

public class Kruskals {
static int a[][],parent[],n;

public static void main(String args[])
{
	Scanner in=new Scanner(System.in);
	int i,j;
	
	System.out.println("\n Enter the no of vertices:");
	n=in.nextInt();
	
	a=new int[n][n];
	parent=new int[n];
	
	System.out.println("\n Enter the cost matrix:");
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			a[i][j]=in.nextInt();
		}
	}
	
	for(i=0;i<n;i++)
	{
		parent[i]=0;
	}
	krush();
	in.close();
	
}

public static void krush()
{
	int u=0,v=0,i,j,k=0,sum=0,min;
	while(k<n-1)
	{
		min=999;
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(a[i][j]<min && i!=j)
				{
					min=a[i][j];
					u=i;
					v=j;
				}
			}
		}
		
		i=find(u);
		j=find(v);
		if(i!=j)
		{
			union(i,j);
			System.out.println(u+","+v+"=>"+a[u][v]);
			sum=sum+a[u][v];
			k++;
		}
		
		a[u][v]=a[v][u]=999;
	}
	
}

public static int find(int p)
{
	while(parent[p]!=0)
	{
		p=parent[p];
	}
	return p;
}

public static void union(int i,int j)
{
	if(i<j)
	{
		parent[i]=j;
	}
	
	else
	{
		parent[j]=i;
	}
}
}
