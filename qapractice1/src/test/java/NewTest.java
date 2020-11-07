import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {

  @Test
  public void newClassTest() {
	  FirstTest test = new FirstTest();
  }
  
  @Test
  public void helloWorldTest() {
	  System.out.println("Hello World!");
  }
  
  @Test
  public void tryCatchBlockTest() {
	  FirstTest test = new FirstTest();
	  test.isExist(5);
  }
  
  @Test
  public void test(){
	  
	  LocationBuilt location = LocationObjectMother.newyorkcity();
	  
  }
  
  
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }
  
  

}
