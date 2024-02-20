/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author santi
 */
public class Lista {
    protected Nodo pFirst;
    protected Nodo pLast;
    protected int iN;
    
public String vaciarLista(){
    pFirst=null;
    iN=0;  
    return "La lista esta vacia";
}

public int numeroNodos(){
    return iN;
 }
 public boolean esVacio(){
    return pFirst==null;
 }
 public Nodo próximo(Nodo pValor){
    if (pValor!=null){
        pValor=pValor.getpNext();
        return pValor;
    }else{
    return null;
    }
 }
 
 public Object leer(Nodo pValor){
    return pValor.getData();
 }
 
 /*public void insertar(Object x, Nodo pValor){
    Nodo pNew=new Nodo(x);
    if (esVacio()){
         pFirst=pNew;
    }else{
        pNew.setpNext(pValor.getpNext());
        pValor.setpNext(pNew);
    }
 iN++;
 }*/
 
 public void insertar(Nodo x){
    Nodo pNew= x;
    if (esVacio()){
         pFirst=pNew;
         pLast=pNew;
    }else{
        pLast.setpNext(pNew);
        pLast=pNew;    
    }
 iN++;
 }
 
  /*public void insertarPrimero(int x){
    Nodo pNew=new Nodo(x);
    if (esVacio()){
         pFirst=pNew;
         pLast=pNew;
    }else{
        pNew.setpNext(pFirst);
        pFirst=pNew;    
    }
 iN++;
 }*/
 public Nodo buscar(String elemento){
        Nodo aux = pFirst;
        while (aux != null){
            if(aux.getData()==elemento){
                return aux;
            }else{
                aux=aux.getpNext();
            }
        }
     return null;
    }
 
}


