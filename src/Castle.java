
public class Castle extends NormalLocation {

	public Castle(Player player) {
		super(player, "KALE");
		

	}

	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		System.out.println("=> KALE 'ye Hoşgeldiniz,Burası Güvenli Alandır!");
		System.out.println("-> Karakterin Canı yenilendi") ;
		return true;

	}

	

}
