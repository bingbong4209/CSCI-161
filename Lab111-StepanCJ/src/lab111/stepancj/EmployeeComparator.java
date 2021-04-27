package lab111.stepancj;

/**
 * The EmployeeComparator class is an example of a concrete comparator class
 * This will help us in our sorts to accurately compare two objects
 *
 * @author Calvin Stepan
 */
public class EmployeeComparator implements Comparator<Employee> {

    public int compare(Employee emp1, Employee emp2) {
        return 1;
    }

    /**
     * @param emp1
     * @param emp2
     * @return which employee id is larger
     */
    public static int idCompare(Employee emp1, Employee emp2) {
        if (emp1.getId() > emp2.getId()) {
            return 1;
        } else if (emp1.getId() < emp2.getId()) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * @param emp1
     * @param emp2
     * @return which employee name is larger
     */
    public static int unicodeNameCompare(Employee emp1, Employee emp2) {
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

    /**
     * @param emp1
     * @param emp2
     * @return which employee dept number is larger
     */
    public static int deptCompare(Employee emp1, Employee emp2) {
        if (emp1.getDept() > emp2.getDept()) {
            return 1;
        } else if (emp1.getDept() < emp2.getDept()) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * @param emp1
     * @param emp2
     * @return which employee hire date is first
     */
    public static int hiredCompare(Employee emp1, Employee emp2) {
        if (emp1.getHired() < emp2.getHired()) {
            return 1;
        } else if (emp1.getDept() > emp2.getDept()) {
            return -1;
        } else {
            return 0;
        }
    }
}
