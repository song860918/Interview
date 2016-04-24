package ds.tree;

public class BuddyTree {

    private IntTreeNode root;
    private int level;

    public BuddyTree(int level, int value) {
        root = addNodes(level, value);
        this.level = level;
    }

    private IntTreeNode addNodes(int level, int value) {
        if (level < 0) {
            return null;
        }

        IntTreeNode curr = new IntTreeNode(value);

        curr.left = addNodes(level - 1, value);
        curr.right = addNodes(level - 1, value);
        return curr;
    }

    public void clearBit(int offset) {
        offset--;

        clearBitHelper(offset - 1, root, level);
    }

    private void clearBitHelper(int offset, IntTreeNode curr, int level) {
        if (level < 0) {
            return;
        }
        clearBitHelper(offset, offset % (int)Math.pow(2.0, (double)(level - 1)) == 0 ? curr.left : curr.right, level - 1);
        curr.val = 0;
    }

    public void setBit(int offset) {
        setBitHelper(offset - 1, root, level, 0);
    }

    private void setBitHelper(int offset, IntTreeNode curr, int level, int currentLevel) {
        int binary = offset % (int)Math.pow(2.0, (double)currentLevel);
        if (binary == 0) {
            if (currentLevel == level) {
                curr.val = 1;
            } else {
                setBitHelper(offset, curr.left, level, currentLevel + 1);
                curr.val = curr.right.val;
            }
        } else {
            if (currentLevel == level) {
                curr.val = 1;
            } else {
                setBitHelper(offset, curr.right, level, currentLevel + 1);
                curr.val = curr.left.val;
            }
        }
    }

}
