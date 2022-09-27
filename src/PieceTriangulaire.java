public class PieceTriangulaire extends Piece{
    
    private double _base;
    private double _hauteur;
    

    public PieceTriangulaire(TypePiece _typePiece, String _niveau, double base, double hauteur) {
        super(_typePiece, _niveau);
        this._base = base;
        this._hauteur = hauteur;
    }


    @Override
    public double surface() {
        double result; 
        result= (_base * _hauteur)/2;
        return result;
    }

    
    
}
