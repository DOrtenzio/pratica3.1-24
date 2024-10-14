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
                        if (indexInseriti == 0 || Funzioni.controllaCapitani(squadra, indexInseriti) == -1) {
                            System.out.println("E' capitano? true/false");
                            isCapitano = in.nextBoolean();
                        }

                        //Inserimento
                        indexInseriti = Funzioni.aggGioc(squadra, indexInseriti, gioc, gol, isCapitano);
                    }
                    break;
                case 1:
                    if(indexInseriti==0)
                        System.out.println("Nessun componente ancora inserito");
                    else{
                        System.out.println(Funzioni.stampa(squadra,indexInseriti));
                    }
                    break;
                case 2:
                    if(indexInseriti==0)
                        System.out.println("Nessun componente ancora inserito");
                    else{
                        int gol;
                        String gioc;
                        boolean isCapitano;

                        System.out.println("Stai modificando un giocatore: \n Inserisci il suo nome:");
                        gioc= in.next();
                        do {
                            System.out.println("Inserire il numero di goal: ");
                            gol=Integer.parseInt(in.next());
                            if (gol<0)
                                System.out.println("Inserire numero corretto di gol");
                        }while (gol<0);
                        System.out.println("E' capitano? true/false");
                        isCapitano=in.nextBoolean();
                        int i=Funzioni.ricercaGioc(squadra,indexInseriti,gioc,gol,isCapitano);
                        if (i==-1)
                            System.out.println("Giocatore inesistente");
                        else{
                            int gol1;
                            String gioc1;
                            boolean isCapitano1=false;

                            System.out.println("Inserisci il suo nuovo nome:");
                            gioc1= in.next();
                            do {
                                System.out.println("Inserire il suo nuovo numero di goal: ");
                                gol1=Integer.parseInt(in.next());
                                if (gol1<0)
                                    System.out.println("Inserire il suo nuovo numero corretto di gol");
                            }while (gol1<0);
                            if (Funzioni.controllaCapitani(squadra,indexInseriti)==-1) {
                                System.out.println("E' capitano? true/false");
                                isCapitano1=in.nextBoolean();
                            }
                            Funzioni.modificaGioc(squadra,i,gioc1,gol1,isCapitano1);
                        }
                    }
                    break;
                case 3:
                    if(indexInseriti==0)
                        System.out.println("Nessun componente ancora inserito");
                    else{
                        int gol;
                        String gioc;
                        boolean isCapitano;

                        System.out.println("Stai cancellando un giocatore: \n Inserisci il suo nome:");
                        gioc= in.next();
                        do {
                            System.out.println("Inserire il numero di goal: ");
                            gol=Integer.parseInt(in.next());
                            if (gol<0)
                                System.out.println("Inserire numero corretto di gol");
                        }while (gol<0);
                        System.out.println("E' capitano? true/false");
                        isCapitano=in.nextBoolean();
                        int i=Funzioni.ricercaGioc(squadra,indexInseriti,gioc,gol,isCapitano);
                        if (i==-1)
                            System.out.println("Giocatore inesistente");
                        else{
                            indexInseriti=Funzioni.cancellaGioc(squadra,i,indexInseriti);
                        }
                    }
                    break;
                case 4:
                    if(indexInseriti==0)
                        System.out.println("Nessun componente ancora inserito");
                    else{
                        System.out.println(Funzioni.stampa5Gol(squadra,indexInseriti));
                    }
                    break;
                case 5:
                    if(indexInseriti==0)
                        System.out.println("Nessun componente ancora inserito");
                    else{
                        int i=Funzioni.controllaCapitani(squadra,indexInseriti);
                        if (i==-1)
                            System.out.println("Non ci sono capitani");
                        else
                            System.out.println("Nome: "+squadra[i].getNome()+"\t Capitano:"+squadra[i].isCapitano()+"\t Gol:"+squadra[i].getGoal());
                    }
                    break;
                case 6:
                    if(indexInseriti==0)
                        System.out.println("Nessun componente ancora inserito");
                    else{
                        int i=Funzioni.capitaniRandom(squadra,indexInseriti);
                        if (i!=-1){
                            System.out.println("C'è gia un capitano");
                        }
                        System.out.println("Capitano:");
                        System.out.println("Nome: "+squadra[Funzioni.controllaCapitani(squadra,indexInseriti)].getNome()+"\t Capitano:"+squadra[Funzioni.controllaCapitani(squadra,indexInseriti)].isCapitano()+"\t Gol:"+squadra[Funzioni.controllaCapitani(squadra,indexInseriti)].getGoal());
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
}
