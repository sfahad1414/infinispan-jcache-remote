package cache;

import org.infinispan.protostream.SerializationContextInitializer;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;
import org.infinispan.protostream.types.java.CommonContainerTypes;
import org.infinispan.protostream.types.java.CommonTypes;

@AutoProtoSchemaBuilder(
        includeClasses = { User.class },
        schemaFileName = "library.proto",
        schemaFilePath = "proto/")
public interface SessionInitializer extends SerializationContextInitializer {
}
