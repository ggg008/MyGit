CREATE VIEW emp_sal 
AS SELECT empno, ename, sal, grade 
FROM (SELECT empno, ename, sal FROM emp) e INNER JOIN salgrade s
ON (e.sal BETWEEN s.losal AND s.hisal);
/* ÀÎ¶óÀÎºä + Á¶ÀÎ => ºä (º¸¾È)*/