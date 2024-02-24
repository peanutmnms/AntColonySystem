/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AntColony;

/**
 *
 * @author santi
 */
public class Ant {
    protected int numCiclos;
    protected String[] recorrido;
    protected String ciudadActual;
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
    public String getCiudadActual() {
        return ciudadActual;
    }

    /**
     * @param ciudadActual the ciudadActual to set
     */
    public void setCiudadActual(String ciudadActual) {
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
    
    
    
    
}
