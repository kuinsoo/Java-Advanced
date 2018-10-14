/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package dao;

import vo.MyMemberVo;

import java.util.List;

public interface IMyMemberDao {

    public int insertMyMember(MyMemberVo myMemberVo);

    public MyMemberVo selectMyMember(String myMemberId);

    public List<MyMemberVo> selectAllMyMember();

    public int deleteMyMember(String myMemberId);

    public int doubleCheckId(String myMemberId);
}
