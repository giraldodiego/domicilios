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
    public GiraldoAlgorithm(Graph graph){
    nodes = graph.getVertexes();
    edges = graph.getEdges();
    }
    
    
    
}
