import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class BienImmobilier {
    private String _rue;
    private String _ville;
    private String _codePostal;
    private Vendeur _vendeur;
    protected ArrayList<Piece> _pieces;
   

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
        double result = 0;
        for (Piece piece : _pieces) {
            if (piece.get_typePiece().isSurfaceHabitable()){
                result += piece.surface();
            }
        }
        return result;
    }

    public double surfaceNonHabitable(){
        double result = 0;
        for (Piece piece : _pieces) {
            if (piece.get_typePiece().isSurfaceHabitable() == false){
                result += piece.surface();
            }
        }
        return result;
    }

    public void ajouterPiece(Piece piece){
        _pieces.add(piece);
    }

    @Override
    public String toString() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        return "\nLocalisation : " +_rue +" " + _codePostal+ " " + _ville + 
        "\n \n Description du bien : \n" +
        _pieces.toString()  +  
        "\nPour une surface habitable de : " + 
        numberFormat.format(surfaceHabitable())+ 
        " m2 et une surface non habitable de : " + 
        numberFormat.format(surfaceNonHabitable())+" m2.";
    }

    
}
