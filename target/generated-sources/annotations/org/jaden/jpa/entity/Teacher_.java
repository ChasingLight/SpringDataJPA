package org.jaden.jpa.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Teacher.class)
public abstract class Teacher_ {

	public static volatile SingularAttribute<Teacher, String> tSubject;
	public static volatile ListAttribute<Teacher, Student> studentList;
	public static volatile SingularAttribute<Teacher, String> tName;
	public static volatile SingularAttribute<Teacher, Integer> tGender;
	public static volatile SingularAttribute<Teacher, String> tId;
	public static volatile SingularAttribute<Teacher, Integer> tAge;

}

