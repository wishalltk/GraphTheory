package com.heap;
import java.util.*;


class Word {
    String word;
    int frequency;

    public Word(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
}

class Item {
    public Item(int value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }

    final int value;
    int frequency;

    @Override
    public String toString() {
        return "value -> "+ value + " : frequency -> " + frequency;
    }
}

public class TopFrequentKElements {

    static SortedSet<Word> sortedSet = new TreeSet<>((o1, o2) -> o2.frequency- o1.frequency);

    private static PriorityQueue<Item> heap = new PriorityQueue<>(Comparator.comparingInt(i -> i.frequency));
    static int k;

    static Map<Integer, Integer> allNums = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter k");
        k  = scanner.nextInt();
        boolean shouldContinue = true;
        while (shouldContinue) {
            System.out.println("Press 1 for streaming numbers\nPress 2 for printing top "+k+" elements\nPress 3 to exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter numbers separated by space in one line");
                    String numbers = scanner.nextLine();
                    for(String s: numbers.trim().split(" "))
                   //     addToSet(s);
                        //add(Integer.parseInt(s));
                    break;
                case 2:
                //    printFromSet();
                    //getTopKFromHeap();
                    System.out.println("------------------------------------------\n");
                    break;
                case 3:
                    shouldContinue = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
        System.out.println("\nBa-Bye");
    }



    private static void getTopKFromHeap() {
        List<Item> temp = new ArrayList<>(k);
        List<Item> result = new ArrayList<>(k);
        int counter = k;
        while (counter-->0) {
            Item item = heap.poll();
            result.add(item);
            temp.add(item);
        }
        heap.addAll(temp);
        Collections.reverse(result);
        System.out.println(result);
        System.out.println("\n");
    }

    private static void add(int number) {

            allNums.merge(number, 1, Integer::sum);
            Item item = new Item(number, allNums.get(number));
            heap.offer(item);
            if(heap.size() > k)
                heap.poll();
    }
}
