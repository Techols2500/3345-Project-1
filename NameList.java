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

public class NameList {
    // Step 1: Make a node class
    class Node { // Class node is a container to hold info
        private String Name; // checks to see if a name is there
        private Node Next; // checks to see if the nodes are Next to each other
        private boolean isLetter; // checks to see if it's an actual letter being inserted


        Node(String Name, Node Next, boolean isLetter) // this is setting data to information we are receiving
        {
            this.Name = Name;
            this.Next = Next;
            this.isLetter = isLetter;
        }

        // Getters and Setters
        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public Node getNext() {
            return Next;
        }

        public void setNext(Node Next) {
            this.Next = Next;
        }

        public boolean isLetter() {
            return isLetter;
        }

        public void isLetter(boolean isLetter) {
            this.isLetter = isLetter;
        }


    }
// Step 2

    private Node Head;
    private int size;


    public NameList() {
        Head = null;
        size = 0;

    }


    public void display() // this prints out for debugging purposes
    {
        Node temp = Head;
        if (Head == null) {
            System.out.println("it's empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.getName() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }


    public void add(String Name) {
        Name.substring(0, 1);
        String Letter = Name.substring(0, 1);
        Node Letter1 = new Node(Letter, null, true);
        Node Name1 = new Node(Name, null, false);
        Node temp = Head;
        if (Head == null) // if the head/list is empty
        {
            Letter1.setNext(Name1);
            Head = Letter1;
        } else if (Head.getName().toString().toLowerCase().charAt(0) > Letter.toLowerCase().charAt(0)) // if the head is greater than the new letter
        {
            Node temp1 = Head;
            Head = Letter1;
            Letter1.setNext(Name1);
            Name1.setNext(temp1);

        } else if (LetterExisit(Letter)) // Head is not empty, and less than next letter, check to see if it exist
        {
            while (temp != null) // checks if there is anything in the head
            {
                if (temp.isLetter() && temp.getName().toString().equals(Letter)) // compares if there is a letter and/or a name that equals the head of the letter
                {
                    Node temp1 = temp.getNext(); // the node for temp1 set equal to get the next the next new node
                    temp.setNext(Name1); // the temp node is being changed to name1
                    Name1.setNext(temp1); // name1
                }
                temp = temp.getNext();

            }

        } else if (!LetterExisit(Letter)) // If the letter doesn't exist we have to figure out where to put it
        {
            Node Front = Head;
            Node Behind = Head;
            while (Front != null) {

                if (Front.getNext() == null) {
                    Front.setNext(Letter1);
                    Letter1.setNext(Name1);
                    break;
                } else {
                    Front = Front.getNext();
                    if (Front.isLetter()) {
                        if (Front.getName().charAt(0) > Letter.charAt(0) && Behind.getName().charAt(0) < Letter.charAt(0)) {
                            while (Behind.getNext() != Front) {
                                System.out.println("End Behind loop");
                                Behind = Behind.getNext();
                            }
                            Behind.setNext(Letter1);
                            Letter1.setNext(Name1);
                            Name1.setNext(Front);
                            break;

                        }
                    }
                }
            }
        }

    }


    public boolean find(String Name) {
        boolean NameHere = false;
        Node temp = Head;
        if (Head == null) {
            System.out.println("it's empty");
            return NameHere;
        }
        while (temp != null) {

            if (temp.getName().toString().equals(Name)) // checks if it's equal and if its the letter is looking for
            {
                NameHere = true;

            }
            temp = temp.getNext();
        }
        return NameHere;
    }

    public String toString() {
        if (Head == null) {
            System.out.println("Empty list");
        }
        Node temp = Head;
        while (temp != null) {
            if (temp.isLetter() == true) {
                System.out.println(temp.getName());
            } else {
                System.out.println(" " + temp.getName());
            }
            temp = temp.Next;

        }
        return null;
    }

    public void remove(String Name) {
        Node Current = Head; // Node for
        Node Second = Head.Next; //

        if (Head == null) {
            System.out.println("Empty List");
        }
        while (Second != null) {
            if (Second.getName() == Name) {
                Current.Next = Second.Next;
                break;
            } else {
                Current = Second;
                Second = Second.Next;
            }

        }
        Current = Head;
        Second = Head.Next;
        Node temp = null;
        while (Second != null) {
            if (Second.Next == null && Second.isLetter()) {
                Current.Next = null;
                return;
            } else if (Current.isLetter() && Second.isLetter()) {

                if (temp == null) {
                    Head = Second;
                    return;

                } else {
                    temp.Next = Current;
                }

            } else {
                temp = Current;
                Current = Second;
                Second = Current.Next;
            }
        }

    }

    public void removeLetter(char Letter) {
        if (Head == null) {
            System.out.println("This list is empty");
        }

        String Word1 = Character.toString(Letter);
        if (Word1.compareTo(Head.getName())==0) {
            Node SecondValue = Head.Next;
            while (SecondValue != null) {
                if (Letter == SecondValue.getName().charAt(0)) { // starting at 0 because that the 1st letter
                    SecondValue = SecondValue.Next;
                } else {
                    Head = SecondValue;
                    return;
                }

            }
        }
        Node Current = Head;
        Node Second = Head.Next;
        while (Second != null) {
            if (Letter == Second.getName().charAt(0)) {
                Current.Next = Second.Next;
                Second = Second.Next;

            } else{
                Current = Second;
                Second = Second.Next;
            }
        }


    }

    public boolean LetterExisit(String Letter) {
        boolean LetterHere = false;
        Node temp = Head;
        if (Head == null) {
            System.out.println("it's empty");
            return LetterHere;
        }
        while (temp != null) {

            if (temp.isLetter() && temp.getName().toString().equals(Letter)) // checks if it's equal and if its the letter is looking for
            {
                LetterHere = true;

            }
            temp = temp.getNext();
        }
        return LetterHere;
    }

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
