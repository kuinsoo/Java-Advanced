package javaFx;
/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import javafx.application.Application;
import javafx.stage.Stage;
/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
public class JavaFxLifeCycle extends Application {
    /*
        자바 GUI => AWT => Swing => javaFx

        FX에서 사용되는 객체
        - Stage(무대) 객체  => window 창을 나타내는 객체
        - Scene(장면) 객체  => 무대에는 하나의 장면이 배치 된다

        - 실행 순서
            main() 메서드 => launch() 메서드 호출 => 객체 생성 (생성자 호출) => init() 메서드
                => start() 메서드 => GUI 환경에서 작업 진행 => 종료 =>  stop  메서드
        - 종료되는 경우
            1) 마지막 윈도우 (Stage)가 닫힐 때
            2) 마지막 윈도우 (Stage)의 close() 메서드가 호출 될 때
            3) 자바코드의 Platform.exit() 메서드가 호출 될 때

                * stop() 메서드를 실행하여 종료시키는 것이 바람직하다.
                (단, System.exit(0)도 프로그램을 종료하지만 이 때는 stop() 메서드를 자동으로 호출해 주지 않는다.)
    */

    /*
        Scene 을 구성하는 객체들
        Container 객체들   => 다른 객체들을 포함하는 객체들
        Contlor 객체들     => 개별적으로 필요에 의해서 사용되는 객체들(Button, Label 등)
    */
        public static void main(String[] args) {
            System.out.println(Thread.currentThread().getName() + " main()메서드");
            launch(args);
        }

        public JavaFxLifeCycle() {
            System.out.println(Thread.currentThread().getName() + " 생성자");
        }

        @Override
        public void init() throws Exception {
            System.out.println(Thread.currentThread().getName() + " init");
        }

        @Override
        public void start(Stage primaryStage) {
            // Stage 에 나타날 Scene 을 구성하여 창을 보여주는 메서드
            System.out.println(Thread.currentThread().getName() + " Start");
            primaryStage.show();
        }

        @Override
        public void stop() throws Exception {
            System.out.println(Thread.currentThread().getName() + " Stop");
        }
}


