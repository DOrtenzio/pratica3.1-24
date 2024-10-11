package squadra;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Giocatore[] squadra = new Giocatore[22];
        int scelta, indexInseriti = 0;

        do {
            System.out.println("Scegli una fra le sceguenti opzioni: " +
                    "\n 0) aggiungere un giocatore alla squadra;" +
                    "\n 1) visualizzare tutti i giocatori della squadra;" +
                    "\n 2) modificare i dati di un giocatore a scelta;" +
                    "\n 3) cancellare un giocatore dalla squadra;" +
                    "\n 4) visualizzare i giocatori che hanno realizzato più di 5 goal;" +
                    "\n 5) visualizzare il nome del capitano;" +
                    "\n 6) assegnare il ruolo di capitano in modo casuale se non ancora presente;" +
                    "\n 7) esci");
            scelta = Integer.parseInt(in.next());
            switch (scelta) {
                case 0:
                    if (indexInseriti == squadra.length)
                        System.out.println("Impossibile squadra al completo");
                    else {
                        int gol;
                        String gioc;
                        boolean isCapitano = false;

                        //Inserimento valori
                        System.out.println("Stai inserendo un nuovo giocatore: \n Inserisci il suo nome:");
                        gioc = in.next();
                        do {
                            System.out.println("Inserire il numero di goal: ");
                            gol = Integer.parseInt(in.next());
                            if (gol < 0)
                                System.out.println("Inserire numero corretto di gol");
                        } while (gol < 0);
                        if (indexInseriti == 0 || controllaCapitani(squadra, indexInseriti) == -1) {
                            System.out.println("E' capitano? true/false");
                            isCapitano = in.nextBoolean();
                        }

                        //Inserimento
                        indexInseriti = aggGioc(squadra, indexInseriti, gioc, gol, isCapitano);
                    }
                    break;
                    case 1:
                    if(indexInseriti==0)
                        System.out.println("Nessun componente ancora inserito");
                    else{
                        System.out.println(stampa(squadra,indexInseriti));
                    }
                    break;

                case 7:
                    System.out.println("Ciao");
                    break;
                default:
                    System.out.println("Selezionare solo un'opzione tra quelle proposte.");
            }
        } while (scelta != 7);
    }

    public static int aggGioc(Giocatore[] squadra, int indexInseriti, String nome, int gol, boolean capitano) {
        squadra[indexInseriti] = new Giocatore(nome, capitano, gol);
        return indexInseriti + 1;
    }

    public static int controllaCapitani(Giocatore[] squadra, int indexInseriti) {
        for (int i = 0; i < indexInseriti; i++) {
            if (squadra[i].isCapitano())
                return i;
        }
        return -1;
    }
}
