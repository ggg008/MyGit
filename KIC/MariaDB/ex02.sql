//���, �μ�, ȣ�� ���̺��� �����ȣ, ����̸�, �޿�, ȣ��, �μ��̸�, �μ���ġ ��� (�ٽ��ѹ�)
SELECT empno, ename, sal, grade, dname, loc 
FROM emp e INNER JOIN dept d INNER JOIN salgrade s 
/* ������ ���� ���� */
ON (e.deptno = d.deptno AND e.sal BETWEEN s.losal AND s.hisal) 
/* ���͸��� ���� ���� */
WHERE e.deptno = 10;