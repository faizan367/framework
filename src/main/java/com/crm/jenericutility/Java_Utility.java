package com.crm.jenericutility;

import java.util.Random;

public class Java_Utility {
	public int getRanDomNum()
	{
	Random ran=new Random();
	int RanNum = ran.nextInt(1000);
	return RanNum;

	}
}
