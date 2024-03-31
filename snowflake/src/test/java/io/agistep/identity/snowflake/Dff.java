package io.agistep.identity.snowflake;

import io.agistep.identity.spi.IdentifierProviderFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Dff {

    @Test
    void name() {
        IdentifierProviderFactory actual = IdentifierProviderFactory.load();
        assertThat(actual).isInstanceOf(SnowflakeIdentifierProviderFactory.class);
    }

}
