package tests;

import mappings.MappingMakeAppointment;
import pages.MakeAppointmentPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class MakeAppointmentTest extends BaseTest{

    public MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage();
    @DataProvider(name= "MakeAppointment")

    private Iterator<MappingMakeAppointment> createData(){
        List<MappingMakeAppointment> data = getDataAsObject("resources/Data.csv", MappingMakeAppointment.class);

        return data.iterator();
    }

    @Test(dataProvider = "MakeAppointment")
    public void MakeAppointmentSuccessfully(MappingMakeAppointment mappingMakeAppointment) {
        makeAppointmentPage.selectFacility();
        makeAppointmentPage.selectFacilityTokyoSelection();
        makeAppointmentPage.checkApplyCheckbox();
        makeAppointmentPage.selectHealthcare();
        makeAppointmentPage.inputVisitDate(mappingMakeAppointment.getVisitDate());
        makeAppointmentPage.inputComment(mappingMakeAppointment.getComment());
        makeAppointmentPage.clickBookAppointmentButton();

    }


}
