/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import EDD.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class GrafManager {

    /**
     * @return the vertices
     */
    public VertexLista getVertices() {
        return vertices;
    }

    /**
     * @param vertices the vertices to set
     */
    public void setVertices(VertexLista vertices) {
        this.vertices = vertices;
    }
    protected VertexLista vertices;
    
    public static VertexLista read_text(File file){
        VertexLista vl = new VertexLista();
        
        String read="";
        String line="";
        try{
                   
            if(!file.exists()){
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line=br.readLine())!=null){
                    if (!line.isEmpty()){
                        read+=line+"\n";
                    }
                }
                br.close();
                if(!read.isEmpty()){
                    String[] lines = read.split("\n");
                    
                    int readingOp = 0;
                    for(int i=0; i < lines.length ;i++){  
                        if(lines[i].trim().equals("ciudad")){
                            readingOp = 0;
                        }else if(lines[i].trim().equals("aristas")){
                            readingOp = 1;                            
                        }else if( readingOp == 0){
                            Vertex ver = new Vertex(lines[i]);
                            vl.insertarNodo(ver);
                        }else if(readingOp==1){
                            String[] arista = lines[i].split(",");
                            //agrega aristas tal cual como salen en el txt para crear el grafo (pero las aristas solo estan vinculadas en una direccion)
                            Edge aris = new Edge(vl.buscar(arista[1]));
                            aris.setLength(Double.parseDouble(arista[2]));
                            vl.buscarVertex(arista[0]).addAdjacent(aris);
                            
                            //agregando aristas de forma inversa para que sea un grafo no dirigido 
                            Edge aris2 = new Edge(vl.buscar(arista[0]));
                            aris2.setLength(Double.parseDouble(arista[2]));
                            vl.buscarVertex(arista[1]).addAdjacent(aris2);
                            
                        }
                    }
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No ha importado ningun archivo");
        }
    return vl;   
    }

    public void imprimir(){
        Vertex aux = (Vertex) this.vertices.getpFirst();
        while(aux!= null){
            System.out.println(aux.getData());
            EdgeLista auxList = (EdgeLista) aux.getAdjacent();
            System.out.println(auxList.recorrer());
            Edge auxE = (Edge) auxList.getpFirst();
            while (auxE.getpNext() != null){
                System.out.println(auxE.getLength());
                auxE = (Edge) auxE.getpNext();
            }
                
            
//            while (aux2 != null)
//                System.out.print(aux.getData()+", ");
//                aux2 = (Edge) aux2.getpNext();
                
            aux = (Vertex) aux.getpNext();
        }
    }
    
    public void addVertex(String ciudad, String aristas){
        Vertex ver = new Vertex(ciudad);
        this.vertices.insertarNodo(ver);
        
        
        String[] lines = aristas.split("\n");
        for(int i=0; i < lines.length ;i++){
            String[] arista = lines[i].split(",");
            //agrega aristas tal cual como salen en el txt para crear el grafo (pero las aristas solo estan vinculadas en una direccion)
            Edge aris = new Edge(this.vertices.buscar(arista[1]));
            aris.setLength(Double.parseDouble(arista[2]));
            this.vertices.buscarVertex(arista[0]).addAdjacent(aris);

            //agregando aristas de forma inversa para que sea un grafo no dirigido 
            Edge aris2 = new Edge(this.vertices.buscar(arista[0]));
            aris.setLength(Double.parseDouble(arista[2]));
            this.vertices.buscarVertex(arista[1]).addAdjacent(aris2); 
        }
    }
    
    public void deleteVertex(String ciudad){
        
    }
    
    public void write_txt(){
        String info = "";
        String path = "test/info.txt";
        String aristas = "";
        info += "ciudad\n";
        String ciudades=""; 
        
        if (!this.vertices.isEmpty()) {
            Vertex auxV = (Vertex) vertices.getpFirst();
            while(auxV!=null){
                Edge auxE = (Edge) auxV.getAdjacent().getpFirst();
                
                while(auxE!=null){
                    
                    if (!ciudades.contains((String) auxE.getDest().getData())) {
                        String infoArista = auxV.getData() + "," + auxE.getDest().getData()+ "," + String.valueOf(auxE.getLength());
                        aristas += infoArista + "\n";   
                    }
                    auxE = (Edge) auxE.getpNext();  
                }
                ciudades+= (String) auxV.getData() + " ";
                
                info += (String) auxV.getData() + "\n";
                auxV = (Vertex) auxV.getpNext();
            }           
        }
        
        info += "aristas\n";
        info += aristas;
        
        try{
            File file = new File(path);
            PrintWriter pw = new PrintWriter(file);
            pw.print(info);
            pw.close();  
        }catch (Exception e){
            
        }
                
    }
    
    public void deleteVertex(Nodo x){
        Vertex aux= (Vertex) vertices.getpFirst();
        while(aux != null){
            aux.deleteEdge(x); 
            aux =(Vertex) aux.getpNext();
        }
        vertices.deleteNodo(x);
        
    }
    
}
