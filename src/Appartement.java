public class Appartement extends BienImmobilier{
    
    private String _etage;
    private boolean _ascenseur;

    public Appartement(String _rue, String _ville, String _codePostal, Vendeur _vendeur, String _etage,
            boolean _ascenseur) {
        super(_rue, _ville, _codePostal, _vendeur);
        this._etage = _etage;
        this._ascenseur = _ascenseur;
    }

    public Appartement(String _rue, String _ville, String _codePostal, Vendeur _vendeur, String _etage) {
        super(_rue, _ville, _codePostal, _vendeur);
        this._etage = _etage;
        this._ascenseur =false;
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
            return "T7+";
        }
        return "T "+ nbrPiece;
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

    
}
