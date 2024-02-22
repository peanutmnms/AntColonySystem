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
    
//    public void deleteEdge(Nodo x){
//    Edge aux = (Edge) adjacent.getpFirst();
//    Vertex aux1 = (Vertex) x;
//    
//    if (aux != null) {
//        //System.out.println(aux.getDest().getData()+ "+" + aux1.getData());
//        if (aux.getDest().getData() == aux1.getData()) {
//           adjacent.deleteFirst();
//        }else{
//            while(aux.getDest().getData()!=aux1.getData()&&aux.getpNext()!=null){
//                System.out.println(aux.getData());
//                aux=(Edge) aux.getpNext();
//            }
//            aux.setpNext(aux1.getpNext());
//            aux1.setpNext(null);
//            adjacent.setiN(adjacent.getiN()- 1 );
//        }  
//    }
//}
    
     public void deleteFirst(){
        if (this.adjacent.getpFirst() != null){
            Nodo aux = this.adjacent.getpFirst();
            this.adjacent.setpFirst(this.adjacent.getpFirst().getpNext());
            aux.setpNext(null);
            this.adjacent.setiN(this.adjacent.getiN() -1);
        }
     }
    
//    public void deleteEdge(Nodo x){
//        Edge aux= (Edge) this.adjacent.getpFirst();
//        if (aux != null) {
//            if ((Vertex) this.adjacent.getpFirst().getData() == x) {
//                this.deleteFirst();
//            }else{
//                while(aux.getData()!= x){
//                    aux=(Edge) aux.getpNext();   
//                    if (aux==null){
//                        break;
//                    }
//                }
//                if (aux!=null){
//                    if (aux.getData()== x){
//                            aux.setpNext(aux.getpNext());
//                            x.setpNext(null);
//                            this.adjacent.setiN(this.adjacent.getiN()- 1 );  
//                    }
//                }
//                
//            }
//            
//        }
//        
//    }
     
     public void deleteEdge(Nodo x){
         Edge aux= (Edge) this.adjacent.getpFirst();
         if (aux != null) {
             while(aux!=null){
                 if ((Edge) aux.getpNext() != null){
                    if (((Edge) aux.getpNext()).getDest().getData() == x.getData()){
                        Edge n = (Edge) aux.getpNext();
                        aux.setpNext((Edge) n.getpNext());
                    }
                }
                 
                 aux=(Edge) aux.getpNext(); 
             } 
         }
         
     }
    
    
    
}
