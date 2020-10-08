-- --------------------------------------------------------
-- 호스트:                          192.168.0.106
-- 서버 버전:                        10.3.17-MariaDB - MariaDB Server
-- 서버 OS:                        Linux
-- HeidiSQL 버전:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- sungjuk_test 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `sungjuk_test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sungjuk_test`;

-- 테이블 sungjuk_test.school 구조 내보내기
CREATE TABLE IF NOT EXISTS `school` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `schoolname` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `schoolcode` char(10) CHARACTER SET utf8 NOT NULL,
  `studentcount` int(11) DEFAULT NULL,
  PRIMARY KEY (`schoolcode`) USING BTREE,
  KEY `no` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- 테이블 데이터 sungjuk_test.school:~4 rows (대략적) 내보내기
DELETE FROM `school`;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` (`no`, `schoolname`, `address`, `schoolcode`, `studentcount`) VALUES
	(2, '충주여자고등학교', '충주시', 'CH00000001', 360),
	(4, '인천남자고등학교', '인천시', 'IC00000001', 560),
	(5, '종로여자고등학교', '종로구', 'JR00000001', 350),
	(3, '서울여자고등학교', '서울시', 'SE00000001', 1200);
/*!40000 ALTER TABLE `school` ENABLE KEYS */;

-- 프로시저 sungjuk_test.school_insert 구조 내보내기
DELIMITER //
CREATE PROCEDURE `school_insert`(
	IN `schoolname` VARCHAR(50),
	IN `address` VARCHAR(50),
	IN `schoolcode` CHAR(10),
	IN `studentcount` INT,
	OUT `result` INT
)
BEGIN
	DECLARE exit handler FOR SQLEXCEPTION
	BEGIN
		ROLLBACK;
		SET result= -1;
	END;
	
	START TRANSACTION;
	  INSERT INTO school(schoolname, address, schoolcode, studentcount) 
	  VALUE(schoolname, address, schoolcode, studentcount);
	COMMIT;
	SET result=0;
		
END//
DELIMITER ;

-- 테이블 sungjuk_test.student 구조 내보내기
CREATE TABLE IF NOT EXISTS `student` (
  `bunho` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `kor` tinyint(4) DEFAULT NULL,
  `mat` tinyint(4) DEFAULT NULL,
  `eng` tinyint(4) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `average` float DEFAULT NULL,
  `grade` char(4) CHARACTER SET utf8 DEFAULT NULL,
  `schoolcode` char(10) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`bunho`),
  KEY `name` (`name`),
  KEY `FK_student_school` (`schoolcode`),
  CONSTRAINT `FK_student_school` FOREIGN KEY (`schoolcode`) REFERENCES `school` (`schoolcode`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

-- 테이블 데이터 sungjuk_test.student:~8 rows (대략적) 내보내기
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`bunho`, `name`, `kor`, `mat`, `eng`, `total`, `average`, `grade`, `schoolcode`) VALUES
	(2, '김만덕', 100, 99, 99, 298, 99.33, 'A', 'CH00000001'),
	(3, '고려인', 100, 99, 99, 298, 99.33, 'A', 'CH00000001'),
	(4, '종로구', 100, 80, 70, 250, 83.33, 'B', 'IC00000001'),
	(28, '전공사', 11, 22, 33, 66, 22, 'F', 'SE00000001');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- 프로시저 sungjuk_test.student_delete 구조 내보내기
DELIMITER //
CREATE PROCEDURE `student_delete`(
	IN `name1` VARCHAR(50),
	OUT `result` INT
)
BEGIN
	DECLARE cnt INT DEFAULT 0; # int cnt=0
	SELECT COUNT(*) INTO cnt FROM student WHERE NAME=NAME1;
	if cnt>0 then DELETE FROM student WHERE NAME=NAME1;
		SET result=0;
	ELSE SET result=2;
	END if;
END//
DELIMITER ;

-- 프로시저 sungjuk_test.student_insert 구조 내보내기
DELIMITER //
CREATE PROCEDURE `student_insert`(
	IN `name` VARCHAR(50),
	IN `kor` TINYINT,
	IN `mat` TINYINT,
	IN `eng` TINYINT,
	IN `schoolcode` CHAR(10),
	OUT `result` INT
)
BEGIN
	DECLARE exit handler FOR SQLEXCEPTION
	BEGIN
		ROLLBACK;
		SET result= -1;
	END;
	
	START TRANSACTION;
	INSERT INTO student(NAME, kor, mat, eng, schoolcode) VALUE(NAME, kor, mat, eng, schoolcode);
	COMMIT;
	SET result=0;
		
END//
DELIMITER ;

-- 프로시저 sungjuk_test.student_select 구조 내보내기
DELIMITER //
CREATE PROCEDURE `student_select`()
BEGIN
	SELECT * FROM student;
END//
DELIMITER ;

-- 프로시저 sungjuk_test.student_update 구조 내보내기
DELIMITER //
CREATE PROCEDURE `student_update`(
	IN `id1` INT,
	IN `name1` VARCHAR(50),
	IN `kor1` TINYINT,
	IN `mat1` TINYINT,
	IN `eng1` TINYINT,
	OUT `result` INT
)
BEGIN
	DECLARE cnt INT DEFAULT 0;
	DECLARE exit handler FOR sqlexception
	begin
		ROLLBACK;
		SET result=-1;
	END;
	
	START TRANSACTION;	
	SELECT COUNT(*) INTO cnt FROM student WHERE name=NAME1;
	if cnt>0 then UPDATE student SET name=NAME1, kor=kor1, mat=mat1, eng=eng1 WHERE bunho=id1;
		SET result=0; # t성공
	ELSE SET result=2; #해당데이터가 없음
	END if;	
END//
DELIMITER ;

-- 트리거 sungjuk_test.student_before_insert 구조 내보내기
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `student_before_insert` BEFORE INSERT ON `student` FOR EACH ROW BEGIN
	SET NEW.total  = NEW.kor + NEW.mat + NEW.eng;
	SET NEW.average = ROUND(NEW.total/3,2);
	
	if NEW.average >=90 then SET NEW.grade='A';
	ELSEIF NEW.average >=80 then SET NEW.grade = 'B';
	ELSEIF NEW.average >=70 then SET NEW.grade = 'C';
	ELSEIF NEW.average >=60 then SET NEW.grade='D';
	ELSE SET NEW.grade='F';
	END if;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- 트리거 sungjuk_test.student_before_update 구조 내보내기
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `student_before_update` BEFORE UPDATE ON `student` FOR EACH ROW BEGIN
	SET NEW.total  = NEW.kor + NEW.mat + NEW.eng;
	SET NEW.average = ROUND(NEW.total/3,2);
	
	if NEW.average >=90 then SET NEW.grade='A';
	ELSEIF NEW.average >=80 then SET NEW.grade = 'B';
	ELSEIF NEW.average >=70 then SET NEW.grade = 'C';
	ELSEIF NEW.average >=60 then SET NEW.grade='D';
	ELSE SET NEW.grade='F';
	END if;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
