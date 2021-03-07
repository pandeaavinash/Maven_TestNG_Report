package groups;

import org.testng.annotations.Test;

public class Group_2 
{
	 @Test(groups= {"integration","regression"})
	  public void f() 
	  {
		  System.out.println("In group-2");
	  }
	 
	 //@Test
	 public void test()
	  {
		  System.out.print("Depends on Regression Group !!");
	  }
}
