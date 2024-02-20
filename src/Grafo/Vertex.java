/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;
import EDD.*;

/**
 *
 * @author santi
 * @param <T>
 */
public class Vertex<T> extends Nodo<T>{ 
    protected EdgeLista adjacent;
    
    public Vertex(T elem) {
    super(elem);
    adjacent = new EdgeLista();
    }
    
    /**
     * @return the adjacent
     */
    public Lista getAdjacent() {
        return adjacent;
    }

    /**
     * @param adjacent the adjacent to set
     */
    public void setAdjacent(EdgeLista adjacent) {
        this.adjacent = adjacent;
    }   
    
    public void addAdjacent(Edge adjacent){
        this.adjacent.insertarNodo(adjacent);
    }
    
    
    
}
