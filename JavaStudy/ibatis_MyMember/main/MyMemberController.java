package main;

import dao.IMyMemberDao;
import dao.MyMemberDaoImpl;
import vo.MyMemberVo;

public class MyMemberController {
    private IMyMemberDao myMemberDao = new MyMemberDaoImpl();

    public static void main(String[] args) {
        new MyMemberController().insertMyMember();
    }


    public void insertMyMember() {
        int intResoutValue = 0;
        MyMemberVo myMemberVo = new MyMemberVo();
        myMemberVo.setId("gooinsoo1");
        myMemberVo.setName("꾸인순");
        myMemberVo.setTelephone("없어요");
        myMemberVo.setAddress("sdlkjflksadf");

        intResoutValue = myMemberDao.insertMyMember(myMemberVo);
        if(intResoutValue > 0 ){
            System.out.println("성공");
        } else {
            System.out.println("추가 실패");
        }
    }

    public void deleteMyMember() {

    }
}
