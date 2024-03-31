package io.agistep.identity;

import io.agistep.identity.spi.IdentifierProviderFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Abc {

    // 클라이언트에서 IDProvider 를 제공받으려면 어떻게 해야하는지.

    // 라이브러리 사용자가 snowflake가 나온다는걸 어떻게 알고 있나. Fixed- 는 어떻게 로드?
    // 원칙
    @Test
    void name() {
        IdentifierProviderFactory.setFactoryClass(FixedIdentifierProviderFactory.class);
        IdentifierProviderFactory actual = IdentifierProviderFactory.load();

        assertThat(actual).isInstanceOf(FixedIdentifierProviderFactory.class);
    }

    @Test
    void name3() {
        IdentifierProviderFactory.setFactoryClass(FooIdentifierProviderFactory.class);
        IdentifierProviderFactory actual = IdentifierProviderFactory.load();

        assertThat(actual).isInstanceOf(FooIdentifierProviderFactory.class);
    }

    @Test
    void name4() {
        IdentifierProviderFactory.setFixed(99);
        IdentifierProvider actual = IdentifierProviderFactory.load().get();
        assertThat(actual.nextId()).isEqualTo(99);

        assertThat(actual).isInstanceOf(FixedIdentifierProviderFactory.class);
    }
}
