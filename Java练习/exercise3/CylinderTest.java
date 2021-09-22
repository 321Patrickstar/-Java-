package exercise3;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cy = new Cylinder();
        cy.setLength(3.4);
        cy.setRadius(2.1);
        double volume = cy.findVolume();
        System.out.println(volume);
        double area = cy.findArea();
        System.out.println(area);
    }
}
