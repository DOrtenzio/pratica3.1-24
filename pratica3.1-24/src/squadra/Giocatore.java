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

    //Costruttori
    public Giocatore(){
        this.nome=null;
        this.capitano=false;
        setGoal(0);
    }
    public Giocatore(String nome){
        this.nome=nome;
        this.capitano=false;
        setGoal(0);
    }
    public Giocatore(boolean capitano){
        this.nome=null;
        this.capitano=capitano;
        setGoal(0);
    }
    public Giocatore(int goal){
        nome=null;
        capitano=false;
        setGoal(goal);
    }
    public Giocatore(String nome, boolean capitano){
        this.nome=nome;
        this.capitano=capitano;
        setGoal(0);
    }
    public Giocatore(String nome, int goal){
        this.nome=nome;
        capitano=false;
        setGoal(goal);
    }
    public Giocatore(boolean capitano, int goal){
        nome=null;
        this.capitano=capitano;
        setGoal(goal);
    }
    public Giocatore(String nome,boolean capitano, int goal){
        this.nome=nome;
        this.capitano=capitano;
        setGoal(goal);
    }
}
