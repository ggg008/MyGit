import java.util.Arrays;

public class P163ArrayCopy
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		int[] originSource = {1, 2, 3, 4, 5};
		
		
		int[] pastetarget = new int[10];
		for(int i = 0; i < originSource.length; ++i) {
			pastetarget[i] = originSource[i];
		}
		System.out.println(Arrays.toString(pastetarget));
		
		int[] pasteTarget2 = new int[10];
		System.arraycopy(originSource, 0, pasteTarget2, 1, originSource.length);//원본, 복사시작위치, 붙여넣기대상, 대상의 붙여넣기시작위치, 복사크기
		System.out.println(Arrays.toString(pasteTarget2));
		
	}

}
