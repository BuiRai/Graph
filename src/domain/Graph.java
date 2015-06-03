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
    
    public int[][] buildAdjacencyMatrix(){
        int sizeMatrix = nodes.size();
        int[][] adjacencyMatrix = new int[sizeMatrix][sizeMatrix];
        
        int numRow;
        int numCol;
        for (Edge edge : edges) {
            numRow = edge.getNodeIn().getIdNode();
            numCol = edge.getNodeOut().getIdNode();
            
            /*It also puts in reverse order because the adjacency matrix 
            is symmetrical*/
            adjacencyMatrix[numRow][numCol] = 1;
            adjacencyMatrix[numCol][numRow] = 1;
        }
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        
        return adjacencyMatrix;
    }

}
