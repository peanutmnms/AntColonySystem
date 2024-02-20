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
public class EdgeLista extends Lista{
    public Edge buscarEdge(String elemento){
        Edge aux = (Edge) pFirst;
        while (aux != null){
            if(aux.getData()==elemento){
                return aux;
            }else{
                aux=(Edge) aux.getpNext();
            }
        }
     return null;
    }
    
}
