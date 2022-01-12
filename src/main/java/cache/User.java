package cache;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

import java.io.Serializable;

public class User implements Serializable {
    @ProtoField(1)
    final String name;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @ProtoField(2)
    final String type;

    @ProtoFactory
    public User(String name, String type){
        this.name = name;
        this.type = type;
    }
}
