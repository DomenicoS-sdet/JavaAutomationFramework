package PageObjects;

import drivers.BrowserCollection.Browser;

public class PageCollection {
	
	public static class Pages {
		
		public static HomePagePO homepage() {
			return new HomePagePO(Browser.getBrowser().getDriver());
		}
		
		public static SearchResultPO searchResultPage() {
			return new SearchResultPO(Browser.getBrowser().getDriver());
		}
	}

}
