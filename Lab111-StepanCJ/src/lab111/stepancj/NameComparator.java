package lab111.stepancj;

/**
 * The Name Comparator compares two given Employee names
 * @author Calvin Stepan
 */
public class NameComparator implements Comparator<Employee> {

    /**
     * @param emp1 the first employee object
     * @param emp2
     * @return which employee name comes first in the alphabet
     */
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getName().compareTo(emp2.getName());
    }
}
