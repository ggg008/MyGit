import day15Class.exception.*;

public class P353UserManagerWithException {
	
	public boolean login(String id, String pass) {
		if (!id.equals("hong")) {
			throw new LoginFailException(LoginFailException.ErrorCode.INVALID_ID, id);
		} else if (!pass.equals("1234")) {
			throw new LoginFailException(LoginFailException.ErrorCode.INVALID_PASS, pass);
		}
		
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P353UserManagerWithException userManager = new P353UserManagerWithException();

		try {
			boolean result = userManager.login("hong", "1234");
			System.out.printf("로그인 성공 여부: %b\n", result);
		} catch (LoginFailException e) {
			// TODO: handle exception
			System.out.printf("예외처리 : %s\n", e.getLocalizedMessage());
		}
	}

}
