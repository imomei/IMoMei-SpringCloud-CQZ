package com.imomei.common.utils;

/**
 * 随机数生成工具类
 */
public class RandomUtils {
    /**
     * 生成20位以内指定位数随机数
     *
     * @param size 指定位数（1-20）
     * @return
     */
    public synchronized static int getRandomNum(int size) {
        if (size > 0 && size < 21) {
            int a = 1;
            for (int i = 0; i < size - 1; i++) {
                a = a * 10;
            }
            return (int) ((Math.random() * 9 + 1) * a);
        }
        return 0;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(RandomUtils.getRandomNum(5));
        }
    }
}
