package com.mikan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchChineseCharacters {
	/** 
     * 根据输入的内容，匹配出包含中文但不包含comment的<a>标签中的中文字符 
     * @param source 要匹配的内容 
     * @return <a>标签中的中文字符 
     */  
    public static String matchChineseCharacters(String source) {  
        //匹配出包含中文但不包含comment的<a>标签  
//        String reg = "(<a[^(comment)]*?>)([^<>]*?[\\u4e00-\\u9fa5]+[^<>]*?)+(?=</a>)";  
        String reg = "<a((?!comment).)*?>([^<>]*?[\\u4e00-\\u9fa5]+[^<>]*?)+(?=</a>)";  
        Pattern pattern = Pattern.compile(reg);  
        Matcher matcher = pattern.matcher(source);  
        StringBuilder character = new StringBuilder();  
        while(matcher.find()){  
            String result = matcher.group();  
            System.out.println(result);  
            //对结果进行二次正则，匹配出中文字符  
            String reg1 = "[\\u4e00-\\u9fa5]+";  
            Pattern p1 = Pattern.compile(reg1);  
            Matcher m1 = p1.matcher(result);  
            while(m1.find()){  
                character.append(m1.group());  
            }  
            //System.out.println(character.toString());  
        }  
        return character.toString();  
    }  
      
    public static void main(String[] args) { 
    	String str = "<a href='www.baidu.comds=id32434#'rewr>特432</a>453543<a guhll,,l>a1特123你好123吗？</a><a href=id=32434#comment'ewrer>特2</a><a>标签中的文字</a>";
        String result = matchChineseCharacters(str);  
        System.out.println(result);  
    }  
}
