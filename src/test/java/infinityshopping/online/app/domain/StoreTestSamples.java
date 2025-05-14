package infinityshopping.online.app.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class StoreTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Store getStoreSample1() {
        return new Store().id(1L).name("name1").location("location1").phoneNumber("phoneNumber1");
    }

    public static Store getStoreSample2() {
        return new Store().id(2L).name("name2").location("location2").phoneNumber("phoneNumber2");
    }

    public static Store getStoreRandomSampleGenerator() {
        return new Store()
            .id(longCount.incrementAndGet())
            .name(UUID.randomUUID().toString())
            .location(UUID.randomUUID().toString())
            .phoneNumber(UUID.randomUUID().toString());
    }
}
