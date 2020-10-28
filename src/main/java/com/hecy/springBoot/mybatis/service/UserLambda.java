package com.hecy.springBoot.mybatis.service;

/**
 * @Author: hecy
 * @Date: 2019/8/29 10:35
 * @Version 1.0
 */
public class UserLambda {

    public static void execute(WorkerInterface workerInterface) {
        workerInterface.doSomeWork("aaa");
    }

    public static void main(String[] args) {
        execute(new WorkerInterface() {
            @Override
            public void doSomeWork(String d) {
                System.out.println("传统方式");
            }
        });
        execute(a -> System.out.println("Lambda 方式"+a));
    }

}
