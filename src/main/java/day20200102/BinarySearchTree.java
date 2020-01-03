package day20200102;

import java.nio.BufferUnderflowException;
import java.util.Random;

public class BinarySearchTree <AnyType extends Comparable>{

    private  static class BinaryNode<AnyType>{
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
        BinaryNode(AnyType element){
            this(element,null,null);
        }
        BinaryNode(AnyType element,BinaryNode<AnyType> lt,BinaryNode<AnyType> rt){
            this.element=element;
            this.left=lt;
            this.right=rt;
        }
    }
    private BinaryNode<AnyType> root;
    public BinarySearchTree(){
        root=null;
    }
    public void makeEmpty(){
        root=null;
    }
    public boolean isEmpty(){
        return root==null;
    }
    public boolean contains(AnyType x){
        return contains(x,root);
    }
    public void insert(AnyType x){
        root = insert(x,root);
    }
    public void remove(AnyType x){
        root = remove(x,root);
    }
    public AnyType findMin(){
        if(isEmpty())
            ;
        return findMin(root).element;
    }
    public AnyType findMax(){
        if(isEmpty())
            ;
        return findMax(root).element;
    }
    public void printTree(){
        if(isEmpty()){
            System.out.print("Empty Tree");
        }else{
            printTree(root);
        }
    }
    private boolean contains(AnyType x,BinaryNode<AnyType> t){
        if(t==null){
            return false;
        }
        int state = x.compareTo(t.element);
        if(state>0){
            return contains(x,t.right);
        }else if(state<0){
            return contains(x,t.left);
        }else{
            return true;
        }
    }
    private BinaryNode<AnyType> insert(AnyType x,BinaryNode<AnyType> t){
        if(t==null){
            return new BinaryNode<AnyType>(x);
        }
        int state = x.compareTo(t.element);
        if(state>0){
            t.right = insert(x,t.right);
        }else if(state<0){
            t.left = insert(x,t.left);
        }else;
        return t;

    }
    private BinaryNode<AnyType> remove(AnyType x,BinaryNode<AnyType> t){
        if(t==null){
            return t;
        }
        int state = x.compareTo(t.element);
        if(state>0){
            t.right = remove(x,t.right);
        }else if(state<0){
            t.left = remove(x,t.left);
        }else if(t.left!=null &&t.right!=null){
            t.element = findMin(t.right).element;
            t.right = remove(t.element,t.right);
        }else{
            t = (t.left!=null)?t.left : t.right;
        }
        return t;
    }
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
        if(t==null){
            return null;
        }else if(t.left==null){
            return t;
        }
        return findMin(t.left);

    }
    private BinaryNode<AnyType>findMax(BinaryNode<AnyType> t){
        if(t==null){
            return null;
        }else if(t.right==null){
            return t;
        }
        return findMax(t.right);
    }
    private void printTree(BinaryNode<AnyType> t){
        if(t!=null){
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);

        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        Random rd = new Random();
        for(int i=0;i<100;i++){
            int n = rd.nextInt(500);
            System.out.println(n);
            bst.insert(n);
        }
        bst.printTree();
    }
}
