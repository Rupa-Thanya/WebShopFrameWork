package testScripts;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageRepository.FindProfesionalPage;
import PageRepository.HomePage;

import genericClass.BaseClass;
import genericClass.FileUtility;

public class ProfessionalPageTest extends BaseClass {
	SoftAssert soft = new SoftAssert();

	@Test
	public void openingPage() {
		HomePage home = new HomePage(driver);
		FindProfesionalPage pro = new FindProfesionalPage(driver);
		home.getSeeAll().click();
		soft.assertEquals(true, pro.getTitle().isDisplayed());
		soft.assertAll();
	}

	/**
	 * verfiy able enter the zip code
	 */
	@Test
	public void zipcodeTest() {
		HomePage home = new HomePage(driver);
		FindProfesionalPage pro = new FindProfesionalPage(driver);
		home.getSeeAll().click();
		pro.getZipcode().clear();
		pro.getZipcode().sendKeys(FileUtility.getProperty("zipcode"));
		pro.getGetStartedButton().click();
		Set<String> ids = driver.getWindowHandles();
		boolean value = false;
		for (String window : ids) {
			driver.switchTo().window(window);

			if (driver.getCurrentUrl().equalsIgnoreCase(FileUtility.getProperty("allprovesionalUrl"))) {
				value = true;
				break;
			}
		}
		soft.assertEquals(true, value);
		soft.assertAll();
	}

	/**
	 * verfiy the able to enter the zipcode in location
	 */
	@Test
	public void locationzipCode() {
		HomePage home = new HomePage(driver);
		FindProfesionalPage pro = new FindProfesionalPage(driver);
		home.getSeeAll().click();
		pro.getLocationSearchBar().click();
		pro.getLocationSearchBar().clear();
		pro.getLocationSearchBar().sendKeys(FileUtility.getProperty("zipcode"), Keys.ENTER);
		soft.assertEquals(pro.getSelectedMsg().getText().contains(FileUtility.getProperty("zipcode")), true);
		soft.assertAll();
	}

	@Test
	public void locationByCity() throws InterruptedException {
		HomePage home = new HomePage(driver);
		FindProfesionalPage pro = new FindProfesionalPage(driver);
		home.getSeeAll().click();
		pro.getLocationSearchBar().click();
		Thread.sleep(2000);
		pro.getLocationSearchBar().clear();
		Thread.sleep(2000);
		pro.getLocationSearchBar().sendKeys("chennai", Keys.ENTER);
		soft.assertEquals(pro.getSelectedMsg().getText().contains("cheenai"), true);
		soft.assertAll();
	}

	/**
	 * verify able select option
	 */
	@Test
	public void ProfesionalCategoryDropDown() {
		HomePage home = new HomePage(driver);
		FindProfesionalPage pro = new FindProfesionalPage(driver);
		home.getSeeAll().click();
		pro.getProfrsionalButton().click();
		pro.getArchitecuteOption().click();
		soft.assertEquals(pro.getArchitects_Building_Designers().getText().contains(pro.getSelectedMsg().getText()),
				true);
		soft.assertAll();
	}

	/**
	 * verify able to deselect the Profeshional Category Option=============>Passed
	 **/
	@Test
	public void ProfesionalCategoyDeselect() {
		HomePage home = new HomePage(driver);
		FindProfesionalPage pro = new FindProfesionalPage(driver);
		home.getSeeAll().click();
		pro.getProfrsionalButton().click();
		pro.getArchitecuteOption().click();
		pro.getArchitectureDelselectOption().click();
	}

	/**
	 * verfiy the Rating CheckBox is Clickable
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void ratingsCheckBox() throws InterruptedException {
		HomePage home = new HomePage(driver);
		FindProfesionalPage pro = new FindProfesionalPage(driver);
		home.getSeeAll().click();
		pro.getRatingBtn().click();
//		Thread.sleep(2000);
		for (WebElement element : pro.getRatingsCheckBoxs()) {
			scrollToElement(pro.getRatingBtn());
//			Thread.sleep(2000);
//			pro.getRatingBtn().click();
			element.click();
			soft.assertEquals(element.isSelected(), true);
		}
		soft.assertAll();

	}
	/**
	 * verfiy the profeshional checkBox
	 */
//	public void CheckBox() {
//		HomePage home = new HomePage(driver);
//		FindProfesionalPage pro = new FindProfesionalPage(driver);
//		home.getSeeAll().click();
//		pro.getProfrsionalButton().click();
//		for (WebElement element : pro.getProCategoryCheckBox()) {
//			element.click();
//			soft.
//		}
//	}

}
