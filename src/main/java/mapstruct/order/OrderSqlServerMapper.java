package mapstruct.order;

import mapstruct.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderSqlServerMapper extends BaseMapper<OrderDto, OrderSqlServer> {

    OrderSqlServerMapper INSTANCE = Mappers.getMapper( OrderSqlServerMapper.class );
}
