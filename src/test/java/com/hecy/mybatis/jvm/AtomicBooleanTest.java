package com.hecy.mybatis.jvm;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author: hecy
 * @Date: 2018/12/17 16:12
 * @Version 1.0
 */
public class AtomicBooleanTest implements Runnable {
    public static AtomicBoolean exits = new AtomicBoolean(true);
    public static  int flag = 1000;
    private static int _1MB = 1024 * 1024;
    public static void main(String[] args) throws InterruptedException {
//        testAllocation();
        testTenuringThreshold();
        Thread.sleep(1000000);
//        AtomicBooleanTest abd = new AtomicBooleanTest();
//        for(int i=0;i<1000; i++){
//            Thread t1 = new Thread(abd);
//            t1.setName(i + "_");
//            t1.start();
//            t1.join();
//        }
//         System.out.println(flag);
//        Thread t1 = new Thread(abd);
//        Thread t2 = new Thread(abd);
//        t1.start();
//        t2.start();
    }


    /**
     * VM 参数  -verbose:gc -Xms20M -Xmx20M -Xmn10M  -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -Xms20M -Xmx20M  限制了Java堆大小为20M ，
     * -Xmn10M 其中10M 分配给了新生代，剩下的10M 分配给了老年代了
     * -XX:SurvivorRatio=8 决定了新生代中Eden区与一个Survivor区的空间比例为8:1
     */
    public static void testAllocation(){
        byte [] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[4 * _1MB];
        allocation2 = new byte[5 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];

    }

    /**
     *  VM 参数  -verbose:gc -Xms20M -Xmx20M -Xmn10M  -XX:+PrintGCDetails -XX:SurvivorRatio=8
     *  -XX:MaxTenuringThreshold = 1
     *  [GC (Allocation Failure) [PSYoungGen: 4365K->1016K(9216K)] 12557K->9807K(19456K), 0.0012538 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * Heap
     *  PSYoungGen      total 9216K, used 5252K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
     *   eden space 8192K, 51% used [0x00000000ff600000,0x00000000ffa22fe8,0x00000000ffe00000)
     *   from space 1024K, 99% used [0x00000000ffe00000,0x00000000ffefe020,0x00000000fff00000)
     *   to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
     *  ParOldGen       total 10240K, used 8791K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
     *   object space 10240K, 85% used [0x00000000fec00000,0x00000000ff495ee8,0x00000000ff600000)
     *  Metaspace       used 3344K, capacity 4500K, committed 4864K, reserved 1056768K
     *   class space    used 356K, capacity 388K, committed 512K, reserved 1048576K
     *
     * Process finished with exit code 0
     *
     *
     */
    public static void testTenuringThreshold(){
        byte [] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[ _1MB / 4];
        // 什么时候进入老年代取决于 XX: MaxTenuringThreshold 设置
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    public void ru1n() {
        flag --;

    }

    public void run() {
        synchronized (exits){
            flag --;
        }

    }

     public void run1() {
//        System.out.println(Thread.currentThread().getName() + " begin run");
//        System.out.println(Thread.currentThread().getName() +  " real " + exits.get());
        if(exits.compareAndSet(true,false)){
            System.out.println(flag);
            flag --;
//            System.out.println(Thread.currentThread().getName() + "  " + exits.get() );
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            exits.set(true);
        }else{
            run();
        }

    }

}
