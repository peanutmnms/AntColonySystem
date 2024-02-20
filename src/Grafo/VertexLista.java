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
        Vertex aux = (Vertex) pFirst;
        while (aux != null){
            if(aux.getData()==elemento){
                return aux;
            }else{
                aux=(Vertex) aux.getpNext();
            }
        }
     return null;
    }
    
}
