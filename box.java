import javax.swing.*;
import java.awt.*;

public class box extends JPanel {

    public static final int WIDTH = 90;
    public static final int HEIGHT = 90;
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
