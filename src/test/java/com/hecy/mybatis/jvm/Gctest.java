package com.hecy.mybatis.jvm;

/**
 * @Author: hecy
 * @Date: 2018/12/13 14:17
 * @Version 1.0
 */
public class Gctest {
    public static Gctest GC_HOOK = null;

    public void isActive(){
        System.out.println("我还活着，还可以抢救一下。");
    }
    @Override
    public void finalize() throws Throwable {
        super.finalize();
        System.out.println("完了，在不救我，我就死了。");
        Gctest.GC_HOOK = this;
    }


    public static void main(String []args) throws InterruptedException {
        GC_HOOK = new Gctest();
        GC_HOOK = null;
        System.gc();
        // 因为finalize() 方法优先级很低，所以暂定0.5s
        Thread.sleep(500);
        if(GC_HOOK != null) {
            GC_HOOK.isActive();
        } else {
            System.out.println("好吧，我死了");
        }

        GC_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(GC_HOOK != null) {
            GC_HOOK.isActive();
        } else {
            System.out.println("好吧，我死了");
        }

    }
}
