package Chapter4;

public class CheckTreeBalanced
{
    public boolean checkTreeBalance(TreeNode node) {
        return Math.abs(node.left.getHeight() - node.right.getHeight()) == 1;
    }
}
