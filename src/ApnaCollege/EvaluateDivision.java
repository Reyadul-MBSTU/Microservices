package ApnaCollege;

import java.util.*;

public class EvaluateDivision {
        class Node {
            String key;
            double val;
            public Node(String k, double v) {
                key = k;
                val = v;
            }
        }

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, List<Node>> g = buildGraph(equations,values);
            double[] result = new double[queries.size()];
            for(int i = 0; i < queries.size(); i++) {
                result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(),g);
            }
            return result;
        }

        public double dfs(String s, String d, Set<String> visited, Map<String, List<Node>> graph) {
            if(!(graph.containsKey(s) && graph.containsKey(d))) {
                return -1.0;
            }
            if(s.equals(d)) return 1.0;
            visited.add(s);
            for(Node ng: graph.get(s)) {
                if(!visited.contains(ng.key)) {
                    double ans = dfs(ng.key,d,visited,graph);
                    if(ans!= -1.0) {
                        return ans*ng.val;
                    }
                }
            }
            return -1.0;
        }

        // Build graph
        public Map<String,List<Node>> buildGraph(List<List<String>> eq,double[] values) {
            Map<String,List<Node>> g = new HashMap<>();
            for(int i = 0; i < values.length;i++) {
                String src = eq.get(i).get(0);
                String des = eq.get(i).get(1);
                g.putIfAbsent(src,new ArrayList<>());
                g.putIfAbsent(des, new ArrayList<>());
                g.get(src).add(new Node(des, values[i]));
                g.get(des).add(new Node(src,1/values[i]));
            }
            return g;
        }

    public static void main(String[] args) {
        List<List<String>> intequations = new ArrayList<>();
        List<String> equation1 = new ArrayList<>();
        equation1.add("a");
        equation1.add("b");
        List<String> equation2 = new ArrayList<>();
        equation2.add("b");
        equation2.add("c");
        intequations.add(equation1);
        intequations.add(equation2);

        double[] list = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        List<String> query1 = new ArrayList<>();
        query1.add("a");
        query1.add("c");
        List<String> query2 = new ArrayList<>();
        query2.add("b");
        query2.add("a");
        List<String> query3 = new ArrayList<>();
        query3.add("a");
        query3.add("e");
        List<String> query4 = new ArrayList<>();
        query4.add("a");
        query4.add("a");
        List<String> query5 = new ArrayList<>();
        query5.add("x");
        query5.add("x");
        queries.add(query1);
        queries.add(query2);
        queries.add(query3);
        queries.add(query4);
        queries.add(query5);

        EvaluateDivision evaluateDivision = new EvaluateDivision();
        double[] res = evaluateDivision.calcEquation(intequations, list, queries);
    }
    }
