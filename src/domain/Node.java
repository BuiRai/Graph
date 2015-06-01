/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.awt.HeadlessException;

/**
 *
 * @author crhistian
 */
public class Node {
    private String nameNode;
    private int axisX;
    private int axisY;

    public Node(String nameNode, int axisX, int axisY) {
        this.nameNode = nameNode;
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

    @Override
    public String toString() {
        return "Node{" + "nameNode =" + nameNode + ", axisX =" + axisX + 
                ", axisY =" + axisY + '}';
    }
    
    
    
}
