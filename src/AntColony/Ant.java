/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AntColony;

import EDD.*;
import Grafo.*;

/**
 *
 * @author santi
 */
public class Ant {
    protected int numCiclos;
    protected String[] recorrido;
    protected Nodo ciudadActual;
    protected String[][] posiblesCaminos;
    

    /**
     * @return the numCiclos
     */
    public int getNumCiclos() {
        return numCiclos;
    }

    /**
     * @param numCiclos the numCiclos to set
     */
    public void setNumCiclos(int numCiclos) {
        this.numCiclos = numCiclos;
    }

    /**
     * @return the recorrido
     */
    public String[] getRecorrido() {
        return recorrido;
    }

    /**
     * @param recorrido the recorrido to set
     */
    public void setRecorrido(String[] recorrido) {
        this.recorrido = recorrido;
    }

    /**
     * @return the ciudadActual
     */
    public Nodo getCiudadActual() {
        return ciudadActual;
    }

    /**
     * @param ciudadActual the ciudadActual to set
     */
    public void setCiudadActual(Nodo ciudadActual) {
        this.ciudadActual = ciudadActual;
    }

    /**
     * @return the posiblesCaminos
     */
    public String[][] getPosiblesCaminos() {
        return posiblesCaminos;
    }

    /**
     * @param posiblesCaminos the posiblesCaminos to set
     */
    public void setPosiblesCaminos(String[][] posiblesCaminos) {
        this.posiblesCaminos = posiblesCaminos;
    }
    
    public void recorridoAnt(double alpha, double beta, Nodo ciudadBuscada){
        Vertex ciudadAct = (Vertex) this.ciudadActual;
        int iN = ciudadAct.getAdjacent().getiN();
        //System.out.println(iN);

        Edge arista = (Edge)ciudadAct.getAdjacent().getpFirst();
    
        double longitud = arista.getLength();
        double feromonas = arista.getPheromones();
        double denominador = 0;
        
        Double[] listado = new Double[iN]; 
        
        
        
        for (int i = 0; i < iN; i++) {
            denominador+= ((Math.pow(feromonas, alpha))*(Math.pow((1/longitud), beta)));
            arista = (Edge)arista.getpNext();
        }
        
        for (int i = 0; i < iN; i++) {
            double total = 0;
            double numerador = ((Math.pow(feromonas, alpha))*(Math.pow((1/longitud), beta)));
            total = numerador/denominador;
            listado[i]=total;

            arista = (Edge)arista.getpNext();
        }
        
        
        
    }
    
    
    
    
    
}
