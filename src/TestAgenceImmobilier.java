import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestAgenceImmobilier {
    // @Test
    // public void surfacePieceCirculaire(){
    //     TypePiece salon = new TypePiece(TypePiece.SALON, true, true);
    //     PieceCirculaire C = new PieceCirculaire(salon, "0", 2.1);
    //     assertEquals(expected, actual);
    // }

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
    public void surfaceHabitatBienImmobilier(){ 

    }

}
