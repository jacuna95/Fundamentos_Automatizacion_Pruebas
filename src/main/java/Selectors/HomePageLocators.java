package Selectors;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.openqa.selenium.By;

public class HomePageLocators {
    public static By firstProductTitleSelector = By.cssSelector(".caption a");
    public static String firstH4Locator = "//H4/a[text()='<name>']";

}
