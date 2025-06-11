import java.awt.Color;

import javax.swing.JPanel;

public class gamepanel extends JPanel{
    
    box x[][];
    gamepanel(){
        setBackground(Color.WHITE);
        super.setLayout(null);
        x = new box[8][8];
       for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
            x[i][j] = new box(j * box.WIDTH, i * box.HEIGHT);

        if ((i + j) % 2 == 0) {
            x[i][j].setBackground(new Color(240, 217, 181));
        } else {
            x[i][j].setBackground(new Color(181, 136, 99));
        }
        x[i][j].setOpaque(true);
        add(x[i][j]);
    }
}

        
    setupInitialPieces();
    }

    private void setupInitialPieces() {
        x[0][0].setPiece(new Materials(Pieces.ROOK2));
        x[0][1].setPiece(new Materials(Pieces.KNIGHT2));
        x[0][2].setPiece(new Materials(Pieces.BISHOP2));
        x[0][3].setPiece(new Materials(Pieces.QUEEN2));
        x[0][4].setPiece(new Materials(Pieces.KING2));
        x[0][5].setPiece(new Materials(Pieces.BISHOP2));
        x[0][6].setPiece(new Materials(Pieces.KNIGHT2));
        x[0][7].setPiece(new Materials(Pieces.ROOK2));
        for (int i = 0; i < 8; i++) {
            x[1][i].setPiece(new Materials(Pieces.PAWN2));
            x[6][i].setPiece(new Materials(Pieces.PAWN));
        }
        x[7][0].setPiece(new Materials(Pieces.ROOK));
        x[7][1].setPiece(new Materials(Pieces.KNIGHT));
        x[7][2].setPiece(new Materials(Pieces.BISHOP));
        x[7][3].setPiece(new Materials(Pieces.QUEEN));
        x[7][4].setPiece(new Materials(Pieces.KING));
        x[7][5].setPiece(new Materials(Pieces.BISHOP));
        x[7][6].setPiece(new Materials(Pieces.KNIGHT));
        x[7][7].setPiece(new Materials(Pieces.ROOK));
    }
}
