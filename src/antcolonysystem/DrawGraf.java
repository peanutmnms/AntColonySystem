/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonysystem;
import Grafo.*;
import javax.swing.JOptionPane;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author santi
 */
public class DrawGraf {
    
    public static void draw(VertexLista vertices) {
        System.setProperty("org.graphstream.ui", "swing");

        Graph graph = new SingleGraph("AntColonySystem");
        graph.setAttribute("ui.stylesheet", " graph {fill-color: white; padding: 50px; } node {fill-color: brown; size: 95px, 95px; size-mode: dyn-size; shape: circle; stroke-mode: plain; stroke-color: black; stroke-width: 2px; text-alignment: center; text-color: white; text-style: bold; text-size: 20;} edge {stroke-mode: plain; stroke-color: black; size: 1px; text-alignment: above; text-color: orange; text-style: bold; text-size: 50; text-padding: 20;}");
        String ciudades=""; 
        String aristas = "";
        try{
            if (!vertices.isEmpty()) {
                Vertex auxV = (Vertex) vertices.getpFirst();
                while(auxV!=null){
                    graph.addNode((String) auxV.getData());
                    graph.getNode((String)auxV.getData()).setAttribute("ui.label", "Ciudad " + (String) auxV.getData());
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
            Viewer viewer = graph.display();
            viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se puede graficar. \nAun no ha subido un archivo.");
        }
    }  
    
}
