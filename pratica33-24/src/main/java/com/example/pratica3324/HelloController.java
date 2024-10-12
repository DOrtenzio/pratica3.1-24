package com.example.pratica3324;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class HelloController {
    private static Giocatore[] squadra = new Giocatore[22];
    private static int indexInseriti = 0;
    private int i=0; //Temp

    @FXML
    private Label labelIn;
    @FXML
    private VBox insertBox;



    @FXML
    public void inserisciGioc() {
        if (indexInseriti == squadra.length)
            labelIn.setText("Impossibile inserire un nuovo giocatore: squadra al completo");
        else {
            boolean isCapitano;
            labelIn.setText("Aggiunta:");

            insertBox.getChildren().clear();
            //Label e textField
            Label l1=new Label("Inserire nome giocatore:");
            TextField t1=new TextField();
            Label l2=new Label("Inserire gol giocatore:");
            TextField t2=new TextField();

            //Li metto nella schermata
            insertBox.getChildren().add(l1);
            insertBox.getChildren().add(t1);
            insertBox.getChildren().add(l2);
            insertBox.getChildren().add(t2);

            //Inserimento valori
            if (indexInseriti == 0 || Function.controllaCapitani(squadra, indexInseriti) == -1) {
                Label l3=new Label("E' capitano?");
                insertBox.getChildren().add(l3);
                CheckBox c1=new CheckBox("<--");
                insertBox.getChildren().add(c1);
                isCapitano=c1.isSelected();
            } else {
                isCapitano = false;
            }
            //Bottone finale
            Button b1=new Button("Invia");
            insertBox.getChildren().add(b1);
            b1.setOnMouseClicked( e -> { //All'azione
                indexInseriti = Function.aggGioc(squadra, indexInseriti, t1.getText(), Integer.parseInt(t2.getText()), isCapitano);
                insertBox.getChildren().clear();
                labelIn.setText("Inserito");
            });
        }
    }
    @FXML
    public void vediGioc() {
        if (indexInseriti == 0)
            labelIn.setText("Impossibile nessun giocatore");
        else {
            insertBox.getChildren().clear();
            labelIn.setText("Visione tutti giocatori:");
            Label l1=new Label(Function.stampa(squadra,indexInseriti));
            insertBox.getChildren().add(l1);
        }
    }
    @FXML
    public void modificaGioc() {
        if (indexInseriti == 0)
            labelIn.setText("Impossibile nessun giocatore inserito");
        else {
            //Ricerca giocatore
                boolean isCapitano;
                i=0;
                labelIn.setText("Modifica:");

                insertBox.getChildren().clear();
                //Label e textField
                Label l1=new Label("Inserire nome giocatore:");
                TextField t1=new TextField();
                Label l2=new Label("Inserire gol giocatore:");
                TextField t2=new TextField();

                //Li metto nella schermata
                insertBox.getChildren().add(l1);
                insertBox.getChildren().add(t1);
                insertBox.getChildren().add(l2);
                insertBox.getChildren().add(t2);

                //Inserimento valori
                if (indexInseriti == 0 || Function.controllaCapitani(squadra, indexInseriti) == -1) {
                    Label l3=new Label("E' capitano?");
                    insertBox.getChildren().add(l3);
                    CheckBox c1=new CheckBox("<--");
                    insertBox.getChildren().add(c1);
                    isCapitano=c1.isSelected();
                } else {
                    isCapitano = false;
                }
                //Bottone finale
                Button b1=new Button("Ricerca");
                insertBox.getChildren().add(b1);
                b1.setOnMouseClicked( e -> { //All'azione
                     i= Function.ricercaGioc(squadra, indexInseriti, t1.getText(), Integer.parseInt(t2.getText()), isCapitano);
                });
                if (i==-1)
                    labelIn.setText("Giocatore inesistente");
                else {
                    boolean isCapitano2;
                    labelIn.setText("Modifica:");

                    insertBox.getChildren().clear();
                    //Label e textField
                    Label l11=new Label("Inserire nuovo nome giocatore:");
                    TextField t11=new TextField();
                    Label l21=new Label("Inserire nuovo numero di gol giocatore:");
                    TextField t21=new TextField();

                    //Li metto nella schermata
                    insertBox.getChildren().add(l11);
                    insertBox.getChildren().add(t11);
                    insertBox.getChildren().add(l21);
                    insertBox.getChildren().add(t21);

                    //Inserimento valori
                    if (Function.controllaCapitani(squadra, indexInseriti) == -1) {
                        Label l3=new Label("E' capitano?");
                        insertBox.getChildren().add(l3);
                        CheckBox c1=new CheckBox("<--");
                        insertBox.getChildren().add(c1);
                        isCapitano2=c1.isSelected();
                    } else {
                        isCapitano2 = false;
                    }
                    //Bottone finale
                    Button b2=new Button("Modifica");
                    insertBox.getChildren().add(b2);
                    b1.setOnMouseClicked( e -> { //All'azione
                        Function.modificaGioc(squadra, indexInseriti, t1.getText(), Integer.parseInt(t2.getText()), isCapitano2);
                        insertBox.getChildren().clear();
                    });
                }
        }
    }
    @FXML
    public void cancellaGiocatore() {
        if (indexInseriti == 0)
            labelIn.setText("Impossibile nessun giocatore inserito");
        else {
            //Ricerca giocatore
            boolean isCapitano;
            i=0;
            labelIn.setText("Cancellazione:");

            insertBox.getChildren().clear();
            //Label e textField
            Label l1=new Label("Inserire nome giocatore:");
            TextField t1=new TextField();
            Label l2=new Label("Inserire gol giocatore:");
            TextField t2=new TextField();

            //Li metto nella schermata
            insertBox.getChildren().add(l1);
            insertBox.getChildren().add(t1);
            insertBox.getChildren().add(l2);
            insertBox.getChildren().add(t2);

            //Inserimento valori
            if (indexInseriti == 0 || Function.controllaCapitani(squadra, indexInseriti) == -1) {
                Label l3=new Label("E' capitano?");
                insertBox.getChildren().add(l3);
                CheckBox c1=new CheckBox("<--");
                insertBox.getChildren().add(c1);
                isCapitano=c1.isSelected();
            } else {
                isCapitano = false;
            }
            //Bottone finale
            Button b1=new Button("Ricerca");
            insertBox.getChildren().add(b1);
            b1.setOnMouseClicked( e -> { //All'azione
                i= Function.ricercaGioc(squadra, indexInseriti, t1.getText(), Integer.parseInt(t2.getText()), isCapitano);
            });
            if (i==-1)
                labelIn.setText("Giocatore inesistente");
            else {
                labelIn.setText("Cancellazione:");
                Function.cancellaGioc(squadra, indexInseriti, i);

                insertBox.getChildren().clear();
                //Label e textField
                Label l11=new Label("Cancellato");

                //Li metto nella schermata
                insertBox.getChildren().add(l11);
            }
        }
    }
    @FXML
    public void vediGioc5Gol() {
        if (indexInseriti == 0)
            labelIn.setText("Impossibile nessun giocatore");
        else {
            insertBox.getChildren().clear();
            labelIn.setText("Visione tutti giocatori:");
            Label l1=new Label(Function.stampa5Gol(squadra,indexInseriti));
            insertBox.getChildren().add(l1);
        }
    }
    @FXML
    public void vediCapitano() {
        if (indexInseriti == 0)
            labelIn.setText("Impossibile nessun giocatore");
        else {
            insertBox.getChildren().clear();
            Label l1=new Label();
            insertBox.getChildren().add(l1);
            i=Function.controllaCapitani(squadra,indexInseriti);
            if (i==-1)
                l1.setText("Non ci sono capitani");
            else
                l1.setText("Nome: "+squadra[i].getNome()+"\t Capitano:"+squadra[i].isCapitano()+"\t Gol:"+squadra[i].getGoal());
        }
    }
    @FXML
    public void capitanoCasuale() {
        if (indexInseriti == 0)
            labelIn.setText("Impossibile nessun giocatore");
        else {
            insertBox.getChildren().clear();
            Label l1=new Label();
            insertBox.getChildren().add(l1);
            Label l2=new Label();
            insertBox.getChildren().add(l2);
            i=Function.capitaniRandom(squadra,indexInseriti);
            if (i!=-1)
                l1.setText("Ci sono già capitani");
            else
                l1.setText("Capitano nuovo:");
            l2.setText("Nome: "+squadra[Function.controllaCapitani(squadra, indexInseriti)].getNome()+"\t Capitano:"+squadra[Function.controllaCapitani(squadra, indexInseriti)].isCapitano()+"\t Gol:"+squadra[Function.controllaCapitani(squadra, indexInseriti)].getGoal());
        }
    }
}