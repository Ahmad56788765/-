class BinaryTreeNode<T extends Comparable<T>> {
    T data;                      // Значение узла
    BinaryTreeNode<T> left;      // Левый потомок
    BinaryTreeNode<T> right;     // Правый потомок

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BinarySearchTree<T extends Comparable<T>> {
    private BinaryTreeNode<T> root; // Корневой узел дерева

    // Вставляем новое значение в дерево
    public void insert(T data) {
        root = insertRecursive(root, data);
    }

    private BinaryTreeNode<T> insertRecursive(BinaryTreeNode<T> current, T data) {
        if (current == null) {
            return new BinaryTreeNode<>(data);
        }

        if (data.compareTo(current.data) < 0) {
            current.left = insertRecursive(current.left, data);
        } else if (data.compareTo(current.data) > 0) {
            current.right = insertRecursive(current.right, data);
        }
        return current;
    }

    // Поиск значения в дереве
    public boolean search(T key) {
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(BinaryTreeNode<T> current, T key) {
        if (current == null) {
            return false;
        }
        if (key.compareTo(current.data) == 0) {
            return true;
        }
        return key.compareTo(current.data) < 0 ? searchRecursive(current.left, key) : searchRecursive(current.right, key);
    }

    // Обход дерева PreOrder (корень -> левое поддерево -> правое поддерево)
    public void preOrderTraversal() {
        preOrderRecursive(root);
    }

    private void preOrderRecursive(BinaryTreeNode<T> current) {
        if (current != null) {
            System.out.print(current.data + " ");
            preOrderRecursive(current.left);
            preOrderRecursive(current.right);
        }
    }

    // Обход дерева InOrder (левое поддерево -> корень -> правое поддерево)
    public void inOrderTraversal() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(BinaryTreeNode<T> current) {
        if (current != null) {
            inOrderRecursive(current.left);
            System.out.print(current.data + " ");
            inOrderRecursive(current.right);
        }
    }

    // Обход дерева PostOrder (левое поддерево -> правое поддерево -> корень)
    public void postOrderTraversal() {
        postOrderRecursive(root);
    }

    private void postOrderRecursive(BinaryTreeNode<T> current) {
        if (current != null) {
            postOrderRecursive(current.left);
            postOrderRecursive(current.right);
            System.out.print(current.data + " ");
        }
    }

    // Удаление узла из дерева
    public void delete(T key) {
        root = deleteRecursive(root, key);
    }

    private BinaryTreeNode<T> deleteRecursive(BinaryTreeNode<T> current, T key) {
        if (current == null) {
            return current;
        }

        if (key.compareTo(current.data) < 0) {
            current.left = deleteRecursive(current.left, key);
        } else if (key.compareTo(current.data) > 0) {
            current.right = deleteRecursive(current.right, key);
        } else {
            // Случаи для одного ребенка или отсутствия детей
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            // Найдем минимальный элемент правого поддерева
            current.data = findMinValue(current.right);
            current.right = deleteRecursive(current.right, current.data);
        }
        return current;
    }

    // Нахождение минимального значения в правом поддереве
    private T findMinValue(BinaryTreeNode<T> node) {
        T minVal = node.data;
        while (node.left != null) {
            minVal = node.left.data;
            node = node.left;
        }
        return minVal;
    }
}
public class Main5 {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Вставка элементов
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);
        bst.insert(14);
        bst.insert(4);
        bst.insert(7);
        bst.insert(13);

        // Обходим дерево различными способами
        System.out.println("Preorder traversal:");
        bst.preOrderTraversal(); // 8 3 1 6 4 7 10 14 13
        System.out.println("\nInorder traversal:");
        bst.inOrderTraversal(); // 1 3 4 6 7 8 10 13 14
        System.out.println("\nPostorder traversal:");
        bst.postOrderTraversal(); // 1 4 7 6 3 13 14 10 8

        // Ищем значение в дереве
        System.out.println("\nIs 6 present? " + bst.search(6)); // true
        System.out.println("Is 15 present? " + bst.search(15)); // false

        // Удаляем узел
        bst.delete(10);
        System.out.println("\nAfter deleting 10, inorder traversal:");
        bst.inOrderTraversal(); // 1 3 4 6 7 8 13 14
    }
}
