import java.util.Scanner;

public class Player {
	private int damage, healthy, money, rHealthy;
	private String name, cName;
	private Inventory inv;

	public Player(String name) {
		this.name = name;
		this.inv=new Inventory();
	}

	

	public void selectCharacter() {
		switch (characterMenu()) {
		case 1: {
			initPlayer("NİNJA ", 6, 100, 200);
			break;
		}
		case 2: {
			initPlayer("KARA ŞOVALYE", 7, 100, 250);
			break;
		}
		case 3: {
			initPlayer("KURT ADAM ", 8, 100, 300);
			break;
		}
		default:
			setcName("NİNJA");
			setDamage(6);
			setHealthy(100);
			setMoney(200);
			break;
		}
		System.out.println(">>>KARAKTER SEÇİLDİ<<<\n>SEÇİLEN KARAKTER => " + getcName() + " <=");
	}

	private int characterMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\t>>>>>> KARAKTERLER <<<<<<");
		System.out.println("#1. -=> NİNJA        => VERDİĞİ HASAR : 6 =>\t SAĞLIK : 100 =>\t PARA : 200 <= ");
		System.out.println("#2. -=> KARA ŞOVALYE => VERDİĞİ HASAR : 7 =>\t SAĞLIK : 100 =>\t PARA : 250 <=");
		System.out.println("#3. -=> KURT ADAM    => VERDİĞİ HASAR : 8 =>\t SAĞLIK : 100 =>\t PARA : 300 <=");
		System.out.println("* OYNAMAK İSTEDİĞİNİZ KARAKTERİ SEÇİNİZ *");
		int charSel = sc.nextInt();
		while (charSel < 1 || charSel > 3) {
			System.out.println("!!! SEÇİMİNİZ HATALIDIR LÜTFEN GEÇERLİ BİR SEÇİM YAPINIZ !!!");
			charSel = sc.nextInt();
		}
		return charSel;
	}
	public int getTotalDamage() {
		return this.getDamage()+this.getInv().getDamage();
		
	}

	public void initPlayer(String cName, int damage, int healthy, int money) {
		setcName(cName);
		setDamage(damage);
		setHealthy(healthy);
		setMoney(money);
		setrHealthy(healthy);
	}

	public int getrHealthy() {
		return rHealthy;
	}

	public void setrHealthy(int rHealthy) {
		this.rHealthy = rHealthy;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealthy() {
		return healthy;
	}

	public void setHealthy(int healthy) {
		this.healthy = healthy;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

}
