
package szachy;


public class Pole {
    
    private Bierka figura;
    
    public Bierka getFigura(){
        return figura;
    }
    public void setFigura(Bierka figura){
        this.figura = figura;
    }
    
    @Override
    public String toString(){
        if(figura == null)
            return "[" + "." + "]";
        
        else return "[" + figura.toString() + "]";
    
}
}    

