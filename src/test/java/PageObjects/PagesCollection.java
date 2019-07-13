package PageObjects;

import drivers.Browser.Chrome;

public class PagesCollection {
	
	public static class Pages {
		public static HomePagePO homePage = new HomePagePO(Chrome.getDriver());		
	}

}
