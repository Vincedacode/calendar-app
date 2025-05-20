package CalenderApp;

import java.io.Serializable;
import java.time.LocalDate;

public class Event implements Serializable {

    protected LocalDate date;
    protected String description;

    public Event(LocalDate date, String description) {
        this.date = date;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return
                "\n" +date + " :: " +
                 description;
    }
}
