package day14Class;

public class IronMan implements Heroable {
	int weaponDamage = 100;

	@Override
	public int fire() {
		// TODO Auto-generated method stub
		System.out.println("빔 발사: %d만큼의 데미지를 가함\n");
		return this.weaponDamage;
	}

	@Override
	public void changeShape(boolean isHeroMode) {
		// TODO Auto-generated method stub

		if (isHeroMode) {
			System.out.println("장갑 장착");
		} else {
			System.out.println("장갑 제거");
		}
	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		int before = weaponDamage;
		weaponDamage += weaponDamage * 0.1;
		System.out.printf("무기성능 개선: %d --> %d\n", before, weaponDamage);
	}

}
