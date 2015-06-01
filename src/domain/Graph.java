/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author crhistian
 */
public class Graph {
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;

    public Graph() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }
    
    public void addNode(Node node){
        nodes.add(node);
    }
    
    public void addEdge(Edge edge){
        edges.add(edge);
    }
    
    public void buldAdjacencyMatrix(){
        int numRows = nodes.size();
        int [][] adjacencyMatrix = new int[numRows][numRows];
    }

}
