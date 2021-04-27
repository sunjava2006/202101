package com.wangrui.javabase.exception;

public class Test {

	
	public static int chu(int a, int...b)throws ParameterException, NullArrayException { // 方法申明，该方法有可能抛出异常。
		int result = 0;
		
		if(b==null) {
			throw new NullArrayException("数组为空"); // 抛出异常对象
		}
		
		if(!(b.length>0)) {
			
			throw new ParameterException("参数b最少有一个值"); // 抛出异常对象
			
		}else{
			for(int i : b) {
				if(i==0) {
					throw new ParameterException("参数b中的值不能为0"); // 抛出异常对象
				}
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {// 方法申明，该方法有可能抛出异常。
		
		try {
			int a = chu(2, 0);
			System.out.println(a);
		} catch (ParameterException | NullArrayException e) {
			e.printStackTrace();
		} 
		
//		catch (Exception ex) {
//			ex.printStackTrace();
//			
//		}
		
	  
		
	}
}
