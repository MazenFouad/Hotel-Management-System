/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author THE LAPTOP SHOP
 */
public class Vocabolario extends Libro{
    int numDefinizioni;
    
    public Vocabolario(int numPagine, int numDefinizioni) {
        super(numPagine);
        this.numDefinizioni = numDefinizioni;
    }
    public void definizioniMessage()
    {
        double medio;
        medio = numDefinizioni/numPagine;
        System.out.println("questo libro ha " + numDefinizioni + "definizioni");
        System.out.println("questo libro ha "+ numPagine + "pagine");
        System.out.println("il medio delle definizioni per pagina sono " + medio);
    }
    
}
