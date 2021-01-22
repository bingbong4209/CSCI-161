
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Calvin Stepan
 */
public class Client {

    public static void main(String[] args) throws FileNotFoundException {
        int i = 0;
        Employee[] employeeList = new Employee[20];

        Scanner scan = new Scanner(new File("C:\\Users\\User\\Downloads\\employeeList\\employeeList.txt"));//change back to Calvin instead of user later

        while (scan.hasNext()) {

            if ("S".equals(scan.next())) {
                employeeList[i] =  new Salaried(scan.nextInt(), scan.next(), scan.next(), scan.nextInt());
                System.out.println(employeeList[i].toString());
                i++;

            } else {
                employeeList[i] =  new Hourly(scan.nextInt(), scan.next(), scan.next(), scan.nextDouble());
                System.out.println(employeeList[i].toString());
                i++;
            }

        }

    }

}
