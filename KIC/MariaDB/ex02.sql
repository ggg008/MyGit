//사원, 부서, 호봉 테이블에서 사원번호, 사원이름, 급여, 호봉, 부서이름, 부서위치 출력 (다시한번)
SELECT empno, ename, sal, grade, dname, loc 
FROM emp e INNER JOIN dept d INNER JOIN salgrade s 
/* 조인을 위한 조건 */
ON (e.deptno = d.deptno AND e.sal BETWEEN s.losal AND s.hisal) 
/* 필터링을 위한 조건 */
WHERE e.deptno = 10;