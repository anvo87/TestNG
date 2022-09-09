package ultilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.io.File;


public class PropertiesFileReader {

    private static Properties properties;
    private static FileInputStream fileIn;
    private static FileOutputStream fileOut;
    private static File file;

    // Get the directory current project
    static String projectPath = System.getProperty("user.dir") + "/";

    //Create the directory to the file configs.properties default



    //Lay gia tri tu file properties file thong qua key
    public static void setProperties(String fileDir){
        properties = new Properties();
        try{
            fileIn = new FileInputStream(projectPath + fileDir);
            properties.load(fileIn);
        }catch (Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }

    }



    // Create Get Value method from Key of File Properties set up above
    // lay gia tri thong qua key tu ham set

    public static String getPropValue(String keyProp){

        String value = null;
        //get value from properties file
        value = properties.getProperty(keyProp);
        System.out.println(value);
        return value;

    }
    // Create Set Value method as in file properties set up above

    public static void setPropValue(String keyProp, String value,String fileDir){
        try{
            // Create value for object class FileOutputStream
            fileOut = new FileOutputStream(projectPath + fileDir);
            //load current properties file and do mapping value with suitable key
            properties.setProperty(keyProp, value);
            //Save key and value into properties file
            properties.store((fileOut),"Set new value in properties file");
            System.out.println("set new value in file properties success");
        } catch (Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }


}
