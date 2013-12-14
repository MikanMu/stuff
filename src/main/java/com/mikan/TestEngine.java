package com.mikan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestEngine {
	
	public static void main(String[] args) {
		Matcher matcher = Pattern.compile("nfa|nfa not").matcher("nfa not");
		if (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
