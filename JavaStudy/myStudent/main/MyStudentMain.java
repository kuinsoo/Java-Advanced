package main;

import service.IMyStudentService;
import service.MyStudentService;
import vo.MyStudenVo;

public class MyStudentMain {

    public static void main(String[] args) {
    IMyStudentService service = MyStudentService.getInstance();
        System.out.println( service.allMyStuden());
        for (MyStudenVo myStudenVo: service.allMyStuden()
             ) {
            System.out.println(myStudenVo.getStd_name());
            System.out.println(myStudenVo.getStd_kor());
            System.out.println(myStudenVo.getStd_eng());
            System.out.println(myStudenVo.getStd_mat());
        }
    }
}
