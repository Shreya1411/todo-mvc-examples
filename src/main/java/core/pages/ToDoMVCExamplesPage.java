package core.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("http://todomvc.com/examples/vue/")
public class ToDoMVCExamplesPage extends BaseWebPage {

    private String todoListItems="ul.todo-list li.todo";

    @FindBy(css = "input.new-todo")
    private WebElementFacade inputTitleField;

    @FindBy(css="ul.todo-list li.todo div.view label")
    private WebElementFacade todoList;

    @FindBy(css="button.destroy")
    private WebElementFacade destroyButton;

    @FindBy(css="input.toggle")
    private WebElementFacade toggleCompleteButtonInList;

    @FindBy(css="#toggle-all + label")
    private WebElementFacade toggleCompleteButtonAtTop;

    @FindBy(css="span.todo-count>strong")
    private WebElementFacade listItemCount;

    @FindBy(css="button.clear-completed")
    private WebElementFacade clearCompletedButton;

    /**
     * enter Input For New ToDo task
     * @param title
     */
    public void enterInputForNewToDoTask(String title){
        this.inputTitleField.sendKeys(title+ "\n");
    }

    /**
     * get the text for new ToDo task created in list
     * @return
     */
    public String verifyToDoTaskCreated(){
       return this.todoList.getText();
    }

    /**
     * click on Delete Icon
     */
    public void clickOnDeleteIcon(){
        //This option is not working on this page, because this javascript page doesn't follows W3C coding standards
//        withAction().moveToElement(todoList).moveToElement(destroyButton).click().perform();
        clickOn(todoList);
        clickOn(destroyButton);
    }

    /**
     * get All items of ToDo List
     * @return
     */
    public List<String> getToDoListItems(){
        List<String> toDoListItems=new ArrayList<>();
        List<WebElementFacade> todDoList=this.findAll(By.cssSelector(todoListItems));
        for(WebElementFacade we:todDoList){
            toDoListItems.add(we.getText());
        }
        return toDoListItems;
    }

    /**
     * Double click to edit task in list
     */
    public void editToDoTask(){
        //This is failing with InvalidArgument exception because this page doesn't follows W3C standards
//         withAction().moveToElement(todoList).doubleClick().build().perform();
    }

    /**
     * click on toggle all button at top to complete task
     */
    public void clickOnToggleButtonAtTop(){
        this.toggleCompleteButtonAtTop.click();
    }

    /**
     * click on Toggle Button in List items
     */
    public void clickOnToggleButtonInList(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        evaluateJavascript("arguments[0].click();", toggleCompleteButtonInList);
//        this.toggleCompleteButtonInList.click();
//        clickOn(toggleCompleteButtonInList);
    }

    /**
     * get Task Counter In List
     * @return
     */
    public String getTaskDisplayCountFromList(){
        return this.listItemCount.getText();
    }

    /**
     * get Visibility of Completed Task
     * @return
     */
    public Boolean clearCompletedIsDisplayed(){
        return this.clearCompletedButton.isDisplayed();
    }
    /**
     * get InVisibility of Completed Task
     * @return
     */
    public void clearCompletedIsNotDisplayed(){
       this.clearCompletedButton.shouldNotBeVisible();
    }
}
