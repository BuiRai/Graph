/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author crhistian
 */
public class Edge {
    private String nameEdge;
    private int valueEdge;
    private Node nodeIn;
    private Node nodeOut;

    public Edge() {
    }

    public Edge(int valueEdge, Node nodeIn, Node nodeOut) {
        this.valueEdge = valueEdge;
        this.nodeIn = nodeIn;
        this.nodeOut = nodeOut;
    }

    public String getNameEdge() {
        return nameEdge;
    }

    public int getValueEdge() {
        return valueEdge;
    }
    
    public Node getNodeIn() {
        return nodeIn;
    }

    public Node getNodeOut() {
        return nodeOut;
    }
    
}