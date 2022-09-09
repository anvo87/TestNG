package mappings;

import com.opencsv.bean.CsvBindByName;

public class MappingMakeAppointment {
    @CsvBindByName(column = "visitDate")
    private String visitDate;
    @CsvBindByName(column = "comment")
    private String comment;

    public String getVisitDate(){
        return this.visitDate;
    }
    public String getComment(){
        return this.comment;
    }
}
