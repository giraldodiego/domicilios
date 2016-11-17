/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domiciliosdiego;

import java.util.List;

/**
 *
 * @author Diego Giraldo
 */
public class GiraldoAlgorithm {
    private final List<Vertex> nodes;
    private final List<Edge> edges;
    TSPNearest tsp = new TSPNearest();
    
    public GiraldoAlgorithm(Graph graph){
    nodes = graph.getVertexes();
    edges = graph.getEdges();
    }
    
    public int[][] getMatrix(){
        int adjacencyMatrix[][];
        adjacencyMatrix = new int[nodes.size()][nodes.size()];
        int i;
        for(i=0;i<edges.size();i++){
        adjacencyMatrix[Integer.parseInt(edges.get(i).getSource().getId())][Integer.parseInt(edges.get(i).getDestination().getId())] 
                = edges.get(i).getWeight();
        }
        return adjacencyMatrix;
    }
    
    public List<Integer> getShortestPath(int adjacencyMatrix[][]){
        return tsp.tsp(adjacencyMatrix);
    }
    
    public String getUrl(List<Integer> shortest, Dot points[]){
        
    String url = "https://www.google.es/maps/dir/";
    
    for(int i=0;i<shortest.size();i++){
        url = url + String.valueOf(points[shortest.get(i)].lat);
        url = url + ",";
        url = url + String.valueOf(points[shortest.get(i)].lng);
        url = url + "/";
    }
    
        url = url + "@";
        url = url + String.valueOf(points[shortest.get(0)].lat);
        url = url + ",";
        url = url + String.valueOf(points[shortest.get(0)].lng);
        url = url + ",11z/data=!3m1!4b1"; 
        
    return url;
    
    }
    
    
    
    
}
