package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class US_01Page {
    public US_01Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(className = "new-todo")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='view']")
    public WebElement milkAssert;

    @FindBy(xpath = "(//input[@class='toggle'])[1]")
    public WebElement marked;

    @FindBy(xpath = "//*[@class='destroy']")
    public WebElement delete;

    @FindBy(xpath ="(//div[@class='view']//label)[1]")
    public WebElement item1;

}
