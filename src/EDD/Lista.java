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

    /**
     * @return the pFirst
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public Nodo getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    /**
     * @return the iN
     */
    public int getiN() {
        return iN;
    }

    /**
     * @param iN the iN to set
     */
    public void setiN(int iN) {
        this.iN = iN;
    }
    protected Nodo pFirst;
    protected Nodo pLast;
    protected int iN;
    
public String emptyList(){
        setpFirst(null);
        setiN(0);  
    return "La lista esta vacia";
}

public int numeroNodos(){
    return getiN();
 }
 public boolean isEmpty(){
    return getpFirst()==null;
 }
 public Nodo próximo(Nodo pValor){
    if (pValor!=null){
        pValor=pValor.getpNext();
        return pValor;
    }else{
    return null;
    }
 }
 
 public Object read(Nodo pValor){
    return pValor.getData();
 }
 
 /*public void insertar(Object x, Nodo pValor){
    Nodo pNew=new Nodo(x);
    if (isEmpty()){
         pFirst=pNew;
    }else{
        pNew.setpNext(pValor.getpNext());
        pValor.setpNext(pNew);
    }
 iN++;
 }*/
 
 public void insertarNodo(Nodo x){
    Nodo pNew= x;
    if (isEmpty()){
            setpFirst(pNew);
            setpLast(pNew);
    }else{
            getpLast().setpNext(pNew);
            setpLast(pNew);    
    }
        setiN(getiN() + 1);
 }
 
 public void insertar(Nodo x){
    Nodo pNew= new Nodo(x);
    if (isEmpty()){
            setpFirst(pNew);
            setpLast(pNew);
    }else{
            getpLast().setpNext(pNew);
            setpLast(pNew);    
    }
        setiN(getiN() + 1);
 }
 
  /*public void insertarPrimero(int x){
    Nodo pNew=new Nodo(x);
    if (isEmpty()){
         pFirst=pNew;
         pLast=pNew;
    }else{
        pNew.setpNext(pFirst);
        pFirst=pNew;    
    }
 iN++;
 }*/
 public Nodo buscar(String elemento){
        Nodo aux = getpFirst();
        while (aux != null){
            if(aux.getData().equals(elemento)){
                return aux;
            }else{
                aux=aux.getpNext();
            }
        }
     return null;
    }
 
}


