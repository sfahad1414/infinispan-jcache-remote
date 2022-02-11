package cache.adaptor;

import org.infinispan.protostream.annotations.ProtoAdapter;
import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

import java.io.*;
import java.util.HashMap;

@ProtoAdapter(HashMap.class)
public class MapAdaptor
{
    @ProtoFactory
    HashMap<?, ?> create(byte[] map) throws IOException {
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bis = new ByteArrayInputStream(map);
            ois = new ObjectInputStream(bis);
            return (HashMap<?,?>) ois.readObject();
        }catch (ClassNotFoundException e){
            throw new IOException(e.getMessage());
        }

    }

    @ProtoField(1)
    byte[] getMap(HashMap<?, ?> data) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(data);
        return bos.toByteArray();
    }
}
