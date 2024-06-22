import java.util.Scanner;

public class Gknapsack {
	static int n;
	static float item[],weight[],profit[],ratio[],capacity;
	public static void main(String args[])
	{
		int i,j;
		float temp;
		Scanner in=new Scanner(System.in);
		
		System.out.println("\n Enter the no of objects:");
		n=in.nextInt();
		
		item=new float[n];
		weight= new float[n];
		profit=new float[n];
		ratio=new float[n];
		
		System.out.println("\n Enter the item,weight and profit:");
		for(i=0;i<n;i++)
		{
			item[i]=in.nextFloat();
			weight[i]=in.nextFloat();
			profit[i]=in.nextFloat();
		}
		
		System.out.println("\n Enter the capacity:");
		capacity=in.nextFloat();
		
		for(i=0;i<n;i++)
		{
			ratio[i]=profit[i]/weight[i];
		}
		
		for(i=0;i<n;i++)
		{
			for(j=i+1;j<n;j++)
			{
				if(ratio[i]<ratio[j])
				{
					temp=ratio[j];
					ratio[j]=ratio[i];
					ratio[i]=temp;
					
					temp=profit[j];
					profit[j]=profit[i];
					profit[i]=temp;
					
					temp=weight[j];
					weight[j]=weight[i];
					weight[i]=temp;
					
					temp=item[j];
					item[j]=item[i];
					item[i]=temp;
				}
			}
		}
		knapsack();
		in.close();
		
	}
	
	public static void knapsack()
	{
		float u=capacity,tp=0;
	    int i;
	    float x[]=new float[n];
	    
	    for(i=0;i<n;i++)
	    {
	    	x[i]=0;
	    }
	    for(i=0;i<n;i++)
	    {
	    	if(weight[i]>u)
	    	{
	    		break;
	    	}
	    	
	    	else
	    	{
	    		x[i]=1;
	    		tp=tp+profit[i];
	    		u=u-weight[i];
	    	}
	    }
	    
	    if(i<n)
	    {
	    	x[i]=u/weight[i];
	    	tp=tp+(x[i]*profit[i]);
	    	
	    }
	    System.out.println("\n The resultant vector:");
	    for(i=0;i<n;i++)
	    {
	    System.out.println("Item"+(int)item[i]+":"+x[i]);
	    }
	    System.out.println("\n The maximum profit:"+tp);
	    
	}

}
