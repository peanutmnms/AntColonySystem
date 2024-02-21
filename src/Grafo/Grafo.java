/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class Grafo {
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
                            aris.setLength(Double.parseDouble(arista[2]));
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
    
    
    public void imprimir(VertexLista v1){
        Vertex aux = (Vertex) v1.getpFirst();
        while(aux!= null){
            System.out.println(aux.getData());
            EdgeLista auxList = (EdgeLista) aux.getAdjacent();
            System.out.println(auxList.recorrer());
//            while (aux2 != null)
//                System.out.print(aux.getData()+", ");
//                aux2 = (Edge) aux2.getpNext();
                
            aux = (Vertex) aux.getpNext();
        }
    }
}
