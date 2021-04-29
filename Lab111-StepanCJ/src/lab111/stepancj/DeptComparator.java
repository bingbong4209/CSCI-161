package lab111.stepancj;

/**
 *
 * @author Calvin Stepan
 */
public class DeptComparator implements Comparator<Employee> {
    /**
     * @param emp1
     * @param emp2
     * @return which employee dept number is larger
     */
    public int compare(Employee emp1, Employee emp2) {
        if (emp1.getDept() > emp2.getDept()) {
            return 1;
        } else if (emp1.getDept() < emp2.getDept()) {
            return -1;
        } else {
            return 0;
        }
    }
}
