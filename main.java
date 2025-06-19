import java.awt.Dimension;

import javax.swing.JFrame;

class main extends JFrame{
    gamepanel panel;
    main(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new gamepanel();
        panel.setPreferredSize(new Dimension(720,720));
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        }
    public static void main(String[] args) {
        new main();
    }
}