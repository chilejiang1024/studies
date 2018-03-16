package main.java8.basics.stream.sorted;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Title : main.java8.basics.stream.sorted <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/3/16 11:03
 */
public class SortedWithList {

    public static void main(String[] args) {
        basicDataType();
        complexDataType();
    }

    private static void basicDataType() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(5);
        numbers.add(0);
        numbers.add(1);
        numbers.add(9);

        System.out.print("origin list : ");
        numbers.forEach(System.out::print);

        System.out.print("\nnatural sorted : ");
        numbers.stream().sorted().forEach(System.out::print);

        System.out.print("\nnatural sorted in reverse order : ");
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
    }

    private static void complexDataType() {
        class Student {
            int    age;
            String name;

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            private Student(int age, String name) {
                this.age  = age;
                this.name = name;
            }

            @Override
            public String toString() {
                 return "name is : " + this.name + ", age is : " + this.age + ".\n";
            }
        }

        List<Student> students = new ArrayList<>();
        Student s1 = new Student(10, "Sam");
        Student s2 = new Student(13, "Max");
        Student s3 = new Student(15, "Dea");
        Student s4 = new Student(16, "Sea");
        Student s5 = new Student(20, "Dom");
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        System.out.print("\n\norigin list : \n");
        students.forEach(System.out::print);

        System.out.print("\nnatural sorted : \n");
        students.stream().sorted(Comparator.comparing(Student::getAge)).forEach(System.out::print);

        System.out.print("\nnatural sorted in reverse order : \n");
        students.stream().sorted(Comparator.comparing(Student::getAge).reversed()).forEach(System.out::print);

        System.out.print("\nsort by age then sort by name : \n");
        students.stream().sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getName)).forEach(System.out::print);
    }

}
