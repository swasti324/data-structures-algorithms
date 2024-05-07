### Problem
Given the root node of a binary search tree (BST) and two integers `low` and `high`, the task is to find the sum of the values of all nodes in the BST that have values within the inclusive range `[low, high]`.

### Approach
- **Traverse and Sum**:
    - Traverse the BST recursively.
    - At each node:
        - If the node's value is within the range `[low, high]`, add it to the sum.
        - Recursively traverse the left subtree if the node's value is greater than `low`.
        - Recursively traverse the right subtree if the node's value is less than `high`.

### Pseudocode
```
FUNCTION rangeSumBST(root, low, high):
    IF root is null:
        RETURN 0
    END IF
    
    // Initialize sum
    sum = 0
    
    // Recursive traversal
    IF root.value >= low AND root.value <= high:
        sum += root.value
    
    IF root.value > low:
        sum += rangeSumBST(root.left, low, high)
    
    IF root.value < high:
        sum += rangeSumBST(root.right, low, high)
    
    RETURN sum
END FUNCTION
```