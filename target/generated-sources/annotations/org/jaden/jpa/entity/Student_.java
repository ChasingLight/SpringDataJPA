package org.jaden.jpa.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ {

	public static volatile SingularAttribute<Student, Teacher> teacher;
	public static volatile SingularAttribute<Student, String> stuId;
	public static volatile SingularAttribute<Student, Integer> gender;
	public static volatile SingularAttribute<Student, StudentExtraInfo> studentExtraInfo;
	public static volatile ListAttribute<Student, Course> courseList;
	public static volatile SingularAttribute<Student, String> className;
	public static volatile SingularAttribute<Student, Date> cTime;
	public static volatile SingularAttribute<Student, Date> uTime;
	public static volatile SingularAttribute<Student, String> stuName;

}

