package com.arraybased;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomSorting {
    public static void main(String[] args) {

        List<Interval> intervals = Lists.newArrayList(
                new Interval(1, 3),
                new Interval(15, 18),
                new Interval(8, 10),
                new Interval(2, 6)


        );

        intervals.sort(Comparator.comparingInt(Interval::getLeft));

        for (Interval interval : intervals)
            System.out.println(interval.getLeft() + " -> " + interval.getRight());

        List<Interval> answer = new ArrayList<>();


        int counter = 1;
        Interval left = intervals.get(0);
        ;
        while (counter < intervals.size()) {
            Interval right = intervals.get(counter);
            if (left.getRight() >= right.getLeft()) {
                left.setRight(Math.max(left.getRight(), right.getRight()));
            } else {
                answer.add(left);
                left = right;
            }
            counter++;
        }
        answer.add(left);

        System.out.println("answer");
        for (Interval interval : answer)
            System.out.println(interval.getLeft() + " -> " + interval.getRight());

    }
}

class Interval {
    private int left;

    public void setLeft(int left) {
        this.left = left;
    }

    public void setRight(int right) {
        this.right = right;
    }

    private int right;

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public Interval(int left, int right) {
        this.left = left;
        this.right = right;
    }

}
