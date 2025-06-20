import javax.swing.*;
import java.awt.*;

public class box extends JPanel {

    public static final int WIDTH = 90;
    public static final int HEIGHT = 90;
    public boolean showDot = false;
    Materials piece;
    public boolean warning = false;
    public boolean check = false;
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
            g.setColor(new Color(112, 128, 144));
            int dotSize = 14;
            int centerX = getWidth()/2 - dotSize/2;
            int centerY = getHeight()/2 - dotSize/2;
            g.fillOval(centerX, centerY, dotSize, dotSize);
        }
        if (warning) {
        Graphics2D g2 = (Graphics2D) g; 
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(6)); 
        g2.drawOval(0, 0, 90, 90);
        }
        if(check){
            Graphics2D g2 = (Graphics2D) g; 
            g2.setColor(Color.RED);
            g2.setStroke(new BasicStroke(7)); 
            g2.drawRect(0, 0, WIDTH, HEIGHT);
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
