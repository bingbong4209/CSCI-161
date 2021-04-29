package lab111.stepancj;

import java.util.Random;

/**
 * The Employee Class is an enhanced version of the Lab101 Employee Class Each
 * employee is assigned a random id number, name, dept, and hired year These
 * values cannot be changed and are randomized per employee duplicates are not
 * accounted for or taken care of
 *
 * @author Calvin Stepan
 * @version 4.27.2021
 */
public class Employee {

    //Random object and corresponding max numbers for each scenario
    Random rand = new Random();
    int idNumber = 100000000;
    int deptNumber = 5;
    int hiredBottom = 1995;
    int hiredTop = 2021;

    //private class variables
    private final int id;
    private String name = "";
    private final int dept;
    private final int hired;

    /**
     * Constructor that randomizes all 4 class variables
     */
    public Employee() {
        id = rand.nextInt(idNumber);
        for (int i = 0; i < rand.nextInt((11 - 5) + 1) + 5; i++) {
            name += randomName(rand.nextInt(26));
        }
        dept = rand.nextInt(deptNumber) + 1;
        hired = rand.nextInt(hiredTop - hiredBottom + 1) + hiredBottom;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @return dept
     */
    public int getDept() {
        return dept;
    }

    /**
     * @return hired
     */
    public int getHired() {
        return hired;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the unicode value of the given name
     */
    public int getNameValue() {
        int temp = 0;
        for (int i = 0; i < name.length(); i++) {
            temp += name.charAt(i);
        }
        return temp;
    }

    /**
     * @param A an int representing the corresponding letter in the alphabet
     * (0-25)
     * @return the letter corresponding to the A-value
     */
    private String randomName(int A) {
        String temp = "";
        switch (A) {
            case 0:
                temp = "a";
                break;
            case 1:
                temp = "b";
                break;
            case 2:
                temp = "c";
                break;
            case 3:
                temp = "d";
                break;
            case 4:
                temp = "e";
                break;
            case 5:
                temp = "f";
                break;
            case 6:
                temp = "g";
                break;
            case 7:
                temp = "h";
                break;
            case 8:
                temp = "i";
                break;
            case 9:
                temp = "j";
                break;
            case 10:
                temp = "k";
                break;
            case 11:
                temp = "l";
                break;
            case 12:
                temp = "m";
                break;
            case 13:
                temp = "n";
                break;
            case 14:
                temp = "o";
                break;
            case 15:
                temp = "p";
                break;
            case 16:
                temp = "q";
                break;
            case 17:
                temp = "r";
                break;
            case 18:
                temp = "s";
                break;
            case 19:
                temp = "t";
                break;
            case 20:
                temp = "u";
                break;
            case 21:
                temp = "v";
                break;
            case 22:
                temp = "w";
                break;
            case 23:
                temp = "x";
                break;
            case 24:
                temp = "y";
                break;
            case 25:
                temp = "z";
                break;
            default:
                temp = "";
        }
        return temp;
    }
    
    /**
     * 
     * @return contents of Employee instance
     */
    public String toString(){
        //return getClass().getName() + "@" + name + ":" + id + ":" + hired + ":" + dept;
        return id + "";
    }
}
