package jdk.vaildReqVo;

import org.jaden.jpa.entity.Student;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class MainTest {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student stu1 = new Student();
        stu1.setStuId("111");
        Student stu2 = new Student();
        stu2.setStuId("222");

        students.add(stu1);
        students.add(stu2);

        show(students);

        for (Student temp : students){
            if (temp.getStuId().equals("111")){
                students.remove(temp);
            }
        }

        show(students);

        String title = new String("天地玄黄天地玄黄天地玄黄11abcd");
        System.out.println(title.length());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");



    }

    public static void show(List<Student> list){
        for (Student temp : list){
            System.out.println("hashcode:" + temp.hashCode() + "; stuId:" + temp.getStuId());
        }
    }


}
