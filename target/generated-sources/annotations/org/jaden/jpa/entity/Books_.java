package org.jaden.jpa.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Books.class)
public abstract class Books_ {

	public static volatile SingularAttribute<Books, Date> createTime;
	public static volatile SingularAttribute<Books, String> author;
	public static volatile SingularAttribute<Books, Integer> price;
	public static volatile SingularAttribute<Books, String> name;
	public static volatile SingularAttribute<Books, String> description;
	public static volatile SingularAttribute<Books, Date> updateTime;
	public static volatile SingularAttribute<Books, Integer> id;

}

