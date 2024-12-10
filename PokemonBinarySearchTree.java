public class PokemonBinarySearchTree {

    PokemonBstNode root;

    PokemonBinarySearchTree() {
        root = null;
    }

    void insertCard(PokemonCard card) {

        PokemonBstNode newNode = new PokemonBstNode(card);

        if (root == null) {
            root = newNode;
        } else {
            PokemonBstNode currentNode = root;
            while (currentNode != null) {
                if (newNode.key.getName().compareTo(currentNode.key.getName()) < 0) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        currentNode = null;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        currentNode = null;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }
    }

    public PokemonCard search(String searchKey) {
        PokemonBstNode currentNode = root;
        while (currentNode != null) {
            if (searchKey.equalsIgnoreCase(currentNode.key.getName())) {
                return currentNode.key;
            } else if (searchKey.compareToIgnoreCase(currentNode.key.getName()) < 0) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return null;
    }

}
