package playerCharacter;

public class PlayerStats {
	private int Strength;
	private int Dexterity;
	private int Constitution;
	private int Intelligence;
	private int Wisdom;
	private int Charisma;

	private int playerLevel;

	public PlayerStats(int str, int dex, int con, int intel, int wis, int cha){
		Strength = str;
		Dexterity = dex;
		Constitution = con;
		Intelligence = intel;
		Wisdom = wis;
		Charisma = cha;
	}

	public void levelUp(){
		playerLevel++;
	}

	public int getLevel(){
		return playerLevel;
	}

	public int getSTR(){
		return Strength;
	}

	public int getDEX(){
		return Dexterity;
	}

	public int getCON(){
		return Constitution;
	}

	public int getINT(){
		return Intelligence;
	}

	public int getWIS(){
		return Wisdom;
	}

	public int getCHA(){
		return Charisma;
	}
}
