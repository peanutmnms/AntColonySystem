/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;
import EDD.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class VertexEdge {
    
    public static VertexEdge read_text(File file){
        VertexLista VertexList = new VertexLista();
        EdgeLista EdgeList = new EdgeLista();
        
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
                            Vertex ver = new Vertex(line);
                            VertexList.insertar(ver);                              
                        }else if(readingOp==1){
                            String[] arista = line.split(",");
                            Edge aris = new Edge(VertexList.buscar(arista[1]));
                            aris.setLength(Double.parseDouble(arista[2]));
                            VertexList.buscarVertex(arista[0]).addAdjacent(aris);
                        }
                    }
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "FAIL");
        }
        return null;
        
    }
}
