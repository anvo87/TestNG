package tests;

import pages.BasePage;
import com.opencsv.bean.CsvToBeanBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    public BasePage basePage;

    @BeforeTest
    public void launchBrowser(){
        basePage = new BasePage();
        basePage.setDriverForPage();
    }

    //convert csv to object
    @AfterTest
    public void closeBrowser(){
        basePage.tearDown();
    }

    public  <T> List<T> getDataAsObject(String pathTOFile, Class<T> type){
        List<T> tList= new ArrayList<>();
        try(Reader reader = new FileReader(pathTOFile)){
            tList = new CsvToBeanBuilder<T>(reader)
                    .withType(type)
                    .build().parse();
        }catch (Exception e){
            e.printStackTrace();
        }
        return tList;

    }

}
