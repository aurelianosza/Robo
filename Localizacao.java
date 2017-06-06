public class Localizacao{
    private int x;
    private int y;
    
    public Localizacao(int x,int y){
        this.setX(x);
        this.setY(y);
    }
     
    public void setX(int x){
        if(x >= 0 && x <= 19)
            this.x = x;
    }
    public void setY(int y){
        if(y >= 0 && y<=19)
            this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public String exibe(){
        return "X: " + this.getX()*10 + " Y: " + this.getY()*10;
    }
}