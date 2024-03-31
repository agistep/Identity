package io.agistep.identity.spi;

import io.agistep.identity.FixedIdentifierProviderFactory;
import io.agistep.identity.IdentifierProvider;
import io.agistep.identity.IdentifierProviderFactoryNotFoundException;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public interface IdentifierProviderFactory {

    List<Class<? extends IdentifierProviderFactory>> factoryClass = new ArrayList<>();


    static IdentifierProviderFactory load() {
        if (factoryClass.isEmpty()) {
            return loadByServiceLocator();
        }

        try {
            return (IdentifierProviderFactory) factoryClass.get(0).getConstructors()[0].newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    static IdentifierProviderFactory loadByServiceLocator() {
        ServiceLoader<IdentifierProviderFactory> loader = ServiceLoader.load(IdentifierProviderFactory.class);
        if (!loader.iterator().hasNext()) {
            throw new IdentifierProviderFactoryNotFoundException("IdentifierProvider Factory not found");
        }
        return loader.iterator().next();
    }

    static void setFactoryClass(Class<? extends IdentifierProviderFactory> factoryClass) {
        IdentifierProviderFactory.factoryClass.add(0, factoryClass);
    }

    static void setFixed(int i) {
        setFactoryClass(FixedIdentifierProviderFactory.class);

    }

    IdentifierProvider get();

}
