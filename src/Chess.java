import java.util.Scanner;

public class Chess
{
    /*******
     *
     * @version: 2022
     * @author Roni Chen
     * The software receives from the user two different types of tools and their locations on the chessboard
     * By requesting from user the y coordinate and x coordinate of each tool and prints if one tool threatens the other tool
     * if the user input digit less than zero or greater than 8 or two tools of the same type or the same position as both tools
     * The program will print an error committee and end
     ************/
    public static void main (String [] args)
    {
        final char BISHOP = 'b', ROOK='r',KNIGHT='k';
        int tempRow, tempCol; //To calculate the steps of the knight
        final int MAX=8, MIN=1, //To check the boundaries of the chessboard
                TWO_STEP=2, ONE_STEP=1; //Steps on the board
        Scanner scan = new Scanner (System.in);
        //Receive user input
        System.out.println("Please enter the type"+ " of the first chessman");
        char first = scan.next().charAt(0);
        System.out.println ("Please enter the number of row");
        int row1 = scan.nextInt();
        System.out.println ("Please enter the number of column");
        int col1 = scan.nextInt();
        System.out.println("Please enter the type"+ " of the second chessman");
        char second = scan.next().charAt(0);
        System.out.println ("Please enter the number of row");
        int row2 = scan.nextInt();
        System.out.println ("Please enter the number of column");
        int col2 = scan.nextInt();
        //if the two tools of the same type
        if (first == second) {
            System.out.println("Chessmen should be different from each other ");
            return;
        }
        //print an error
        //* if the user input digit less than zero or greater than 8
        if(row1< MIN || row1 >MAX || row2<MIN ||row2 >MAX || col1 <MIN || col1> MAX || col2 < MIN || col2 >MAX) {
            System.out.println ("Position is not legal");
        return;
        }
        //if the same position as both tools
        if(row1 == row2 && col1==col2 ) {
            System.out.println ("Chessmen positions should not be identical");
            return;
        }
        //If one of the tools is a rook, and it threatens the other vessel
       if ( first==ROOK || second==ROOK ) {
           if (row1 == row2 || col1==col2) {
               //See who's the vessel that's threatened by a rook.
            if (first==KNIGHT || second==KNIGHT )
                System.out.println("Rook threats knight");
            else  System.out.println("Rook threats bishop");
               return;
           }
           //If one of the tools is a bishop, and it threatens the other vessel
       }if (first==BISHOP || second==BISHOP ) {
        //The bishop only threatens if the relationship between the rows and the columns is one-on-one
                 tempRow=Math.abs(row1-row2);
                 tempCol= Math.abs(col1 -col2);
                    if(tempCol==tempRow) {
                        //See who's the vessel that's threatened by a bishop.
                        if (first == KNIGHT || second == KNIGHT)
                            System.out.println("Bishop threats knight");
                        else
                            System.out.println("Bishop threats rook");
                        return;
                    }
                }
       //So that the location of the knight will always be in the first variable
            if(second==KNIGHT) {
                tempCol=col1;
                tempRow= row1;
                col1=col2;
                row1=row2;
                col2=tempCol;
                row2=tempRow;
            }
        //If one of the tools is a knight, and it threatens the other vessel
        if (first==KNIGHT || second==KNIGHT ) {
                if(((row1-TWO_STEP ==col2 ||row1+TWO_STEP ==col2) &&( col1-ONE_STEP==row2 || col1+ONE_STEP==row2))
                || ((row1-ONE_STEP ==col2 ||row1+ONE_STEP ==col2) &&( col1-TWO_STEP==row2 || col1+TWO_STEP==row2))){
                    //See who's the vessel that's threatened by a knight.
                    if (first == BISHOP || second == BISHOP)
                    System.out.println("Knight  threats bishop");
                else
                    System.out.println("Knight threats rook");
                return;
            }
        }
        //If there are no threats
         System.out.println("Not threat");

    } // end of method main
} //end of class Chess
