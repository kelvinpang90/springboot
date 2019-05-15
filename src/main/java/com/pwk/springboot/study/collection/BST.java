package com.pwk.springboot.study.collection;

import org.springframework.lang.NonNull;

import java.util.Iterator;

public class BST<T extends Comparable<T>> extends AbstractTree<T> {
    private TreeNode<T> root;
    private int size = 0;

    public BST(T[] objects) {
        for (T object : objects) insert(object);
    }

    @Override
    public boolean search(T t) {
        TreeNode<T> current = root;
        while(current!=null){
            if(current.element.compareTo(t)>0){
                current = current.left;
            }else if(current.element.compareTo(t)<0){
                current = current.right;

            }else{
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean insert(T t) {
        if(root == null){
            root = new TreeNode<>(t);
        }else{
            TreeNode<T> current = root;
            TreeNode<T> parent = null;
            while(current!=null){
                if(current.element.compareTo(t)>0){
                    parent = current;
                    current = current.left;
                }else if(current.element.compareTo(t)<0){
                    parent = current;
                    current = current.right;
                }else{
                    return false;
                }
            }
            if(t.compareTo(parent.element)>0){
                parent.right = new TreeNode<>(t);
            }else{
                parent.left = new TreeNode<>(t);
            }
        }
        size++;
        return true;
    }

    /**
     * step 1, locate the node will be deleted and also locate its parent
     * step 2, if node has no left child, link the right child to its parent(determine either connect to left or right)
     * step 3, if node has left child,
     * @param t t is the element will be deleted
     * @return true if delete successful,false if element not exist
     */
    @Override
    public boolean delete(T t) {
        TreeNode<T> current = root;
        TreeNode<T> parent = null;
        while(current!=null){
            if(t.compareTo(current.element)>0){
                parent = current;
                current = current.right;
            }else if(t.compareTo(current.element)<0){
                parent = current;
                current = current.left;
            }else
                break;
        }
        if(current == null) return false;   //element t is not in the tree
        //case 1:current has no left child
        //判断需要删除的t是其母节点的左子节点还是右子节点，然后将t的右子节点接上去
        if(current.left == null){
            //删除的点是root，直接将右子节点作为root
            if(parent == null) root = current.right;
            else{
                //如果节点比母节点大，则把节点的右节点作为母节点的右节点，否则作为母节点的做节点
                if(t.compareTo(parent.element)>0)
                    parent.right = current.right;
                else
                    parent.left = current.right;
            }
        }else{
            //找到左子树的最右边的子元素，代替为current element
            TreeNode<T> rightMost = current.left;
            TreeNode<T> rightMostParent = current;
            while(rightMost.right!=null){
                rightMostParent = rightMost;
                rightMost = rightMost.right;
            }

            //处理rightMost的左子数
            if(rightMostParent.right.equals(rightMost))
                rightMostParent.right = rightMost.left;
            else
                rightMostParent.left = rightMost.left;
        }
        size--;
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode<T> root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.element+" ");
        inorder(root.right);
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    private void preorder(TreeNode<T> root){
        if(root == null) return;
        preorder(root.left);
        preorder(root.right);
        System.out.print(root.element+" ");
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    private void postorder(TreeNode<T> root){
        if(root == null) return;
        System.out.print(root.element+" ");
        postorder(root.left);
        postorder(root.right);

    }

    @NonNull
    @Override
    public Iterator iterator() {
        return null;
    }

    public static class TreeNode<T>{
        T element;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T element) {
            this.element = element;
        }
    }
}
