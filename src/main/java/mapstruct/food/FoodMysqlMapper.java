package mapstruct.food;

import mapstruct.BaseMapper;
import mapstruct.order.OrderDto;
import mapstruct.order.OrderMysql;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMysqlMapper extends BaseMapper<FoodDto, FoodMysql> {

    FoodMysqlMapper INSTANCE = Mappers.getMapper( FoodMysqlMapper.class );

    @Override
    @Mappings({@Mapping(source = "birthday", target = "birth")})
    FoodMysql poToVo(FoodDto var1);
}
