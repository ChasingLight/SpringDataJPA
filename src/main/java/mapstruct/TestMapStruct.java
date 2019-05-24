package mapstruct;

import com.alibaba.fastjson.JSON;
import mapstruct.order.OrderSqlServer;
import mapstruct.order.OrderDto;
import mapstruct.order.OrderSqlServerMapper;

public class TestMapStruct {

    public static void main(String[] args) {

        BaseMapper<OrderDto, OrderSqlServer> baseMapper = OrderSqlServerMapper.INSTANCE;

        OrderSqlServer order = new OrderSqlServer();
        order.setOrderID(112233L);
        order.setName("jaden");
        order.setAge(25);

        OrderDto orderDto = baseMapper.voToPo(order);

        System.out.println(JSON.toJSONString(orderDto));

        OrderSqlServer order2 = baseMapper.poToVo(orderDto);
        System.out.println(JSON.toJSONString(order2));


    }
}
