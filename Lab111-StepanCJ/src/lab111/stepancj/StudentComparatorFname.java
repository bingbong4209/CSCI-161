package lab111.stepancj;

/**
 *
 * @author Calvin Stepan
 */
public class StudentComparatorFname implements Comparator<Employee> {

    public int compare(Employee a, Employee b) {
        return a.getName().compareTo(b.getName());
    }

}
