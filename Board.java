import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board {
    box[][] x;
    box selectedBox = null; 

    Board() {
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

                // Attach click listener
                int finalI = i;
                int finalJ = j;
                x[i][j].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        handleClick(finalI, finalJ);
                    }
                });
            }
        }
        setupInitialPieces();
    }

    private void handleClick(int i, int j) {
        box clickedBox = x[i][j];
        box initialBox = x[i][j];
        // First click: select piece
        if (selectedBox == null) {
            if (clickedBox.piece != null) {
                selectedBox = clickedBox;
                clickedBox.setBackground(Color.YELLOW); //highlight
            }
        } 
        // Second click: move piece
        else {
            if (clickedBox != selectedBox) {
                if(moveValid(clickedBox,selectedBox)){
                    clickedBox.setPiece(selectedBox.piece);
                     selectedBox.setPiece(null);
                    
                }else{
                    clickedBox = initialBox;
                }
            }
                 // Restore original background
                int sx = selectedBox.getY() / box.HEIGHT;
                int sy = selectedBox.getX() / box.WIDTH;
                Color original = ((sx + sy) % 2 == 0) ?
                    new Color(240, 217, 181) :
                    new Color(181, 136, 99);
                selectedBox.setBackground(original);
            
            selectedBox = null;
            
        }
    }



    // Move Logic
    private boolean moveValid(box clickedBox, box selectedBox2) {
        if (selectedBox2.piece == null) return false;

    int startX = selectedBox2.getY() / box.HEIGHT;
    int startY = selectedBox2.getX() / box.WIDTH;
    int endX = clickedBox.getY() / box.HEIGHT;
    int endY = clickedBox.getX() / box.WIDTH;
    Ccolor SourceColor = selectedBox2.piece.getColor();
    Ccolor DestinationColor = (clickedBox.piece != null) ? clickedBox.piece.getColor() : null;
    String type = selectedBox2.piece.getType();

    //move logic according to material type

    // pawn
    if (type.equals("pawn")){
            int direction = (SourceColor == Ccolor.WHITE) ? -1 : 1;

            // Normal move forward
            if (startY == endY && clickedBox.piece == null) {
                if (endX == startX + direction) {
                    return true;
                }
                // Two-step move from initial row
                if ((SourceColor == Ccolor.WHITE && startX == 6 || SourceColor == Ccolor.BLACK && startX == 1) &&
                    endX == startX + 2 * direction && x[startX + direction][startY].piece == null) {
                    return true;
                }
            }

            // Diagonal capture
            if (Math.abs(endY - startY) == 1 && endX == startX + direction &&
                clickedBox.piece != null && clickedBox.piece.getColor() != SourceColor) {
                return true;
            }
    }
    
    // rook

   if (type.equals("rook")) {
    if ((startX == endX || startY == endY) && (clickedBox.piece == null || SourceColor != DestinationColor)) {

        // Horizontal movement 
        if (startX == endX) {
            int step = (endY > startY) ? 1 : -1;
            for (int y = startY + step; y != endY; y += step) {
                if (x[startX][y].piece != null) return false; 
            }
        }

        // Vertical movement 
        if (startY == endY) {
            int step = (endX > startX) ? 1 : -1;
            for (int xRow = startX + step; xRow != endX; xRow += step) {
                if (x[xRow][startY].piece != null) return false; 
            }
        }

        return true; 
    }
}


    
    

        return false;
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
