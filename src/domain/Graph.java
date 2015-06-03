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
    
    public Node foundNode(String nameNode){
        Node node = null;
        for( Node currentNode : nodes ){
            if (nameNode.equalsIgnoreCase(currentNode.getNameNode())) {
                node = currentNode;
                break;
            }
        }
        return node;
    }
    
    public void printInfoGraph(){
        System.out.println("Nodes:");
        for (Node node : nodes) {
            System.out.print(node + "\n");
        }
        System.out.println("Edges:");
        for (Edge edge : edges) {
            System.out.print(edge + "\n");
        }
        System.out.println("-----------------------------------------------");
    }
    
    public void printSizeEdges(){
        System.out.println(edges.size());
    }
    
    public void printNumbersOfEdges(){
        System.out.println(edges.size());
    }

}
