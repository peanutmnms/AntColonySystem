/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonysystem;
import Grafo.*;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

/**
 *
 * @author santi
 */
public class Ant {
    
    public static void draw(VertexLista vertices) {
        System.setProperty("org.graphstream.ui", "swing");

        Graph graph = new SingleGraph("AntColonySystem"); 
        String ciudades=""; 
        String aristas = "";
        
        if (!vertices.isEmpty()) {
            Vertex auxV = (Vertex) vertices.getpFirst();
            while(auxV!=null){
                graph.addNode((String) auxV.getData());
                auxV = (Vertex) auxV.getpNext();
            }
            auxV = (Vertex) vertices.getpFirst();
            while(auxV!=null){
                Grafo.Edge auxE = (Grafo.Edge) auxV.getAdjacent().getpFirst();
                while(auxE!=null){
                    if (!ciudades.contains((String) auxE.getDest().getData())) {
                        graph.addEdge((String) auxV.getData()+"+"+(String)auxE.getDest().getData(), (String) auxV.getData(), (String) auxE.getDest().getData());
                    }
                    auxE = (Grafo.Edge) auxE.getpNext();  
                }
                ciudades+= (String) auxV.getData() + " ";
                auxV = (Vertex) auxV.getpNext();
            }
        }
        graph.display();
    }  
    
}
