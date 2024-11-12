import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Main2 {
    public static void main(String[] args) {
        List<Person> list = List.of(
                new Person("Дарья", "Волошина", "voloshina1112@mail.com"),
                new Person("Диана", "Смирнова", "smirnova1@mail.com"),
                new Person("Никита", "Юсупов", "yusupow32@mail.com"),
                new Person("Света", "Иванова", "ivanova543@mail.com"),
                new Person("Раиса", "Синицина", "sinitsina111@mail.com")
        );
        Stream<String> stream1 = list.stream().map(p -> p.getlName() + " " + p.getfName()).limit(3).peek(s -> System.out.println("peek:" + s));
        List<String> list1 = stream1.toList(); //лист из результата
        long count = list.stream().map(p -> p.getlName() + " " + p.getfName()).limit(3).peek(s -> System.out.println("peek:" + s)).count();
        System.out.println(count);
        LinkedList<Person> collect = list.stream().collect(Collectors.toCollection(() -> new LinkedList<>()));
        System.out.println("==========Лист всех владельцев счетов===========");
        TreeSet<Person> collect1 = list.stream().collect(Collectors.toCollection(  () -> new TreeSet<>(  (p1, p2) -> p1.getlName().compareTo(p2.getlName())  )   ));//лямбда
        System.out.println(collect1);
        System.out.println();
        Map<String, Person> collect2 = list.stream().collect(Collectors.toMap(p -> p.getEmail(), (p) ->{ return p; } ));
        System.out.println(collect2);
    }
}
