package ro.siit;

import ro.siit.model.Event;
import ro.siit.service.ServiceCalendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ServiceCalendar serviceCalendar = new ServiceCalendar();
        List<Event> listOfDates = new ArrayList<>();
        listOfDates = serviceCalendar.getDatesFromDB();
        System.out.println(listOfDates);
    }
}
