
package buss;

import java.util.Scanner;

public class Buss {
    // Johan va här
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int val;
        
        int status = 1;
   
        //while(status == 1)
        
            System.out.println("vill du fortsätta? ja/nej");
        
             int[][] plats = new int[21][21] ;
                plats[0][0]=20020203;
                plats[0][1]=20121213;
                
                
         
        for (int rad = 0; rad < 21; rad++) {
            for (int kolumn = 0; kolumn < 21; kolumn++) {
                plats[rad][kolumn]=rad+kolumn;
                if (plats[rad][kolumn] == 0) {
                    plats[rad][kolumn] = persnummer;
                    break;
                    
                }
                        
                    
            }
        }
       
        
        System.out.println("välj alternativ; 1 boka plats, 2 avboka plats, 3 räkna ut totala vinten");
        val = input.nextInt();
        switch(val){
            case 1:
                System.out.println("skriv in personnummer");
                int persnummer = input.nextInt();
                System.out.println("ditt personnummer " + persnummer);
                
                if (Integer.p > 8){
                    System.out.println("pröva igen");
                    
                   
                
                /* for(int i=0;i < plats.length;  i++){
                 System.out.println(plats[i]);
                    if(plats[i] == 0) {
                        plats[i] = persnummer;
                        System.out.println(i);
                        break;
                    }
                }
*/
            case 2:
                System.out.println("see alla bokningar och priser");
                
            
            
        }
    }}
                
        
         
        
    

