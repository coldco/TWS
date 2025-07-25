package exception_finding_modules.device.entity;

import lombok.Data;

import java.util.List;

@Data
public class GraphEntity {
    private List<Node> nodes;
    private List<Edge> edges;

    public static class Node {
        private String id;
        private String label;
        private Object data;

        // Getters and Setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getLabel() { return label; }
        public void setLabel(String label) { this.label = label; }
        public Object getData() { return data; }
        public void setData(Object data) { this.data = data; }
    }

    public static class Edge {
        private String source;
        private String target;
        private String label;
        private Object data;

        // Getters and Setters
        public String getSource() { return source; }
        public void setSource(String source) { this.source = source; }
        public String getTarget() { return target; }
        public void setTarget(String target) { this.target = target; }
        public String getLabel() { return label; }
        public void setLabel(String label) { this.label = label; }
        public Object getData() { return data; }
        public void setData(Object data) { this.data = data; }
    }

    // Getters and Setters for nodes and edges
    public List<Node> getNodes() { return nodes; }
    public void setNodes(List<Node> nodes) { this.nodes = nodes; }
    public List<Edge> getEdges() { return edges; }
    public void setEdges(List<Edge> edges) { this.edges = edges; }
}