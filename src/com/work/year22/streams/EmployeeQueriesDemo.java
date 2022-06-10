package com.work.year22.streams;

import com.work.year22.Employee;

import java.util.*;

import java.util.stream.Collectors;


public class EmployeeQueriesDemo {

    public static void main(String[] args){
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1,"John",21,"active", 1000));
        empList.add(new Employee(2,"Jack",23,"active", 5000));
        empList.add(new Employee(3,"Jill",18,"Inactive", 8000));
        empList.add(new Employee(4,"Harry",21,"active", 6000));

        Map<Integer,List<Employee>> resultMap = empList.stream().collect(Collectors.groupingBy(x->x.getDeptId()));
        System.out.println("resultMap = " + resultMap);

        Map<Integer,Long> resultMap2 = empList.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.counting()));
        System.out.println("resultMap2 = " + resultMap2);

        Map<String,List<Employee>> resultMap3 = empList.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println("resultMap3 = " + resultMap3);  // Or use filter method

        Map<String,Long> resultMap4 = empList.stream().collect(Collectors.groupingBy(Employee::getStatus,Collectors.counting()));
        System.out.println("resultMap4 = " + resultMap4);

        Optional<Employee> emplOpt = emplOpt = empList.stream().max(Comparator.comparing(Employee::getSalary));
        //OR
        //empList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
        System.out.println("Employee with MAX salary:" + emplOpt.get());

        emplOpt = empList.stream().collect(Collectors.minBy(Comparator.comparing(Employee::getSalary)));
        System.out.println("Employee with MIN salary:" + emplOpt.get());

        Map<Integer,Optional<Employee>> resultMap5 = empList.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println("resultMap5 = " + resultMap5);

    }
}
