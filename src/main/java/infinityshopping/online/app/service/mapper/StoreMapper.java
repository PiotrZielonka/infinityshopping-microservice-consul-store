package infinityshopping.online.app.service.mapper;

import infinityshopping.online.app.domain.Store;
import infinityshopping.online.app.service.dto.StoreDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Store} and its DTO {@link StoreDTO}.
 */
@Mapper(componentModel = "spring")
public interface StoreMapper extends EntityMapper<StoreDTO, Store> {}
