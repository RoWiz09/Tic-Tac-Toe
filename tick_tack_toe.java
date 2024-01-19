import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.awt.Desktop;
import java.awt.desktop.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class tick_tack_toe {
    public static String[] StringBoard = new String[9];
    public static int[] board = new int[9];
    public static void main(String[] args) {
        for (int item = 0; item<9; item++){
            board[item] = 0;
            StringBoard[item] = "_";
        }
        gameLoop();
    }
    
    public static void gameLoop(){
        String visualBoard = "a "+ StringBoard[0] +"|"+ StringBoard[1] +"|"+ StringBoard[2] +" \nb "+ StringBoard[3] +"|"+ StringBoard[4] +"|"+ StringBoard[5] +"\nc "+ StringBoard[6] +"|"+ StringBoard[7] +"|"+ StringBoard[8] +" \n  1 2 3";
        String xo = "x";
        while (true){
            int pos = getInput(visualBoard, xo);
            StringBoard[pos]=xo;
            visualBoard = "a "+ StringBoard[0] +"|"+ StringBoard[1] +"|"+ StringBoard[2] +" \nb "+ StringBoard[3] +"|"+ StringBoard[4] +"|"+ StringBoard[5] +"\nc "+ StringBoard[6] +"|"+ StringBoard[7] +"|"+ StringBoard[8] +" \n  1 2 3";
            if(xo.equals("x"))
                xo = "o";
            else
                xo = "x";
            if ((board[0] == 1 & board[1] == 1 & board[2] == 1) || (board[3] == 1 & board[4] == 1 & board[5] == 1) || (board[6] == 1 & board[7] == 1 & board[8] == 1) || (board[0] == 1 & board[3] == 1 & board[6] == 1) || (board[1] == 1 & board[4] == 1 & board[7] == 1) || (board[2] == 1 & board[5] == 1 & board[8] == 1) || (board[0] == 1 & board[4] == 1 & board[8] == 1) || (board[2] == 1 & board[4] == 1 & board[6] == 1)){print(visualBoard);winning("x");}
            else if ((board[0] == 2 & board[1] == 2 & board[2] == 2) || (board[3] == 2 & board[4] == 2 & board[5] == 2) || (board[6] == 2 & board[7] == 2 & board[8] == 2) || (board[0] == 2 & board[3] == 2 & board[6] == 2) || (board[1] == 2 & board[4] == 2 & board[7] == 2) || (board[2] == 2 & board[5] == 2 & board[8] == 2) || (board[0] == 2 & board[4] == 2 & board[8] == 2) || (board[2] == 2 & board[4] == 2 & board[6] == 2)){print(visualBoard);winning("o");}
            for(int space = 0; space<9; space++){
                if(board[space] == 0){
                    break;
                }
                else if(space == 8){draw();}
            }
        }
    }
    public static int getInput(String visualBoard, String xo){
        System.out.println(visualBoard + "\n where do you want to place your " + xo);
        Scanner tinput = new Scanner(System.in);
        String input = tinput.nextLine(); 
        int pos = 9;
        if(input.equals("a1")){pos = 0;}
        else if(input.equals("a2")){pos = 1;}
        else if(input.equals("a3")){pos = 2;}
        else if(input.equals("b1")){pos = 3;}
        else if(input.equals("b2")){pos = 4;}
        else if(input.equals("b3")){pos = 5;}
        else if(input.equals("c1")){pos = 6;}
        else if(input.equals("c2")){pos = 7;}
        else if(input.equals("c3")){pos = 8;}
        if(pos == 9){System.out.println("please put in an ACTUAL POSITION on the board, LILLY!");System.exit(1);}
        else if(board[pos] != 0){
        System.out.println("Please play a valid move!");
        pos = getInput(visualBoard, xo);
        }
        int player = 0;
        if(xo.equals("x")){player = 1;}
        else{player = 2;}
        board[pos] = player;
        return pos;
    }
    public static void winning(String team){print(team + " wins!");String url = "https://docs.google.com/document/d/11Nqxg_lOjFnlwF-7qWdbGGRtWyfXfzX5gnkFMG3S_RE/edit?usp=sharing"; Desktop desktop = Desktop.getDesktop(); try{URI uri = new URI(url); desktop.browse(uri);System.exit(1);} catch (IOException excp) {excp.printStackTrace();} catch (URISyntaxException excp) {excp.printStackTrace();} try{TimeUnit.SECONDS.sleep(5);}catch (InterruptedException e) {Thread.currentThread().interrupt();} while (true){String url2 = "https://www.youtube.com/watch?v=AuoH0vz3Mqk"; try{URI uri = new URI(url); desktop.browse(uri);System.exit(1);} catch (IOException excp) {excp.printStackTrace();} catch (URISyntaxException excp) {excp.printStackTrace();} try{TimeUnit.MILLISECONDS.sleep(20);}catch (InterruptedException e) {Thread.currentThread().interrupt();}}}
    public static void draw(){print("Game over! \nYou failed to confirm the kill..."); gameLoop();}
    public static void print(String message){System.out.println(message);}
}
