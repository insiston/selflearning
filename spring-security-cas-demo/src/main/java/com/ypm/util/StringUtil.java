package com.ypm.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 功能描述 字符串工具类
 * 
 * @类型名称 StringUtil
 * @版本 1.0
 * @创建者 yangpengming
 * @创建时间 2015年11月4日 下午3:53:08
 * @版权所有 ©2015 中教美育
 * @修改者 yangpengming
 * @修改时间 2015年11月4日 下午3:53:08
 * @修改描述
 */
public class StringUtil
{

	/**
	 * 
	 * 功能描述：字符串判空和null值
	 * 
	 * @param str
	 * @return
	 * @版本 1.0
	 * @创建者 yangpengming
	 * @创建时间 2015年11月4日 下午3:54:48
	 * @版权所有 ©2015 中教美育
	 * @修改者 yangpengming
	 * @修改时间 2015年11月4日 下午3:54:48 修改描述
	 */
	public static boolean isEmptyOrNull(String str)
	{
		return str == null || str.isEmpty();
	}

	/**
	 * 
	 * 功能描述：字符串不为空和null
	 * 
	 * @param str
	 * @return
	 * @版本 1.0
	 * @创建者 yangpengming
	 * @创建时间 2015年11月4日 下午3:57:47
	 * @版权所有 ©2015 中教美育
	 * @修改者 yangpengming
	 * @修改时间 2015年11月4日 下午3:57:47 修改描述
	 */
	public static boolean isNotEmptyAndNull(String str)
	{
		return !isEmptyOrNull(str);
	}
	
	/**
	 * 
	 * 功能描述：将带逗号的字符串转化成list数组
	 * @param str
	 * @return 
	 * @版本 1.0
	 * @创建者 yangpengming
	 * @创建时间 2015年11月12日 下午3:55:15
	 * @版权所有 ©2015 中教美育
	 * @修改者 yangpengming
	 * @修改时间 2015年11月12日 下午3:55:15
	 * 修改描述※
	 */
	public static List<String> getSeparatorList(String str,String separator)
	{
		List<String> resultList = new ArrayList<String>();
		if(isEmptyOrNull(str))
		{
			return resultList;
		}
		if(isEmptyOrNull(separator))
		{
			separator = ",";
		}
		String[] arr = str.split(separator);
		return Arrays.asList(arr);
	}
	
}
