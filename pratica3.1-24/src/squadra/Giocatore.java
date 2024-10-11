package squadra;

public class Giocatore {
    private String nome;
    private boolean capitano;
    private int goal;

    //Metodi get e set
    public int getGoal() { return goal; }
    public String getNome() { return nome; }
    public boolean isCapitano() { return capitano; }

    public void setCapitano(boolean capitano) { this.capitano = capitano; }
    public void setGoal(int goal) {
        if(goal<0)
            this.goal = 0;
        else
            this.goal=goal;
    }
    public void setNome(String nome) { this.nome = nome; }
}
