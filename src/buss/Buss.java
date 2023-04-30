
package buss;

import java.util.Scanner;

public class Buss {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int val;
        int status = 1;
        //skapar listorna
        long[] plats = new long[21];
        double[] prisA = new double[21];
        String[][] info = new String[21][3];
        
        do {
            System.out.println("välj alternativ; 1 boka plats, 2 avboka plats, 3 räkna ut totala vinten, 4 hitta din plats, 5 visa alla bokningar");
            val = input.nextInt();
            switch (val) {
                // Först hämtas input från användaren namn, efternamn, personnummer,kön. Sen hämtas input om användaren ska ha fönsterplats eller ej. Om fönsterplats väljs har jag först en loop som går igenom fältet och sen ett If statement som kollar om värdet är null och kollar man om talet delat med 4 har en rest på 1 och 0 och om så är fallet bokas platsen. 20 är ett undantag och tas därför bort. 
                case 1:
                    input.nextLine();
                    System.out.println("Skriv in ditt namn:");
                    String namn = input.nextLine();
                    System.out.println("Skriv in ditt efternamn:");
                    String efternamn = input.nextLine();
                    System.out.println("Skriv in ditt kön:");
                    String kön = input.nextLine();
                    System.out.println("Skriv in personnummer:");
                    long persnummer = input.nextLong();
                    System.out.println("Vill du boka en fönsterplats eller inte? (1 = fönsterplats, 2 = inte)");
                    int bokF = input.nextInt();
                    if (bokF == 1) {
                        //pos står för position
                        System.out.println("du vill boka en fönster plats");
                        for (int pos = 0; pos < info.length; pos++) {
                            if (info[pos][0] == null && ((pos+1) % 4 == 1 || (pos+1) % 4 == 0) && (pos+1) != 20) {
                                info[pos][0] = namn;
                                info[pos][1] = efternamn;
                                info[pos][2] = kön;
                                plats[pos] = persnummer;
                                int bokadplats = pos + 1;
                                //om personnummer är mindre än 1963 är man 70 barre och då kostar det 200.00, om personnummer är större än 2005 är man yngre än 18 och ska beta 149.90 och annars är man vuxen och betalar 299.90.
                                double pris = (persnummer < 19530101) ? 200.00 : (persnummer > 20050101 ? 149.90 : 299.90);
                                //priset stoppas sedan i en array. 
                                if (prisA[pos] == 0) {
                                    prisA[pos] = pris;
                                    System.out.println("du bokade platsen: " + bokadplats + " och det kostade:" + pris + "kr" );
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Alla fönsterplatser är upptagna eller så valde du en vanlig plats.");
                        for (int pos2 = 0; pos2 < info.length; pos2++) {
                                info[pos2][0] = namn;
                                info[pos2][1] = efternamn;
                                info[pos2][2] = kön;
                                plats[pos2] = persnummer;
                                int bokadplats2 = pos2 +1;
                                double pris = (persnummer < 19630101) ? 200.00 : (persnummer > 20050101 ? 149.90 : 299.90);
                                if (prisA[pos2] == 0) {
                                    prisA[pos2] = pris;
                                    System.out.println("du bokade platsen: " + bokadplats2 + " och det kostade:" + pris + "kr" );
                                    break;
                                }
                            }
                        }
                    
                    break; 
                case 2:
                    System.out.println("Avboka plats");
                    System.out.println("vad är ditt personnummer");
                    int persavboka = input.nextInt();
                    //har en boolean som är false tills den är hittat och om den inte hittas printas det att bokningen inte finns. Sen har jag en loop som går igenom plats-listan och checkar om den hittar något värde i listan som stämmer med användar input. Sen ändras värderna på platserna i listorna tilbaka till start värdena.
                    boolean hittad = false;
                    for(int i = 0; i < plats.length; i++){
                        if (persavboka == plats[i]){
                            plats[i] = 0;
                            info[i][0] = null;
                            info[i][0] = null;
                            info[i][0] = null;
                            System.out.println("bokningen är nu bortagen");
                            hittad = true;
                            break;
                        }if(!hittad) {
                            System.out.println("din bokning hittades inte");
                        }
                        
                    }
                    
                    break;
                case 3:
                    //en simpel loop som går igenom prisA fältet och plussar ihop värderna mellan varje plats i listan
                    int summa = 0;
                    System.out.println("Räkna ut totala vinten");
                    for (int i = 0; i < prisA.length; i++ ){
                        summa += prisA[i]; 
                    }
                    
                   
                    break;
                    //först tar jag in om man vill checka mot personnummer eller namn
                case 4:
                        String namnplats = "";
                        int persplats = 0;
                        System.out.println("kolla vilken plats du har");
                        System.out.println("skriv in persnummer 1, skriv in namn 2");
                        int val1 = input.nextInt();
                        if(val1 == 1){
                            System.out.println("skriv in personnummer");
                            persplats = input.nextInt();
                            //sen loopar jag igenom listan och checkar värdet mot input
                            for(int i = 0; i < plats.length; i++) {
                                if (plats[i] == persplats) {
                                    System.out.println("din plats: " + (i+1) );
                                    break;
                                } 
                                //om den når slutet av listan printas "du har ingen bokning"
                                if (i == plats.length - 1) {
                                    System.out.println("du har ingen bokning");
                                }
                            }
                        }
                        else if(val1 == 2){
                            input.nextLine();
                            System.out.println("skriv in namn");
                            namnplats = input.nextLine();
                            for (int i = 0; i < info.length; i++) {
                                if (namnplats.equals(info[i][0])){
                                    System.out.println("din plats: " + (i+1) );
                                    break;
                                } 
                                if (i == info.length - 1) {
                                    System.out.println("du har ingen bokning");
                                }
                            }
                          }
                        break;
                        //går igenom listan och skriver ut alla värden för varje plats
                case 5:
                    System.out.println("kolla vilka som har bokat");
                    for (int i = 0;i < info.length; i++) {
                        int platsc = i + 1;
                        if (plats[i] != 0) {
                            System.out.println("namn: " + info[i][0] +" " + info[i][1] + " kön:" + info[i][2] + " personnummer: " + plats[i] + " plats: " + platsc);
                    }
                    }
                    break;
                default:
                    System.out.println("Ogiltigt val");
            }
            val = 0;
            //en while loop som ger användaren ett val efter varje case att avsluta eller fortsätta.
            System.out.println("Vill du fortsätta? Ja/Nej");
            String svar = input.next();
            if (svar.equalsIgnoreCase("ja")) {
                status = 1;
            } else {
                status = 0;
            }
        } while (status == 1);
    }
}
