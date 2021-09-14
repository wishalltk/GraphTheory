package com.aditya.verma;

import java.util.*;

public class EmpProb {
    public static void main(String[] args) {
        int n = 15;
        int head = 0;
        int[] manager = {-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        int[] time = {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};

        Solution solution = new Solution();
        int op = solution.numOfMinutes(n, head, manager, time);
        System.out.println(op);
    }
}

class Solution {
    int totalTime;
    Map<Integer, List<Employee>> map; // mngr -> employee

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        totalTime = 0;
        int[] processed = new int[manager.length];
        for(int i=0;i<n;i++) {
            int mgr = manager[i]+1;
            processed[mgr] = Math.max(informTime[mgr], processed[mgr]);
        }
        for(int j : processed)
            totalTime += processed[j];
        /*map = new TreeMap<>();
        // Employee root = new Employee(headID, -1, informTime[headID]);
        // List<Employee> list = new ArrayList<>();
        // list.add(root);
        // map.put(-1, list);
        for (int i = 0; i < n; i++) {
            //if(i == headID) continue;
            Employee emp = new Employee(i, manager[i], informTime[i]);
            if (!map.containsKey(manager[i]))
                map.put(manager[i], new ArrayList<>());
            map.get(manager[i]).add(emp);

        }//n = 1, headID = 0, manager = [-1], informTime = [0]

        Map<Integer, Integer> sumMap = new HashMap<>();
        for (Map.Entry<Integer, List<Employee>> entry : map.entrySet()) {
            int mgrId = entry.getKey();
            List<Employee> emps = entry.getValue();
            if (emps == null) continue;
            for (Employee emp : emps) {
                if (sumMap.containsKey(mgrId)) {
                    sumMap.put(mgrId, Math.max(sumMap.get(mgrId), emp.informTime));
                } else {
                    sumMap.put(mgrId, emp.informTime);
                }
                //localMax = Math.max(emp.informTime, localMax);
            }
            //prev = localMax;

        }
        for (Map.Entry<Integer, Integer> ent : sumMap.entrySet()) {
            totalTime += ent.getValue();
        }*/
        return totalTime;
    }
}

class Employee {
    Employee(int id, int manager, int informTime) {
        this.id = id;
        this.manager = manager;
        this.informTime = informTime;
    }

    int id;
    int manager;
    int informTime;
}
