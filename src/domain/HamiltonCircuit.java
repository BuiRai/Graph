/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author crhistian
 */
public class HamiltonCircuit {
    private int V, pathCount;
    private int[] path;     
    private int[][] graph;
 
    /** Function to find cycle
     * @param g the matrix
     * @return  **/
    public ArrayList findHamiltonianCycle(int[][] g){
        ArrayList nodes = new ArrayList();
        V = g.length;
        path = new int[V];
 
        Arrays.fill(path, -1);
        graph = g;        
        try{            
            path[0] = 0;
            pathCount = 1;            
            solve(0);
            System.out.println("No solution");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            nodes = display();
        }
        return nodes;
    }
    /** function to find paths recursively **/
    public void solve(int vertex) throws Exception{
        /** solution **/
        if (graph[vertex][0] == 1 && pathCount == V)
            throw new Exception("Solution found");
        /** all vertices selected but last vertex not linked to 0 **/
        if (pathCount == V)
            return;
 
        for (int v = 0; v < V; v++){
            /** if connected **/
            if (graph[vertex][v] == 1 ){
                /** add to path **/            
                path[pathCount++] = v;    
                /** remove connection **/            
                graph[vertex][v] = 0;
                graph[v][vertex] = 0;
 
                /** if vertex not already selected  solve recursively **/
                if (!isPresent(v))
                    solve(v);
 
                /** restore connection **/
                graph[vertex][v] = 1;
                graph[v][vertex] = 1;
                /** remove path **/
                path[--pathCount] = -1;                    
            }
        }
    }    
    /** function to check if path is already selected
     * @param v
     * @return boolean **/
    public boolean isPresent(int v){
        for (int i = 0; i < pathCount - 1; i++)
            if (path[i] == v)
                return true;
        return false;                
    }
    
    /** display solution
     * @return  Array of nodes**/
    public ArrayList display(){
        ArrayList nodes = new ArrayList();
        for (int i = 0; i <= V; i++){
            System.out.print(path[i % V] +" ");
            nodes.add(i%V);
        }
        return nodes;
    }     
}
