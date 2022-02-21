package SlidingWindow;

import java.util.HashMap;
//        You are visiting a farm to collect fruits. The farm has a single row of fruit trees. You will be given two baskets, and your goal is to pick as many fruits as possible to be placed in the given baskets.
//
//        You will be given an array of characters where each character represents a fruit tree. The farm has following restrictions:
//
//        Each basket can have only one type of fruit. There is no limit to how many fruit a basket can hold.
//        You can start with any tree, but you can’t skip a tree once you have started.
//        You will pick exactly one fruit from every tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
//        Write a function to return the maximum number of fruits in both baskets.
//
//        Example 1:
//
//        Input: Fruit=['A', 'B', 'C', 'A', 'C']
//        Output: 3
//        Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
//        Example 2:
//
//        Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
//        Output: 5
//        Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
//        This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
public class EX5_FindMaxFruitCountOf2Types {

    public static int findLength(char[] arr) {
        int start =0;
        int maxFruit =0;
        HashMap<Character,Integer> counter =new HashMap<>();

        for (int end = 0; end <arr.length ; end++) {

            char nextChar = arr[end];
            counter.put(nextChar,counter.getOrDefault(nextChar,0)+1);

            while (counter.size()>2){
                char firstChar = arr[start];
                counter.put(firstChar,counter.get(firstChar)-1);

                if(counter.get(firstChar) == 0){
                    counter.remove(firstChar);

                }
                start += 1;
            }
            maxFruit=Math.max(maxFruit,end - start+1);
        }
        return maxFruit;
    }

    public static void main(String[] args) {
        System.out.println("Maximum number of fruits: " +
                findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
              findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
