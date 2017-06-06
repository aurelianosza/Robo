/*public class Android extends Robo{
    
    public Android(String nome,char sexo,Bateria bateria, Localizacao localizacao){
        super(nome,sexo,bateria,localizacao);
    }
    
    @Override
        public void andar(){
        
        Bateria bateria = null;
        int direcao = this.getDirecao();
        Localizacao localizacao = this.getLocalizacao();
       
        if(this.getPrincipal().getEnergiaDisponivel() >= 1)
            bateria = this.getPrincipal();
        else
            bateria = this.getReservaInterna();
            
            if(bateria.getEnergiaDisponivel() < 1){
                System.out.println("Estou sem bateria");
                return;
            }
            if(this.getDirecao() == 1){
                if(localizacao.getX() == 180){
                    System.out.println("impossível andar, está no limite do quadrante");
                    return; 
                }
                else{
                    for(int i = 0;i <= 2; i++){
                        //VERIFICA SE TEM COMIDA PARA ONDE ELE VAI ANDAR
                        if(Robopolis.getMatriz((int)(this.getLocalizacao().getX() / 10 ) + 2,(int)(this.getLocalizacao().getY() / 10), i) instanceof Comida){
                            //CASO TENHA, ADICIONAA COMIDA NA MOCHILA
                            Object c = Robopolis.getMatriz((int)(this.getLocalizacao().getX() / 10 ) + 2,(int)this.getLocalizacao().getY() / 10, i);
                            
                            this.addComida((Comida)c);
                            
                            //O ROBO ASSUME A POSICAO DA COMIDA
                            Robopolis.setMatriz((int)(this.getLocalizacao().getX() / 10 ) + 2,(int)this.getLocalizacao().getY() / 10, i,this);
                            
                            this.getLocalizacao().setX(this.getLocalizacao().getX() + 20);

                        }   
                    }                        
                }
            }
            if(this.getDirecao() == 2){
                if(localizacao.getY() == 0){
                    System.out.println("impossível andar, está no limite do quadrante");
                    return;
                }else{
                    for(int i = 0;i <= 2; i++){
                        //VERIFICA SE TEM COMIDA PARA ONDE ELE VAI ANDAR
                        if(Robopolis.getMatriz((int)(this.getLocalizacao().getX() / 10 ),(int)((this.getLocalizacao().getY() / 10) - 2) , i) instanceof Comida){
                            //CASO TENHA, ADICIONAA COMIDA NA MOCHILA
                            Object c = Robopolis.getMatriz((int)(this.getLocalizacao().getX() / 10 ),(int)((this.getLocalizacao().getY() / 10) - 2), i);
                            
                            this.addComida((Comida)c);
                            
                            //O ROBO ASSUME A POSICAO DA COMIDA
                            Robopolis.setMatriz((int)(this.getLocalizacao().getX() / 10 ),(int)((this.getLocalizacao().getY() / 10)-2), i,this);
                            this.getLocalizacao().setY(this.getLocalizacao().getY() -20);

                        }
                    }                        
                }
            }
            else if(this.getDirecao() == 3){
                if(localizacao.getX() == 0){
                    System.out.println("impossível andar, está no limite do quadrante");
                    return;
                }else{
                    for(int i = 0;i <= 2; i++){
                        //VERIFICA SE TEM COMIDA PARA ONDE ELE VAI ANDAR
                        if(Robopolis.getMatriz((int)(this.getLocalizacao().getX() / 10 ) - 2,(int)(this.getLocalizacao().getY() / 10), i) instanceof Comida){
                            //CASO TENHA, ADICIONAA COMIDA NA MOCHILA
                            Object c = Robopolis.getMatriz((int)(this.getLocalizacao().getX() / 10 ) - 2,(int)this.getLocalizacao().getY() / 10, i);
                            
                            this.addComida((Comida)c);
                            
                            //O ROBO ASSUME A POSICAO DA COMIDA
                            Robopolis.setMatriz((int)(this.getLocalizacao().getX() / 10 ) - 2,(int)this.getLocalizacao().getY() / 10, i,this);
                            
                            this.getLocalizacao().setX(this.getLocalizacao().getX() + 20);

                        }   
                    }                        
                }
            }
            else if(this.getDirecao() == 4){
                if(localizacao.getY() == 180){
                    System.out.println("impossível andar, está no limite do quadrante");
                    return;
                }
                else{
                    for(int i = 0;i <= 2; i++){
                        //VERIFICA SE TEM COMIDA PARA ONDE ELE VAI ANDAR
                        if(Robopolis.getMatriz((int)(this.getLocalizacao().getX() / 10 ),(int)((this.getLocalizacao().getY() / 10) + 2) , i) instanceof Comida){
                            //CASO TENHA, ADICIONAA COMIDA NA MOCHILA
                            Object c = Robopolis.getMatriz((int)(this.getLocalizacao().getX() / 10 ),(int)((this.getLocalizacao().getY() / 10) + 2), i);
                            
                            this.addComida((Comida)c);
                            
                            //O ROBO ASSUME A POSICAO DA COMIDA
                            Robopolis.setMatriz((int)(this.getLocalizacao().getX() / 10 ),(int)((this.getLocalizacao().getY() / 10) + 2), i,this);
                            this.getLocalizacao().setY(this.getLocalizacao().getY() + 20);

                        }   
                    }                        
                }
            }

        if(bateria!=null)
            bateria.setEnergiaDisponivel(bateria.getEnergiaDisponivel() - 3);         
    }
}
*/