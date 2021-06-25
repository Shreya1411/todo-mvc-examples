package steps;

import core.constants.StoryContextKey;
import core.constants.ToDoMVCConstants;
import core.utils.DateTimeUtils;
import io.cucumber.java.bs.A;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import core.pages.ToDoMVCExamplesPage;

import java.util.List;

public class ToDoMVCSteps {
    ToDoMVCExamplesPage toDoMVCExamplesPage;

    public void navigateToExamplesHomePage(){
        this.toDoMVCExamplesPage.open();
    }
    public void enterInputForNewToDoTask(){
        String title= ToDoMVCConstants.TODO_CREATE_TITLE+ DateTimeUtils.getTimestampWithoutDash();
        this.toDoMVCExamplesPage.enterInputForNewToDoTask(title);
        Serenity.getCurrentSession().put(StoryContextKey.title,title);
    }
    public void verifyToDoTaskCreated(){
        String actualText= this.toDoMVCExamplesPage.verifyToDoTaskCreated();
        String expectedText= Serenity.getCurrentSession().get(StoryContextKey.title).toString();
        Assert.assertEquals("The new task is not displayed in list post creation", expectedText,actualText);
    }
    public void clickOnDeleteIcon(){
        this.toDoMVCExamplesPage.clickOnDeleteIcon();
    }
    public void verifyToDoTaskDeletion(){
        List<String> toDoListTasks=this.toDoMVCExamplesPage.getToDoListItems();
        Assert.assertTrue("Item is not deleted and size is greater than 1.",toDoListTasks.size()==0);
        Assert.assertTrue("Deleted items are still displayed in list.",!(toDoListTasks.contains(Serenity.getCurrentSession().get(StoryContextKey.title))));
    }
    public void editToDoTask(){
        this.toDoMVCExamplesPage.editToDoTask();
    }
    public void createNewTask(String title){
        this.toDoMVCExamplesPage.enterInputForNewToDoTask(title);
    }
    public void verifyNewToDoTaskWithTitle(String title){
        List<String> toDoListTasks=this.toDoMVCExamplesPage.getToDoListItems();
        Assert.assertTrue("Created items are not displayed in list.",toDoListTasks.contains(title));
    }
    public void verifyCountOfTakInList(){
        List<String> toDoListTasks=this.toDoMVCExamplesPage.getToDoListItems();
        Assert.assertTrue("Count Of task created is not matching in the list.",toDoListTasks.size()==2);
    }
    public void clickOnToggleButtonAtTop(){
        this.toDoMVCExamplesPage.clickOnToggleButtonAtTop();
    }
    public void clickOnToggleButtonInList(){
        this.toDoMVCExamplesPage.clickOnToggleButtonInList();
    }
    public void verifyTaskCountPostCompletion(String reducedOrIncreased){
        String taskCount=this.toDoMVCExamplesPage.getTaskDisplayCountFromList();
        if(reducedOrIncreased.equalsIgnoreCase("reduced")){
            Assert.assertTrue("More than 0 item items left is displayed in list.",(taskCount.equals("0")));
        }
        else if(reducedOrIncreased.equalsIgnoreCase("increased")){
            Assert.assertTrue("Item left count is not increased when task completed is unchecked.",(taskCount.equals("1")));
        }
    }
    public void clearCompletedIsDisplayed(String displayedOrNotDisplayed){
        if(displayedOrNotDisplayed.equalsIgnoreCase("displayed")){
            Boolean flag=this.toDoMVCExamplesPage.clearCompletedIsDisplayed();
            Assert.assertTrue("Clear Completed Button is not displayed",flag);
        }
        else if(displayedOrNotDisplayed.equalsIgnoreCase("notDisplayed")){
            this.toDoMVCExamplesPage.clearCompletedIsNotDisplayed();
        }
    }
}
