public class PieceParallelogramme extends Piece{

    private int _base;
    private int _hauteur;
    

    public PieceParallelogramme(TypePiece _typePiece, String _niveau, int base, int hauteur) {
        super(_typePiece, _niveau);
        this._base = base;
        this._hauteur = hauteur;
    }

    @Override
    public double surface() {
        return _base * _hauteur;
    }
    
}
