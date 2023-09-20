import java.util.Scanner;

public class ToolStory extends NormalLocation {
	Scanner sc = new Scanner(System.in);

	public ToolStory(Player player) {
		super(player, "MAĞAZA");
	}

	public boolean getLocation() {

		System.out.println("-> Paranız : " + player.getMoney());
		System.out.println("#1. => SİLAHLAR <=");
		System.out.println("#2. => ZIRHLAR  <=");
		System.out.println("#3. =>  ÇIKIŞ   =>");
		System.out.print("-> Seçiminiz : ");
		int selTool = sc.nextInt();
		int selItemId;
		switch (selTool) {
		case 1: {
			selItemId = weaponMenu();
			buyWeanpon(selItemId);
			break;
		}
		case 2: {
			selItemId =armorMenu();
			buyArmor(selItemId);
			break;
		}
		case 3: {
			System.out.println("-> ÇIKIŞ YAPILIYOR <-");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + selTool);
		}
		return true;

	}
	public int armorMenu() {
		System.out.println("#1. Hafif   -> Fiyatı :90  > Hasar :2");
		System.out.println("#2.  Orta   -> Fiyatı :115 > Hasar :4");
		System.out.println("#3.  Ağır   -> Fiyatı :155 > Hasar :7");
		System.out.println("#4. => ÇIKIŞ => ");
		System.out.print("-> Seçim yapınız : ");
		int selArmorId = sc.nextInt();
		return selArmorId;
	}
	public void buyArmor(int itemId) {
		int aVoid = 0, price = 0;
		String aName = null;

		switch (itemId) {
		case 1: {
			aVoid = 1;
			aName="Hafif Zırh";
			price = 90;
			break;
		}
		case 2: {
			aVoid = 2;
			aName="Orta Zırh";
			price = 115;
			break;
		}
		case 3: {
			aVoid = 3;
			aName="Ağır Zırh";
			price = 155;
			break;
		}
		case 4: {
			System.out.println("-> ÇIKIŞ YAPILIYOR <-");
			break;
		}
		default:
			System.out.println("!!! Geçersiz İşlem !!!");
		}
		if(price>0) {
			if (player.getMoney() >= price  ) {
				player.getInv().setArmor(aVoid);
				player.getInv().setaName(aName);
				System.out.println("-> Alışverişiniz Tamamlanmıştır <-> Alınan Ürün -> " + aName);
				player.setMoney(player.getMoney() - price);
			} else {
				System.out.println("!!! YETERSİZ BAKİYE !!!");
			}
		}
		System.out.println("-> Paranız :" + player.getMoney());
	}

	public int weaponMenu() {
		System.out.println("#1. Tabanca -> Fiyatı :90 > Hasar Verme :4");
		System.out.println("#2.  Kılıç  -> Fiyatı :110 > Hasar Verme :7");
		System.out.println("#3.  Tüfek  -> Fiyatı :150 > Hasar Verme :10");
		System.out.println("#4. => ÇIKIŞ => ");
		System.out.print("-> Seçim yapınız : ");
		int selWeaponId = sc.nextInt();
		return selWeaponId;

	}

	public void buyWeanpon(int itemId) {
		int damage = 0, price = 0;
		String wName = null;

		switch (itemId) {
		case 1: {
			wName = "Tabanca";
			price = 90;
			damage = 4;
			break;
		}
		case 2: {
			wName = "Kılıç";
			price = 110;
			damage = 7;
			break;
		}
		case 3: {
			wName = "Tüfek";
			price = 150;
			damage = 10;
			break;
		}
		case 4: {
			System.out.println("-> ÇIKIŞ YAPILIYOR <-");
			break;
		}
		default:
			System.out.println("!!! Geçersiz İşlem !!!");
		}
		if(price>0) {
			if (player.getMoney() >= price  ) {
				player.getInv().setDamage(damage);
				player.getInv().getwName();
				System.out.println("-> Alışverişiniz Tamamlanmıştır <-> Alınan Ürün -> " + wName);
				player.setMoney(player.getMoney() - price);
			} else {
				System.out.println("!!! YETERSİZ BAKİYE !!!");
			}
		}
		
		System.out.println("-> Paranız :" + player.getMoney());
	}

}
