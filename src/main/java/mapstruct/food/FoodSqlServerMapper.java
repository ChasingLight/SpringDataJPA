package mapstruct.food;

import mapstruct.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodSqlServerMapper extends BaseMapper<FoodDto, FoodSqlServer> {

    FoodSqlServerMapper INSTANCE = Mappers.getMapper( FoodSqlServerMapper.class );
}
