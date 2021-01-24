
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Calvin Stepan
 * @version 1/24/2021 The Client class takes information from all three classes
 * and puts it together in the main method to be run
 */
public class Client {

    public static void main(String[] args) throws FileNotFoundException {
        //indexer for placing employees into the array
        int i = 0;

        //temporary variables to hold the data taken in from the user
        int tempIDSalary;
        int tempIDHourly;
        String tempNameSalary;
        String tempNameHourly;
        String tempTitle;
        String tempPosition;
        int tempSalary;
        double tempHourlyRate;

        Employee[] employeeList = new Employee[20];

        Scanner fileScan = new Scanner(new File("C:\\data\\employeeList.txt"));
        Scanner outputScan = new Scanner(System.in);

        //Salaried Employee Data
        //All loops are made to be typesafe so if the user doesn't enter in an integer, the system will wait for the correct data 
        System.out.println("Please enter data for a salaried employee:");

        System.out.println("Please enter an ID number for the salaried employee: ");
        while (!outputScan.hasNextInt()) {
            System.out.println("Please enter a valid integer for the ID");
            outputScan.next();
        }

        tempIDSalary = outputScan.nextInt();

        System.out.println("Please enter a name for the salaried employee: ");
        while (outputScan.hasNextInt()) {
            System.out.println("Please enter a valid String for the name");
            outputScan.next();
        }

        tempNameSalary = outputScan.next();
        System.out.println("Please enter a title for the salaried employee: ");
        while (outputScan.hasNextInt()) {
            System.out.println("Please enter a valid String for the title");
            outputScan.next();
        }

        tempTitle = outputScan.next();

        System.out.println("Please enter a salary for the salaried employee: ");
        while (!outputScan.hasNextInt()) {
            System.out.println("Please enter a valid integer for the salary");
            outputScan.next();
        }

        tempSalary = outputScan.nextInt();

        //Hourly Employee Data
        //All loops are made to be typesafe so if the user doesn't enter in an integer, the system will wait for the correct data 
        System.out.println("Please enter data for a hourly employee:");

        System.out.println("Please enter an ID number for the hourly employee: ");
        while (!outputScan.hasNextInt()) {
            System.out.println("Please enter a valid integer for the ID");
            outputScan.next();
        }

        tempIDHourly = outputScan.nextInt();

        System.out.println("Please enter a name for the hourly employee: ");
        while (outputScan.hasNextInt()) {
            System.out.println("Please enter a valid String for the name");

            outputScan.next();
        }

        tempNameHourly = outputScan.next();

        System.out.println("Please enter a position for the hourly employee: ");
        while (outputScan.hasNextInt()) {
            System.out.println("Please enter a valid String for the position");

            outputScan.next();
        }

        tempPosition = outputScan.next();

        System.out.println("Please enter an hourly rate for the hourly employee: ");
        while (!outputScan.hasNextDouble()) {
            System.out.println("Please enter a valid double for the hourly rate");
            outputScan.next();
        }

        tempHourlyRate = outputScan.nextDouble();

        //parse the file before anything else, intaking the data and putting it into the array accordingly
        while (fileScan.hasNext()) {

            if ("S".equals(fileScan.next())) {
                employeeList[i] = new Salaried(fileScan.nextInt(), fileScan.next(), fileScan.next(), fileScan.nextInt());
                System.out.println(employeeList[i].toString());
                i++;
            } else {
                employeeList[i] = new Hourly(fileScan.nextInt(), fileScan.next(), fileScan.next(), fileScan.nextDouble());
                System.out.println(employeeList[i].toString());
                i++;
            }
        }
        //add the salaried and hourly employees the user created to the array
        employeeList[i] = new Salaried(tempIDSalary, tempNameSalary, tempTitle, tempSalary);
        System.out.println(employeeList[i].toString());
        i++;

        employeeList[i] = new Hourly(tempIDHourly, tempNameHourly, tempPosition, tempHourlyRate);
        System.out.println(employeeList[i].toString());
        i++;

        //fill the remainder of the array with empty Employee objects
        while (i < 20) {
            employeeList[i] = new Employee();
            System.out.println(employeeList[i].toString());
            i++;
        }

        //reprint the whole array after giving everyone raises
        for (int j = 0; j < employeeList.length; j++) {
            if (employeeList[j] instanceof Salaried) {
                Salaried instanceS = (Salaried) employeeList[j];
                instanceS.giveRaise();
                System.out.println(employeeList[j].toString());
            } else if (employeeList[j].getId() == 0) {

            } else {
                Hourly instanceH = (Hourly) employeeList[j];
                instanceH.giveRaise();
                System.out.println(employeeList[j].toString());
            }
        }
        //instantiate two test objects to test the equals method
        Salaried testSalaried = new Salaried(12313, "jerome", "gamer", 1234);
        Hourly testHourly = new Hourly(12313, "jerome", "gamer", 12.34);
        
        //test the equals method for all 3 classes
        System.out.println("Employee class equals method test\n false test: " + employeeList[0].equals(i) + "\ntrue test: " + employeeList[0].equals(employeeList[0]));
        System.out.println("Salaried class equals method test\n false test: " + testSalaried.equals(i) + "\ntrue test: " + testSalaried.equals(testSalaried));
        System.out.println("Employee class equals method test\n false test: " + testHourly.equals(i) + "\ntrue test: " + testHourly.equals(testHourly));

    }

}
