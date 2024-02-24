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
public class Edge<T> extends Nodo<T>{
    protected double length;
    protected double pheromones;
    
    public Edge(T vertex) {
    super(vertex);
    pheromones = 0.1;
    }

    /**
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * @return the pheromones
     */
    public double getPheromones() {
        return pheromones;
    }

    /**
     * @param pheromones the pheromones to set
     */
    public void setPheromones(double pheromones) {
        this.pheromones = pheromones;
    }

    public Vertex getDest(){
        return (Vertex) data;
    }
}
