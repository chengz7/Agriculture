package com.farm;

import com.farm.netty.FarmNettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 不直接使用 mvn install 构建，使用mvn package -DskipTests命令构建
 * nohup java -jar xxxx.jar & 在Linux下以服务启动启动 按一下ENTER回车
 * ps aux | grep "java -jar" 查找以java -jar *.jar 运行的springboot项目PID
 * netstat -anp|grep PID 通过进程id查看进程信息
 * rm -r * 删除当前目录下的所有文件及目录
 * kill -9 PID 杀死进程
 */
@SpringBootApplication
@MapperScan("com.farm.dao")
@EnableScheduling
public class InitApplication implements CommandLineRunner {

    @Autowired
    private FarmNettyServer myServer;

    public static void main(String[] args) {
        SpringApplication.run(InitApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        myServer.run(8765);
    }
}
