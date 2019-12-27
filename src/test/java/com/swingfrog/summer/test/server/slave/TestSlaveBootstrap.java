package com.swingfrog.summer.test.server.slave;

import com.swingfrog.summer.app.Summer;
import com.swingfrog.summer.app.SummerApp;
import com.swingfrog.summer.app.SummerConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestSlaveBootstrap implements SummerApp {

    @Override
    public void init() {
        log.info("init");
    }

    @Override
    public void start() {
        log.info("start");
    }

    @Override
    public void stop() {
        log.info("stop");
    }

    public static void main(String[] args) throws Exception {
        String resources = TestSlaveBootstrap.class.getClassLoader().getResource("server/slave").getPath();
        Summer.hot(SummerConfig.newBuilder()
                .app(new TestSlaveBootstrap())
                .dbProperties(resources + "/db.properties")
                .logProperties(resources + "/log.properties")
                .redisProperties(resources + "/redis.properties")
                .serverProperties(resources + "/server.properties")
                .taskProperties(resources + "/task.properties")
                .build());
    }

}
