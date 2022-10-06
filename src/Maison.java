public class Maison extends BienImmobilier{
    private double _surfaceTerrain;
    private boolean _piscine;
   
    public Maison(String _rue, String _ville, String _codePostal, Vendeur _vendeur, double _surfaceTerrain,
            boolean _piscine) {
        super(_rue, _ville, _codePostal, _vendeur);
        this._surfaceTerrain = _surfaceTerrain;
        this._piscine = _piscine;
    }

    public Maison(String _rue, String _ville, String _codePostal, Vendeur _vendeur, double _surfaceTerrain) {
        super(_rue, _ville, _codePostal, _vendeur);
        this._surfaceTerrain = _surfaceTerrain;
        this._piscine = false;
    }

    @Override
    public String toString() {
        String resultat ="";
        resultat = "Maison individuelle ";
        resultat += "avec son terrain de " + _surfaceTerrain + "m2";
        if(_piscine){
            resultat += " et sa piscine";
        }
        resultat += ". " + super.toString();
        return resultat;

    }    
}
