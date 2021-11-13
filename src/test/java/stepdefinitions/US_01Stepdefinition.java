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

import java.util.ArrayList;
import java.util.List;

public class US_01Stepdefinition {

    US_01Page page = new US_01Page();
    Actions actions=new Actions(Driver.getDriver());
// 1)   Boş Yapılacaklar listesi verildi
//    O zaman boş yapılacaklar listesi görmeliyim
//    <text box>'a "biraz süt al" yazıp <enter> tuşuna bastığımda
//    O zaman Yapılacaklar listesinde "biraz süt al" öğesini görmeliyim
    @Given("Empty ToDo list")
    public void emptyToDoList() {
        Driver.getDriver().get(ConfigReader.getProperty("todomvc_url"));
    }
    @Then("I should see empty todo list")
    public void iShouldSeeEmptyTodoList() {
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//*[@class='view']"));
        Assert.assertTrue(list.size() == 0);
        //todosa eklediklerimiz liste altiliyor herhangi birsey ekli degilse size 0 olacak
        //o yuzden sifir oldugunu dogruladik
    }
    @When("I write {string} to <text box> and press <enter>")
    public void when_i_write_to_text_box_and_press_enter(String insertTodo) {
        page.searchBox.sendKeys(insertTodo + Keys.ENTER);
    }
    @Then("I should see {string} item in Todo list")
    public void i_should_see_item_in_todo_list(String string) {
        Assert.assertTrue(page.milkAssert.isDisplayed());
    }

// 2)   "Biraz süt satın al" öğesi içeren Yapılacaklar listesi
//    <metin kutusu>na "atamanın tadını çıkar" yazıp <enter> tuşuna bastığımda
//    O zaman "biraz süt al" öğesinin altındaki Yapılacaklar listesine eklenen "ödevin tadını çıkar" öğesini görmeliyim.
    @Given("ToDo list with {string} item")
    public void todoListWithItem(String todoitem) throws InterruptedException {
        page.searchBox.sendKeys(todoitem + Keys.ENTER);
    }
    @Then("I should see {string} item insterted to ToDo list below {string} item")
    public void iShouldSeeItemInstertedToDoListBelowItem(String item2, String item1) {
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//div[@class='view']//label"));
        //System.out.println(list.get(list.size()-1).getText());
        Assert.assertEquals(item2, list.get(list.size() - 1).getText());
    }
//3)    "Biraz süt satın al" öğesi içeren Yapılacaklar listesi
//   "Biraz süt al" öğesinin yanındaki <onay kutusu> seçeneğine tıkladığımda
//   O zaman "Bitti" olarak işaretlenmiş "biraz süt al" maddesi görmeliyim
    @When("I click on <checkbox> next to {string} item")
    public void iClickOnCheckboxNextToItem(String arg0) {
        //page.searchBox.sendKeys("buy some milk"+ Keys.ENTER);
        page.marked.click();
    }
    @Then("I should see {string} item marked as DONE")
    public void iShouldSeeItemMarkedAsDONE(String arg0) {
        Assert.assertTrue(page.marked.isEnabled());
        //Assert.assertTrue(page.tikliAssert.isDisplayed());
    }
//4)    İşaretli öğe ile verilen yapılacaklar listesi
//    Öğenin yanındaki <onay kutusu> seçeneğine tıkladığımda
//    O zaman "Biraz süt al" madde işaretini GERİ DÖNDÜ olarak görmeliyim
    @Given("todo list with marked item")
    public void todoListWithMarkedItem()  {
        page.searchBox.sendKeys("buy some milk" + Keys.ENTER);

    }
    @When("I click on <check box> next to item")
    public void iClickOnCheckBoxNextToItem() throws InterruptedException {

        WebElement hoverover=Driver.getDriver().findElement(By.xpath("//*[@class='toggle']"));
        Thread.sleep(5000); actions.doubleClick(hoverover).perform();
    }
    @Then("I should see {string} item marked as UNDONE")
    public void iShouldSeeItemMarkeAsUNDONE(String arg0) {

        Assert.assertTrue(page.item1.isEnabled());
    }
//5)   "Bir süre dinlenin" öğesi ile verilen Yapılacaklar listesi
//    "Bir süre dinlen" öğesinin yanındaki <sil düğmesine> tıkladığımda
//    O zaman Liste boş olmalı
    @When("I click on <delete button> next to {string} item")
    public void iClickOnDeleteButtonNextToItem(String arg0) throws InterruptedException {

        WebElement hoverover=Driver.getDriver().findElement(By.xpath("//div[@class='view']"));
       // Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(hoverover).perform();
        page.delete.click();
    }
    @Then("List should be empty")
    public void listShouldBeEmpty() {
        List<WebElement> list = Driver.getDriver().findElements(By.xpath(" //*[@class='view']"));
        Assert.assertTrue(list.size()==0);

    }
//6)    Sırasıyla "biraz dinlenin" ve "su içiniz" maddesi ile Yapılacaklar listesi verildi
//    "Bir süre dinlen" öğesinin yanındaki <sil düğmesine> tıkladığımda
//    O zaman Yapılacaklar listesinde "su iç" maddesini görmeliyim
    @Given("ToDo list with {string} and {string} item in order")
    public void todoListWithAndItemInOrder(String item1, String item2) {
        page.searchBox.sendKeys(item1+Keys.ENTER);
        page.searchBox.sendKeys(item2+Keys.ENTER);
    }
    @When("I click on <delete button> next to {string}item")
    public void iClickOnDeleteButtonNextToIte(String arg0) {
        WebElement hoverover=Driver.getDriver().findElement(By.xpath("//*[@class='view']"));
       // Actions actions=new Actions(Driver.getDriver());
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