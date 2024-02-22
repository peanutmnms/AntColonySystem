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
        Edge aux = (Edge) getpFirst();
        while (aux != null){
            if(aux.getData().equals(elemento)){
                return aux;
            }else{
                aux=(Edge) aux.getpNext();
            }
        }
     return null;
    }
    
    public String recorrer(){
    Nodo pAux;
    String resultado="";
        if (isEmpty()){
            resultado=" está vacía";

        }else{
            pAux=pFirst;
            while(pAux!= null){
                resultado=resultado + this.read((Nodo)pAux.getData())+ ", ";
                pAux=próximo(pAux);
                //pAux=pAux.pnext;
            }
        }
        return resultado;
    }
    
}
