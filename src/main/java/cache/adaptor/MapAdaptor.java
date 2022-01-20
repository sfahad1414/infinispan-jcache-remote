package cache.adaptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.infinispan.protostream.annotations.ProtoAdapter;
import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

import java.util.HashMap;

@ProtoAdapter(HashMap.class)
public class MapAdaptor
{
    ObjectMapper objectMapper = new ObjectMapper();

    @ProtoFactory
    HashMap<?, ?> create(String map) throws JsonProcessingException {
        return objectMapper.readValue(map, new TypeReference<>() {
        });
    }

    @ProtoField(1)
    String getMap(HashMap<?, ?> data) throws JsonProcessingException {
        return objectMapper.writeValueAsString(data);
    }
}
