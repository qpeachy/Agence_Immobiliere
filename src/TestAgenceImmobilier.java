import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import org.junit.Test;

public class TestAgenceImmobilier {
    @Test
    public void surfacePieceCirculaire(){
        TypePiece salon = new TypePiece(TypePiece.SALON, true, true);
        PieceCirculaire C = new PieceCirculaire(salon, "0", 2.1);
        assertEquals(13.85, C.surface(), 1e-2);
    }

    @Test
    public void surfacePieceParallelogramme(){
        TypePiece salon = new TypePiece(TypePiece.SALON, true, true);
        PieceParallelogramme P = new PieceParallelogramme(salon,"0",3,4);
        assertEquals(12, P.surface(), 1e-2);
    }

    @Test
    public void surfacePieceQuadrilatere(){
        TypePiece salon = new TypePiece(TypePiece.SALON, true, true);
        PieceQuadrilatere P =new PieceQuadrilatere(salon, "0", 5, 2.1);
        assertEquals(10.5, P.surface(), 1e-2);
    }

    @Test
    public void surfacePieceTrapezoidale(){
        TypePiece salon = new TypePiece(TypePiece.SALON, true, true);
        PieceTrapezoidale P = new PieceTrapezoidale(salon , "0", 24, 53, 5);
        assertEquals(462, P.surface(), 1e-2);
    }

    @Test
    public void surfacePieceTriangulaire(){
        TypePiece salon = new TypePiece(TypePiece.SALON, true, true);
        PieceTriangulaire P = new PieceTriangulaire(salon, "0", 2, 5);
        assertEquals(5, P.surface(), 1e-2);
    }


    @Test
    public void TestSurfaceHabitable(){
        TypePiece chambre = new TypePiece(TypePiece.CHAMBRE, true, true);
        Vendeur vendeur = new Vendeur("Dupuis", "Jean-Claude", "dp.jc@gmail.com", "06.74.74.00.00");
        Maison maison = new Maison("155 route du lac", "ANNECY", "74000", vendeur, 875);
        TypePiece Cave = new TypePiece(TypePiece.CAVE, false, false);
        maison.ajouterPiece(new PieceQuadrilatere(Cave, "-1", 3, 4.2));
        maison.ajouterPiece(new PieceTriangulaire(chambre, "0", 6.2, 4.5));
        maison.ajouterPiece(new PieceTriangulaire(chambre, "1", 3.8, 6));
        maison.ajouterPiece(new PieceQuadrilatere(chambre, "1", 5.8, 2.8));
        assertEquals(41.59, maison.surfaceHabitable(), 1e-2);
        assertEquals(12.6, maison.surfaceNonHabitable(), 1e-2); 
    }

    @Test
    public void typeBien(){ 
        Vendeur vendeur = new Vendeur("Dupuis", "Jean-Claude", "dp.jc@gmail.com", "06.74.74.00.00");
        Appartement appartement = new Appartement("16 rue du lac", "ANNECY", "74000", vendeur, "1er étage");
        TypePiece chambre = new TypePiece(TypePiece.CHAMBRE, true, true);
        appartement.ajouterPiece(new PieceQuadrilatere(chambre, "0", 4, 3));
        assertEquals("T1", appartement.typeBien());

    }

    @Test
    public void prixAnnonce(){ 
        Vendeur vendeur = new Vendeur("Dupuis", "Jean-Claude", "dp.jc@gmail.com", "06.74.74.00.00");
        Appartement appartement = new Appartement("16 rue du lac", "ANNECY", "74000", vendeur, "1er étage");
        TypePiece chambre = new TypePiece(TypePiece.CHAMBRE, true, true);
        appartement.ajouterPiece(new PieceQuadrilatere(chambre, "0", 1, 1));
        Annonce annonce = new Annonce("AM0922001","27/09/2022", "Villa familliale", 4860, appartement);
        assertEquals(4860, annonce.prix(), 1e-2);

    }

    @Test
    public void dpeTest(){
        Vendeur vendeur = new Vendeur("Dupuis", "Jean-Claude", "dp.jc@gmail.com", "06.74.74.00.00");
        Appartement appartement = new Appartement("16 rue du lac", "ANNECY", "74000", vendeur, "1er étage");
        TypePiece chambre = new TypePiece(TypePiece.CHAMBRE, true, true);
        appartement.ajouterPiece(new PieceQuadrilatere(chambre, "0", 5, 6));
        appartement.diagnosticDPE("Sud", "Bonne", "Electrique", "Excellente");
        assertEquals(29.04, appartement.dpe(), 1e-2);
    }

}
