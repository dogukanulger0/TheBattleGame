import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner sc = new Scanner(System.in);

	public void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\t      < EPIC GAME BATTLE > ");
		System.out.print("<= OYUNA BAŞLAMAK İÇİN İSMİNİZİ GİRİNİZ =>");
		String playerName = sc.nextLine();
		System.out.println("=> " + playerName + " <==> HOŞGELDİNİZ =>");
		System.out.println("=========================================");
		player = new Player(playerName);
		player.selectCharacter();
		start();

	}

	public void start() {
		while (true) {
			System.out.println();
			System.out.println("=========================================");
			System.out.println();
			System.out.println("\t        *BÖLGELER*");
			System.out.println("#1.  => KALE    <==> Güvenli alan,Düşman yok       <= ");
			System.out.println("#2.  => MAĞARA  <==> Dikkat Vampir Çıkabilir          <= ");
			System.out.println("#3.  => GÖLET   <==> Dikkat Göl Canavarı Çıkabilir <= ");
			System.out.println("#4.  => ORMAN   <==> Zombi Çıkabilir       <= ");
			System.out.println("#5.  => MAĞAZA  <==> Alışveriş Yapabilirsiniz      <= ");
			System.out.print("=> Gitmek İstediğiniz Yer :");
			int locSec = sc.nextInt();
			while (locSec < 1 || locSec > 5) {
				System.out.println("!!! SEÇİMİNİZ HATALIDIR LÜTFEN GEÇERLİ BİR SEÇİM YAPINIZ !!!");
				locSec = sc.nextInt();
			}

			switch (locSec) {
			case 1: {
				location = new Castle(player);
				break;
			}

			case 2: {
				location = new Magara(player);
				break;
			}
			case 3: {
				location = new Golet(player);
				break;
			}
			case 4: {
				location = new Orman(player);
				break;
			}
			default:
				location = new Castle(player);
				break;

			}
			if (location.getClass().getName().equals("KALE")) {
				if(player.getInv().isClothes() && player.getInv().isFood() && player.getInv().isWater()) {
					System.out.println(">>>> TEBRİKLER OYUNU KAZANDINIZ <<<<");
				}
			}
				if (!location.getLocation()) {
					System.out.println(">>>>>>>>>>     OYUN BİTTİ     <<<<<<<<<<");
					break;
				}
			
		}

	}

}
