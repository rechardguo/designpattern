package rechard.learn.designpattern.iterator;

public class WithIteratorDemo {

    public static void main(String[] args) {
        WithIteratorDemo.Room room=new WithIteratorDemo.Room();
        room.addStudent(new WithIteratorDemo.Student("rechard",18));
        room.addStudent(new WithIteratorDemo.Student("rechardlove",18));

        Iterator<Student> it=room.iterator();
        while (it.hasNext()){
            Student stu=it.next();
            if(stu!=null)
              System.out.println(stu);
        }
    }


    public static class Room{
        WithIteratorDemo.Student[] students=new WithIteratorDemo.Student[10];
        int index=0;
        //List<Student> students=new ArrayList<Student>();
        public void addStudent(WithIteratorDemo.Student stu){
            this.students[index++]=stu;
        }

        public WithIteratorDemo.Student[] getStudents() {
            return students;
        }

        public Iterator iterator(){
            return it;
        }

        Iterator it=new MyIterator(this.students);

        class MyIterator implements  WithIteratorDemo.Iterator{
            WithIteratorDemo.Student[] students;
            int index;
            public MyIterator(WithIteratorDemo.Student[] students) {
                this.index=0;
                this.students = students;
            }

            @Override
            public boolean hasNext() {
                return index<students.length;
            }

            @Override
            public Object next() {
                return students[index++];
            }
        }

    }
    public static interface Iterator<T>{
        public boolean hasNext();
        public T next();
    }

    public static  class Student {
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
