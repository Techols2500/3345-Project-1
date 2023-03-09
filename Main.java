/*
Tyler Echols

CS 3345.002 - Data Structures and Introduction to Algorithmic Analysis


Project #1

        Due Dates:  Monday, February 22 at 11:59pm

        Submit:    eLearning

        Late Policy:  -10 points per hour late

        Instructions: This is an individual assignment.  Answers should be your own work.
        You are expected to code this yourself from scratch by thinking
        through the requirements and design, then writing the code.
*/

public class Main {
    public static void main(String args[])
    {
        NameList TheObj = new NameList();
        TheObj.add("Apple"); // checks
        TheObj.display();
        TheObj.add("Dairy");
        TheObj.display();
        TheObj.add("Maple Syrup"); // letter exist
        TheObj.display();
        TheObj.add("Lettecue"); // letter don't exisit
        TheObj.display();
        TheObj.add("Waffles");
        TheObj.display();
        TheObj.add("Pineapples");
        TheObj.display();
        System.out.println(TheObj.find("Milk"));
        System.out.println(TheObj.find("Cheese"));

        TheObj.toString();

        TheObj.remove("Apple");
        TheObj.display();

        TheObj.removeLetter('D');
        TheObj.display();





    }
}
