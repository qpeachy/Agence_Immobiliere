public class PieceTrapezoidale extends Piece{

    private double _petiteBase;
    private double _grandeBase;
    private double _hauteur;
    

    public PieceTrapezoidale(TypePiece _typePiece, String _niveau, double _petiteBase, double _grandeBase, double _hauteur) {
        super(_typePiece, _niveau);
        this._petiteBase = _petiteBase;
        this._grandeBase = _grandeBase;
        this._hauteur = _hauteur;
    }



    @Override
    public double surface() {
        return 1.2*_hauteur*(_grandeBase + _petiteBase);
    }
    
}
