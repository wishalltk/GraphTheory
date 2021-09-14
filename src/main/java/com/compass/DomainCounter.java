package com.compass;

import java.util.*;
import java.util.stream.Collectors;

public class DomainCounter {
    public static void main(String[] args) {
        String[] inputs = {"900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "5,com.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk" };



        Map<String, Integer> countPerDomain = countClickByDomain(inputs);
        countPerDomain.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .forEach(System.out::println);


    }

    private static Map<String, Integer> countClickByDomain(String[] inputs) {

        Map<String, Integer> countPerDomainMap = new HashMap<>();
        for (String input : inputs) {
            String[] countAndDomain = input.split(",");
            int count = Integer.parseInt(countAndDomain[0]);
            String domainName = countAndDomain[1];
            splitAndRecordCount(domainName, count, countPerDomainMap);
        }
        return countPerDomainMap;
    }


    private static void splitAndRecordCount(String domainName, int count, Map<String, Integer> countPerDomainMap) {
        int front = domainName.length()-1;
        while (front >= 0) {
            if (domainName.charAt(front) == '.') {
                String subDomain = domainName.substring(front+1);
                countPerDomainMap.merge(subDomain, count, Integer::sum);
            }
            front-=1;
        }
        countPerDomainMap.merge(domainName, count, Integer::sum);

        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.name.compareTo(o2.name);
            }
        };

//        Comparator<Employee> sortById = new Comparator<Employee>() {
//            @Override
//            public int compareTo(Employee e1 , Employee e2) {
//                return e1.id - e2.id;
//            }
//        }
    }



}
class Employee {
    final int id;
    final String name;

    public Employee(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name +" - " + id;
    }
}

