package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 3607. 电网维护
 */
public class Solution3607 {
    class Vertex {
        public int vertexId;
        public boolean offline = false;
        public int powerGridId = -1;
        public Vertex() {}

        public Vertex(int id) {
            this.vertexId = id;
        }
    }

    private List<Vertex> vertices = new ArrayList<>();

    private void traverse(Vertex u, int powerGridId, PriorityQueue<Integer> powerGrid,
                          List<List<Integer>> graph) {
        u.powerGridId = powerGridId;
        powerGrid.offer(u.vertexId);
        for (int vid : graph.get(u.vertexId)) {
            Vertex v = vertices.get(vid);
            if (v.powerGridId == -1) {
                traverse(v, powerGridId, powerGrid, graph);
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= c; i++) {
            graph.add(new ArrayList<>());
            vertices.add(new Vertex(i));
        }

        for (int[] conn : connections) {
            int u = conn[0];
            int v = conn[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        List<PriorityQueue<Integer>> powerGrids = new ArrayList<>();

        for (int i = 1, powerGridId = 0; i <= c; i++) {
            Vertex v = vertices.get(i);
            if (v.powerGridId == -1) {
                PriorityQueue<Integer> powerGrid = new PriorityQueue<>();
                traverse(v, powerGridId, powerGrid, graph);
                powerGrids.add(powerGrid);
                powerGridId++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int op = q[0];
            int x = q[1];
            if (op == 1) {
                if (!vertices.get(x).offline) {
                    ans.add(x);
                } else {
                    PriorityQueue<Integer> powerGrid = powerGrids.get(vertices.get(x).powerGridId);
                    while (!powerGrid.isEmpty() && vertices.get(powerGrid.peek()).offline) {
                        powerGrid.poll();
                    }
                    ans.add(!powerGrid.isEmpty() ? powerGrid.peek() : -1);
                }
            } else if (op == 2) {
                vertices.get(x).offline = true;
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
