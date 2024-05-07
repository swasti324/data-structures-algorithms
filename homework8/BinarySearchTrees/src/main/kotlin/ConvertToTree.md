
### Problem
The task involves converting a sorted list of numbers into a balanced tree. 
Each node in the tree must follow a rule: smaller numbers go to the left, and larger numbers go to the right. 
A balanced tree ensures that both sides of the tree are nearly the same height, making it easier to search. 

### Approach
- Find the middle index of the list by dividing its length by 2.
- Extract the value at the middle index to create a new tree node. (Choosing middle index to keep it balanced)
- Recursively:
    - Build the left subtree using the portion of the list before the middle index.
    - Build the right subtree using the portion of the list after the middle index.
- Attach the left and right subtrees to the current node.
- Return the current node, representing the root of the subtree.

### Pseudocode
```
FUNCTION sortedArrayToBST(nums):
IF nums is empty:
RETURN nullptr
END IF

middleIndex = length(nums) / 2
middleValue = nums[middleIndex]

// Create a new TreeNode with middleValue
node = new TreeNode(middleValue)

// Recursively construct left and right subtrees
node.left = sortedArrayToBST(nums[0:middleIndex])
node.right = sortedArrayToBST(nums[middleIndex+1:end])

RETURN node
END FUNCTION
```