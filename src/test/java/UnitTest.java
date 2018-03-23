import com.alibaba.fastjson.JSON;
import org.jaden.jpa.entity.*;
import org.jaden.jpa.repository.TeacherRepository;
import org.jaden.jpa.service.BooksService;
import org.jaden.jpa.service.CourseService;
import org.jaden.jpa.service.StudentService;
import org.jaden.jpa.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.event.demo.ContentEvent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JadenOliver on 2017/3/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-context.xml"})
public class UnitTest {
    @Autowired
    private BooksService booksService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ApplicationContext applicationContext;


    @Test
    public void testBooksRepository(){
        //1.模糊查询
        List<Books> booksList = booksService.findByAuthor("jad");

        System.out.println("booksList's size is:" + booksList.size());

        for(Books temp : booksList){
            System.out.println(temp.toString());
        }

        //2.计数
        int authorCount = booksService.countByAuthor("靳浩东");
        System.out.println("作者为靳浩东的书籍共" + authorCount + "本");
    }

    @Test
    public  void testStuManyToManyAndManyToOne(){
        Student student = studentService.findByStuId("104");
        String jsonStr = JSON.toJSONString(student);
        System.out.println(jsonStr);
    }

    @Test
    public void testCourseManyToMany(){
        Course course = courseService.findByCId("1701");//1701 商务礼仪
        System.out.println(course.toString());
    }

    @Test
    public void testTeacherOneToMany(){
        Teacher teacher = teacherService.findByTeacherId("666");
        System.out.println(teacher.toString());
    }

    @Test
    public void testExtraInfoOneToOne(){
        Teacher teacher = new Teacher();
        teacher.settGender(1);
        //teacher.settId("777");
        teacher.settName("卡卡西老师");
        teacher.settSubject("忍术、生活道理");
        teacher.settAge(23);

        Student student1 = new Student();
        //student1.setStuId("001");
        student1.setStuName("鸣人");
        student1.setGender(1);
        student1.setClassName("卡卡西班级");
        student1.setcTime(new Date());
        //级联设置
        student1.setTeacher(teacher);

        Student student2 = new Student();
        //student1.setStuId("002");
        student2.setStuName("小樱");
        student2.setGender(0);
        student2.setClassName("卡卡西班级");
        student2.setcTime(new Date());
        //级联设置
        student2.setTeacher(teacher);

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student1);
        studentList.add(student2);

        //设置学生列表
        teacher.setStudentList(studentList);


        //设置学生额外信息
        StudentExtraInfo studentExtraInfo = new StudentExtraInfo();
        studentExtraInfo.setExtraInfo("鸣人额外信息：鸣人坚韧不拔，拥有火之意志");

        //级联设置
        studentExtraInfo.setStudent(student1);
        student1.setStudentExtraInfo(studentExtraInfo);

        teacherRepository.save(teacher);

    }

    @Test
    public void testSpringEventDemo(){
        System.out.println(applicationContext);

        this.applicationContext.publishEvent(new ContentEvent("号外!鹿晗和关晓彤正式确认恋人关系了。"));

    }

    public static void main(String[] args) {
            ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
            ctx.publishEvent(new ContentEvent("号外!鹿晗和关晓彤正式确认恋人关系了。"));

    }


    public static String validOrderInfo(String reqJsonStr){

        String validResult = "{\n" +
                "\t\"holderPhone\": \"18737104575\",\n" +
                "\t\"holderName\": \"靳浩东\",\n" +
                "\t\"holderIdType\": \"1\",\n" +
                "\t\"holderId\": \"410185199405201510\",\n" +
                "\t\"imeiImgPath\": \"bfe2606d-d3b1-4343-8563-9552f30e3512.jpg\"\n" +
                "}";


        return "";
    }

}
