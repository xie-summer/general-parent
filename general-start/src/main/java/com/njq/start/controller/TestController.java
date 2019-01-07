package com.njq.start.controller;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.lang.Nullable;

public class TestController {

	public static void main(String[] args) {
		System.out.println(DateTime.now().getDayOfWeek());
		System.out.println(Period.weeks(1).toString());

//		String[] s=new String[1];
//		s[0]="ftl/*";
//		TestController.simpleMatch(s, "ftl/abc");
	}
	
	public static boolean simpleMatch(@Nullable String[] patterns, String str) {
		if (patterns != null) {
			for (String pattern : patterns) {
				if (simpleMatch(pattern, str)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean simpleMatch(@Nullable String pattern, @Nullable String str) {
		if (pattern == null || str == null) {
			return false;
		}
		int firstIndex = pattern.indexOf('*');
		if (firstIndex == -1) {
			return pattern.equals(str);
		}
		if (firstIndex == 0) {
			if (pattern.length() == 1) {
				return true;
			}
			int nextIndex = pattern.indexOf('*', firstIndex + 1);
			if (nextIndex == -1) {
				return str.endsWith(pattern.substring(1));
			}
			String part = pattern.substring(1, nextIndex);
			if ("".equals(part)) {
				return simpleMatch(pattern.substring(nextIndex), str);
			}
			int partIndex = str.indexOf(part);
			while (partIndex != -1) {
				if (simpleMatch(pattern.substring(nextIndex), str.substring(partIndex + part.length()))) {
					return true;
				}
				partIndex = str.indexOf(part, partIndex + 1);
			}
			return false;
		}
		return (str.length() >= firstIndex &&
				pattern.substring(0, firstIndex).equals(str.substring(0, firstIndex)) &&
				simpleMatch(pattern.substring(firstIndex), str.substring(firstIndex)));
	}
}
