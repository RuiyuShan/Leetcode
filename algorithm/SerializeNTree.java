package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shanruiyu <shanruiyu@kuaishou.com>
 * Created on 2021-12-28
 */
public class SerializeNTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // 含义：将一个Node序列化为"parent[child_1,child_2...child_n]"的形式
    public String serialize(Node root) {
        if (root == null) {
            return "NULL";
        }
        if (root.children.isEmpty()) {
            return String.valueOf(root.val);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append("[");
        for (Node c : root.children) {
            sb.append(serialize(c));
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // 含义：将一个形为"parent[child_1,child_2...child_n]"的字符串反序列化为Node
    public Node deserialize(String data) {
        if (data.equals("NULL")) {
            return null;
        }
        if (!data.contains("[")) {
            return new Node(Integer.parseInt(data), new ArrayList<>());
        }
        int val = Integer.parseInt(data.substring(0, data.indexOf('[')));
        Node root = new Node(val, new ArrayList<>());
        List<String> cStr = parse(data.substring(data.indexOf('[') + 1, data.length() - 1));
        for (String c : cStr) {
            root.children.add(deserialize(c));
        }
        return root;
    }

    private List<String> parse(String s) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        List<String> res = new LinkedList<>();
        int leftBrackets = 0;
        for (char ch : c) {
            if (ch == '[') {
                leftBrackets++;
            } else if (ch == ']') {
                leftBrackets--;
            } else if (ch == ',') {
                if (leftBrackets == 0) {
                    res.add(sb.toString());
                    sb.delete(0,sb.length());
                    continue;
                }
            }
            sb.append(ch);
        }
        res.add(sb.toString());
        return res;
    }


}
