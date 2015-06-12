/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author crhistian
 */
public class Graph {
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;

    public Graph(ArrayList<Node> nodes, ArrayList<Edge> edges){
        this.nodes = nodes;
        this.edges = edges;
    }
    
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

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
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
        
        return adjacencyMatrix;
    }
    
    public String getShortenedPath(Node nodeIn, Node nodeOut){
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(this);
        dijkstra.execute(nodeIn);
        LinkedList<Node> path = dijkstra.getPath(nodeOut);
        
        String shortenestPath = "";
        for (Node vertex : path) {
            shortenestPath += vertex.getNameNode()+"  -> ";
        }
        
        return shortenestPath;
    }
    
    public String getEulerCircuit(){
        ArrayList nodesPath = new ArrayList();
        int numberOfNodes = nodes.size();
        int[][] adjacencyMatrix = buildAdjacencyMatrix();
        String informationEuler = "";
        EulerCircuit eulerCircuit = new EulerCircuit(numberOfNodes, adjacencyMatrix);
        nodesPath = eulerCircuit.printEulerTour();
        if (!nodesPath.isEmpty()) {
            for (int i = 0; i < nodesPath.size(); i++) {
                String nodeSource = "Fuente: " + 
                        nodes.get((int)nodesPath.get(i)).getNameNode() + " --> ";
                System.out.print(nodeSource);
                i++;
                String nodeDestiny = "Destino: " + 
                        nodes.get((int)nodesPath.get(i)).getNameNode() + "\n";
                System.out.print(nodeDestiny);
                informationEuler = informationEuler + nodeSource + nodeDestiny;
            }
        }else{
            informationEuler = "No se ha encontrado un circuito de Euler";
        }
        return informationEuler;
    }
    
    public String getHamiltonCircuit(){
        String nodesPath = "";
        ArrayList nodesHamilton = new ArrayList();
        int[][] adjacencyMatrx = buildAdjacencyMatrix();
        HamiltonCircuit hamiltonCircuit = new HamiltonCircuit();
        nodesHamilton = hamiltonCircuit.findHamiltonianCycle(adjacencyMatrx);
        
        if (!nodesHamilton.isEmpty()) {
            for (Object idNode : nodesHamilton) {
                nodesPath += this.nodes.get((int)idNode).getNameNode() +  " -> ";
            }
        }else{
            nodesPath = "No se ha encontrado un circuito de Hamilton";
        }
        return nodesPath;
    }

}
