package it.unibo.inner;

import it.unibo.inner.api.IterableClass;
import it.unibo.inner.api.IterableWithPolicy;

import java.util.List;

import static it.unibo.inner.test.Assertions.assertContentEqualsInOrder;

public class TestIterablePlain {

    private TestIterablePlain() {}

    private static <T> IterableClass<T> getIterableWithPolicy(T[] elements) {
        return new IterableClass<>(elements); // TODO: return the implementation of IterableWithPolicy
    }

    public static void main(final String[] args) {
        String[] test1 = { "pippo", "pluto", "paperino" };

        IterableClass<String> evenIterable = getIterableWithPolicy(test1);
        assertContentEqualsInOrder(evenIterable, List.of("pippo", "pluto", "paperino"));

        String[] test2 = {};

        IterableClass<String> emptyIterable = getIterableWithPolicy(test2);
        assertContentEqualsInOrder(emptyIterable, List.of());

        String[] test3 = { "foo" };

        IterableClass<String> oneIterable = getIterableWithPolicy(test3);
        assertContentEqualsInOrder(oneIterable, List.of("foo"));
    }
}
