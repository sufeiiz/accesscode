/**
 * Created by sufeizhao on 5/28/15.
 */
public class MyObjectNode extends MyNode<MyObject> {

    public MyObjectNode(MyNode left, MyNode right, MyObject data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    @Override
    public MyNode getLeft() {
        return this.left;
    }

    public void setLeft(MyNode left) {
        this.left = left;
    }

    @Override
    public MyNode getRight() {
        return this.right;
    }

    public void setRight(MyNode right) {
        this.right = right;
    }

    @Override
    public MyObject getData() {
        return this.data;
    }

    public void setData(MyObject data) {
        this.data = data;
    }

    @Override
    public void insert(MyNode newNode) {
    }
}
