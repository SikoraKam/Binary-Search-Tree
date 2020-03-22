//Binary search tree with dupicates (allowed in sample picture)

public class BinarySearchTree {

    Node root;
//---------------Additional functions -------------------------------
    BinarySearchTree add(int data){
        root = nodeInsertion(root,data);
        return this;
    }

    Node nodeInsertion(Node node, int data){
        if(node == null)
            return new Node(data);

        if(data < node.data)
            node.left = nodeInsertion(node.left,data);
        else
            node.right = nodeInsertion(node.right, data);
        return node;
    }

    void printTree(Node node){
        if(node!= null){
            printTree(node.left);
            System.out.println(node.data);
            printTree(node.right);
        }
    }


    //function used in average
    int size(Node node){
        int size = 0;

        if(node == null)
            return 0;
        if(node.left != null)
            size += size(node.left);

        size++;

        if (node.right != null)
            size += size(node.right);
        return size;

    }

    // fuction used in finding median
    int findNthElement(Node node, int n){
        if(node==null)
            return 0;

        int count = size(node.left);

        if(n == count +1)
            return node.data;
        else if(count >= n)
            return findNthElement(node.left,n);
        else
            return findNthElement(node.right,n-count-1);

    }

    //---------------------------------------------------------------

    int sumDataInSubTree(Node node){
        if(node == null)
            return 0;

        return  sumDataInSubTree(node.left) + node.data + sumDataInSubTree(node.right);

    }

    double averageValueInSubTree(Node node){
        return (double) sumDataInSubTree(node)/size(node);
    }



    double medianInSubTree(Node node){
        int size = size(node);
        if(size == 1)
            return node.data;
        if(size%2 == 0)
            return ((double) findNthElement(node,size/2) + (double)findNthElement(node, size/2 + 1))/2;
        else
            return findNthElement(node,size/2 + 1);
    }


    public static void main(String [] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5).add(2).add(3).add(7).add(6).add(8).add(4);
        bst.printTree(bst.root);
        BinarySearchTree bst1 = new BinarySearchTree();

        System.out.println("Sum: " + bst.sumDataInSubTree(bst.root.left.right));
        System.out.println("Average: " + bst.averageValueInSubTree(bst.root.left.right));
        System.out.println("Median: " + bst.medianInSubTree(bst.root));
        bst.add(1);
        System.out.println("Median: " + bst.medianInSubTree(bst.root));



    }
}
