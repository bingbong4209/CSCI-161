package lab111.stepancj;

/**
 *
 * @author Calvin Stepan
 */
public class NameComparator implements Comparator<Employee> {
    /**
     * @param emp1
     * @param emp2
     * @return which employee name is larger
     */
    public int compare(Employee emp1, Employee emp2) {
        if (emp1.getNameValue() > emp2.getNameValue()) {
            return 1;
        } else if (emp1.getNameValue() < emp2.getNameValue()) {
            return -1;
        } else {
            return 0;
        }
    }
    
    /**
     * @param emp1
     * @param emp2
     * @return which employee name comes first in the alphabet\
     */
    public static int firstLetterNameCompare(Employee emp1, Employee emp2) {
        if (emp1.getName().charAt(0) > emp2.getName().charAt(0)) {
            return 1;
        } else if (emp1.getName().charAt(0) < emp2.getName().charAt(0)) {
            return -1;
        } else {
            return 0;
        }
    }
}
