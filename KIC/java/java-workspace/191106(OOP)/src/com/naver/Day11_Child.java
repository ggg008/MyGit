package com.naver;

public class Day11_Child extends Day11_Parent {
	
	public void viewChild() {
		System.out.println("Child viewChild");
	}

	@Override
	public void viewParent() {
		// TODO Auto-generated method stub
//		super.viewParent();
		this.viewChild();
	}
	
	//annotation
//	@Override
//	public void viewParent() {
//		// TODO Auto-generated method stub
//		super.viewParent();
//	}
	
}
