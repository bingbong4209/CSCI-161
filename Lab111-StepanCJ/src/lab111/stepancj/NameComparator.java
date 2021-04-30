package lab111.stepancj;

/**
 *
 * @author Calvin Stepan
 */
public class NameComparator implements Comparator<Employee> {
    /**
     * @param emp1
     * @param emp2
     * @return which employee name comes first in the alphabet
     */
    @Override
    public int compare(Employee emp1, Employee emp2) {
        /*
        int length1 = emp1.getName().length();
        int length2 = emp2.getName().length();
        int iterableLength;
        int returnValue = -2;
        if (length1 > length2) {
            iterableLength = length1;
        } else {
            iterableLength = length2;
        }
        for (int i = 0; i < iterableLength; i++) {
            if (emp1.getName().charAt(i) < emp2.getName().charAt(i)) {
                returnValue = 1;
                break;
            } else if (emp1.getName().charAt(i) > emp2.getName().charAt(i)) {
                returnValue = -1;
                break;
            }
        }*/
        return emp1.getName().compareTo(emp2.getName());
    }
}
