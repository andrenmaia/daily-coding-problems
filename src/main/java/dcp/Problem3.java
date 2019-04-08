package dcp;

import java.util.*;
import java.lang.*;

public class Problem3 {

    public static class Node {
        public String val;
        public Node left;
        public Node right;

        public static final String END_MARKER = "END";
        public static final String NODE_MAKER = ",";

        public Node(String val) {
            this(val, null, null);
        }
        public Node(String val, Node left) {
            this(val, left, null);
        }
        public Node(String val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public void traversePreorder(Node current, StringBuilder builder) {
            if (current == null) {
                builder.append(END_MARKER).append(NODE_MAKER);
                return;
            }

            builder.append(current.val).append(NODE_MAKER);
            traversePreorder(current.left, builder);
            traversePreorder(current.right, builder);
        }

        public static String serialize(Node current) {
            return current.toString();
        }

        private static Node deserialize(Iterator<String> content) {

            if (!content.hasNext()) {
                return null;
            }

            String current = content.next();
            
            if (END_MARKER.equals(current)) {
                return null;
            }

            Node root = new Node(current);
            root.left = deserialize(content);
            root.right = deserialize(content);

            return root;
        }

        public static Node deserialize(String data) {
            List<String> content = Arrays.asList(data.split(NODE_MAKER));
            Node root = deserialize(content.iterator());
            
            return root;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            traversePreorder(this, builder);

            return builder.toString();
        }
    }
}