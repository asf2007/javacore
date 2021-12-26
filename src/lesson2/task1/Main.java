package lesson2.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> filter1 = new ArrayList<>();
        for (int num:intList
             ) {
          if (num>0){
              filter1.add(num);
          }
        }
        List<Integer> filter2 = new ArrayList<>();
        for (int num:filter1
             ) {
            if(num%2==0){
                filter2.add(num);
            }
        }
        Collections.sort(filter2);
        for (int num: filter2
             ) {
            System.out.println(num);
        }
    }
}
