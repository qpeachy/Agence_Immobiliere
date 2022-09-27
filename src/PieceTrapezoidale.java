public class PieceTrapezoidale extends Piece{

    private int _petiteBase;
    private int _grandeBase;
    private int _hauteur;
    

    public PieceTrapezoidale(TypePiece _typePiece, String _niveau, int _petiteBase, int _grandeBase, int _hauteur) {
        super(_typePiece, _niveau);
        this._petiteBase = _petiteBase;
        this._grandeBase = _grandeBase;
        this._hauteur = _hauteur;
    }



    @Override
    public double surface() {
        return 1.2*_hauteur*(_grandeBase) + _petiteBase);
    }
    
}
