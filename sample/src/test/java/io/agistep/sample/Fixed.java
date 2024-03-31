package io.agistep.sample;

import io.agistep.FixedIdentifierProviderFactory;
import io.agistep.identity.spi.IdentifierProviderFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Fixed {

    @Test
    void name() {
        IdentifierProviderFactory.setFactoryClass(FixedIdentifierProviderFactory.class);
        IdentifierProviderFactory actual = IdentifierProviderFactory.load();
        assertThat(actual).isInstanceOf(FixedIdentifierProviderFactory.class);
    }

}
