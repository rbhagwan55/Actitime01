package TryAndCatch;

public class src2 {

	public static void main(String[] args) {
		
	int a[]= {1,2,3,4,5};
		
		try
		{
			System.out.println(a[10]);
		}
        catch(ArrayIndexOutOfBoundsException c)
		{
          System.out.println("exception");	
		}
		
		finally
		{
			System.out.println("hiii");
		}
		System.out.println("end");
	

	}

}
