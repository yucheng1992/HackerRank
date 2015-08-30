public class HuffmanDecoding {
    /*  
    class Node {
        public  int frequency; // the frequency of this tree
        public  char data;
        public  Node left, right;
    }
    */ 

    public String decode(String S ,Node root) {
        String res = "";
        Node node = root;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0') {
                node = node.left;
            } else {
                node = node.right;
            }
            if (node.left == null && node.right == null) {
                res += node.data;
                node = root;
            }
        }
    return res;
    }
}
