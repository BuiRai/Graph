/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.awt.HeadlessException;
import java.util.ArrayList;

/**
 *
 * @author crhistian
 */
public class Node {
    private int idNode;
    private String nameNode;
    private ArrayList<Edge> edges;
    private int axisX;
    private int axisY;

    public Node(int idNode, String nameNode, int axisX, int axisY) {
        this.idNode = idNode;
        this.nameNode = nameNode;
        edges = new ArrayList<>();
        this.axisX = axisX;
        this.axisY = axisY;
    }

    public Node() throws HeadlessException {
        this.nameNode = "node";
        this.axisX = 0;
        this.axisY = 0;
    }
    
    public int getIdNode(){
        return idNode;
    }

    public String getNameNode() {
        return nameNode;
    }
    
    public int getAxisX() {
        return axisX;
    }

    public int getAxisY() {
        return axisY;
    }
    
    public void addEdgeToNode(Edge edge){
        edges.add(edge);
    }

    @Override
    public String toString() {
        String info = "Node{" + "ID = "+ idNode + ", nameNode = " + nameNode + 
                ", axisX = " + axisX + ", axisY = " + axisY + "}::Edges: ";
        for (Edge edge : edges) {
            info += "{ Value: "+edge.getValueEdge()+" }";
        }
        return  info;
    }
    
}
