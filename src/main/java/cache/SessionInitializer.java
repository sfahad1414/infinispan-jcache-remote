package cache;

import cache.adaptor.MapAdaptor;
import org.infinispan.protostream.SerializationContextInitializer;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(
        includeClasses = { User.class, MapAdaptor.class},
        schemaFileName = "library.proto",
        schemaFilePath = "proto/")
public interface SessionInitializer extends SerializationContextInitializer {
}
