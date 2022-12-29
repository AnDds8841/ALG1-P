
package ALG1Sem;

import java.util.Scanner;
public class semestralniPrace {
    static Scanner sc = new Scanner(System.in);
    static int j = 0;
    public static void main(String[] args) {
        System.out.println("Chcete spustit Vanocni ulohu nebo Semestralni prace? (v/s):");
        char t = sc.next().charAt(0);
        // VANOCNI ULOHA
        while(t == 'v'){
        Scanner sc = new Scanner (System.in);
        int h = 1;
        int i, j, s;
        int m  = 3;
        
        String space = " ";
        String star = "*";
        int spaceAmount, starsAmount;
        System.out.println("Udelam pro vas Vanocni dekorace");
        System.out.print("Jak velkou chcete(jenom licha cisla): ");
        int figSize = sc.nextInt();
        while (figSize <= 1 || figSize % 2 == 0){
            System.out.println("Neda se vitvorit takovou dekorace,");
            System.out.print("uvedte jine cislo: ");
            figSize = sc.nextInt();
        }
        int lase = figSize / 2;
        int k = lase - 2;
        
        
        //cyklus pro lano dekorace
        for(i = 0; i < (int)(figSize * 0.3); i++){
            for (j = 0; j < lase; j++){
            System.out.print(space);
            }
            System.out.println(star);  
        }
        
        //cyklus pro prvni cast dekorace
        while (h < figSize){
           for (spaceAmount = 0; spaceAmount <= k; spaceAmount++){
               System.out.print(space);
           } 
           for(starsAmount = 0; starsAmount < m; starsAmount++){
               System.out.print(star);
           }
            System.out.println(space);
            h = h + 2;
            m = m + 2;
            k = k - 1;
            
                    
        }
        m = m - 4;
        k = k + 2;
        while (h != 1){
           for (spaceAmount = 0; spaceAmount <= k; spaceAmount++){
               System.out.print(space);
           } 
           for(starsAmount = 0; starsAmount < m; starsAmount++){
               System.out.print(star);
           }
            System.out.println(space);
            h = h - 2;
            m = m - 2;
            k = k + 1;
            
                    
        }
        System.out.println("Malovat jeste jednou (a/n):");
        t = sc.next().charAt(0);
        if(t == 'n'){
            System.exit(0);
        }
        }
        
        
        
        
        // SEMSETRALNI PRACE
        //VYTVARENI PROMENNYCH
        int size = 2;
        int [] mainAr;
        int [] searchedAr;
        boolean result = false;
        int tempi = 0;
        boolean continuation;
        //
        System.out.println("Pokracovat ve zpracovani (a/n):");
        char c = sc.next().charAt(0);
        // ZACATEK ZPRACOVANI 
        continuation = gettingStarted(c);
        while(continuation == true){
            //NACITANI DVOU POLI
            mainAr = new int [size + 1];
            System.out.println("Zadej posloupnost:");
            mainAr[0] = sc.nextInt();
            for (int q = 1; mainAr[q - 1] >= 0; q++) {
                if(q <= size){
                mainAr[q] = sc.nextInt(); 
                }else{
                    mainAr = addSize(mainAr, size);
                    size = size + 1;
                    q = q - 1;
                }
            }
            size = 2;
            searchedAr = new int [size + 1];
            System.out.println("Hledana sekvence: ");
            searchedAr[0] = sc.nextInt();
            for (int q = 1; searchedAr[q - 1] >= 0; q++) {
                if(q <= size){
                searchedAr[q] = sc.nextInt();
                }else if(q > size){
                   searchedAr = addSize(searchedAr, size);
                   size = size + 1;
                   q = q - 1;
                }    
            }
            
            //NALEZENI SEKVENCE
            for (int q = 0; q < mainAr.length -1; q++) {
                tempi = q;
                for (j = 0; j < searchedAr.length -1; j++) { 
                    if(mainAr[q] == searchedAr[j]){
                        result = true;
                        q++;
                    }else if(result == true && mainAr[q] != searchedAr[j]){
                        result = false;
                        q = q - 1;
                        break;
                    }else{
                        result = false;
                        break;
                    }
                }
                if(j == searchedAr.length - 1 && result == true){
                    tempi++;
                    System.out.println("Sekvence nalezena na pozici " + tempi);
                    System.out.println("");
                    break;
                }   
            }
            if(result == false){
               System.out.println("Sekvence nenalezena ");
               System.out.println(""); 
            }
            //UKONCENI PROGRAMU
            System.out.println("Pokracovat ve zpracovani (a/n):");
            c = sc.next().charAt(0);
            continuation = gettingStarted(c);
        }
    }      
    // METODA PRO NACITANI ODPOVEDI
    public static boolean gettingStarted(char c){
        boolean k = false;
        boolean flag = true;
        do{
            if(c == 'a' || c == 'A'){
                k = true;
                break;
            }else if(c == 'n' || c == 'N'){
                break;
            }else{
              System.out.println("Pokracovat ve zpracovani (a/n):");
              c = sc.next().charAt(0);  
            }
            }while(flag = true);
        
            return k;
    }
    
    public static int[] addSize(int [] a, int size){
        int [] temp = new int [size + 2];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];  
        }
      return temp;
    }
}