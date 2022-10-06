import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

public abstract class BienImmobilier {
    private String _rue;
    private String _ville;
    private String _codePostal;
    private Vendeur _vendeur;
    private String _orientation;
    private String _menuiserie;
    private String _chauffage;
    private String _isolation;
    protected ArrayList<Piece> _pieces;
    protected HashMap<String, Double> _coeffsOrientation = new HashMap<String, Double>();
    protected HashMap<String, Double> _coeffsMenuiserie = new HashMap<String, Double>();
    protected HashMap<String, Double> _coeffsChauffage = new HashMap<String, Double>();
    protected HashMap<String, Double> _coeffsIsolation = new HashMap<String, Double>();
   

    public BienImmobilier(String _rue, String _ville, String _codePostal, Vendeur _vendeur) {
        this._rue = _rue;
        this._ville = _ville;
        this._codePostal = _codePostal;
        this._vendeur = _vendeur;
        _pieces = new  ArrayList<Piece>();
        _coeffsOrientation = new HashMap<String, Double>();
        _coeffsMenuiserie = new HashMap<String, Double>();
        _coeffsChauffage = new HashMap<String, Double>();
        _coeffsIsolation = new HashMap<String, Double>();
        addCoeff();
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

    public double consommationKWhAn(){
        double result;
        result= surfaceHabitable()*110;
        return result;
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

    public void diagnosticDPE(String orientation, String menuiserie, String chauffage, String isolation){
        this._orientation=orientation;
        this._menuiserie=menuiserie;
        this._chauffage=chauffage;
        this._isolation=isolation;
    }

    public void addCoeff(){
        _coeffsOrientation.put("Nord", 1.8);
        _coeffsOrientation.put("Sud",1.00 );
        _coeffsOrientation.put("Est", 1.2);
        _coeffsOrientation.put("Ouest", 1.4);

        _coeffsMenuiserie.put("Excellente", 1.00);
        _coeffsMenuiserie.put("Bonne", 1.1);
        _coeffsMenuiserie.put("Moyenne", 1.3);
        _coeffsMenuiserie.put("Mauvaise", 1.6);

        _coeffsChauffage.put("Bois", 0.8);
        _coeffsChauffage.put("Géothermie", 0.6);
        _coeffsChauffage.put("Electrique", 1.00);
        _coeffsChauffage.put("Gaz", 0.9);

        _coeffsIsolation.put("Excellente", 0.8);
        _coeffsIsolation.put("Bonne",1.00);
        _coeffsIsolation.put("Moyenne", 1.4);
        _coeffsIsolation.put("Aucune", 2.00);
    }

    public double dpe(){
        double result;
        diagnosticDPE(_orientation, _menuiserie, _chauffage, _isolation);
        result = (consommationKWhAn() *_coeffsOrientation.get(_orientation)* _coeffsMenuiserie.get(_menuiserie) * _coeffsChauffage.get(_chauffage) * _coeffsIsolation.get(_isolation)) /100;
        return result;
    }
}
