public class Comida{
    private String nome;
    private int quantidadeDeEnergia;
    
    public Comida(){
        super();
    }
    
    static public Comida criarComida(){
        
        
            int energia = 1 + (int)(Math.random() * 10);
            energia *= 6;
            int nome = (int)(Math.random() * 12);
        
            return new Comida(nomeDeComida[nome],energia);
    }
    
    public Comida(String nome, int qunatidadeDeEnergia){
        this.setNome(nome);
        this.setQuantidadeDeEnergia(qunatidadeDeEnergia);
    }
    
    public String exibe(){
        return this.getNome() + " com " + this.getQuantidadeDeEnergia() + " pontos de energia";
    }
    
    public void setNome(String nome){
        if(nome!=null)
            this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setQuantidadeDeEnergia(int quantidadeDeEnergia){
        this.quantidadeDeEnergia = quantidadeDeEnergia;
    }
    public int getQuantidadeDeEnergia(){
        return this.quantidadeDeEnergia;
    }   
}