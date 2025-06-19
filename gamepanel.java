import java.awt.Color;

import javax.swing.JPanel;

public class gamepanel extends JPanel{
    
    Board board;
    gamepanel(){
        setBackground(Color.WHITE);
        super.setLayout(null);
        board = new Board();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                add(board.x[i][j]);
            }
        }
    }


        
   
}
