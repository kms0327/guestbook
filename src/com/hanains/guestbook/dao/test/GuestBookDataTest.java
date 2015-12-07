package com.hanains.guestbook.dao.test;

import java.util.List;

import com.hanains.guestbook.dao.GuestBookDao;
import com.hanains.guestbook.vo.GuestBookVo;

public class GuestBookDataTest {
	public static void main(String[] args){
		getListTest();
	}
	public static void getListTest(){
		GuestBookDao dao = new GuestBookDao();
		List<GuestBookVo> list = dao.getList();
		for(GuestBookVo vo : list){
			System.out.println(vo);
		}
	}
}
