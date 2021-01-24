/**
 *
 * @author Calvin Stepan
 * @version 1/24/2021
 * The Salaried Class is a subclass of the Employee class that also indicates a title and a salary in its constructor
 */
public class Salaried extends Employee {

    private String title;
    private int salary;
    private static int salariedEmployeeCount = 0;

    /**
     *
     * @param id 
     * @param name
     * @param title position of work
     * @param salary 
     */
    public Salaried(int id, String name, String title, int salary) {
        super(id, name);
        this.title = title;
        this.salary = salary;
        salariedEmployeeCount++;
    }

    /**
     *
     * @return title/position 
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title updates title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     *
     * @param salary updates salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void giveRaise() {
        salary += (salary * .1);
    }

    /**
     *
     * @return contents of instance
     */
    public String toString() {
        return super.toString() + ":" + getClass().getName() + "@" + title + ":" + salary + ":" + salariedEmployeeCount;
    }

    /**
     *
     * @param o
     * @return true if equal, false otherwise
     */
    public boolean equals(Object o) {
        if (!(o instanceof Salaried)) {
            return false;
        }

        Salaried s = (Salaried) o;

        return super.equals(s)
                && title.equals(s.title)
                && salary == s.salary;
    }
}
