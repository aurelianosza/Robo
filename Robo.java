public class Robo {
    private String nome;
    private char sexo;
    private Bateria principal;
    private Bateria reservaInterna = new Bateria("Inerna",20);
    private Localizacao localizacao;
    private int direcao;
    private Comida mochila[] = new Comida[10];
    
    public Robo(){
        super();
    } 
    
    public static Robo criarRobo(Localizacao localizacao){
        Robo r;
        
        int x = (int)(Math.random()*51);
        
        if(x <=1 )
            r = new Robo("Iron giant",'m',Bateria.criarBateria(),localizacao);
        else if( x > 1 && x <= 5 )
            r = new Robo("Sonny", 'f', Bateria.criarBateria(),localizacao);
        else if( x > 5 && x <= 10 )
            r = new Robo("Projeto Zeta", 'm', Bateria.criarBateria(),localizacao);
        else if( x > 10 && x <= 17 )
            r = new Robo("Wall-e", 'm', Bateria.criarBateria(),localizacao);
        else if( x > 15 && x <=28)
            r = new Robo("Baymax", 'm', Bateria.criarBateria(),localizacao);
        else if( x > 28 && x <= 38)
            r = new Robo("Mega-XRL", 'm', Bateria.criarBateria(),localizacao);
        //else if( x > 38 && x <=46)
        //     r = new Android("Iron-man", 'm', Bateria.criarBateria(),localizacao);
        else
             r = new Robo("Numero-18", 'f', Bateria.criarBateria(),localizacao);
        
        
        return r;
    }
    
    public Robo(String nome,char sexo,Bateria bateria, Localizacao localizacao){
        this.setNome(nome);
        this.setSexo(sexo);
        this.setPrincipal(bateria);
        this.setLocalizacao(localizacao);
        this.setDirecao(1);
    }
    
    private void pegarComida(Comida comida){
        
        System.out.println("Voce encontrou comida");
        System.out.println(comida.exibe());
        
        if(this.mochilaCheia()){
            this.comer(comida);
            System.out.println("voce comeu");
        }
        else{
            this.adicionarComida(comida);
        }
        
        if(comida.getQuantidadeDeEnergia() >=0 ){
            do{
                int x = (int)(3 - Math.random() * 4); 
                int y = (int)(3 - Math.random() * 4);
                for(int i = 0; i <= 2; i++){
                    if(Robopolis.getMatriz(this.getLocalizacao().getX() + x,this.getLocalizacao().getY() + y,i) == null){
                        Robopolis.setMatriz(this.getLocalizacao().getX() + x,this.getLocalizacao().getY() + y,i, comida);
                        comida = null;
                        i = 3;
                    }
                }
            }while(comida != null );
        }
    }
    
    private void pegarBateria(Bateria bateria){
        
        System.out.println("Voce encontrou Uma bateria");
        System.out.println(bateria.exibe());
        
        if(bateria.getEnergiaDisponivel() >= this.getPrincipal().getEnergiaDisponivel()){
            Bateria auxiliar = this.getPrincipal();
            this.setPrincipal(bateria);
            bateria = auxiliar;
        }
        
            do{
                int x = (int)(3 - Math.random() * 4); 
                int y = (int)(3 - Math.random() * 4);
                for(int i = 0; i <= 2; i++){
                    if(Robopolis.getMatriz(this.getLocalizacao().getX() + x,this.getLocalizacao().getY() + y,i) == null){
                        Robopolis.setMatriz(this.getLocalizacao().getX() + x,this.getLocalizacao().getY() + y,i, bateria);
                        bateria = null;
                        i = 3;
                    }
                }
            }while(bateria != null );
        
    }
    
    public void andar(){
        
        if((this.getDirecao() == 1 && this.getLocalizacao().getX() == 19) ||
          (this.getDirecao() == 2 && this.getLocalizacao().getY() == 0) ||
          (this.getDirecao() == 3 && this.getLocalizacao().getX() == 0) ||
          (this.getDirecao() == 4 && this.getLocalizacao().getY() == 19)){
            System.out.println("Impossivel andar, está no limite do quadrante...");
            return;
        } 
        
        Bateria bateria;
        
        if( this.getPrincipal().getEnergiaDisponivel() >= 1 )
            bateria = this.getPrincipal();
        else
            bateria = this.getReservaInterna();
        
        if( bateria.equals( this.getReservaInterna() ) ){
            System.out.println("Estou usando somente a bateria reserva");
        }
        else if( bateria.equals( this.getPrincipal() ) && bateria.getEnergiaDisponivel() <= 10 ){
            System.out.println("A bateria esta em nivel baixo");
        }
        
        int x = 0, y = 0, i = -1;
        
        switch(this.getDirecao()){
            case 1:
                x = 1;
                y = 0;
                break;
            case 2:
                x = 0;
                y = -1;
                break;
            case 3:
                x = -1;
                y = 0;
                break;
            case 4:
                x = 0;
                y = 1;
                break;
        }
        
        for(int a = 2; a >= 0; a-- ){
            Object objeto = Robopolis.getMatriz(this.getLocalizacao().getX() + x, this.getLocalizacao().getY() + y, a);
            if(objeto instanceof Comida){
                this.pegarComida((Comida)objeto);
                i = a;
            }
            else if(objeto instanceof Bateria){
                this.pegarBateria((Bateria)objeto);
                i = a;
            }
            else if(objeto == null){
                i = a;
            }
            else if(objeto instanceof Robo){
                
            }
        }
        
        if(i >= 0){
            
            System.out.println("Estou andando...");
            
            Robopolis.setMatriz(this.getLocalizacao().getX(), this.getLocalizacao().getY(), i, null);
            Robopolis.setMatriz(this.getLocalizacao().getX() + x, this.getLocalizacao().getY() + y, i, this);
            bateria.setEnergiaDisponivel(bateria.getEnergiaDisponivel() - 1);
            this.getLocalizacao().setX(this.getLocalizacao().getX() + x);
            this.getLocalizacao().setY(this.getLocalizacao().getY() + y);
            
        }
        
    }
    
    public void girarEsquerda(){
        if(this.getDirecao() == 1)
            this.setDirecao(4);
        else
            this.setDirecao(this.getDirecao() - 1);
    }
    
    public void girarDireita(){
        if(this.getDirecao() == 4)
            this.setDirecao(1);
        else
            this.setDirecao(this.getDirecao() + 1);
    }
        
    public void comer(Comida comida){
        
        Bateria bateria;
        
        if(this.getReservaInterna().getEnergiaDisponivel() < 20)
             bateria = this.getReservaInterna();    
        else
            bateria = this.getPrincipal();
        
        if((bateria.getEnergiaDisponivel())<(bateria.getCapacidade())){
            if(comida!=null){
                if(comida.getQuantidadeDeEnergia() >= 1){
                    if( comida.getQuantidadeDeEnergia() < ( bateria.getCapacidade() - bateria.getEnergiaDisponivel() ) ){
                        this.carregar(bateria, comida.getQuantidadeDeEnergia());
                        comida.setQuantidadeDeEnergia(0);
                    }
                    else{
                        comida.setQuantidadeDeEnergia( comida.getQuantidadeDeEnergia() - (bateria.getCapacidade() -bateria.getEnergiaDisponivel()) );
                        this.carregar(bateria);
                    }
                }
            }
        }
        
         if(bateria.equals(this.getReservaInterna()) && bateria.getEnergiaDisponivel() == 20 && comida.getQuantidadeDeEnergia ()>= 1)
            this.comer(comida); 
    }
    
    public void comer(){      
        Comida comida = this.getComidaMochila();  
        comer(comida);
    }
    
    public void carregar(Bateria bateria){
        bateria.setEnergiaDisponivel(bateria.getCapacidade());
    }
    
    public void carregar(Bateria bateria,int carga){
        if( (bateria.getCapacidade() - bateria.getEnergiaDisponivel()) < carga)
            carregar(bateria);
        else
            bateria.setEnergiaDisponivel(bateria.getEnergiaDisponivel() + carga);
    }
    
    private Comida getComidaMochila(){
        for(int i =0; i<10 ; i++){
            if(this.mochila[i] != null && this.mochila[i].getQuantidadeDeEnergia() >= 1)
                return this.mochila[i];
        }
        return null;
    }
    
    public void adicionarComida(Comida comida){
        if(comida!=null){
            for(int i = 0; i < 10 ; i++ ){
                if(mochila[i]==null){
                    mochila[i]=comida;
                    i=10;
                }       
            }
        }
    }
    
    public boolean mochilaCheia(){
        boolean cheia = true;
        for(int i = 0; i < 10; i++){
            if(this.mochila[i] == null){
                cheia = false;
                i = 10;
            }
        }
        return cheia;
    }
    
    public String exibe(){
        return "Bateria Principal: " + this.getPrincipal().exibe() + " \nBateria Reserva" + this.getReservaInterna().exibe() + " \nLocalizacao: " + this.getLocalizacao().exibe();
    }
    
    public void exibeMochila(){
        for(int i = 0; i < 10; i++){
            if(this.mochila[i] != null){
                System.out.println(this.mochila[i].exibe());
            }
        }
    }
    private void setNome(String nome){
        if(nome!=null)
            this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    private void setSexo(char sexo){
        if(sexo == 'f' || sexo == 'm')
            this.sexo = sexo;
    }
    public char getSexo(){
        return this.sexo;
    }
    public void setPrincipal(Bateria principal){
        this.principal = principal;
    }
    public Bateria getPrincipal(){
        return this.principal;
    }
    public Bateria getReservaInterna(){
        return this.reservaInterna;
    }
    public void setLocalizacao(Localizacao localizacao){
        if(localizacao!=null)
            this.localizacao = localizacao;
    }
    public Localizacao getLocalizacao(){
        return this.localizacao;
    } 
    
    public void setDirecao(int direcao){
        if(direcao>=1 && direcao <=4)
            this.direcao = direcao;
    }
    
    public int getDirecao(){
        return this.direcao;
    }
}