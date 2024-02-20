/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;
import EDD.*;

/**
 *
 * @author santi
 */
public class VertexLista extends Lista{
    
    public Vertex buscarVertex(String elemento){
        Vertex aux = (Vertex) getpFirst();
        while (aux != null){
//            System.out.println(aux.getData());
//            System.out.println(elemento);
            if(aux.getData().equals(elemento)){
                return aux;
            }else{
                aux=(Vertex) aux.getpNext();
            }
        }
     return null;
    }
    
}
