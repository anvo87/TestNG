package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;



public class MakeAppointmentPage extends BasePage{

    By facilitySelection = By.id("combo_facility");
    By applyCheckbox = By.id("chk_hospotal_readmission");
    By healthcareRadio = By.id("radio_program_medicaid");
    By visitDateInput = By.id("txt_visit_date");
    By commentInput = By.id("txt_comment");
    By bookAppointmentButton = By.id("btn-book-appointment");


    public void selectFacility(){
        driver.findElement(facilitySelection).click();


    }

    public void selectFacilityTokyoSelection(){
       Select dropdown = new  Select(driver.findElement(facilitySelection));
       dropdown.selectByVisibleText("Hongkong CURA Healthcare Center");
    }

    public void checkApplyCheckbox(){
        driver.findElement(applyCheckbox).isSelected();
    }

    public void selectHealthcare(){
        driver.findElement(healthcareRadio).isSelected();
    }

    public void inputVisitDate(String visitDate){
        driver.findElement(visitDateInput).sendKeys(visitDate);
    }

    public void inputComment(String comment){
        driver.findElement(commentInput).sendKeys(comment);
    }

    public void clickBookAppointmentButton(){
        driver.findElement(bookAppointmentButton).click();
    }
}
