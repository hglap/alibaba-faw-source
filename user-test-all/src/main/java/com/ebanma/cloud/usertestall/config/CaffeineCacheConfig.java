package com.ebanma.cloud.usertestall.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 开启缓存框架配置类，此示例使用的是本地缓存，若在分布式系统中，需要替换的redis中
 */
@Configuration
@EnableCaching
public class CaffeineCacheConfig {

    /**
     * 手动建造缓存
     * @return
     */
    @Bean("cacheManager")
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        // 缓存集合
        ArrayList<CaffeineCache> caches = new ArrayList<>();
        // 对缓存key属性做设置
        caches.add(new CaffeineCache("user-cache", Caffeine.newBuilder()
                // 指定Key下的最大缓存数据量
                .maximumSize(1024)
                // 最后一次访问之后 120秒 过期
                .expireAfterAccess(120, TimeUnit.SECONDS)
                .build()));
        cacheManager.setCaches(caches);
        return cacheManager;
    }
    /**
     * spring 的缓存的写法
     */
    //@Bean("cacheManager")
    //public CacheManager cacheManager() {
    //    SimpleCacheManager cacheManager = new SimpleCacheManager();
    //    cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("user-cache")));
    //    return cacheManager;
    //}
}
