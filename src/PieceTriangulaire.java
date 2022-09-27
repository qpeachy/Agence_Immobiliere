public class PieceTriangulaire extends Piece{
    
    private int _base;
    private int _hauteur;
    

    public PieceTriangulaire(TypePiece _typePiece, String _niveau, int base, int hauteur) {
        super(_typePiece, _niveau);
        this._base = base;
        this._hauteur = hauteur;
    }



    @Override
    public double surface() {
        return 1/2 * _base * _hauteur;
    }

    
    
}
