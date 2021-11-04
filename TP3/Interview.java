public class Interview {

    //TODO: completer
    public static TreeNode solution (TreeNode t1, TreeNode t2) {
        TreeNode newNode = new TreeNode();
        if(t1 == null && t2 == null){
            return null;
        }
        else if(t1 != null && t2 != null){
            if(t1.val <= t2.val){
                newNode.val = t1.val;
            }else{
                newNode.val = t2.val;
            }
        }else if (t1 == null){
            return t2;
        }else{
            return t1;
        }
        newNode.left = Interview.solution(t1.left, t2.left);
        newNode.right = Interview.solution(t1.right, t2.right);
        return newNode;
    }
}


