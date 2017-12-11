package org.jaden.jpa.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Course.class)
public abstract class Course_ {

	public static volatile SingularAttribute<Course, String> cName;
	public static volatile ListAttribute<Course, Student> studentList;
	public static volatile SingularAttribute<Course, Integer> cGrade;
	public static volatile SingularAttribute<Course, Date> cTime;
	public static volatile SingularAttribute<Course, Date> uTime;
	public static volatile SingularAttribute<Course, String> cRemark;
	public static volatile SingularAttribute<Course, String> cId;

}

