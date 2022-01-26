# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        
        if root1 == None and root2 == None:
            return []
        def inorder(root, li):
            if root == None:
                return
            inorder(root.left, li)
            li.append(root.val)
            inorder(root.right,li)
            
        l1, l2 = [],[]
        ans = []
        inorder(root1,l1)
        inorder(root2,l2)
        len1,len2 = len(l1), len(l2)
        i,j=0,0
        while i<len1 and j<len2:
            if l1[i]<=l2[j]:
                ans.append(l1[i])
                i+=1
            else:
                ans.append(l2[j])
                j+=1
                
        while i<len1:
            ans.append(l1[i])
            i+=1
        while j<len2:
            ans.append(l2[j])
            j+=1
        return ans