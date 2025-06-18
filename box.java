import javax.swing.*;
import java.awt.*;

public class box extends JPanel {

    public static final int WIDTH = 90;
    public static final int HEIGHT = 90;
    public boolean showDot = false;
    Materials piece;
    box(int x, int y) {
        setBounds(x, y, WIDTH, HEIGHT); 
    }
    public void setPiece(Materials m) {
        this.piece = m;
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getBackground());
        g.fillRect(0, 0, WIDTH, HEIGHT);
        if(showDot){
            g.setColor(new Color(30, 30, 30));
            int dotSize = 14;
            int centerX = getWidth()/2 - dotSize/2;
            int centerY = getHeight()/2 - dotSize/2;
            g.fillOval(centerX, centerY, dotSize, dotSize);
        }
        
        if (piece != null && piece.getImage() != null) {
            g.drawImage(piece.getImage(), 0, 0, WIDTH, HEIGHT, this);
        }
    }

    public  int getWidth() {
        return WIDTH;
    }

    public  int getHeight() {
        return HEIGHT;
    }
    
}
