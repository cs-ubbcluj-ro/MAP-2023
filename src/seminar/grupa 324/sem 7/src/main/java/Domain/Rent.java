package Domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Rent extends Entity {
    private int carId;
    private Date startDate;
    private Date endDate;

    public Rent(int id, int carId, Date startDate, Date endDate) {
        super(id);
        this.carId = carId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Rent(String line) {
        super(Integer.parseInt(line.split(",")[0]));
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        try {

            carId = Integer.parseInt(line.split(",")[1]);
            startDate = formatter.parse(line.split(",")[2]);
            endDate = formatter.parse(line.split(",")[3]);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }


    @Override
    public String toString()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return "id: " + id + ", car id" + carId + ", start date: " + dateFormat.format(startDate)+ ", end date: " + dateFormat.format(endDate);
    }

    public String toFileString() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return id + "," + carId + ","+ dateFormat.format(startDate)+ "," + dateFormat.format(endDate) + "\n";
    }
}
