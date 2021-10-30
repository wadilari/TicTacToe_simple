import java.util.Scanner;

public class TicTacToe {
    boolean running;
    String[] feld = new String[9];
    String[] spieler = new String[2];
    Scanner sc= new Scanner(System.in);

    public TicTacToe(){
        spieler[0]="x";
        spieler[1]="o";

        this.reset();
    }

    public static void main(String[] args) {
        TicTacToe spiel = new TicTacToe();
        boolean stop = false;
        while (stop == false){
            if (spiel.run()==false){
                stop = true;
            }
        }
    }

    public boolean run(){
        this.running = true;
        int aktSpieler = 2;
        int winner;
        String a = "ja";
        spielfeld();
        while(running){
            aktSpieler = 3-aktSpieler;
            System.out.printf("Spieler %d ist am Zug \n", aktSpieler);
            int eingabe = sc.nextInt();
            feld[eingabe-1] = spieler[aktSpieler-1];
            spielfeld();
            winner = this.winner();
            if (winner == 3) {
                System.out.println("UNENTSCHIEDEN! Beide schlecht!");
                running = false;
            }
            else if(winner!=0){
                System.out.printf("Spieler %d hat gewonnen. Herzlichen Glückwunsch! \n", winner);
                running = false;
                System.out.println("Wollt ihr eine Revange?");
                String antwort = sc.next();
                if(antwort.equals(a)){
                    this.reset();
                    return true;
                }
                return false;
            }
        }

        return false;
    }

    public void reset(){
        feld[0]="1";
        feld[1]="2";
        feld[2]="3";
        feld[3]="4";
        feld[4]="5";
        feld[5]="6";
        feld[6]="7";
        feld[7]="8";
        feld[8]="9";
    }
    public int winner(){
        String standderdinge = "";
        if (feld[0].equals(feld[1]) && feld[0].equals(feld[2])) standderdinge = feld[0];
        if (feld[0].equals(feld[3]) && feld[0].equals(feld[6])) standderdinge = feld[0];
        if (feld[0].equals(feld[4]) && feld[0].equals(feld[8])) standderdinge = feld[0];

        if (feld[8].equals(feld[5]) && feld[8].equals(feld[2])) standderdinge = feld[8];
        if (feld[8].equals(feld[7]) && feld[8].equals(feld[6])) standderdinge = feld[8];

        if (feld[2].equals(feld[4]) && feld[2].equals(feld[6])) standderdinge = feld[2];

        if (feld[3].equals(feld[4]) && feld[3].equals(feld[5])) standderdinge = feld[3];
        if (feld[1].equals(feld[4]) && feld[1].equals(feld[7])) standderdinge = feld[1];

        boolean found_number = false;
        if (standderdinge == "") {
            for (int i = 0; i < feld.length; i++) {
                if (!feld[i].equals(spieler[0]) && !feld[i].equals(spieler[1])) {
                    found_number = true;
                }
            }
        }

        if(standderdinge.equals(spieler[0])){
            return 1;
        }else if(standderdinge.equals(spieler[1])){
            return 2;
        } else if (!found_number) {
            return 3;
        }
        else{
            return 0;
        }
    }
    public void spielfeld(){
        System.out.println();
        System.out.println("Spielfeld:");
        System.out.println("+---+---+---+");
        int index = 0;
        for(int i = 0 ; i<3 ; i++){
            for(int j = 0 ; j<3 ; j++){
                System.out.print("| "+feld[index]+" ");
                index++;
            }
            System.out.println("|");
            System.out.println("+---+---+---+");
        }
    }
}
