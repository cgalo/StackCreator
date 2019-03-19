/*Author: CGalo
Date: March 19, 2019
IDE: IntelliJ*/
import java.util.*;

public class StackMenu {

    public static void main ( String [] args ) {

        //Create stack
        Stack newStack = new Stack ();


        int i = 0; //To initialize while-loop

        //Do-while loop until user selects "Quit" on menu
        do {
            //Try to run program if user inputs an integer, catch if user inputs anything else
            try {
                //Create menu
                System.out.println("\n\tMenu");

                //User options
                System.out.println(
                        "1: Add to Stack"               +
                        "\n2: Delete from Stack"        +
                        "\n3: Check top of Stack"       +
                        "\n4: Check bottom of Stack"    +
                        "\n5: Display Stack"            +
                        "\n6: Check if stack is empty"  +
                        "\n7: Empty Stack"              +
                        "\n0: Quit Program"             )   ;

                Scanner scanner = new Scanner(System.in);

                //Ask user for menu answer
                System.out.println("\nEnter # of desire action: ");
                int menuAns = scanner.nextInt();

                switch (menuAns) {

                    //Quit program
                    case 0:
                        System.out.println("You're exiting the program");
                        i = 1;
                        break;

                    //Push to Stack
                    case 1:
                        pushStack(newStack);
                        break;

                    //Pop peek of stack
                    case 2:
                        popStack(newStack);
                        break;

                    //Print top of stack
                    case 3:
                        checkPeekStack(newStack);
                        break;

                    //Display bottom of stack
                    case 4:
                        System.out.println("Currently on the bottom of the stack: " + newStack.lastElement());
                        break;

                    //Display Stack
                    case 5:
                        System.out.println("Your stack is:\n " + newStack);
                        break;

                    //Check if Stack is empty
                    case 6:
                        checkStack(newStack);
                        break;

                    //Empty Stack
                    case 7:
                        emptyStack(newStack);
                        break;

                    //Default swtich in case user inputs a # not available in the above cases
                    default:
                        System.out.println("Error! Option not available, use options from the Menu.");
                }
            }
            //Catch if user inputs anything that is not a #
            catch ( InputMismatchException e ) {
                System.out.println ( "Error! Wrong input, please enter a number." ) ;
            }
        } while ( i != 1 );

    }

    private static void pushStack ( Stack stack ) {
        System.out.println ( "What do you want add to the stack: " );
        Scanner input = new Scanner (System.in);
        String addToStack = input.nextLine();
        stack.push ( addToStack );
        System.out.println( addToStack + " has been added to stack." );
    }

    private static void popStack ( Stack stack ){

        try {
            //Delete top of Stack
            String a = (String) stack.pop();
            System.out.println( a + " was deleted from stack." );

        } catch (EmptyStackException e) {
            System.out.println ( "Error! Stack is empty." );
        }

    }

    private static void checkPeekStack (Stack stack) {

        try {
            System.out.println ( "Current peek of the stack is: " + stack.peek () ) ;
        } catch (EmptyStackException e){
            System.out.println ( "Stack is empty, no peek found." ) ;
        }

    }

    private static void checkStack (Stack stack) {

        if ( stack.empty() )
             System.out.println  ( "Stack is empty"    );
        else System.out.println ( "Stack is not empty" );

    }


    private static void emptyStack ( Stack stack ) {

        System.out.println ( "Emptying stack..." ) ;
        stack.empty();
        System.out.println ( "Done: stack has been emptied" ) ;

    }

}
