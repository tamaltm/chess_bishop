import javax.swing.ImageIcon;
import java.awt.Image;
public class Materials {
    String type;
    Ccolor color;
    Pieces pi;
    Image image;
    public Materials(Pieces p){
        this.pi = p;
        switch (p) {
            case KING:
                type = "king";
                color = Ccolor.WHITE;
                
                break;
            case KING2:
                type = "king";
                color = Ccolor.BLACK;
                
                break;
            case KNIGHT:
                type = "knight";
                color = Ccolor.WHITE;
               
                break;
            case KNIGHT2:
                type = "knight";
                color = Ccolor.BLACK;
                
                break;
            case BISHOP:
                type = "bishop";
                color = Ccolor.WHITE;
                
                break;
            case BISHOP2:
                type = "bishop";
                color = Ccolor.BLACK;
                
                break;
            case ROOK:
                type = "rook";
                color = Ccolor.WHITE;
                
                break;
            case ROOK2:
                type = "rook";
                color = Ccolor.BLACK;
                
                break;
            case PAWN:
                type = "pawn";
                color = Ccolor.WHITE;
                
                break;
            case PAWN2:
                type = "pawn";
                color = Ccolor.BLACK;
                
                break;
            case QUEEN:
                type = "queen";
                color = Ccolor.WHITE;
              
                break;
            case QUEEN2:
                type = "queen";
                color = Ccolor.BLACK;
               
                break;
            default:
                break;
        }
        ImageIcon ii = new ImageIcon(getClass().getResource("pieces" + MaterialFile(p, color)));
        image = ii.getImage();
    }
    private String MaterialFile(Pieces p,Ccolor c) {
        char k = 'a';
        if(c==Ccolor.BLACK){
            k = 'b';
        }
        if(c==Ccolor.WHITE){
            k = 'w';
        }
    
    return "/"+type+k+".gif";
}
    public String getType() {
        return type;
    }
    public Ccolor getColor() {
        return color;
    }
    public Pieces getPi() {
        return pi;
    }
    public Image getImage() {
        return image;
    }
    

}