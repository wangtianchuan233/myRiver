package com.exercise.util;


/**
 * 王天传
 * 2021/1/9 0009 12:52
 */
public class MyTreeSet <T extends Comparable>{
    Node<T> node = new Node<T>();

    /**
     * 添加元素
     */
    public boolean add(T e){
        return node.add(e);
    }

    /**
     * TODO 判断元素是否存在
     */
    public boolean contains(T e){
        return false;
    }

    /**
     * TODO 删除元素
     */
    public boolean remove(T e){
        return false;
    }

    /**
     * 中序遍历 MyTreeSet 中的元素并打印至控制台
     */
    public void middleList(){
        node.middleList();
    }

    /**
     * TODO 中序遍历的顺序把 MyTreeSet 转换为数组
     */
    public void toArray(){

    }
    /**
     * 节点内部类
     */
    private static class Node<E extends Comparable> {
        Node left;
        Node right;
        E value;
        int size;
        boolean add(E e){
            if (value == null){
                value = e;
                size += 1;
                return true;
            }
            if (e.compareTo(value) < 0){
                if (left == null){
                    left = new Node();
                }
                left.add(e);
                size += 1;
                return true;
            }
            if (e.compareTo(value) > 0){
                if (right == null){
                    right = new Node();
                }
                right.add(e);
                size += 1;
                return true;
            }
            return false;
        }
        void middleList(){
            if (this.left != null){
                this.left.middleList();
            }
            System.out.println(value);
            if (this.right!= null){
                this.right.middleList();
            }
        }

    }
}

