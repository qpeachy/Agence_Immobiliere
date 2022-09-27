import java.util.ArrayList;

public abstract class BienImmobilier {
    private String _rue;
    private String _ville;
    private String _codePostal;
    private Vendeur _vendeur;
    private ArrayList<Piece> _pieces;
   

    public BienImmobilier(String _rue, String _ville, String _codePostal, Vendeur _vendeur) {
        this._rue = _rue;
        this._ville = _ville;
        this._codePostal = _codePostal;
        this._vendeur = _vendeur;
        _pieces = new  ArrayList<Piece>();
    }

    

    public Vendeur getVendeur() {
        return _vendeur;
    }



    public double surfaceHabitable(){
        double result;
        if ()
        return 0;
    }

    public void ajouterPiece(Piece piece){
        _pieces.add(piece);
    }
}
