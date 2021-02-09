package lab103.stepancj;

/**
 *
 * @author Calvin Stepan
 * @version 1.9.2021
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayBag MensTeam = new ArrayBag(2);
        LinkedBag WomensTeam = new LinkedBag(2);

        //Instantiate the men's football team players to be inserted into the list later
        Player jonPlayer = new Player("Jon", "Center", 99);
        Player jeremyPlayer = new Player("Jeremy", "Lineman", 80);
        Player jimmyPlayer = new Player("Jimmy", "Quarterback", 12);
        Player jaredPlayer = new Player("Jared", "Safety", 3);
        Player jonathanPlayer = new Player("Jonathan", "Linebacker", 54);
        Player jiffyPlayer = new Player("Jiffy", "Kicker", 9);
        Player jaRulePlayer = new Player("Ja Rule", "Punter", 13);
        Player jensonPlayer = new Player("Jenson", "Wide Receiver", 24);
        Player jujuPlayer = new Player("Juju", "Kick Returner", 67);

        //Instantiate the womnen's basketball team players to be inserted into the list later
        Player jillPlayer = new Player("Jill", "Center", 65);
        Player jessicaPlayer = new Player("Jessica", "Point Guard", 5);
        Player janessaPlayer = new Player("Janessa", "Shooting Guard", 10);
        Player jocelynPlayer = new Player("Jocelyn", "Shooting Guard", 23);
        Player joliePlayer = new Player("Jolie", "Center", 54);
        Player juliePlayer = new Player("Julie", "Power Forward", 33);
        Player jeanettePlayer = new Player("Jeanette", "Power Forward", 13);
        Player jeanPlayer = new Player("Jean", "Small Forward", 15);
        Player joycePlayer = new Player("Joyce", "Small Forward", 9);

        //add the first 8 players to the roster
        MensTeam.add(jonPlayer);
        MensTeam.add(jeremyPlayer);
        MensTeam.add(jimmyPlayer);
        MensTeam.add(jaredPlayer);
        MensTeam.add(jonathanPlayer);
        MensTeam.add(jiffyPlayer);
        MensTeam.add(jaRulePlayer);
        MensTeam.add(jensonPlayer);

        //display the current roster
        System.out.print(MensTeam.toString());

        //remove a random player from the team
        MensTeam.remove();

        //display the roster after the random removal of a team member
        System.out.print(MensTeam.toString());

        //add the new player
        MensTeam.add(jujuPlayer);

        //display the current roster after adding the new player
        System.out.print(MensTeam.toString());

        //remove the player we just added
        MensTeam.remove(jujuPlayer);

        //display the current roster
        System.out.print(MensTeam.toString());

        //-----------Repeating the same steps for the Women's team--------------
        //add the first 8 players to the roster
        WomensTeam.add(jillPlayer);
        WomensTeam.add(jessicaPlayer);
        WomensTeam.add(janessaPlayer);
        WomensTeam.add(jocelynPlayer);
        WomensTeam.add(joliePlayer);
        WomensTeam.add(juliePlayer);
        WomensTeam.add(jeanettePlayer);
        WomensTeam.add(jeanPlayer);

        //display the current roster
        System.out.print(WomensTeam.toString());

        //remove a random player from the team
        WomensTeam.remove();

        //display the roster after the random removal of a team member
        System.out.print(WomensTeam.toString());

        //add the new player
        WomensTeam.add(joycePlayer);

        //display the current roster after adding the new player
        System.out.print(WomensTeam.toString());

        //remove the player we just added
        WomensTeam.remove(joycePlayer);

        //display the current roster
        System.out.print(WomensTeam.toString());

    }

}
