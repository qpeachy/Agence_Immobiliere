public class PieceQuadrilatere extends Piece{

    private double _longeur;
    private double _largeur;

    public PieceQuadrilatere(TypePiece _typePiece, String _niveau, double longeur, double largeur) {
        super(_typePiece, _niveau);
        this._longeur = longeur;
        this._largeur = largeur;
    }


    @Override
    public double surface() {
        return _longeur * _largeur;
    }
    
    
}
