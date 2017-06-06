public class Bateria{
    private String nome;
    private int energiaDisponivel;
    private int capacidade;
    
    public Bateria(){
        super();
    } 
    
    public static Bateria criarBateria(){
        
        int x = 1 + (int)(Math.random()*12);
        x*=15;
        
        Bateria bateria = new Bateria("rayovac",x);
        
        return bateria;
        
    }
    
    public static Bateria criarBateriaEspecial(){
        Bateria bateria = new Bateria("Eletrolitica",220);
        
        
        return bateria;
    }
    
    public Bateria(String nome, int capacidade){
        this.setNome(nome);
        this.setCapacidade(capacidade);
        this.setEnergiaDisponivel(this.getCapacidade());
    }
    
    public String exibe(){
        return "Tem: " + this.getEnergiaDisponivel() + " pontos de energia";
    }
    
    public void setNome(String nome){
        if(nome!=null)
            this.nome = nome;
    }    
    public String getNome(){
        return this.nome;
    }    
    public void setEnergiaDisponivel(int energiaDisponivel){
        if(energiaDisponivel >= 0 && energiaDisponivel <= this.getCapacidade()) 
            this.energiaDisponivel = energiaDisponivel;
    }    
    public int getEnergiaDisponivel(){
        return this.energiaDisponivel;
    }    
    public void setCapacidade(int capacidade){
        if(capacidade >= 1)
            this.capacidade = capacidade;
    }    
    public int getCapacidade(){
        return this.capacidade;
    }          
}