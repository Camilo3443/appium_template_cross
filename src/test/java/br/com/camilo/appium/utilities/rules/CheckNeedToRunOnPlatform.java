package br.com.camilo.appium.utilities.rules;

import br.com.camilo.appium.utilities.enums.OS;
import org.junit.AssumptionViolatedException;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class CheckNeedToRunOnPlatform implements TestRule {

	private boolean checkNeedToRunOnPlatform;

	public CheckNeedToRunOnPlatform(OS os) {
		this.checkNeedToRunOnPlatform = verifyIfWillTestInPlatform(os);
	}

	@Override
	public Statement apply(Statement base, Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				if (!checkNeedToRunOnPlatform) {
					throw new AssumptionViolatedException("Not the platform required. Skipping test!");
				} else {
					base.evaluate();
				}
			}
		};
	}
	
	public boolean verifyIfWillTestInPlatform(OS os) {
		OS OSMaven = System.getProperty("executionOS") == null ? OS.BOTH
				: OS.valueOfIgnoreCase(System.getProperty("executionOS"));

		switch (OSMaven) {
			case ANDROID:
				return os.equals(OS.ANDROID) ? true : false;
			case IOS:
				return os.equals(OS.IOS) ? true : false;
			default:
				return true;
		}
	}

}
