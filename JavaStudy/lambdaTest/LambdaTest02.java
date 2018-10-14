/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

public class LambdaTest02 {
    public static void main(String[] args) {
        System.out.println("리턴 X , 매개변수 X  람다식");
        // 람다식을 사용하지 않을 경우
        ILambdaTest1 t1 = new ILambdaTest1() {
            @Override
            public void test() {
                System.out.println("안녕하세요~~");
            }
        };
        t1.test();


        // 람다식 표현
        ILambdaTest1 t2 = () -> {
            System.out.println("()->{방식}");
        };
        t2.test();

        ILambdaTest1 t3 = () -> System.out.println("() -> 방식 ");

        t3.test();

        System.out.println("============================================================");
        System.out.println("리턴 X , 매개변수 O => 람다식");
        //------------------------------------------------------------------------------

        ILambdaTest2 t4 = (int a) -> {
            int result = a + 10;
            System.out.println("(int a ) -> {} 방식 / result = " + result );
        };
        t4.test(6);

        ILambdaTest2 t5 = (a) -> {
            int r = a * 20;
            System.out.println("(a) -> {} 방식  / r = " + r);
        };
        t5.test(8);

        ILambdaTest2 t6 = a -> System.out.println("a -> 방식 /" + a + 50);
        t6.test(3);

        System.out.println("============================================================");
        System.out.println("리턴 O , 매개변수 O => 람다식");
        //------------------------------------------------------------------------------

        ILambdaTest3 t7 = (int a, int b) -> {
            int r = a * b;
            return r;
        };
        int k = t7.test(4,8);
        System.out.println("(int a, int b) -> { return } "+ "k = " + k);

        ILambdaTest3 t8 = (a, b) -> {
            return a - b  ;
        };
        k = t8.test(32, 21 );
        System.out.println("(a,b) -> { return } k = " + k);

        ILambdaTest3 t9 = (a, b) -> a + b;
        k = t9.test(14,20);
        System.out.println("(a,b) -> a + b k = " + k);
    }
}
