### Problem
The problem is to find the element in a binary search tree that is closest to a given query value. 
This involves traversing the tree and comparing the values of nodes to the query, keeping track of the closest value encountered.

### Approach
Traversal Function:
- At each node, calculate the absolute difference between the node's value and the query. 
- Update closest and minDistance if the current node is closer to the query than the previously found closest element. 

Recursive Traversal:
- Recursively traverse the left subtree if the query is less than the current node's value, or the right subtree if it's greater. 
- If the query matches the current node's value exactly, update closest and return, as an exact match has been found. 

Return Result:
- After traversal completes, return the value stored in closest, representing the closest element found to the query in the binary search tree.

### Pseudocode
```
FUNCTION findClosestElement(root, query):
    IF root is null:
        RETURN null
    END IF
    
    closest = null
    minDistance = Infinity
    
    FUNCTION traverse(node):
        IF node is null:
            RETURN
        END IF
        
        distance = abs(node.value - query)
        
        IF distance < minDistance:
            closest = node.value
            minDistance = distance
        END IF
        
        IF query < node.value:
            traverse(node.left)
        ELSE IF query > node.value:
            traverse(node.right)
        ELSE:
            closest = node.value
            RETURN
        END IF
    END FUNCTION
    
    traverse(root)
    RETURN closest
END FUNCTION

```