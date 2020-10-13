insert into school(schoolname, address, schoolcode, studentcount)
				VALUES("충주여자고등학교", "충주시", "studentCH00000001", 360);
insert into school(schoolname, address, schoolcode, studentcount)
				VALUES("서울여자고등학교", "서울시", "SE00000001", 1200);
insert into school(schoolname, address, schoolcode, studentcount)
				VALUES("인천남자고등학교", "인천시", "IC00000001", 560);

SELECT * from school

insert INTO student(NAME, kor, mat, eng, school_code)
		VALUES('김민덕', 100, 99, 99, 'CH00000001');
insert INTO student(NAME, kor, mat, eng, school_code)
		VALUES('고려인', 100, 99, 99, 'CH00000001');
insert INTO student(NAME, kor, mat, eng, school_code)
		VALUES('종로구', 100, 80, 70, 'IC00000001');
		
CALL student_select;
# subquery
SELECT NAME, kor, mat, eng FROM student WHERE schoolcode IN (SELECT schoolcode FROM school);

SELECT NAME, kor, mat, eng FROM student WHERE NAME = LIKE '김%';
CREATE TABLE if NOT EXISTS student_backup SELECT * FROM student;
SELECT * FROM student WHERE kor>90 AND mat>90 AND eng>90;
SELECT * FROM student WHERE kor BETWEEN 60 AND 80;
SELECT * FROM student LIMIT 2;
SELECT * FROM student ORDER BY NAME DESC; #내림차순 ASC
SELECT sc.schoolname, sc.schoolcode, st.name, st.average 
	FROM student st INNER JOIN school sc 
	ON st.schoolcode = sc.schoolcode;
SELECT SUM(total) FROM student group BY schoolcode; # 그룹화

SET @result=0;
CALL school_insert('종로여자고등학교', '종로구', 'JR00000001', 350, @result);
SELECT @result;
SELECT * from school;

#전공인의 이름뒤에 '님'자를 붙히고 국어 수락 영어 점수를 출력하시오
SELECT CONCAT(NAME, '님'), kor, mat, eng FROM student;

#학교별로 총점의 합계를 구하시오 # group by => pandas #inner join으로 실습
SELECT sc.schoolname, SUM(st.total) FROM school sc INNER JOIN student st 
	WHERE sc.schoolcode = st.schoolcode GROUP BY sc.schoolname;
	
#학교별로 그릅핑하고 학교코드와 학교 이름 그리고 총점의 합계를 구하고 출력하시오
SELECT sc.schoolname, sc.schoolcode, (ifnull(st.total, 0)) AS '총점' FROM school sc left outer JOIN student st 
	ON sc.schoolcode = st.schoolcode GROUP BY sc.schoolname;
	
#서울 여자 고등학생들만 별도로 백업하시오


#수정프로시저를 이용하여 전공사의 국어=10 수학=20 영어=30점으로 수정하고 결과를 출력하시오
#CALL student_update('김만덕', 10, 20, 30, @result);
SET @id1=0; SELECT bunho INTO @id1 from student WHERE NAME = '전공사'; SELECT @id1; 
SET @result=0; CALL student_update(@id1, '전공사', 10, 80, 99, @result); SELECT @result;

CALL student_insert('전공사', 11, 22, 33, 'SE00000001', @result);
CALL student_insert('aaa', 11, 22, 33, 'SE00000001', @result);

CALL student_delete('전공사', @result);

CALL student_select;
