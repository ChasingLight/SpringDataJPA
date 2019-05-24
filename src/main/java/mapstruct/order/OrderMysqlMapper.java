package mapstruct.order;

import mapstruct.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMysqlMapper extends BaseMapper<OrderDto, OrderMysql> {

    OrderMysqlMapper INSTANCE = Mappers.getMapper( OrderMysqlMapper.class );
}
