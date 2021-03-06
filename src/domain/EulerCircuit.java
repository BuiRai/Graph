/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author crhistian
 */
public class EulerCircuit {
 
    public EulerCircuit (int numberOfNodes, int[][] adjacencyMatrix){
        this.numberOfNodes = numberOfNodes;
        this.adjacencyMatrix = new int[numberOfNodes + 1] [numberOfNodes + 1];
        nodesPath = new ArrayList();
        for (int sourceVertex = 1; sourceVertex <= numberOfNodes; sourceVertex++){
            for (int destinationVertex = 1; destinationVertex <= numberOfNodes; destinationVertex++){
                this.adjacencyMatrix[sourceVertex][destinationVertex]
                   = adjacencyMatrix[sourceVertex-1][destinationVertex-1];
            }
        }
    }
 
    public int degree (int vertex){
        int degree = 0;
        for (int destinationvertex = 1; destinationvertex <= numberOfNodes ; destinationvertex++){
            if (adjacencyMatrix[vertex][destinationvertex] == 1 
                   || adjacencyMatrix[destinationvertex][vertex] == 1){
                degree++;
            }
        }
        return degree;
    }
 
    public int oddDegreeVertex (){
        int vertex = -1;
        for (int node = 1; node <= numberOfNodes; node++) {
            if ((degree(node) % 2) != 0){
                vertex = node;
                break;
            }
        }
        return vertex;
    }
 
    public ArrayList printEulerTourUtil (int vertex){
        
        for (int destination = 1; destination <= numberOfNodes; destination++){
            if(adjacencyMatrix[vertex][destination] == 1 && 
                    isVaildNextEdge(vertex, destination)){
                System.out.println(" source : " + vertex + " destination " + destination);
                /*El -1 es porque esta clase comienza a contar desde 1 y no 
                desde 0*/
                nodesPath.add(vertex-1);
                nodesPath.add(destination-1);
                removeEdge(vertex, destination);
                printEulerTourUtil(destination); 
            }	
        }
        System.out.println(nodesPath);
        return nodesPath;
    }
 
    public ArrayList printEulerTour (){
        ArrayList listOfNodes = new ArrayList();
        int vertex = 1;
        if (oddDegreeVertex() != -1){
            vertex = oddDegreeVertex();
        }
        listOfNodes = printEulerTourUtil(vertex);
        System.out.println(listOfNodes);
        return listOfNodes;
    }
 
    public boolean isVaildNextEdge (int source, int destination){
        int count = 0;
        for (int vertex = 1; vertex <= numberOfNodes; vertex++){
            if (adjacencyMatrix[source][vertex] == 1){
                count++;
            }
        }
        if (count == 1 ){   
            return true;
        }
        int visited[] = new int[numberOfNodes + 1];		
        int count1 = DFSCount(source, visited);
        removeEdge(source, destination);
        for (int vertex = 1; vertex <= numberOfNodes; vertex++){
            visited[vertex] = 0;
        }
        int count2 = DFSCount(source, visited);
       addEdge(source, destination);
       
       return (count1 <= count2);
       //return (count1 > count2 ) ? false : true;
    } 
 
    public int DFSCount (int source, int visited[]){
        visited[source] = 1;
        int count = 1;
        int destination = 1;
 
        while (destination <= numberOfNodes){
            if(adjacencyMatrix[source][destination] == 1 && visited[destination] == 0){
                count += DFSCount(destination, visited);
            }
            destination++;
        }
        return count;
    }
 
    public void removeEdge (int source, int destination){
        adjacencyMatrix[source][destination]  = 0;
        adjacencyMatrix[destination][source] = 0;
    }
 
    public void addEdge (int source, int destination){
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;
    }
    
    private int[][] adjacencyMatrix;
    private int numberOfNodes; 
    private ArrayList nodesPath;
    
}
