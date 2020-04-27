SELECT empno, ename, sal, grade, dname, loc 
FROM emp e INNER JOIN dept d 
ON e.deptno = d.deptno 
INNER JOIN salgrade s 
ON e.sal BETWEEN s.losal AND s.hisal;