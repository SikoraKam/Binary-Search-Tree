
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {
    private BinarySearchTree bst;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.bst = new BinarySearchTree();
        bst.add(5).add(2).add(3).add(7).add(6).add(8).add(4);
    }


    @org.junit.jupiter.api.Test
    void sumDataInSubTree() {
        assertAll(
                ()-> assertEquals(35,bst.sumDataInSubTree(bst.root)),
                () -> assertEquals(7,bst.sumDataInSubTree(bst.root.left.right)),
                () -> assertEquals(21,bst.sumDataInSubTree(bst.root.right))
        );
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(7,bst.size(bst.root));
    }

    @org.junit.jupiter.api.Test
    void averageValueInSubTree() {
        assertAll(
                ()-> assertEquals(5,bst.averageValueInSubTree(bst.root)),
                ()-> assertEquals(3.5,bst.averageValueInSubTree(bst.root.left.right)),
                () -> assertEquals(7,bst.averageValueInSubTree(bst.root.right))
        );
    }

    @org.junit.jupiter.api.Test
    void findNthElement() {
        assertEquals(4,bst.findNthElement(bst.root,3));
    }

    @org.junit.jupiter.api.Test
    void medianInSubTree() {
        assertAll(
                ()-> assertEquals(5,bst.medianInSubTree(bst.root)),
                ()-> assertEquals(3.5,bst.medianInSubTree(bst.root.left.right)),
                () -> assertEquals(7,bst.medianInSubTree(bst.root.right)),
                () ->  bst.add(1),
                () -> assertEquals(4.5,bst.medianInSubTree(bst.root))
        );
    }
}