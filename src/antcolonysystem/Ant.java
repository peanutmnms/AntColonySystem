/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package antcolonysystem;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

/**
 *
 * @author santi
 */
public class Ant {
    
    public static void draw() {
            System.setProperty("org.graphstream.ui", "swing");

            Graph graph = new SingleGraph("Tutorial 1");

            graph.addNode("A");
            graph.addNode("B");
            graph.addNode("C");
            graph.addEdge("AB", "A", "B");
            graph.addEdge("BC", "B", "C");
            graph.addEdge("CA", "C", "A");

            graph.display();
    }

    
    
}
