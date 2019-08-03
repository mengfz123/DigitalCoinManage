package com.ivan.digitalCoinInvest.test;

import java.util.LinkedList;

/**
 * @创建人：WUHUI
 * @创建时间：2019-7-31
 * @描述：
 **/
public class testit {

    public static void main(String[] args) {
        LinkedList<String> lList = new LinkedList <String>();
        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");
        System.out.println(lList);
        System.out.println("链表的第一个元素是 : " + lList.getFirst());
        System.out.println("链表最后一个元素是 : " + lList.getLast());
        lList.removeFirst();
        lList.addLast("6");
        System.out.println(lList);
    }
}
