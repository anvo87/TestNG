package mappings;

import com.opencsv.bean.CsvBindByName;

public class MappingLogin {

    @CsvBindByName(column = "userName")
    private String userName;
    @CsvBindByName(column = "passWord")
    private String passWord;

    public String getUserName(){
        return this.userName;
    }
    public String getPassWord(){
        return this.passWord;
    }

//    @CsvBindByName(column = "visitDate")
//    private String visitDate;
//    @CsvBindByName(column = "comment")
//    private String comment;
//
//    public String getVisitDate(){
//        return this.visitDate;
//    }
//    public String getComment(){
//        return this.comment;
//    }

}
