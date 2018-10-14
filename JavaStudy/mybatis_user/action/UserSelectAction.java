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

import java.util.List;

public class UserSelectAction implements UserAction {
    @Override
    public void execute() {
            //DB

        UserDAO userDao = UserDAO.getInstance();

        List<UserDTO> list = userDao.getUserList();



        // 출력

        for(UserDTO data : list){

            System.out.println(data.getName() + "\t" + data.getId() + "\t" + data.getPwd());

        }

        System.out.println();

    }
}

