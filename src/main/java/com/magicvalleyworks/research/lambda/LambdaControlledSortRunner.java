package com.magicvalleyworks.research.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaControlledSortRunner {

    public static void main(String[] args) {
        System.out.println("*******************1*******************");
        List<Integer> integerList = new ArrayList<>(List.of(5, 33, 33, 3, 23, 73, 12, 4, 7, 33,  17, -2, 0, 32));
        System.out.println(integerList);
        List<Integer> sortedIntegerList = LambdaControlledSort.sort(integerList, (Integer nextValueCandidate, Integer currentValue) -> nextValueCandidate <= currentValue);
        System.out.println(sortedIntegerList);

        System.out.println("*******************2*******************");
        List<String> stringList = new ArrayList<>(List.of("very medium string", "little string", "the most biggest string in the world", "very very big string"));
        System.out.println(stringList);
        List<String> sortedStringList = LambdaControlledSort.sort(stringList, ((nextValueCandidate, currentValue) -> nextValueCandidate.length() >= currentValue.length()));
        System.out.println(sortedStringList);
    }

}
