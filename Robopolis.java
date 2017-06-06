public class Robopolis{
    static private Object matriz[][][] = new Object[20][20][3]; 
    
    public Robopolis(){
    
    }
    public static void setMatriz(int i, int j, int k, Object objeto){
        if(objeto!=null){
            if(i >= 1 && i <= 19 && j >= 0 && j <= 19 && k >= 0 && k <= 2){
                matriz[i][j][k] = objeto;
            }
        }
    }
    public static Object getMatriz(int i, int j, int k){
        if(i >= 0 && i <= 19 && j >= 0 && j <= 19 && k >= 0 && k <= 2){
            return matriz[i][j][k];
        }
        else
            return null;
    }
    
    
    public static void criarCidade(){
        for(int i = 0; i <= 19; i++){
            for(int j = 0; j <= 19; j++){
                for(int k = 0; k <= 2; k++){
                    
                    if(i == 0 && j==0 && k == 0)
                        break;
                    
                    int selecao = (int)(Math.random()*10);
                    
                    Comida c;
                    
                    switch(selecao){
                        case 1:
                            c = Comida.criarComida();
                            
                            setMatriz(i,j,k,c);
                            
                            break;
                            
                        case 3:
                            c = Comida.criarComida();
                            
                            setMatriz(i,j,k,c);
                            
                            break;                            
                            
                        case 2:
                            Localizacao localizacao = new Localizacao(i,j);
                            
                            Robo r = Robo.criarRobo(localizacao);
                            
                            setMatriz(i,j,k,r);
                            
                            break;
                        default:
                            
                            setMatriz(i,j,k,null);
                            
                            break;
                    }  
                }
            }
        }
        
        int numeroDeBateria = 0;
        do{
            int x = (int)(Math.random()*20), y = (int)(Math.random()*20);
            if(Robopolis.getMatriz(x,y,0) == null){
                Robopolis.setMatriz(x,y,0,Bateria.criarBateriaEspecial());
                numeroDeBateria++;
            }
        }while(numeroDeBateria < 5);
    }
}