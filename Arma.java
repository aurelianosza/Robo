public class Arma{
    private String nome;
    private float hps;
    private int maximaPotencia;
    
    public Arma(String nome, float hps, int maximaPotencia){
        
    }
    
    public void setNome(String nome){
        if(nome != null)
            this.nome = nome;
    }
    public void set(float hps){
        if(hps >= 0.1)
            this.hps = hps;
    }
    public void setMaximaPotencia(int maximaPotencia){
        if(maximaPotencia >=1)
            this.maximaPotencia = maximaPotencia;
    }
    
}