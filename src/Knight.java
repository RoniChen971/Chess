
import java.util.Scanner;

 /*******
  *
  * @version: 2022
  * @author Roni Chen
  *The software receives from the user the location of the Knight on the chessboard, By requesting from user
  * the y coordinate and x coordinate and prints all the legal steps the Knight can take on board
  * if the user input digit less than zero or greater than 8 The program will print an error committee and end
  *
  ********/
public class Knight {

    public static void main (String [] args)
    {
        final int ZERO=0, MAX=8, //To check the boundaries of the chessboard
                TWO_STEP=2, ONE_STEP=1; //Steps on the board
        //variables to check if the step is allowed and there is no deviation from the clipboard
        boolean rowBack=false, rowForward=false, colBack=false, colForward=false;
        Scanner scan = new Scanner (System.in);
        System.out.println ("This program reads two integers which " + "represent the knight's location on the chess board: ");
        System.out.println ("Please enter the number of row");
        int row = scan.nextInt();//The row on which the Knight stands
        System.out.println ("Please enter the number of column");
        int col = scan.nextInt(); //the column on which the Knight stands
        //Check that the user hasn't input digits less than zero or greater than 8
        if(row<=ZERO || row>MAX || col <=ZERO || col>MAX) {
            System.out.println("illegal is input "); //print an error
            return;
        }

        System.out.println ("Moves: ");//prints all the legal steps the Knight can take on board
        // Check that the steps don't go beyond the board
        if (row-TWO_STEP > ZERO )
            rowBack=  true;
        if ( row +TWO_STEP<= MAX)
            rowForward = true;
        if(col+ONE_STEP <= MAX)
            colForward= true;
        if (col-ONE_STEP > ZERO)
            colBack = true;
        // Prints two columns back a row above the Knight and a row below the Knight
     if(rowBack) {
         if (colBack) //below the Knight
             System.out.println( (row-TWO_STEP) + "  " + (col - ONE_STEP) );
         if (colForward)// above the Knight
             System.out.println((row-TWO_STEP) + "  " + (col + ONE_STEP));
     }
        // Prints two columns forward a row above the Knight and a row below the Knight
        if (rowForward){
         if (colBack)// below the Knight
             System.out.println( (row+ TWO_STEP) + "  " + (col - ONE_STEP) );
        if (colForward)// above the Knight
            System.out.println((row+ TWO_STEP) + "  " + (col + ONE_STEP));
            }
        //Check that two rows up and down don't overstep the board
     colBack=false;
        colForward=false;
        if(row -ONE_STEP >ZERO)
            rowBack=true;
        if(row+ONE_STEP <=MAX )
            rowForward = true;
         if(col<(MAX-ONE_STEP))
             colForward= true;
         if (col > TWO_STEP)
             colBack =true;
        // Prints two row below a columns forward the Knight and a columns behind the Knight
        if(colForward) {
            if (rowBack)
                System.out.println((row-ONE_STEP) + "  " + (col +TWO_STEP) );
            if (rowForward)
                System.out.println( (row +ONE_STEP) + "  " + (col + TWO_STEP) );
        }
        // Prints two row above a columns forward the Knight and a columns behind the Knight
        if (colBack){
            if (rowBack)
                System.out.println( (row-ONE_STEP) + "  " + (col - TWO_STEP) );
            if (rowForward)
                System.out.println(( row+ ONE_STEP) + "  " + (col - TWO_STEP));
        }
    } // end of method main
} //end of class Knight
