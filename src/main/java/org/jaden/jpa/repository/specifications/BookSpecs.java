package org.jaden.jpa.repository.specifications;

import org.apache.commons.lang3.StringUtils;
import org.jaden.jpa.entity.Books;
import org.jaden.jpa.entity.Books_;
import org.jaden.jpa.vo.BooksVo;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JadenOliver
 */
public class BookSpecs {

    /**
     * 条件查询书籍
     * @param booksVo
     * @return
     */
    public static Specification<Books> findBooksByConditions(final BooksVo booksVo){

        return new Specification<Books>() {
            @Override
            public Predicate toPredicate(Root<Books> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<>();

                if (StringUtils.isNotEmpty(booksVo.getName())){  //书名
                    predicates.add(builder.like(root.get(Books_.name), "%" + booksVo.getName() + "%"));
                }

                if (StringUtils.isNotEmpty(booksVo.getAuthor())){  //作者名
                    predicates.add(builder.like(root.get(Books_.author), "%" + booksVo.getAuthor() + "%"));
                }

                return builder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }//end method



}
