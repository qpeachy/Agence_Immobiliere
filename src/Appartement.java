import java.util.HashMap;

public class Appartement extends BienImmobilier{
    
    private String _etage;
    private boolean _ascenseur;
    private boolean _dernierEtage;
    private String _facesExterieur;
    protected HashMap<String, Double> _faces = new HashMap<String, Double>();

    public Appartement(String rue, String ville, String codePostal, Vendeur vendeur, String etage,
            boolean ascenseur, boolean dernierEtage, String facesExterieur) {
        super(rue, ville, codePostal, vendeur);
        this._etage = etage;
        this._ascenseur = ascenseur;
        this._dernierEtage = dernierEtage;
        this._facesExterieur=facesExterieur;
        _faces = new HashMap<String, Double>();
        cas();
    }

    public Appartement(String rue, String ville, String codePostal, Vendeur vendeur, String etage, boolean dernierEtage, String facesExterieur) {
        super(rue, ville, codePostal, vendeur);
        this._etage = etage;
        this._ascenseur =false;
        this._dernierEtage = dernierEtage;
        this._facesExterieur=facesExterieur;
        _faces = new HashMap<String, Double>();
        cas();
    }
    
    public String typeBien(){
        int nbrPiece = 0;
        for (Piece piece : _pieces) {
            if(piece.get_typePiece().isPiece()){
                nbrPiece+=1;
            }
        }
        if(nbrPiece>7)
        {
            return "T7+ ";
        }
        return "T"+ nbrPiece;
    }

    @Override
    public String toString() {
        String resultat ="";
        resultat = "Appartement de type "+ typeBien();
        if(_ascenseur){
            resultat += " avec ascenseur ";
        }
        resultat += " situé au " + _etage + " ";
        resultat += super.toString();
        return resultat;

    }

    public void cas(){
        _faces.put("0", null);
        _faces.put("1", null);
        _faces.put("2", 1.1);
        _faces.put("3", 1.15);
        _faces.put("4", 1.25);

    }

    @Override
    public double dpe(){
        double result = super.dpe();
        if(_etage=="0" || _dernierEtage){
            result*=1.2;
        }else  {
            result*=0.9;
        } 
        result*=_faces.get(_facesExterieur);
        return result;
    }
}
