FROM emp e LEFT OUTER JOIN dept d 
SELECT empno, ename, sal, d.deptno, dname, loc 
ON (e.deptno = d.deptno);
