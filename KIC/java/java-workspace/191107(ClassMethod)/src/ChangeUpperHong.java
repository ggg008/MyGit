
public class ChangeUpperHong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * hong kill dong -> Hong Kill Dong
		 * java 클래스명 "hong kill dong" 
		 * */
		String[][] strDualArray = new String[args.length][];
		for(int i = 0 ; i<args.length; ++i)
			strDualArray[i] = args[i].split(" ");
		
		for(String[] strArray : strDualArray)
			for(String strO : strArray)
			{
				strO = strO.substring(0, 1).toUpperCase() + strO.substring(1).toLowerCase();
				System.out.printf(strO + " ");
			}
		

	}

}
