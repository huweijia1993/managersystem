package com.clps.managersystem.util;

import org.junit.Test;

import com.clps.managersystem.utils.Md5Util;

public class TestMd5 {

	@Test
	public void test(){
		
		String value=Md5Util.getMD5Code("abc");
		System.out.println(value);
		
	}
}
