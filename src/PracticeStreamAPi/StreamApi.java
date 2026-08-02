package PracticeStreamAPi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//        numbers.stream().filter(number -> number % 2 == 0).toList().forEach(System.out::println);
//        numbers.stream().map(x -> x * 10).forEach(System.out::println);
//        List<String> names = Arrays.asList(
//                "Rahul",
//                "Amit",
//                "Ankit",
//                "John",
//                "Ajay",
//                "Bob"
//        );
//        List<String> result = names.stream()
//                .filter(name -> name.startsWith("A"))
//                .map(String::toUpperCase)
//                .toList();
//        System.out.println(result);
       /* List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        int sum = numbers.stream().reduce(0, (x, y) -> x + y);

        System.out.println(sum);*/
        /*List<String> words = Arrays.asList(
                "Java",
                "Spring",
                "Microservices",
                "SQL",
                "Docker"
        );
        String longest = words.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);

        System.out.println(
                longest
        );*/

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5,6,7,8);
        // double list :- 2 , 4, 6 , 8 ,10

        List<Integer> ans  = numbers.stream().skip(2).limit(3).map(n-> n*2 ).toList();
//        int sum1 = numbers.stream().mapToInt(n -> n * 2).sum();
//        int sum2 = numbers.stream().map(n -> n * 2).reduce(0, Integer::sum);

//        System.out.println(sum1);d
//        System.out.println(sum2);
        System.out.println(ans);

        
    }
}
