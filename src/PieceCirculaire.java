public class PieceCirculaire extends Piece {

    private double _rayon;


    public PieceCirculaire(TypePiece _typePiece, String _niveau,double rayon) {
        super(_typePiece, _niveau);
        this._rayon=rayon;
    }


    @Override
    public double surface() {
        return Math.PI * Math.pow(_rayon, 2);
    }

}
