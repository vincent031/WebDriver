package pptv;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opera.core.systems.scope.protos.UmsProtos.Response;

import java.io.*;


public class RunClick {

	WebDriver wd = new FirefoxDriver();
	int nitem, mitem, nnum, mnum, listpage, page, btcount;
	String enter = "\n";
	// -----------------------
	// Open PPTV
	// -----------------------
	
	@BeforeTest
	@Parameters({ "url" })
	public void OpenW(String url) {
		wd.get(url);
		System.out.println("open" + url);
	}
	

	// -----------------------
	// Count NavBar Tag Names "a"
	// -----------------------
	
	@Test
	public void CountNav() {
		WebElement element = wd.findElement(By.className("nav_chl"));
		List<WebElement> nav = element.findElements(By.tagName("a"));
		nitem = nav.size();
//		System.out.println("\n" + nitem);
	}

	// -----------------------
	// Count Video list ClassNames "text", link to movie detail
	// -----------------------
	
	@Test
	public void CountMovie() {
		WebElement element2 = wd.findElement(By.className("bd"));
		List<WebElement> mov = element2.findElements(By.className("txt"));
		mitem = mov.size();
//		System.out.println("\n" + mitem);
	}
	
	@Test
	public void CountPage(){
		String Pages = wd.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[2]/div/p/a[10]")).getText();
		int page = Integer.parseInt(Pages);
//		Package.Show(Pages + "=" + page + enter);
	}
	
	// -----------------------
	// loop to click
	// -----------------------
	
	@Test
	public void LoopClick() {
		
		CountNav();
		//loop click nav bar
		for (nnum = 1; nnum <= nitem - 1; nnum++) {
			CountPage();
			CountMovie();
			wd.findElements(By.cssSelector("html body div.re_980 div.nav div.nav_chl ul li a")).get(nnum).click();
			String nav_title = wd.findElement(By.cssSelector("html body div.re_980 div.nav div.nav_chl ul li a")).getText();
			System.out.print("Into " + nav_title + ":\n");
			String navigate = "Navigation Num " + nnum + " " + nav_title;
			
			for (listpage=-1;listpage<=page;listpage++){
				if (listpage >=0){
					wd.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[2]/div/p/a[11]")).click();
					CountMovie();
				}
				else{
					Package.Show("First page..");
				}
				//loop click video list
				for (mnum = 0; mnum < mitem; mnum++) {
					if (mitem >= 0){
						System.out.print(nnum + "&&" + mnum + " && " + nitem + " && " + mitem);
						wd.findElements(By.cssSelector("html body div.re_980 div.m div.content div.bd ul.list_120x160 li p.txt a")).get(mnum).click();
						String mname = wd.findElements(By.cssSelector("html body div.re_980 div.m div.content div.bd ul.list_120x160 li p.txt a")).get(mnum).getText();
						String movies = "Names " + mname + " " + wd.getCurrentUrl();
						Package.Show(navigate + ", Page " + listpage + ", " + movies); 
						Package.SwitchWinForward(wd);
						Package.SwitchWinBack(wd);
					}
					else{
						Package.Show("First page..");
					}
				}				
			}
		}
	}

	@AfterTest
	public void After() {
		// wd.quit();
	}
}
