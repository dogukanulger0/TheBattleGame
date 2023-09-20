import java.util.Scanner;

public abstract class BattleLocation extends Location {
	protected Enemy enemy;
	protected String award;
	Scanner sc = new Scanner(System.in);

	public BattleLocation(Player player, String name, Enemy enemy, String award) {
		super(player);
		this.enemy = enemy;
		this.name = name;
		this.award = award;
	}

	public boolean getLocation() {
		int enmCount = enemy.count();
		System.out.println("-> Şuan -> " + this.getName() + " <-> Konumundasınız ");
		System.out.println("-> LÜTFEN DİKKAT BURADA -> " + enemy.getName() + " <- Yaşıyor !!!");
		System.out.println("<S> SAVAŞ ya da <K> KAÇ");
		String selCase = sc.next();
		selCase = selCase.toUpperCase();
		if (selCase.equals("S")) {
			if (combat(enmCount)) {
				System.out.println("-> " + this.getName() + " -> KONUMUNDAKİ DÜŞMANLARI ÖLDÜRDÜNÜZ <-");
				if (this.award.equals("Yemek") && player.getInv().isFood()) {
					System.out.println("-> " + this.award + " Kazandınız <-");
					player.getInv().setFood(true);
				} else if (this.award.equals("Su") && player.getInv().isWater()) {
					System.out.println("-> " + this.award + " Kazandınız <-");
					player.getInv().setWater(true);
				} else if (this.award.equals("Odun") && player.getInv().isClothes()) {
					System.out.println("-> " + this.award + " Kazandınız <-");
					player.getInv().setClothes(getLocation());
				}
				return true;
			} 
			if(player.getHealthy() <= 0) {
				System.out.println("-> Öldünüz ->");
				return false;
			}

		}
		return true;

	}

	public boolean combat(int enmCount) {
		for (int i = 0; i < enmCount; i++) {
			int defEnmHealth = enemy.getHealth();
			playerStats();
			enemyStats();
			while (player.getHealthy() > 0 && enemy.getHealth() > 0) {
				System.out.println("<V> Vur ya da <K> Kaç");
				String selCase = sc.next();
				selCase = selCase.toUpperCase();
				if (selCase.equals("V")) {
					System.out.println("-> Siz Vurdunuz <-");
					enemy.setHealth(enemy.getHealth() - player.getTotalDamage());
					afterHit();
					if (enemy.getHealth() > 0) {
						System.out.println();
						System.out.println("-> Canavar Vurdu <-");
						player.setHealthy(player.getrHealthy() - (enemy.getDamage() - player.getInv().getArmor()));
						afterHit();

					}

				} else {
					return false;
				}
			}
			if (enemy.getHealth() < player.getHealthy()) {
				System.out.println("-> Tüm Düşmanlar Öldü <-");
				player.setMoney(player.getMoney() + enemy.getAward());
				System.out.println("=> Güncel Paranız -> " + player.getMoney());
				enemy.setHealth(defEnmHealth);
			} else {
				return false;

			}
			System.out.println("---------------------------------");
		}
		return true;

	}

	public void playerStats() {
		System.out.println("Oyuncu Değerleri\n>>>>>---------------------<<<<<");
		System.out.println("Can   => " + player.getHealthy());
		System.out.println("Hasar => " + player.getTotalDamage());
		System.out.println("Para  => " + player.getMoney());
		if (player.getInv().getArmor() > 0) {
			System.out.println("Zırh => " + player.getInv().getaName());
		}
	}

	public void enemyStats() {
		System.out.println(enemy.getName() + " Değerleri \n>>>>>---------------------<<<<<");
		System.out.println("Oyuncu Değerleri\n>>>>>---------------------<<<<<");
		System.out.println("Can   => " + enemy.getHealth());
		System.out.println("Hasar => " + enemy.getDamage());
		System.out.println("Ödül  => " + enemy.getAward());
	}

	public void afterHit() {
		System.out.println("-> Oyuncu Canı -> " + player.getrHealthy());
		System.out.println("-> " + enemy.getName() + " Canı -> " + enemy.getHealth());
		System.out.println();
	}
}
