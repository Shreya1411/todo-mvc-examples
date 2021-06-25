package glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.ToDoMVCSteps;

public class ToDoMVCGlue {
    @Steps
    ToDoMVCSteps toDoMVCSteps;


    @Given("^Navigate to Examples Home Page$")
    public void navigateToExamplesHomePage(){
      this.toDoMVCSteps.navigateToExamplesHomePage();
    }

    @When("^User enters new Task in ToDo Bar$")
    public void enterInputForNewToDoTask(){
        this.toDoMVCSteps.enterInputForNewToDoTask();
    }
    @Then("^New Todo Task is displayed in list post creation$")
    public void verifyToDoTaskCreated(){
        this.toDoMVCSteps.verifyToDoTaskCreated();
    }
    @When("^User clicks on delete icon in list$")
    public void clickOnDeleteIcon(){
        this.toDoMVCSteps.clickOnDeleteIcon();
    }
    @Then("^ToDo task is deleted$")
    public void verifyToDoTaskDeletion(){
        this.toDoMVCSteps.verifyToDoTaskDeletion();
    }
    @When("^User edits the task$")
    public void editToDoTask(){
        this.toDoMVCSteps.editToDoTask();
    }
    @When("^User enters new Task in ToDo Bar-(.*)$")
    public void createNewTask(String title){
        this.toDoMVCSteps.createNewTask(title);
    }
    @Then("^New Todo Task is displayed in list post creation-(.*)$")
    public void verifyNewToDoTaskWithTitle(String title){
        this.toDoMVCSteps.verifyNewToDoTaskWithTitle(title);
    }
    @Then("^verify the total count Of created task in list$")
    public void verifyCountOfTakInList(){
        this.toDoMVCSteps.verifyCountOfTakInList();
    }
    @When("^user (?:completes|unCompletes) the task from top$")
    public void clickOnToggleButtonAtTop(){
        this.toDoMVCSteps.clickOnToggleButtonAtTop();
    }
    @When("^user completes the task from list$")
    public void clickOnToggleButtonInList(){
        this.toDoMVCSteps.clickOnToggleButtonInList();
    }
    @Then("^the count of items is (reduced|increased) in list$")
    public void verifyItemsLeftPostCompletionUnCompletion(String reducedOrIncreased){
        this.toDoMVCSteps.verifyTaskCountPostCompletion(reducedOrIncreased);
    }
    @Then("^Clear Completed Button is (displayed|notDisplayed)$")
    public void isClearCompletedButtonDisplayed(String displayedOrNotDisplayed){
        this.toDoMVCSteps.clearCompletedIsDisplayed(displayedOrNotDisplayed);
    }
}
