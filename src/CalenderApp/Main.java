package CalenderApp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calender mycalender = new Calender(new ArrayList<Event>());
        boolean loop = true;
        Scanner myscanner = new Scanner(System.in);
        mycalender.loadEvents();
      try{
          while (loop){
              System.out.println("Vincedacode's Calendar");
              System.out.println("1. Add new event");
              System.out.println("2. View all events");
              System.out.println("3. Check today's events");
              System.out.println("4. Exit");
              int userchoice = myscanner.nextInt();
              myscanner.nextLine();
              switch (userchoice){
                  case 1:
                      mycalender.addNewEvent();
                      break;
                  case 2:
                      mycalender.viewEvents();
                      break;
                  case 3:
                      mycalender.checkTodayEvents();
                      break;
                  case 4:
                      loop =false;
                      System.out.println("Exiting...");
                      break;
                  default:
                      System.out.println("Please enter valid option! (1-4)");
              }

          }
      }catch (InputMismatchException e){
          System.out.println("Please enter valid option! (1-4)");
      }
      catch (Exception e){
          System.out.println(e.getMessage());
      }
    }
}
