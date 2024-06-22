import java.util.Scanner;

public class Dijkstras {
static int a[][],n;
public static void main(String args[])
{
	Scanner in=new Scanner(System.in);
	System.out.println("\nEnter vertices:");
	n=in.nextInt();
	
	a=new int[n][n];
	
	System.out.println("\n Enter cost matrix:");
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			a[i][j]=in.nextInt();
		}
	}
	
	System.out.println("\n Enter source vertex:");
	int s=in.nextInt();
	dij(s);
	in.close();
}

public static void dij(int s)
{
	int vis[]=new int[n];
	int dis[]=new int[n];
	int i,u,v;
	
	for(i=0;i<n;i++)
	{
		vis[i]=0;
		dis[i]=a[s][i];
	}
	
	vis[s]=1;
	dis[s]=0;
	i=1;
	
	while(i<=n-1)
	{
		u=Ext_min(vis,dis);
		vis[u]=1;
		i++;
		for(v=0;v<n;v++)
		{
			if((dis[u]+a[u][v]<dis[v])&& vis[v]==0)
			{
				dis[v]=dis[u]+a[u][v];
			}
		}
	}
	
	
		for(i=0;i<n;i++)
		{
			if(i!=s)
	System.out.println(s+"->"+i+":"+dis[i]);
		}
}

public static int Ext_min(int vis[],int dis[])
{
	int i,j=0,min=999;
	for(i=0;i<n;i++)
	{
		if(dis[i]<min && vis[i]==0)
		{
			min=dis[i];
			j=i;
		}
	}
	
	return j;
}
}
