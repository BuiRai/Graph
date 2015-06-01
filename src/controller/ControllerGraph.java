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
    
    public void addNodeToGraph(String name, int axisX, int axisY){
        Node node = new Node(name, axisX, axisY);
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
    
}

