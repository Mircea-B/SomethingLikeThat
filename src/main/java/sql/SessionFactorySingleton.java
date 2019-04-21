package sql;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {

    private SessionFactorySingleton() {
    }

    private static SessionFactory INSTANCE = null;

    public static SessionFactory getInstance() {
        if (INSTANCE == null) {
            // Create registry
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
// Create MetadataSources
            MetadataSources sources = new MetadataSources(registry);
// Create Metadata
            Metadata metadata = sources.getMetadataBuilder().build();
// Create SessionFactory
            INSTANCE = metadata.getSessionFactoryBuilder().build();
        }
        return INSTANCE;
    }
}
