/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author crhistian
 */
public class TestDijkstraAlgorithm {
     private ArrayList<Node> nodes;
     private ArrayList<Edge> edges;
     
      public void testExcute() {
    nodes = new ArrayList<Node>();
    edges = new ArrayList<Edge>();
//    for (int i = 0; i < 11; i++) {
//      Node location = new Node("Node_" + i, "Node_" + i);
//      nodes.add(location);
//    }
    for (int i = 0; i < 6; i++) {
      Node location = new Node(i, "Node_" + i,0,0);
      nodes.add(location);
    }
    
          addLane("Edge_0", 0, 1, 1);
          addLane("Edge_1", 0, 2, 1);
          addLane("Edge_2", 1, 3, 1);
          addLane("Edge_3", 2, 3, 1);
          addLane("Edge_4", 3, 4, 5);
          addLane("Edge_5", 2, 5, 1);
          

//    addLane("Edge_0", 0, 1, 85);
//    addLane("Edge_1", 0, 2, 217);
//    addLane("Edge_2", 0, 4, 173);
//    addLane("Edge_3", 2, 6, 186);
//    addLane("Edge_4", 2, 7, 103);
//    addLane("Edge_5", 3, 7, 183);
//    addLane("Edge_6", 5, 8, 250);
//    addLane("Edge_7", 8, 9, 84);
//    addLane("Edge_8", 7, 9, 167);
//    addLane("Edge_9", 4, 9, 502);
//    addLane("Edge_10", 9, 10, 40);
//    addLane("Edge_11", 1, 10, 600);

    // Lets check from location Loc_1 to Loc_10
    Graph graph = new Graph(nodes, edges);
    DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
    dijkstra.execute(nodes.get(0));
    LinkedList<Node> path = dijkstra.getPath(nodes.get(5));
    
    
    for (Node vertex : path) {
      System.out.println(vertex);
    }
    
  }
      
    private void addLane(String laneId, int sourceLocNo, int destLocNo, int duration) {
      Node nodeIn = nodes.get(sourceLocNo);
      Node nodeOut = nodes.get(destLocNo);
      Edge lane = new Edge(laneId, duration, nodeIn, nodeOut);
      edges.add(lane);
  }
       
    public static void main(String[] args) {
        TestDijkstraAlgorithm t = new TestDijkstraAlgorithm();
        t.testExcute();
    }

}
