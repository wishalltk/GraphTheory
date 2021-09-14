package com.heap;

import com.google.common.collect.Lists;
import javafx.util.Pair;
import lombok.Builder;

import java.util.*;

public class HeapApplications {

    static Scanner scanner;

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Lists.newArrayList(961148050, 385599125));
        list.add(Lists.newArrayList(951133776, 376367013));
        list.add(Lists.newArrayList(283280121, 782916802));
        list.add(Lists.newArrayList(317664929, 898415172));
        list.add(Lists.newArrayList(980913391, 847912645));
        int ans = minimumAverage(list);
        System.out.println(ans);
        //1418670047
//        scanner = new Scanner(System.in);
//        //topKNumbersProgram();
//        //kClosestNumbers();
//        List<Employee> employeeList = new ArrayList<>();
//        employeeList.add(new Employee("alpha", 2, 10000));
//        employeeList.add(new Employee("beta", 1, 30000));
//        employeeList.add(new Employee("gamma", 3, 20000));
//
//        Map<String, Integer> map = new HashMap<>();
//        map.put("alpha",1000);
//        map.put("beta",2000);
//        map.put("gamma",3000);
//        map.entrySet().stream().sorted( (e1, e2) -> e2.getValue()-e1.getValue()).forEach(System.out::println);
////        Comparator<Employee> comparator = (o1, o2) -> (int) (o2.salary - o1.salary);
////        employeeList.sort(comparator);
////        System.out.println(employeeList);
//        List<Integer> list = new ArrayList<>();
//        for(int i=0;i<10;i++)
//            list.add(i);
//
//        list.sort(Collections.reverseOrder());
//        System.out.println(list);
//        Collections.sort(list);
//        System.out.println(list);
    }

    static class Customer {
        int cookingTime;
        int arrivalTime;

        Customer(int ct, int at) {
            cookingTime = ct;
            arrivalTime = at;
        }
    }

    public static int minimumAverage(List<List<Integer>> customers) {
        // Write your code here
        Comparator<Customer> customComp = (c1, c2) -> (Math.abs(c1.cookingTime - c1.arrivalTime) - Math.abs(c2.cookingTime - c2.arrivalTime));
        Queue<Customer> minHeap = new PriorityQueue<>(customComp);
        for (List<Integer> data : customers) {
            System.out.println("ct - ar = "+(data.get(1)-data.get(0)));
            minHeap.add(new Customer(data.get(1), data.get(0)));
        }

        int cookingTimeSoFar = 0;
        int waitingTimeSoFar = 0;
        int count = minHeap.size();
        while (!minHeap.isEmpty()) {
            Customer c = minHeap.poll();
            cookingTimeSoFar += c.cookingTime;
            waitingTimeSoFar += (cookingTimeSoFar - c.arrivalTime);
        }
        return waitingTimeSoFar / count;
    }

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minHeap = new PriorityQueue<>();
        List<Double> ans = new ArrayList<>();
        // small elements in max heap, large elements in min heap
        for (int num : a) {
            if (maxHeap.isEmpty() || num < maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            int mxSize = maxHeap.size();
            int mnSize = minHeap.size();
            int absDiff = Math.abs(mxSize - mnSize);
            if (absDiff > 1) {
                if (mxSize > mnSize) {
                    while (absDiff-- > 1) {
                        minHeap.add(maxHeap.poll());
                    }
                } else {
                    while (absDiff-- > 1) {
                        maxHeap.add(minHeap.poll());
                    }
                }
            }
            mxSize = maxHeap.size();
            mnSize = minHeap.size();
            double median;
            if (mxSize == mnSize) {
                double mxTop = (double) maxHeap.peek();
                double mnTop = (double) minHeap.peek();
                // System.out.println("mxtop=" + mxTop + " and mnTop=" + mnTop);
                median = (mxTop + mnTop) / 2.0;
                //  System.out.println("median=" + median);
            } else if (mxSize > mnSize) {
                median = maxHeap.peek();
            } else {
                median = minHeap.peek();
            }
            ans.add(median);
            System.out.println(median);
        }
        return ans;
    }


    static class Employee {

        @Override
        public String toString() {
            return "name=" + name + " id=" + id + " salary=" + salary + "\n";
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (this.getClass() != obj.getClass()) return false;
            Employee employee = (Employee) obj;
            return this.name.equals(employee.name);
        }

        private final String name;
        private final int id;
        private final long salary;

        public Employee(String name, int id, long salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public long getSalary() {
            return salary;
        }

    }

    static void kClosestNumbers() {
        int k = 3;
        int target = 7;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Comparator<Pair<Integer, Integer>> pc = (o1, o2) -> o2.getKey() - o1.getKey();
        Queue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>(pc);
        for (int a : arr) {
            maxHeap.add(makePair(Math.abs(target - a), a));
            if (maxHeap.size() > k) maxHeap.poll();
        }
        while (!maxHeap.isEmpty()) System.out.println(maxHeap.poll());
    }

    static Pair<Integer, Integer> makePair(int left, int right) {
        return new Pair<>(left, right);
    }

    static void topKNumbersProgram() {
        System.out.println("Enter value of K");
        int k = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter min for top min elements, max for top max elements heap");
        String type = scanner.nextLine();
        Queue<Integer> heap;
        System.out.println("type |" + type + "|");
        heap = ("min".equals(type) ? new PriorityQueue<>(Collections.reverseOrder()) : new PriorityQueue<>());
        System.out.println("Creating a " + type + " heap for top " + k + " items");
        System.out.println("Enter the number with insert as prefix to store it in heap\nenter top to view the items\nenter blank to break");
        String userInput = "Start";
        while (!userInput.isEmpty()) {
            userInput = scanner.nextLine();
            if (userInput.startsWith("i")) {
                int num = Integer.parseInt(userInput.substring(1));
                heap.add(num);
                if (heap.size() > k)
                    heap.poll();
                System.out.println("Added");
            } else {
                Queue<Integer> temp = new PriorityQueue<>(heap);
                printHeapInReverseOrder(temp);
            }
        }
        System.out.println("Bye");
    }

    static void printHeapInReverseOrder(final Queue<Integer> heap) {
        if (heap.isEmpty())
            return;
        int num = heap.poll();
        printHeapInReverseOrder(heap);
        System.out.println(num);
    }
}
