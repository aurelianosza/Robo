public class Teste {
    public static void main(String[] args) {
        
    Robopolis.criarCidade();
          
    Robo r1 = Robo.criarRobo(new Localizacao(0,0));    
    
    System.out.println(r1.exibe());    
    System.out.println();    
        

    int i, x;
    
    for(i = 0; i < 100; i++){
        x = (int)(Math.random()*2000);
        
        if(x < 1000)
            r1.andar();
        else{
            if(x % 2 == 0)
                r1.girarDireita();
            else
                r1.girarEsquerda();
        }
        
    }
        
        
    System.out.println();
    System.out.println(r1.exibe());
        
    System.out.println();
    
    r1.exibeMochila();
        
        
    }
        
}