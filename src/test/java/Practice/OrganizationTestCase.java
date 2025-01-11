package Practice;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;

import com.crm.FileUtility.ReadFromExcelFile;
import com.crm.Vtiger_Base.Vtiger_Base;
import com.crm.javaUtility.GenerateRandomNumbers;
import com.crm.pom.HomePage;
import com.crm.pom.Organization;

public class OrganizationTestCase extends Vtiger_Base 
{
	public void testCase1() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		
	HomePage hp=new HomePage(driver);
	assertTrue(hp.Home().isDisplayed(),"I am not in Vtiger Home page.");
	Reporter.log("I am in Vtiger Home Page.");
	hp.organization();
	Organization org=new Organization(driver);
	org.plusOrg();
	String org_name = ReadFromExcelFile.readExcel("Organization", 0, 0);
	int dynamicNumbers=GenerateRandomNumbers.random();
	String exp_org=org_name+dynamicNumbers;
	org.accountName(org_name+dynamicNumbers);
	org.save();
	String actual_org=org.header().getText();
	assertTrue(actual_org.contains(exp_org));
	Thread.sleep(2000);
	
	}
}
