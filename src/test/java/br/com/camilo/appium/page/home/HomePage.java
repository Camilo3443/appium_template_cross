package br.com.camilo.appium.page.home;

import org.junit.Assert;

import br.com.camilo.appium.constants.home.HomeConstants;
import br.com.camilo.appium.utilities.screen_actions.ScreenActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends ScreenActions {

	@AndroidFindBy(id = "")
	@iOSXCUITFindBy(id = "")
	private MobileElement HEADER;

	public HomePage() {
		initElements(this);
	}

	public HomePage validateHeader() {
		Assert.assertEquals(HomeConstants.TXT_HEADER, getText(HEADER));
		return this;
	}
}
