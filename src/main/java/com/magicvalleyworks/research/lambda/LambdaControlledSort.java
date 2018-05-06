package com.magicvalleyworks.research.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaControlledSort {

    public interface NextValueExpression<T> {
        boolean next(T nextValueCandidate, T currentValue);
    }

    public static <T> List<T> sort(List<T> valueList, LambdaControlledSort.NextValueExpression<T> nextValueExpression) {
        if (valueList == null || valueList.isEmpty()) {
            return new ArrayList<>();
        }

        List<T> sortedList = new ArrayList<>();

        for (int i = 0; i < valueList.size(); i++) {
            T currentValue = valueList.get(i);
            insertNextValue(sortedList, currentValue, nextValueExpression);
        }

        return sortedList;
    }

    private static <T> void insertNextValue(List<T> sortedList, T nextValueCandidate, LambdaControlledSort.NextValueExpression<T> nextValueExpression) {
        int indexToInsertValue = 0;
        boolean addToTheEnd = false;
        int sortedListSize = sortedList.size();
        for (int i = 0; i < sortedListSize; i++) {
            T currentValue = sortedList.get(i);
            if (nextValueExpression.next(nextValueCandidate, currentValue)) {
                indexToInsertValue = i;
                break;
            }
            if (i + 1 == sortedListSize) {
                addToTheEnd = true;
            }
        }

        if (addToTheEnd) {
            sortedList.add(nextValueCandidate);
        } else {
            sortedList.add(indexToInsertValue, nextValueCandidate);
        }
    }

}
