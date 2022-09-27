public class Annonce {
   
    public static double COEF_NON_HABITABLE = 0.25;
   
    private String _reference;
    private String _date;
    private String _titre;
    private double _prixM2Habitable;
    private BienImmobilier _logement;



    
    public Annonce(String _reference, String _date, String _titre, double _prixM2Habitable, BienImmobilier _logement) {
        this._reference = _reference;
        this._date = _date;
        this._titre = _titre;
        this._prixM2Habitable = _prixM2Habitable;
        this._logement = _logement;
    }

    public double prix(){
        double result;
        result = (_logement.surfaceHabitable() *_prixM2Habitable )+ (_logement.surfaceNonHabitable() * _prixM2Habitable * COEF_NON_HABITABLE);
        return result;
    }

    @Override
    public String toString() {
       String result;
       result = _titre + "\n"+ _reference + " " + _date + "\n" + _logement.toString() + "\n" + "-Prix du m2 habitable : " + _prixM2Habitable + "\n" + "-Prix du m2 non habitable : " + (_prixM2Habitable*COEF_NON_HABITABLE) + "\n Valeur du bien : " + prix() + "\nContact : " + _logement.getVendeur().getEmail() + " / "+ _logement.getVendeur().getNumeroTelephone();
       return result;
    }

    
}
