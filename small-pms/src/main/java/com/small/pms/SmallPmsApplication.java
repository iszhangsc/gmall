package com.small.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>
 *  商品管理服务
 * </p>
 *
 * @author zhangshichang
 * @date 2020/2/13 下午2:49
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SmallPmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmallPmsApplication.class, args);
    }

}
