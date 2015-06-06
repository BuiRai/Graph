/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Edge;
import domain.Exporter;
import domain.Graph;
import domain.Node;
import java.awt.Canvas;

/**
 *
 * @author crhistian
 */
public class ControllerGraph {
    private Graph graph;
    private Exporter exporter;

    public ControllerGraph() {
        graph = new Graph();
        exporter = new Exporter();
    }
    
    public void addNodeToGraph(int idNode, String name, int axisX, int axisY){
        Node node = new Node(idNode, name, axisX, axisY);
        graph.addNode(node);
    }
    
    public void addNodeToGraph(Node node){
        graph.addNode(node);
    }
    
    public void addEdgeToGraph(int valueEdge, Node nodeIn, Node nodeOut){
        Edge edge = new Edge(valueEdge, nodeIn, nodeOut);
        graph.addEdge(edge);
    }
    
    public void addEdgeToGraph(Edge edge){
        graph.addEdge(edge);
    }
    
    public void addEdgeToNode(String nameNode, Edge edge){
        Node node = graph.foundNode(nameNode);
        node.addEdgeToNode(edge);
    }
    
    public void printInfoGraph(){
        graph.printInfoGraph();
    }
    
    public String getAdjacencyMatrix(){
        String adjacencyMatrix = "";
        int[][] adjacencyMatrix_i = graph.buildAdjacencyMatrix();
        for (int i = 0; i < adjacencyMatrix_i.length; i++) {
            for (int j = 0; j < adjacencyMatrix_i.length; j++) {
                adjacencyMatrix += adjacencyMatrix_i[i][j] + " ";
            }
            adjacencyMatrix += "\n";
        }
        return adjacencyMatrix;
    }
    
    public String getShortenedPath(String nameNodeIn, String nameNodeOut){
        Node nodeIn = graph.foundNode(nameNodeIn);
        Node nodeOut = graph.foundNode(nameNodeOut);
        String shortenedPath = graph.getShortenedPath(nodeIn, nodeOut);
        return shortenedPath;
    }
    
    public void exportGraphToPNG(Canvas canvas){
        exporter.saveImageToPNG(canvas);
    }
    
    public String showCircuitEuler(){
        String nodesPath = graph.getEulerCircuit();
        return nodesPath;
    }
    
    public String showCircuitHamilton(){
        String nodesPath = graph.getHamiltonCircuit();
        return nodesPath;
    }
    
}

