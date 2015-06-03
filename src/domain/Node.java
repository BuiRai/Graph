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
    private String nameNode;
    private ArrayList<Edge> edges;
    private int axisX;
    private int axisY;

    public Node(String nameNode, int axisX, int axisY) {
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
        String info = "Node{" + "nameNode =" + nameNode + ", axisX =" + axisX + 
                ", axisY =" + axisY + "}\nEdges: ";
        for (Edge edge : edges) {
            info += "{ Value: "+edge.getValueEdge()+" }";
        }
        return  info;
    }
    
    
    
}
