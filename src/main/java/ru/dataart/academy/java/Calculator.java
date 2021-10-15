package ru.dataart.academy.java;

import java.util.*;

public class Calculator {
    /**
     * @param firstNumber  - list for first number in reversed order (1 - 2 - 3 -> 321)
     * @param secondNumber - list for second number in reversed order (1 - 2 - 3 -> 321)
     * @return - sum of firstNumber + secondNumber
     */
    public Integer getSum(List<Integer> firstNumber, List<Integer> secondNumber) {
        StringBuilder stringBuilderOfFirstNumber = new StringBuilder();
        StringBuilder stringBuilderOfSecondNumber = new StringBuilder();

        if (firstNumber.size() > 0) {
            ListIterator<Integer> firstListIterator = firstNumber.listIterator(firstNumber.size());
            while (firstListIterator.hasPrevious()) {
                stringBuilderOfFirstNumber.append(firstListIterator.previous());
            }
        } else stringBuilderOfFirstNumber.append(0);

        if (secondNumber.size() > 0) {
            ListIterator<Integer> secondListIterator = secondNumber.listIterator(secondNumber.size());
            while (secondListIterator.hasPrevious()) {
                stringBuilderOfSecondNumber.append(secondListIterator.previous());
            }
        } else stringBuilderOfSecondNumber.append(0);

        try {
            int firstN = Integer.parseInt(stringBuilderOfFirstNumber.toString());
            int secondN = Integer.parseInt(stringBuilderOfSecondNumber.toString());
            return firstN + secondN;
        } catch (NumberFormatException e) {
            System.out.println("Out of Integer range");;
        }
        return 0;
    }

    /**
     *
     * @param list - list of elements
     * @param <T> - type of element
     * @return - odd list elements
     * Example: [1, 22, 34] -> [1, 34]
     */
/*    public <T> List<T> getOddElementsSecondWay(List<T> list) {
        List<T> outputList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ((i + 1 & 1) == 1) outputList.add(list.get(i));   // Nice trick from StackOverflow to find odd/even numbers
        }
        return outputList;
    }*/

    public  <T> List<T> getOddElements(List<T> list) {
        List<T> outputList = new ArrayList<>();
        Iterator<T> iteratorOfInputList = list.iterator();
        boolean isOdd = true;
        while (iteratorOfInputList.hasNext()) {
            if (isOdd) {
                outputList.add(iteratorOfInputList.next());
                isOdd = false;
            } else {
                iteratorOfInputList.next();
                isOdd = true;
            }
        }
        return outputList;
    }

    /**
     *
     * @param list - list of elements
     * @param <T> - type of element
     * @return - first and last elements of the list
     * Example: [1, 2, 3] -> [1, 3]
     * [1, 2, 3 , 4] -> [1, 4]
     */
    public <T> List<T> getBounds(List<T> list) {
        if (list.size() == 0) return new ArrayList<>();
        if (list.size() == 1) return new ArrayList<>(list);
        LinkedList<T> tempList = new LinkedList<>(list);
        List<T> outputList = new ArrayList<>();
        outputList.add(tempList.getFirst());
        outputList.add(tempList.getLast());
        return outputList;
    }
}
