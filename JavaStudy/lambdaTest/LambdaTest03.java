/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

public class LambdaTest03 {
    public void myMethod(final int temp) {
        int localVar = 40;

        // 람다식
        ILambdaTest1    lt = () -> {
            // 람다식 내에서 지역변수를 사용하는 경우
            // 이 때 지역변수는 final 이어야 한다
            // 지역변수가 선언되어 초기화된 후 값의 변화가 없을 경우에는
            // 컴파일러가 자동으로 final 을 붙여 준다.
            System.out.println("temp = " + temp);
            System.out.println("localVar = " + localVar ) ;
        };
        lt.test();
    }

    public static void main(String[] args) {
        LambdaTest03 lambda = new LambdaTest03();
        lambda.myMethod(50);
    }
}
