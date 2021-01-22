
/**
 *
 * @author Calvin Stepan
 */
public class Hourly extends Employee {

    private String title;
    private double hourlyRate;
    private static int hourlyEmployeeCount = 0;

    /**
     *
     * @param id
     * @param name
     * @param title
     * @param hourlyRate
     */
    public Hourly(int id, String name, String title, double hourlyRate) {
        super(id, name);
        this.title = title;
        this.hourlyRate = hourlyRate;
        hourlyEmployeeCount++;
    }

    /**
     *
     * @return title
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
     * @return hourlyRate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     *
     * @param hourlyRate updates hourlyRate
     */
    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     *
     * @return contents of instance
     */
    public String toString() {
        return super.toString() + ":" + getClass().getName() + "@" + title + ":" + hourlyRate + ":" + hourlyEmployeeCount;
    }

    /**
     *
     * @param o
     * @return true if equal, false otherwise
     */
    public boolean equals(Object o) {
        if (!(o instanceof Hourly)) {
            return false;
        }

        Hourly s = (Hourly) o;

        return super.equals(s)
                && title.equals(s.title)
                && hourlyRate == s.hourlyRate;
    }
}
