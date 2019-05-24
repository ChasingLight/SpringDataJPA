package orika.util;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;

public class EntityMapper {
    private MapperFacade mapperFacade;

    private EntityMapper() {
        MapperFactory factory = new DefaultMapperFactory.Builder().useAutoMapping(true).mapNulls(true).build();
        mapperFacade = factory.getMapperFacade();
    }

    private static class EntityMapperHolder {
        private static final EntityMapper INSTANCE = new EntityMapper();
    }

    public static EntityMapper getInstance() {
        return EntityMapperHolder.INSTANCE;
    }

    public <S, D> D map(S var1, Class<D> var2) {
        return mapperFacade.map(var1, var2);
    }

    public <S, D> List<D> map(List<S> var1, Class<D> var2) {
        return mapperFacade.mapAsList(var1, var2);
    }
}
