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
    private char abcLetter;
    private int idNode;
    
    public DrawArea(){
        
    }
    
    public DrawArea(JPanel elementsPanel, ControllerGraph controllerGraph) {
        this.elementsPanel = elementsPanel;
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        this.controllerGraph = controllerGraph;
        currentAxisX = 0;
        currentAxisY = 0;
        currentNameNode = "Name";
        abcLetter = 'A';
        idNode = 0;
        setSize(680, 250);
        setBackground(Color.BLACK);
        printElementsFronPanelElement();
        addMouseListener(this);
    }
    
    @Override
    public void paint(Graphics g) {
        paintNodes(g);
        paintEdges(g);
    }
    
    public void paintNodes(Graphics g){
        /*Print all the nodes on the Canvas*/
        for (Node node : nodes) {
            g.setColor(Color.GREEN);
            g.fillOval(node.getAxisX(), node.getAxisY(), 16, 16);
            g.setColor(Color.WHITE);
            g.drawString(node.getNameNode(), node.getAxisX(), node.getAxisY());
        }
    }
    
    public void paintEdges(Graphics g){
        /*Print all the edges on the Canvas*/
        for (Edge edge : edges) {
            g.setColor(Color.CYAN);
            Node nodeIn = edge.getNodeIn();
            Node nodeOut = edge.getNodeOut();
            /*Si no es un lazo*/
            if (edge.getNodeIn() != edge.getNodeOut()) {
//              Node nodeIn = edge.getNodeIn();
                g.drawLine(nodeIn.getAxisX()+8, nodeIn.getAxisY()+8,
                    nodeOut.getAxisX()+8, nodeOut.getAxisY()+8);

                /*Escribir el peso de la arista*/
                g.setColor(Color.WHITE);
                String valueEdge = String.valueOf(edge.getValueEdge());
                int[] coordenates = getNewCoordenates(nodeIn, nodeOut);
                int axisX = coordenates[0];
                int axisY = coordenates[1];
                g.drawString(valueEdge, axisX, axisY);
                
            /*Si es un lazo*/
            }else{
//                Node nodeIn = edge.getNodeIn();
//                Node nodeOut = edge.getNodeOut();
                /*The number 8 is for centering the ends of the edge, cause the diameter
                of a node is 16.*/
                g.drawOval(nodeIn.getAxisX()-30, nodeIn.getAxisY()-5, 45, 25);
                
                /*Escribir el peso de la arista*/
                g.setColor(Color.WHITE);
                String valueEdge = String.valueOf(edge.getValueEdge());
                g.drawString(valueEdge, nodeIn.getAxisX()-40, nodeIn.getAxisY()+10);
            }
        }
    }
    
    public int[] getNewCoordenates(Node first, Node second){
        int middleX = (int)((first.getAxisX()+second.getAxisX())/2);
        int middleY = (int)((first.getAxisY()+second.getAxisY())/2);
        int coordenates[] = new int[2];
        coordenates[0] = middleX;
        coordenates[1] = middleY;
        return coordenates;
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
        Node node = new Node(idNode, currentNameNode, currentAxisX, currentAxisY);
        idNode++;
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
        
        /*Agregar la arista a cada nodo que toca*/
        controllerGraph.addEdgeToNode(nameNodeIn, edge);
        controllerGraph.addEdgeToNode(nameNodeOut, edge);
    }
    
    public void addNewNameToPanelElements(){
        int currentLetter = (int)abcLetter;
        currentLetter++;
        int nextLetter_i = currentLetter;
        abcLetter = (char)nextLetter_i;
        String nextLetter_s = String.valueOf(abcLetter);
        JTextField textField = (JTextField)elementsPanel.getComponent(1);
        textField.setText(nextLetter_s);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        currentAxisX = e.getX();
        currentAxisY = e.getY();
        currentNameNode = getCurrentNameOfNode();
        addNode();
        addNewNameToPanelElements();
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

