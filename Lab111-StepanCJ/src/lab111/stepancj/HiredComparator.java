package lab111.stepancj;

/**
 *
 * @author Calvin Stepan
 */
public class HiredComparator implements Comparator<Employee> {
    /**
     * @param emp1
     * @param emp2
     * @return which employee hire date is first
     */
    public int compare(Employee emp1, Employee emp2) {
        if (emp1.getHired() < emp2.getHired()) {
            return 1;
        } else if (emp1.getDept() > emp2.getDept()) {
            return -1;
        } else {
            return 0;
        }
    }
}
