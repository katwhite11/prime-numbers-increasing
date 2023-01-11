/*
author: Kathryn White
purpose: This program finds all prime numbers less than or equal to a given positive integer n (received by user) and prints all results.
*/
import java.util.Scanner;

class SieveOfEratosthenes{
    //instance fields
    final int MAXSIZE = 100;
    boolean p[];
    int n; //userinput
    
    
    //constructor
    SieveOfEratosthenes(){
        p = new boolean[MAXSIZE];
        n = 1; //default so that while loop will complete
    }
    
    //sets user input to n
    public void setP(int nn){
        n = nn;        
    }
    
    //finds all prime nums using array p
    public void sieve(){
        for(int i=0;i<n;i++)
            p[i] = true;
        
        for(int j=2;j*j<=n;j++){
            if(p[j] == true){
                for(int k=j*j; k<=n;k+=j)
                    p[k] = false; //sets to false if it is a multiple of a previous prime number
            }
        }
    }
    
    //prints the prime nums found up to integer n
    public void printP(){
        
        sieve();
        System.out.println("The prime numbers under the integer you input are: ");
        //if true, prints that it is a prime number
        for(int m=2;m<=n;m++){
            if(p[m] == true)
                System.out.print(m+" ");
        }
        System.out.println();
        System.out.println();
    }
}
public class Lab07 {

    public static void main(String[] args) {
        
        //TEST
        //instance fields
        String userInput;
        Scanner in = new Scanner(System.in);
        Scanner out = new Scanner(System.in);
        
        SieveOfEratosthenes test = new SieveOfEratosthenes();
        
        //do while loop to print menu and receive input on actions from user
        do{
            System.out.println("Please select from the following menu:");
            System.out.println("S: Set your max positive integer");
            System.out.println("P: Find and print all prime numbers");
            System.out.println("Q: Quit");
            System.out.println();
            System.out.println("Select: ");
            
            //receives user input
            userInput = in.nextLine();
            userInput = userInput.toLowerCase();
            
            //checks first letter from userinput
            switch(userInput.charAt(0)){
                case 's':
                    System.out.println("What would you like to set your boundary integer as?");
                    
                    //receives user input
                    int nn = out.nextInt();
                    if(nn>=100){
                        System.out.println("Number out of bounds. Please choose a number below 100.");
                        System.out.println();
                        break;
                    }
                    test.setP(nn); //sets boundary to user input
                    System.out.println("Integer boundary has been set.");
                    break;
                case 'p':
                    test.printP();
                    break;
                case 'q':
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid response.");
                    System.out.println();
            }
        //while loop checks if user has input 'q' to quit program, will continue to run until q is entered
        }while(userInput.charAt(0)!= 'q');
    }   
}
