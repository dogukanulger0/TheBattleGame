
public class Inventory {
	private boolean water, food, clothes;
	private String wName, aName;
	public boolean isWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public boolean isFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public boolean isClothes() {
		return clothes;
	}

	public void setClothes(boolean clothes) {
		this.clothes = clothes;
	}

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	private int damage, armor;

	Inventory() {
		this.water = false;
		this.food = false;
		this.clothes = false;
		this.wName = null;
		this.aName = null;
		this.damage = 0;
		this.armor = 0;
	}

	public Inventory(boolean water, boolean food, boolean clothes, String wName, String aName, int damage, int armor) {
		super();
		this.water = water;
		this.food = food;
		this.clothes = clothes;
		this.wName = wName;
		this.aName = aName;
		this.damage = damage;
		this.armor = armor;
	}
	

}
