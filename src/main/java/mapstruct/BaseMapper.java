package mapstruct;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 1、SOURCE 与 TARGET 中属性名相同的默认映射(如这两个都有name属性)
 * 2、SOURCE 与 TARGET 中属性名不同的，需要通过 @Mappings({@Mapping()}) 明确关系来形成映射(如sex对应gender)
 * 3、形成映射关系的属性类型不同的,需要通过表达式转换数据类型类型(如Date对应String)
 * 4、无映射关系属性被忽略(如UserEntity的password)
 */
//@Mapper
public interface BaseMapper<SOURCE, TARGET> {

    /**
     * 映射同名属性
     */
    TARGET poToVo(SOURCE var1);

    /**
     * 反向，映射同名属性
     */
    @InheritInverseConfiguration(name = "poToVo")
    SOURCE voToPo(TARGET var1);

    /**
     * 映射同名属性，集合形式
     */
    @InheritConfiguration(name = "poToVo")
    List<TARGET> poToVo(List<SOURCE> var1);

    /**
     * 反向，映射同名属性，集合形式
     */
    @InheritConfiguration(name = "voToPo")
    List<SOURCE> voToPo(List<TARGET> var1);

    /**
     * 更新属性
     */
    @InheritConfiguration(name = "poToVo")
    void updatePoToVo(SOURCE var1, @MappingTarget TARGET var2);

    /**
     * 反向，更新属性
     */
    @InheritConfiguration(name = "voToPo")
    void updateVoToPo(@MappingTarget SOURCE var1, TARGET var2);

    /**
     * 映射同名属性，集合流形式
     */
    List<TARGET> poToVo(Stream<SOURCE> stream);

    /**
     * 反向，映射同名属性，集合流形式
     */
    List<SOURCE> voToPo(Stream<TARGET> stream);
}
