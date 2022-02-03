package TryAndCatch;

public class sc1 {

	public static void main(String[] args) {
	
		int a[]= {1,2,3,4,5};
		
		try
		{
			System.out.println(a[2]);
		}
        catch(ArrayIndexOutOfBoundsException e)
		{
          System.out.println("exception");	
		}
		
		System.out.println("end");
	}

}
