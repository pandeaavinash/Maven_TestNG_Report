package groups;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class Group_1 
{
  @Test(groups= {"integration","regression"})
  public void f() 
  {
	  System.out.println("In group-1");
	  
  }
  
  @Test(dependsOnGroups= {"regression"},invocationCount=0,enabled=true)
  public void test()
  {
	  System.out.print("Depends on Regression Group !!");
  }
}
