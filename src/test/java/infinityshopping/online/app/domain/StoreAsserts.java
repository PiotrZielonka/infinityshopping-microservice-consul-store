package infinityshopping.online.app.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertStoreAllPropertiesEquals(Store expected, Store actual) {
        assertStoreAutoGeneratedPropertiesEquals(expected, actual);
        assertStoreAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertStoreAllUpdatablePropertiesEquals(Store expected, Store actual) {
        assertStoreUpdatableFieldsEquals(expected, actual);
        assertStoreUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertStoreAutoGeneratedPropertiesEquals(Store expected, Store actual) {
        assertThat(actual)
            .as("Verify Store auto generated properties")
            .satisfies(a -> assertThat(a.getId()).as("check id").isEqualTo(expected.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertStoreUpdatableFieldsEquals(Store expected, Store actual) {
        assertThat(actual)
            .as("Verify Store relevant properties")
            .satisfies(a -> assertThat(a.getName()).as("check name").isEqualTo(expected.getName()))
            .satisfies(a -> assertThat(a.getLocation()).as("check location").isEqualTo(expected.getLocation()))
            .satisfies(a -> assertThat(a.getPhoneNumber()).as("check phoneNumber").isEqualTo(expected.getPhoneNumber()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertStoreUpdatableRelationshipsEquals(Store expected, Store actual) {
        // empty method
    }
}
