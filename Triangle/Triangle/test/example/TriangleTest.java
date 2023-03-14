package example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest { 
	 
    @Test 
    public void equilateralTriangleHaveEqualSides() throws Exception { 
        Triangle triangle = new Triangle(2, 2, 2); 
 
        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind()); 
    } 
    
    @Test 
    public void isoscelesTriangle() throws Exception { 
        Triangle triangle = new Triangle(3, 2, 2); 
 
        assertEquals(TriangleKind.ISOSCELES, triangle.getKind()); 
    } 

    @Test 
    public void isoscelesTriangleEmDiferenteOrdem() throws Exception { 
        Triangle triangle = new Triangle(3, 2, 3); 
 
        assertEquals(TriangleKind.ISOSCELES, triangle.getKind()); 
    } 

    @Test 
    public void isoscelesTriangleEmDiferenteOrdem2() throws Exception { 
        Triangle triangle = new Triangle(3, 3, 2); 
 
        assertEquals(TriangleKind.ISOSCELES, triangle.getKind()); 
    } 

    @Test 
    public void scaleneTriangle() throws Exception { 
        Triangle triangle = new Triangle(4, 2, 3); 
 
        assertEquals(TriangleKind.SCALENE, triangle.getKind()); 
    } 

    @Test
    void testTriangleComValoresDecimais() throws TriangleException {
        Triangle triangle = new Triangle(3.5, 3.8, 3.3);
        Assertions.assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    @Test
    void testTriangleComValoresMenores() throws TriangleException {
        Triangle triangle = new Triangle(0.3, 0.3, 0.4);
        Assertions.assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Test
    public void testTriangleComValorMaximo() throws TriangleException {
        double max = Double.MAX_VALUE;
        Triangle triangle = new Triangle(max, max, max);
        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind());
    }

    @Test
    void testTriangleComValoresDecimaisComMuitasCasas() throws TriangleException {
        Triangle triangle = new Triangle(0.2, 0.3, 0.40000000000111);
        Assertions.assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    @Test
    public void testViolatesTriangleInequality() {
        Assertions.assertThrows(TriangleException.class, () -> new Triangle(3, 6, 11));
    }

    @Test
    public void testAllSidesAreZero() {
        Assertions.assertThrows(TriangleException.class, () -> new Triangle(0, 0, 0));
    }

    @Test
    public void testHasImpossibleSides() {
        Assertions.assertThrows(TriangleException.class, () -> new Triangle(2, 2, -1));
    }

    @Test
    public void testGetNumberOfUniqueSides() throws Exception{
        Triangle triangle = new Triangle(2, 3, 4);
        assertEquals(3, triangle.getNumberOfUniqueSides());
    }

    @Test
    public void testGetNumberOfUniqueSides2() throws Exception{
        Triangle triangle = new Triangle(3, 3, 4);
        assertEquals(2, triangle.getNumberOfUniqueSides());
    }

    @Test
    public void testGetNumberOfUniqueSides3() throws Exception{
        Triangle triangle = new Triangle(2, 2, 2);
        assertEquals(1, triangle.getNumberOfUniqueSides());
    }
}