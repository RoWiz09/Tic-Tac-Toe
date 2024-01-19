import java.util.Arrays;
import java.util.Scanner;

public class tick_tack_toe {
    public static String[] StringBoard = new String[9];
    public static void main(String[] args) {
        int[] board = new int[9];
        for (int item = 0; item<9; item++){
            board[item] = 0;
            StringBoard[item] = "_";
        }
        gameLoop();
    }
    
    public static void gameLoop(){
        String visualBoard = "a "+ StringBoard[0] +"|"+ StringBoard[1] +"|"+ StringBoard[2] +" \nb "+ StringBoard[3] +"|"+ StringBoard[4] +"|"+ StringBoard[5] +"\nc "+ StringBoard[6] +"|"+ StringBoard[7] +"|"+ StringBoard[8] +" \n  1 2 3";
        String xo = "x";
        for(int i=0; i<9; i++){
            int pos = getInput(visualBoard, xo);
            StringBoard[pos]=xo;
            visualBoard = "a "+ StringBoard[0] +"|"+ StringBoard[1] +"|"+ StringBoard[2] +" \nb "+ StringBoard[3] +"|"+ StringBoard[4] +"|"+ StringBoard[5] +"\nc "+ StringBoard[6] +"|"+ StringBoard[7] +"|"+ StringBoard[8] +" \n  1 2 3";
            if(xo.equals("x"))
                xo = "o";
            else
                xo = "x";
        }
    }
    public static int getInput(String visualBoard, String xo){
        System.out.println(visualBoard + "\n where do you want to place your " + xo);
        Scanner tinput = new Scanner(System.in);
        String input = tinput.nextLine(); 
        System.out.println(input);
        int pos = 9;
        if(input.equals("a1"))
            pos = 0;
        if(input.equals("a2"))
            pos = 1;
        if(input.equals("a3"))
            pos = 2;
        if(input.equals("b1"))
            pos = 3;
        if(input.equals("b2"))
            pos = 4;
        if(input.equals("b3"))
            pos = 5;
        if(input.equals("c1"))
            pos = 6;
        if(input.equals("c2"))
            pos = 7;
        if(input.equals("c3"))
            pos = 8;
        if(pos == 9)
        {
            System.out.println("please put in an ACTUAL POSITION ON THE BOARD LILLY!" + pos);
            System.exit(1);
        }
        return pos;
    }
}
