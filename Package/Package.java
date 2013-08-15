package pptv;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class Package{
	int nitem, mitem, nnum, mnum, btcount;
	
	// -----------------------
	// Switch Browser Older Window
	// -----------------------
	public static void SwitchWinBack(WebDriver wd){
		String currentWindow = wd.getWindowHandle();   
			Set<String> handles = wd.getWindowHandles();  
			Iterator<String> it = handles.iterator();  
			while(it.hasNext()){  
				String handle = it.next();  
				if(currentWindow.equals(handle)) continue;  
				WebDriver window = wd.switchTo().window(handle);  
				System.out.println("Open" + window.getTitle() + "\n" + window.getCurrentUrl() + "\n"); 
				//Resources
				//Edit
				
		}
	}
	
	// -----------------------
	// Switch Browser Newer Window 
	// -----------------------
	
	public static void SwitchWinForward(WebDriver wd){
		String currentWindow = wd.getWindowHandle(); 
	       Set<String> handles = wd.getWindowHandles();  
	       Iterator<String> it = handles.iterator();  
	       while(it.hasNext()){
				String handle = it.next();
				if(currentWindow.equals(handle)) continue;
				WebDriver window = wd.switchTo().window(handle);
				System.out.println("Open" + window.getTitle() + "\n" + window.getCurrentUrl() + "\n");
	       }
	       wd.close();
	       wd.switchTo().window(currentWindow);
	}
	// -----------------------
	// Print Method
	// -----------------------
	public static void Show(String str){
		System.out.print(str);
	}
	
	public void Assert(WebDriver wd) {
		// -----------------------
		// Assert ZDBtn
		// -----------------------

		// Switch to New window
		for (String winhandle : wd.getWindowHandles()) {
			wd.switchTo().window(winhandle);
		}
		System.out.print(wd.getTitle());
		
		// -----------------------
		// Locate Element ClassName is rssbox, Judgment have not
		// -----------------------
		WebElement element = wd.findElement(By.className("rssbox"));
		List<WebElement> btn = element.findElements(By.id("zdbtn"));
		btcount = btn.size();
		System.out.println("\n" + btcount);
		if (btcount > 0) {
			wd.switchTo().frame("widget_1");
			wd.findElement(By.id("clc_btn")).click();
		} else {
//			foo();
			System.out.print("failed");
		}

		// 得到当前窗口的句柄
		String currentWindow11 = wd.getWindowHandle();

		// 得到所有窗口的句柄，并定位至新窗口
//		for (String winhandle : wd.getWindowHandles()) {
//			wd.switchTo().window(winhandle);
//		}

		// 定位至原先窗口，并关闭原来窗口
//		wd.switchTo().window(currentWindow11);
//		wd.close();

		// 回到新窗口
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String winhandle : wd.getWindowHandles()) {
			wd.switchTo().window(winhandle);
		}

		// 打印新窗口的标题并与正确的标题进行比较
		System.out.println(wd.getTitle());
		assertEquals(wd.getTitle(), "我的闹钟 | 正点闹钟");

		// 关闭新窗口
//		wd.close();

		Package.switchwinbak(wd);
	}
}

	
