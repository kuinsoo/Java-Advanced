/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package action;

import bean.UserDTO;
import dao.UserDAO;

import java.util.Scanner;

public class UserUpdateAction implements UserAction {
    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);



        //DB

        UserDAO userDAO = UserDAO.getInstance();

        UserDTO userDTO = new UserDTO();

        String sId=null;

        String sPwd =null;

        boolean idCheck = false;



        while(!idCheck){

            if(sId == null){

                System.out.print("ID를 입력하세요: ");

                sId = scan.next();

            }



            if(userDAO.getUser(sId) != null){

                idCheck=true;

            }else{

                System.out.print("잘못입력하셨습니다. \n다시 ID를 입력주세요 : ");

                sId = scan.next();

            }

        }



        boolean pwdCheck = false;

        while(!pwdCheck){

            System.out.print("비밀번호를 입력하세요: ");

            sPwd = scan.next();





            if(userDAO.getUser(sId).getPwd().equals(sPwd)){

                pwdCheck = true;

            }



            if(pwdCheck == false){

                System.out.println("비밀번호가 틀렸습니다 ");

            }

        }







        System.out.print("변경할 이름을 입력하세요: ");

        String sName = scan.next();



        System.out.print("변경할 비밀번호를 입력하세요: ");

        sPwd = scan.next();



        userDTO.setId(sId);

        userDTO.setName(sName);

        userDTO.setPwd(sPwd);



        userDAO.updateUser(userDTO);



    }
}

