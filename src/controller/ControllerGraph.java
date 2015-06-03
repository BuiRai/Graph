/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Edge;
import domain.Graph;
import domain.Node;

/**
 *
 * @author crhistian
 */
public class ControllerGraph {
    private Graph graph;

    public ControllerGraph() {
        graph = new Graph();
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
    
    public void imprimeNumeroDeAristas(){
        graph.printNumbersOfEdges();
    }
    
}

