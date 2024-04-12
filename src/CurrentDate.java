
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDate {
    private final String date;
    
    public CurrentDate(){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");    
        String formattedDate = dateFormat.format(currentDate);
        this.date = formattedDate;
    }

    
    public String getdate(){
        return date;
    }
}
