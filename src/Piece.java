public abstract class Piece {
    private TypePiece _typePiece;
    private String _niveau;
    

    public Piece(TypePiece _typePiece, String _niveau) {
        this._typePiece = _typePiece;
        this._niveau = _niveau;
    }


    public TypePiece get_typePiece() {
        return _typePiece;
    }


    public String get_niveau() {
        return _niveau;
    }

    public abstract double surface();


    @Override
    public String toString() {
        return _typePiece + "surface :" + surface() + "m2 \n";
    }

    
    
}
