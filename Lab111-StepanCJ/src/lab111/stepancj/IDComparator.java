package lab111.stepancj;

/**
 *
 * @author Calvin Stepan
 */
public class IDComparator implements Comparator<Employee> {
    /**
     * @param emp1
     * @param emp2
     * @return which employee id is larger
     */
    public int compare(Employee emp1, Employee emp2) {
        if (emp1.getId() > emp2.getId()) {
            return 1;
        } else if (emp1.getId() < emp2.getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}
