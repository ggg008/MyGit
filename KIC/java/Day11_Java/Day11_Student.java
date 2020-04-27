/*
    com.naver라는 패키지안에
    이름 학번 나이 키로 구성되는
    student라는 클래스를 만들고 활용하는 
    프로그램 제작
*/
package com.naver;

public class Day11_Student{
    private int hakbun;
    private String name;
    private int age;
    private double height;


    public void setHakbun(int hakbun){
        this.hakbun = hakbun;
    }
    public int getHakbun(){
        return this.hakbun;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    public void setHeight(double height){
        this.height = height;
    }
    public double getHeight(){
        return this.height;
    }


}