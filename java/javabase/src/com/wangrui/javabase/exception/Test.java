package com.wangrui.javabase.exception;

public class Test {

	
	public static int chu(int a, int...b)throws ParameterException, NullArrayException { // �����������÷����п����׳��쳣��
		int result = 0;
		
		if(b==null) {
			throw new NullArrayException("����Ϊ��"); // �׳��쳣����
		}
		
		if(!(b.length>0)) {
			
			throw new ParameterException("����b������һ��ֵ"); // �׳��쳣����
			
		}else{
			for(int i : b) {
				if(i==0) {
					throw new ParameterException("����b�е�ֵ����Ϊ0"); // �׳��쳣����
				}
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {// �����������÷����п����׳��쳣��
		
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
