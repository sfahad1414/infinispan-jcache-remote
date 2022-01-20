import cache.SessionInitializerImpl;
import cache.User;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.commons.marshall.ProtoStreamMarshaller;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.jboss.marshalling.commons.GenericJBossMarshaller;
import org.infinispan.jcache.remote.JCacheManager;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import java.net.URISyntaxException;
import java.util.HashMap;

public class main
{
    public static void main(String[] args) throws URISyntaxException {
        CacheManager cacheManager = Caching.getCachingProvider("org.infinispan.jcache.remote.JCachingProvider").getCacheManager(main.class.getClassLoader().getResource("infinispan.properties").toURI(), main.class.getClassLoader(), null);
        Cache<String, User> cache = cacheManager.getCache("sample_cache");
        cache.put("test", new User("test", "test"));
        User user = cache.get("test");
        System.out.println(user.getType());
        System.out.println(user.getName());
        Cache<String, HashMap<String, Object>> cache1 = cacheManager.getCache("map_cache");
        HashMap<String, Object> map = new HashMap<>();
        map.put("Test", "Data");
        cache1.put("test1", map);
        HashMap<String, Object> data = cache1.get("test1");
        System.out.println(data.get("Test"));
        /*org.infinispan.client.hotrod.configuration.ConfigurationBuilder cb
                = new org.infinispan.client.hotrod.configuration.ConfigurationBuilder();
        cb.marshaller(new org.infinispan.commons.marshall.ProtoStreamMarshaller())
                .addContextInitializer(new SessionInitializerImpl())
                .statistics()
                .enable()
                .jmxDomain("org.example")
                .addServer()
                .host("127.0.0.1")
                .port(11222)
                .security()
                .authentication()
                .username("3NPylMBvmT")
                .password("lhDRse0YaQ")
                .saslMechanism("SCRAM-SHA-512")
                .realm("default");
        cb.remoteCache("sample_cache").templateName("example.PROTOBUF_DIST");
        RemoteCacheManager rmc = new RemoteCacheManager(cb.build());
        RemoteCache<String, User> cache = rmc.getCache("sample_cache");
        cache.put("test", new User("test", "demo"));
        User user = cache.get("test");
        System.out.println(user.getName());
        System.out.println(user.getType());*/
    }
}
