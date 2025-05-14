package infinityshopping.online.app.service.mapper;

import static infinityshopping.online.app.domain.StoreAsserts.*;
import static infinityshopping.online.app.domain.StoreTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StoreMapperTest {

    private StoreMapper storeMapper;

    @BeforeEach
    void setUp() {
        storeMapper = new StoreMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getStoreSample1();
        var actual = storeMapper.toEntity(storeMapper.toDto(expected));
        assertStoreAllPropertiesEquals(expected, actual);
    }
}
