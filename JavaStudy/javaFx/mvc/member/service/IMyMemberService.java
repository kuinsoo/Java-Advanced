package member.service;



import member.vo.MyMemberVo;

import java.util.List;

public interface IMyMemberService {

    /**
     * MemberVO에 담겨진 자료를 DB에 insert하는 메서드
     *
     * @param	MemberVO memVo insert할 자료가 저장된 MemberVO객체
     * @return 	int DB작업이 성공하면 1이상의 정수값이 반환된다
     * 				싱패하면 0이 반환된다.
     * @author	"Mr_KKu"
     * @since 	2018. 8. 6.
     */
    public int insertMember(MyMemberVo memVo);

    /**
     * 회원 ID값을 매개변수로 받아서 해당 회원 정보를 삭제하는 메서드
     *
     * @param	String memId 삭제할 회원 ID값이 저장된 String 변수
     * @return 	int 작업성공:1, 실패 : 0
     * @author	"Mr_KKu"
     * @since 	2018. 8. 6.
     */
    public int delleteMember(String memId);

    /**
     * 하나의 MemberVO 자료를 이용하여 DB를 update하는 메서드
     *
     * @param	MemberVO memberVo update할 회원 정보가 들어있는 MemberVO객체
     * @return 	int 작업성공 :1, 살패 :0
     * @author	"Mr_KKu"
     * @since 	2018. 8. 6.
     */
    public int updateMember(MyMemberVo memVo);

    /**
     * DB의 mymember테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메서드
     *
     * @param
     * @return 	List<MemberVO> 객체를 담고 있는 List객체
     * @author	"Mr_KKu"
     * @since 	2018. 8. 6.
     */
    public List<MyMemberVo> getAllMemberList();

    /**
     * 주어진 회원ID의 존재 여부를 알아내는 메서드
     *
     * @param	String memId 검색할 회원 ID
     * @return 	int	해당 회원ID가 있으면 1, 없으면 0 을 반환
     * @author	"Mr_KKu"
     * @since 	2018. 8. 6.
     */
    public int getMember(String memId);

}
