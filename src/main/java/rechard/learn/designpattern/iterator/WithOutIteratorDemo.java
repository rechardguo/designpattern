package rechard.learn.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class WithOutIteratorDemo {

    public static void main(String[] args) {
        Room room=new Room();
        room.addStudent(new Student("rechard",18));
        room.addStudent(new Student("rechardlove",18));

       /* List<Student> students=room.getStudents();
        for (Student stu:students){
            System.out.println(stu);
        }*/

        //不用迭代器模式，则代码就得更改
        Student[] students=room.getStudents();
        for(int i=0;i<students.length;i++){
            if(students[i]!=null)
                System.out.println(students[i]);
        }
    }

    public static class Room{
        Student[] students=new Student[10];
        int index=0;
        //List<Student> students=new ArrayList<Student>();
        public void addStudent(Student stu){
            this.students[index++]=stu;
        }

        public Student[] getStudents() {
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
