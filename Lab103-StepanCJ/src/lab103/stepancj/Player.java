package lab103.stepancj;

/**
 * @author Calvin Stepan
 * @version 1.9.2021
 */
public class Player {

    String name;
    String positionPlayed;
    int jerseyNumber;

    /**
     * Default Constructor for the player class
     */
    public Player() {
        name = "Jerome";
        positionPlayed = "Short Stop";
        jerseyNumber = 32;
    }

    /**
     * Alternate Constructor for the player class
     *
     * @param name a String name for the player
     * @param positionPlayed a String to describe the position the player plays
     * @param jerseyNumber a nonnegative integer that represents the player's
     * jersey number
     */
    public Player(String name, String positionPlayed, int jerseyNumber) {
        this.name = name;
        this.positionPlayed = positionPlayed;
        this.jerseyNumber = jerseyNumber;
    }

    /**
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * @return the position played by the player
     */
    public String getPositionPlayed() {
        return positionPlayed;
    }

    /**
     * @return the jersey number of the player
     */
    public int getJerseyNumber() {
        return jerseyNumber;
    }

    /**
     * @param name a String to represent the player's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param positionPlayed a String to describe the player's position
     */
    public void setPositionPlayed(String positionPlayed) {
        this.positionPlayed = positionPlayed;
    }

    /**
     * @param jerseyNumber a nonnegative integer representing the player's
     * jersey number
     */
    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }
    
    public String toString() {
        return getClass().getName() + "@" + name + ":" + jerseyNumber + ":" + positionPlayed;
    }
}
