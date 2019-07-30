package ar.com.maxo;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.impl.ConfigurationProperties;
 
public class InfinispanRemote {
 
   public static void main(String[] args) {
      // Create a configuration for a locally-running server
      ConfigurationBuilder builder = new ConfigurationBuilder();
      builder.addServer().host("127.0.0.1").port(ConfigurationProperties.DEFAULT_HOTROD_PORT);
      // Connect to the server
      RemoteCacheManager cacheManager = new RemoteCacheManager(builder.build());

      getCacheConfigs(cacheManager);
      putAndGetKeyValueExample(cacheManager);
      getKeyValueExample(cacheManager);
      putAndGetKeyIntegerValueExample(cacheManager);
      getKeyValueExample(cacheManager);
      getCacheConfigs(cacheManager);


      // Stop the cache manager and release all resources
      cacheManager.stop();
   }

   public static void putAndGetKeyValueExample(RemoteCacheManager cacheManager){
       System.out.println(">>>>>> putAndGetKeyValueExample: ");
       // Obtain the remote cache
       RemoteCache<String, String> cache = cacheManager.getCache();
       System.out.println("======= Obtain dafault Cache =======");
       /// Store a value
       cache.put("key", "value");
       System.out.println("======= PUT (key : value) =======");
       // Retrieve the value and print it out
       System.out.printf("Obtain key = %s\n", cache.get("key"));
       System.out.println("<<<<<<");
   }

   public static void getKeyValueExample(RemoteCacheManager cacheManager){
       System.out.println(">>>>>> getKeyValueExample: ");
       // Obtain the remote cache
       RemoteCache<String, String> cache = cacheManager.getCache();
       System.out.println("======= Obtain dafault Cache =======");
       // Retrieve the value and print it out
       System.out.printf("Obtain key = %s\n", cache.get("key"));
       System.out.println("<<<<<<");
   }

    public static void putAndGetKeyIntegerValueExample(RemoteCacheManager cacheManager){
        System.out.println(">>>>>> putAndGetKeyIntegerValueExample: ");
        // Obtain the remote cache
        RemoteCache<String, Integer> cache = cacheManager.getCache();
        System.out.println("======= Obtain dafault Cache =======");
        /// Store a value
        cache.put("key", 456);
        System.out.println("======= PUT (key : value) =======");
        // Retrieve the value and print it out
        System.out.printf("Obtained key = %s\n", cache.get("key"));
        System.out.println("<<<<<<");
    }


    public static void getCacheConfigs(RemoteCacheManager cacheManager){
        System.out.println(">>>>>> getCacheConfigs: ");
        // Obtain the remote cache
        Configuration cacheConfig = cacheManager.getConfiguration();
        System.out.println("======= Obtain cache configuration =======");
        System.out.println("Obtained cache configs: " + cacheConfig);
        System.out.println("<<<<<<");
    }
}