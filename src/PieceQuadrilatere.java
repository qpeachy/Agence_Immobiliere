public class PieceQuadrilatere extends Piece{

    private int _longeur;
    private int _largeur;

    public PieceQuadrilatere(TypePiece _typePiece, String _niveau, int longeur, int largeur) {
        super(_typePiece, _niveau);
        this._longeur = longeur;
        this._largeur = largeur;
    }
}

    @Override
    public double surface() {
        return _longeur * _largeur;
    }
    
    
}
