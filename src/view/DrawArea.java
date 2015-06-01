/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerGraph;
import domain.Edge;
import domain.Node;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author crhistian
 */
public class DrawArea extends Canvas implements MouseListener{
    private JPanel elementsPanel;
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;
    private ControllerGraph controllerGraph;
    private int currentAxisX;
    private int currentAxisY;
    private String currentNameNode;
    
    public DrawArea(){
        
    }
    
    public DrawArea(JPanel elementsPanel) {
        this.elementsPanel = elementsPanel;
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        controllerGraph = new ControllerGraph();
        currentAxisX = 0;
        currentAxisY = 0;
        currentNameNode = "Name";
        setSize(680, 425);
        setBackground(Color.WHITE);
        printElementsFronPanelElement();
        addMouseListener(this);
    }
    
    @Override
    public void paint(Graphics g) {
        /*Print all the nodes on the Canvas*/
        for (Node node : nodes) {
            g.setColor(Color.GREEN);
            g.fillOval(node.getAxisX(), node.getAxisY(), 15, 15);
            g.setColor(Color.BLACK);
            g.drawString(node.getNameNode(), node.getAxisX(), node.getAxisY());
        }
        
        /*Print all the edges on the Canvas*/
        for (Edge edge : edges) {
            g.setColor(Color.BLACK);
            Node nodeIn = edge.getNodeIn();
            Node nodeOut = edge.getNodeOut();
            g.drawLine(nodeIn.getAxisX(), nodeIn.getAxisY(),
                nodeOut.getAxisX(), nodeOut.getAxisY());
        }
        
    }
    
    private void printElementsFronPanelElement(){
        /*Solo para imprimir los componentes del panel de elementos*/
        Component[] components = elementsPanel.getComponents();
        for (Component component : components) {
            System.out.println(component);
        }
    }
    
    private String getCurrentNameOfNode(){
        JTextField textField = (JTextField)elementsPanel.getComponent(1);
        String currentName = textField.getText();
        textField.setText("Nombre");
        return currentName;
    }
    
    private void addNode(){
        /*Add a node on this Canvas to paint*/
        Node node = new Node(currentNameNode, currentAxisX, currentAxisY);
        nodes.add(node);
        /*Add a node to the clas Graph to made all the bussines logical*/
        controllerGraph.addNodeToGraph(node);
    }
    
    public Node foundNode(String name){
        Node node = null;
        for (Node currentNode : nodes) {
            String currentName = currentNode.getNameNode();
            if (currentName.equalsIgnoreCase(name)) {
                node = currentNode;
                break;
            }
        }
        return node;
    }
    
    public void addEdge(int valueEdge, String nameNodeIn, String nameNodeOut){
        /*Add an edge on this Canvas to paint*/
        Node nodeIn = foundNode(nameNodeIn);
        Node nodeOut = foundNode(nameNodeOut);
        Edge edge = new Edge(valueEdge, nodeIn, nodeOut);
        edges.add(edge);
        /*Add a node to the clas Graph to made all the bussines logical*/
        controllerGraph.addEdgeToGraph(edge);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        currentAxisX = e.getX();
        currentAxisY = e.getY();
        currentNameNode = getCurrentNameOfNode();
        addNode();
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
