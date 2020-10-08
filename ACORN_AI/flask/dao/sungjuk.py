import json
import pymysql
def getConnection():
	return pymysql.connect(host="192.168.0.106", port=3306, user='root', passwd='1234acorn', 
		use_unicode=True, db='sungjuk_test', autocommit=True)

def getSungjuk():
	conn = getConnection()
	cur = conn.cursor()
	cur.callproc("student_select")
	if cur.rowcount:
		result = cur.fetchall()
		# print(result) # debug
	else :
		result = 0
	cur.close()
	conn.close()
	return result

def setSungjuk(sungData): # 나중에 수정 : out 값으로 확인가능하게
	conn = getConnection()
	cur = conn.cursor()
	args = (sungData['name'], int(sungData['kor']), int(sungData['mat']), int(sungData['eng']), 'CH00000001', 0)
	cur.callproc("student_insert", args)
	result = cur.rowcount	
	# cur.execute('select @_student_insert_5') # @ DB 사용자 정의 변수 # 5번째 데이터를 받아와라
	# result = cur.fetchone()
	cur.close()
	conn.close()
	return json.dumps({"rows":result}) # json으로 데이터전달 (형변환 ajax에서 사용)

def delSungjuk(in_name): 
	conn = getConnection()
	cur = conn.cursor()
	args = (in_name, -1)
	cur.callproc("student_delete", args)
	cur.execute('select @_student_delete_1')	
	result = cur.fetchone()	
	cur.close()
	conn.close()
	print('삭제: ', args, result)
	return json.dumps({"rows":result}) # json으로 데이터전달 (형변환 ajax에서 사용)

#업데이트를 작성하시오
def putSungjuk(sungData): 
	conn = getConnection()
	cur = conn.cursor()
	args = (int(sungData['id1']), int(sungData['name1']), int(sungData['kor1']), int(sungData['mat1']), 
		int(sungData['eng1']), 0)
	cur.callproc("student_update", args)
	cur.execute('SELECT @_student_update_5')	
	result = cur.fetchone()	
	cur.close()
	conn.close()
	return json.dumps({"rows":result}) # json으로 데이터전달 (형변환 ajax에서 사용)
