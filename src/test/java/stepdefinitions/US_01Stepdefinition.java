package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import page.US_01Page;
import utilities.ConfigReader;
import utilities.Driver;
import java.util.List;

public class US_01Stepdefinition {

    US_01Page page = new US_01Page();
    Actions actions=new Actions(Driver.getDriver());

    @Given("Empty ToDo list")
    public void emptyToDoList() {
        Driver.getDriver().get(ConfigReader.getProperty("todomvc_url"));
    }
    @Then("I should see empty todo list")
    public void iShouldSeeEmptyTodoList() {
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//*[@class='view']"));
        Assert.assertTrue(list.size() == 0);

    }
    @When("I write {string} to <text box> and press <enter>")
    public void when_i_write_to_text_box_and_press_enter(String insertTodo) {
        page.searchBox.sendKeys(insertTodo + Keys.ENTER);
    }
    @Then("I should see {string} item in Todo list")
    public void i_should_see_item_in_todo_list(String string) {
        Assert.assertTrue(page.milkAssert.isDisplayed());
    }

    @Given("ToDo list with {string} item")
    public void todoListWithItem(String todoitem) throws InterruptedException {
        page.searchBox.sendKeys(todoitem + Keys.ENTER);
    }
    @Then("I should see {string} item insterted to ToDo list below {string} item")
    public void iShouldSeeItemInstertedToDoListBelowItem(String item2, String item1) {
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//div[@class='view']//label"));
        Assert.assertEquals(item2, list.get(list.size() - 1).getText());
    }

    @When("I click on <checkbox> next to {string} item")
    public void iClickOnCheckboxNextToItem(String arg0) {
        page.marked.click();
    }
    @Then("I should see {string} item marked as DONE")
    public void iShouldSeeItemMarkedAsDONE(String arg0) {
        Assert.assertTrue(page.marked.isEnabled());
    }

    @Given("todo list with marked item")
    public void todoListWithMarkedItem()  {
        page.searchBox.sendKeys("buy some milk" + Keys.ENTER);
    }

    @When("I click on <check box> next to item")
    public void iClickOnCheckBoxNextToItem() throws InterruptedException {
        WebElement hoverover = Driver.getDriver().findElement(By.xpath("//*[@class='toggle']"));
        Thread.sleep(5000);
        actions.doubleClick(hoverover).perform();
    }

    @Then("I should see {string} item marked as UNDONE")
    public void iShouldSeeItemMarkeAsUNDONE(String arg0) {
        Assert.assertTrue(page.item1.isEnabled());
    }
    @When("I click on <delete button> next to {string} item")
    public void iClickOnDeleteButtonNextToItem(String arg0)  {
        WebElement hoverover=Driver.getDriver().findElement(By.xpath("//div[@class='view']"));
        actions.moveToElement(hoverover).perform();
        page.delete.click();
    }
    @Then("List should be empty")
    public void listShouldBeEmpty() {
        List<WebElement> list = Driver.getDriver().findElements(By.xpath(" //*[@class='view']"));
        Assert.assertTrue(list.size()==0);

    }
    @Given("ToDo list with {string} and {string} item in order")
    public void todoListWithAndItemInOrder(String item1, String item2) {
        page.searchBox.sendKeys(item1+Keys.ENTER);
        page.searchBox.sendKeys(item2+Keys.ENTER);
    }
    @When("I click on <delete button> next to {string}item")
    public void iClickOnDeleteButtonNextToIte(String arg0) {
        WebElement hoverover=Driver.getDriver().findElement(By.xpath("//*[@class='view']"));
        actions.moveToElement(hoverover).perform();
        page.delete.click();
    }

    @Then("I should see {string} item in ToDo list")
    public void iShouldSeeItemInToDoList(String item) {
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//div[@class='view']//label"));
        Assert.assertEquals(item,list.get(0).getText());
    }
    @And("close page")
    public void closePage() {
        Driver.closeDriver();
    }
}