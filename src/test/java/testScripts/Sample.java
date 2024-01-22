package testScripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericClass.BaseClass;

public class Sample extends BaseClass{
	@Test
	public void rupa() {
		Reporter.log(driver.getTitle(),true);
		
	}

}
