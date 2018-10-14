/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main;



import action.*;
import dao.UserDAO;

import java.util.Scanner;

public class UserMain {
    public void menu() {

        while (true) {

            System.out.println("******	메뉴	******");

            System.out.println("   1. 사용자 조회");

            System.out.println("   2. 사용자 입력");

            System.out.println("   3. 사용자 수정");

            System.out.println("   4. 사용자 삭제");

            System.out.println("   5. 종료");

            System.out.println("****************");

            System.out.print("메뉴를 선택하세요: ");



            Scanner scan = new Scanner(System.in);

            int iSelectMenu = scan.nextInt();



            if(iSelectMenu==5) break;



            UserAction userAction = null;



            switch (iSelectMenu) {

                case 1:

                    userAction = new UserSelectAction();

                    break;

                case 2:

                    userAction = new UserInsertAction();

                    break;

                case 3:

                    userAction = new UserUpdateAction();

                    break;

                case 4:

                    userAction = new UserDeleteAction();

                    break;

                default:

                    System.out.println("1~5 값만 선택하세요.");

            }

            if(userAction != null)

                userAction.execute();



        }



    }



    public static void main(String[] args) {

        UserMain userMain = new UserMain();

        userMain.menu();

        System.out.println("종료되었습니다.");

    }

}
