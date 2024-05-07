### Problem
The task involves deleting a node with a given key from a binary search tree (BST) and returning the root node reference of the modified BST. The deletion process consists of two stages:
- Search for the Node to Remove
- Remove it while maintaining the tree structure
### Approach
- **Search and Delete**:
    - Traverse the BST to find the node with the given key to delete.
    - If the node is found:
        - Handle three cases:
            - If the node is a leaf node (has no children), remove it directly.
            - If the node has only one child, replace the node with its child.
            - If the node has two children, find its inorder successor (smallest node in the right subtree) or inorder predecessor (largest node in the left subtree), replace the node's value with the successor/predecessor's value, and recursively delete the successor/predecessor from the right/left subtree.
### Pseudocode
```
FUNCTION deleteNode(root, key):
IF root is null:
RETURN null
END IF

    // Search for the node to delete
    IF key < root.value:
        root.left = deleteNode(root.left, key)
    ELSE IF key > root.value:
        root.right = deleteNode(root.right, key)
    ELSE:
        // Node with the key is found
        IF root.left is null:
            RETURN root.right
        ELSE IF root.right is null:
            RETURN root.left
        END IF
        
        // Node to delete has two children
        successor = findSuccessor(root.right)
        root.value = successor.value
        root.right = deleteNode(root.right, successor.value)
    END IF
    
    RETURN root
END FUNCTION

FUNCTION findSuccessor(node):
WHILE node.left is not null:
node = node.left
END WHILE
RETURN node
END FUNCTION
```