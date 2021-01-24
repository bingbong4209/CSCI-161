/**
 *
 * @author Calvin Stepan
 * @version 1/24/2021
 * The Hourly Class is a subclass of the Employee class that also indicates a position and an hourly rate in its constructor
 */
public class Hourly extends Employee {

    private String position;
    private double hourlyRate;
    private static int hourlyEmployeeCount = 0;

    /**
     *
     * @param id
     * @param name
     * @param position
     * @param hourlyRate
     */
    public Hourly(int id, String name, String position, double hourlyRate) {
        super(id, name);
        this.position = position;
        this.hourlyRate = hourlyRate;
        hourlyEmployeeCount++;
    }

    /**
     *
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     *
     * @param position updates position
     */
    public void setPosition(String position) {
        this.position = position;
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

    public void giveRaise() {
        hourlyRate += (0.10 * hourlyRate);
        System.out.println();
    }

    /**
     *
     * @return contents of instance
     */
    public String toString() {
        return super.toString() + ":" + getClass().getName() + "@" + position + ":" + hourlyRate + ":" + hourlyEmployeeCount;
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
                && position.equals(s.position)
                && hourlyRate == s.hourlyRate;
    }
}
