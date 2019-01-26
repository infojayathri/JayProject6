package HomeWork;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import ExcelREAD.*;
import javax.xml.parsers.ParserConfigurationException;


public class ExerciseExcelRead {
	WebDriver driver;
	ExcelRead excelFile= new ExcelRead();
	
@BeforeTest
	public void setup() throws IOException
	{
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/V4/");
	}

@Test

	public void testAdd() throws IOException
	{
		driver.findElement(By.name("uid")).sendKeys(excelFile.readExcel(1,1,".\\Data\\DataDriven.xlsx", "Sheet1"));
		driver.findElement(By.name("password")).sendKeys(excelFile.readExcel(1,2,".\\Data\\DataDriven.xlsx", "Sheet1"));
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
		driver.findElement(By.name("name")).sendKeys(excelFile.readExcel(1,3,".\\Data\\DataDriven.xlsx", "Sheet1"));	
		driver.findElement(By.cssSelector("input[value='m']")).click();
		driver.findElement(By.id("dob")).sendKeys(excelFile.readExcel(1,4,".\\Data\\DataDriven.xlsx", "Sheet1"));
		driver.findElement(By.name("addr")).sendKeys(excelFile.readExcel(1,5,".\\Data\\DataDriven.xlsx", "Sheet1"));
		driver.findElement(By.name("city")).sendKeys(excelFile.readExcel(1,6,".\\Data\\DataDriven.xlsx", "Sheet1"));
		driver.findElement(By.name("state")).sendKeys(excelFile.readExcel(1,7,".\\Data\\DataDriven.xlsx", "Sheet1"));;
		driver.findElement(By.name("pinno")).sendKeys(excelFile.readExcel(1,8,".\\Data\\DataDriven.xlsx", "Sheet1"));
		driver.findElement(By.name("telephoneno")).sendKeys(excelFile.readExcel(1,9,".\\Data\\DataDriven.xlsx", "Sheet1"));
		driver.findElement(By.name("emailid")).sendKeys(excelFile.readExcel(1,10,".\\Data\\DataDriven.xlsx", "Sheet1"));
		driver.findElement(By.name("password")).sendKeys(excelFile.readExcel(1,11,".\\Data\\DataDriven.xlsx", "Sheet1"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String webTitle = driver.getTitle();
		
		//Assert.assertEquals(webTitle, "Guru99 Bank New Customer Entry Page");
		Assert.assertEquals(webTitle, "Guru99 Bank Customer Registration Page");

	}

//@AfterTest
	//public void tearDown() throws IOException
	//{
	//driver.close();
	//driver.quit();
	//}

}
