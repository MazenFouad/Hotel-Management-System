/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author THE LAPTOP SHOP
 */

public class Libro {
        int numPagine;

    public Libro(int numPagine) {
        this.numPagine = numPagine;
    }
    public void pageMessage()
    {
        System.out.println("questo libro ha "+ numPagine + "pagine");
    }
}
