package rechard.learn.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class WithIteratorDemo {

    public static void main(String[] args) {
        Room room=new Room();
        room.addStudent(new Student("rechard",18));
        room.addStudent(new Student("rechardlove",18));

        List<Student> students=room.getStudents();

        for (Student stu:students){
            System.out.println(stu);
        }

    }

    public static class Room{
        List<Student> students=new ArrayList<Student>();
        public void addStudent(Student stu){
            this.students.add(stu);
        }

        public List<Student> getStudents() {
            return students;
        }

    }

    public static  class Student{
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
