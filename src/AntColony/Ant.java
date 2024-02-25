/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AntColony;

import EDD.*;
import GUI.*;
import Grafo.*;
import java.lang.Math;
import java.util.Random;

/**
 *
 * @author santi
 */
public class Ant {
    protected int numCiclos;
    protected String[] recorridoHecho = new String[Menu.grafo.getVertices().getiN()];
    protected int numCiudadesVisitadas;
    protected Nodo ciudadActual;

    

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
     * @return the recorridoHecho
     */
    public String[] getRecorridoHecho() {
        return recorridoHecho;
    }

    /**
     * @param recorrido the recorridoHecho to set
     */
    public void setRecorridoHecho(String[] recorridoHecho) {
        this.recorridoHecho = recorridoHecho;
    }
    
    /**
     * @param recorrido the recorridoHecho to set
     */
    public void addRecorridoHecho(String ciudad, int indice) {
        this.recorridoHecho[indice] = ciudad;
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
    
    public void recorridoAnt(double alpha, double beta, Nodo ciudadBuscada){
        Vertex ciudadAct = (Vertex) this.ciudadActual;
        int iN = ciudadAct.getAdjacent().getiN();
        //System.out.println(iN);
        this.recorridoInterno(iN, ciudadAct, alpha, beta, ciudadBuscada);
    }

    
    public void recorridoInterno(int iN, Vertex ciudadAct, double alpha, double beta, Nodo ciudadBuscada){
        int indice = 0;
        Edge arista = (Edge)ciudadAct.getAdjacent().getpFirst();
        double longitud = arista.getLength();
        double feromonas = arista.getPheromones();
        double denominador = 0;
        
        
        int count = 0;
        //Calcula el valor del denominador
        for (int i = 0; i < iN; i++) {
            int posicion = -1;
            for (int j = 0; j < getRecorridoHecho().length; j++) {
                if (getRecorridoHecho()[j] == arista.getDest().getData()) {
                    posicion = j;
                    count +=1;
                }
            }
            
            if (i != posicion) {
                denominador+= ((Math.pow(feromonas, alpha))*(Math.pow((1/longitud), beta)));
            }
            
            arista = (Edge)arista.getpNext();
            if(arista!=null){
                longitud = arista.getLength();
                feromonas = arista.getPheromones();
            }
        }
        
        Double[] listado = new Double[iN-count];
        
        //Calcula el valor del numerador y lo divide por el denominador, guardando todas las probabilidades en un array.
        arista = (Edge)ciudadAct.getAdjacent().getpFirst();
        longitud = arista.getLength();
        feromonas = arista.getPheromones();
        for (int i = 0; i < iN; i++) {
            int posicion = -1;
            for (int j = 0; j < getRecorridoHecho().length; j++) {
                if (getRecorridoHecho()[j] == arista.getDest().getData()) {
                    posicion = j;
                }
            }
            
            if (i != posicion) {
                double total = 0;
                double numerador = ((Math.pow(feromonas, alpha))*(Math.pow((1/longitud), beta)));
                //System.out.println("numerador"+numerador);
                total = numerador/denominador;
                listado[i-posicion]=total;
            }

            arista = (Edge)arista.getpNext();
            
            if(arista!=null){
                longitud = arista.getLength();
                feromonas = arista.getPheromones();
            }
        }
        
        double sum = 0;
        //suma el total probabilistico
        for (int i = 0; i < iN; i++) {
            sum += listado[i]; 
        }
        
        double x =0;
        for (int i = 0; i < iN; i++) {
            double y = listado[i];
            listado[i]=sum-x;
            x+=y;  
        }
        
        Random rand = new Random();
        double randub1 = rand.nextDouble();
        //System.out.println(randub1);
        
        int camino = 0;
        for (int i = 0; i < iN; i++) {
            if (i!=iN-1) {
                if (listado[i+1] < randub1 && randub1 <= listado[i]) {
                    camino = i;
                }
            }else{
                if (0 < randub1 && randub1 <= listado[i]) {
                    camino = i;
                }
            }
        }
        
        arista = (Edge)ciudadAct.getAdjacent().getpFirst();
        indice+=1;
        this.addRecorridoHecho((String) ciudadAct.getData(), indice);
        System.out.println("Estoy parado en: "+this.ciudadActual.getData());
        for (int i = 0; i < listado.length; i++) {
            if (i == camino) {
                this.setCiudadActual(arista.getDest());
                ciudadAct = (Vertex) this.ciudadActual;
                iN = ciudadAct.getAdjacent().getiN();
                System.out.println(this.ciudadActual.getData());
            }
            arista = (Edge)arista.getpNext();
            
            
        }
        
        if (this.ciudadActual != ciudadBuscada){
            recorridoInterno(iN, ciudadAct, alpha, beta, ciudadBuscada);
        }
        else{
            System.out.println("La siguiente es la ciudad final ");
        }
   
    }
    
    public void actualizarFermonas(){
        
    }
    
    
    
    
    
}
