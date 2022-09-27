public class PieceParallelogramme extends Piece{

    private double _base;
    private double _hauteur;
    

    public PieceParallelogramme(TypePiece _typePiece, String _niveau, double base, double hauteur) {
        super(_typePiece, _niveau);
        this._base = base;
        this._hauteur = hauteur;
    }

    @Override
    public double surface() {
        return _base * _hauteur;
    }
    
}
