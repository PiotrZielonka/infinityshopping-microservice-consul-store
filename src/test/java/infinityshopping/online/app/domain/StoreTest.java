package infinityshopping.online.app.domain;

import static infinityshopping.online.app.domain.StoreTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import infinityshopping.online.app.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class StoreTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Store.class);
        Store store1 = getStoreSample1();
        Store store2 = new Store();
        assertThat(store1).isNotEqualTo(store2);

        store2.setId(store1.getId());
        assertThat(store1).isEqualTo(store2);

        store2 = getStoreSample2();
        assertThat(store1).isNotEqualTo(store2);
    }
}
