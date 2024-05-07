### Problem
Given the root of a Binary Search Tree (BST), the task is to find the minimum absolute difference between the values of any two different nodes in the tree.

### Approach
- **Inorder Traversal**:
    - Perform an inorder traversal of the BST, which visits nodes in non-decreasing order.
    - During traversal, calculate the absolute difference between adjacent node values and update the minimum difference found.

### Pseudocode
```
FUNCTION getMinimumDifference(root):
    // Initialize variables
    minDiff = Infinity
    prevValue = null
    
    // Define a helper function for inorder traversal
    FUNCTION inorderTraversal(node):
        nonlocal minDiff, prevValue
        
        IF node is null:
            RETURN
        
        // Traverse left subtree
        inorderTraversal(node.left)
        
        // Update minimum difference if a previous value exists
        IF prevValue is not null:
            minDiff = min(minDiff, abs(node.value - prevValue))
        
        // Update previous value
        prevValue = node.value
        
        // Traverse right subtree
        inorderTraversal(node.right)
    
    // Perform inorder traversal starting from the root
    inorderTraversal(root)
    
    // Return the minimum difference found
    RETURN minDiff
END FUNCTION
```