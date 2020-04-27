enum Season {
	SPRING, SUMMER, FALL, WINTER
}

public class P300SeasonEnumTest {

	public void compareEnum(Season season) {
		if (season.equals(Season.SPRING)) {
			System.out.println("따뜻한 봄날입니다.");
		} else if (season.compareTo(Season.WINTER) < 0) {
			System.out.println("최소한 겨울은 아니잖아요. " + season.ordinal() + " " + Season.WINTER.ordinal() + " "
					+ season.compareTo(Season.WINTER));
		} else {
			System.out.println(season.compareTo(Season.WINTER));
		}
	}

	public void enumSwitch(Season season) {
		switch (season) {
		case SPRING:
			System.out.println("새잎이 나는 시기");
			break;
		case SUMMER:
			System.out.println("열매가 무르익는 시기");
			break;
		case FALL:
			System.out.println("잎이 떨어지는 시기");
			break;
		case WINTER:
			System.out.println("겨울잠을 자는 시기");
			break;

		default:
			System.out.println("겨울잠을 자는 시기");
			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P300SeasonEnumTest set = new P300SeasonEnumTest();
		set.compareEnum(Season.SUMMER);
		set.enumSwitch(Season.SPRING);

	}

}
