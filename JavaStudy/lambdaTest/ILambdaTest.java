/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */


/* 함수적 인터페이스 선언 */
@FunctionalInterface    // 함수적 인터페이스가 아닐경우 에러 표기
interface ILambdaTest1 {
    public void test();
}


@FunctionalInterface
interface ILambdaTest2 {
    //  반환값이 ㅇ벗고 매개변수가 있는 메서드
    public void test(int a);
}

@FunctionalInterface
interface ILambdaTest3 {
    public int test(int a, int b);
}