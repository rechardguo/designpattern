package rechard.learn.designpattern.strategy;

public class Bene {
	private boolean canDoAct;
	private boolean canDoTT ;
	private boolean canDoICT ;
	private boolean canDoHVT;
	private String name;

	public Bene(String name) {
		this.name = name;
	}

	public boolean isCanDoAct() {
		return canDoAct;
	}

	public void setCanDoAct(boolean canDoAct) {
		this.canDoAct = canDoAct;
	}

	public boolean isCanDoTT() {
		return canDoTT;
	}

	public void setCanDoTT(boolean canDoTT) {
		this.canDoTT = canDoTT;
	}

	public boolean isCanDoICT() {
		return canDoICT;
	}

	public void setCanDoICT(boolean canDoICT) {
		this.canDoICT = canDoICT;
	}

	public boolean isCanDoHVT() {
		return canDoHVT;
	}

	public void setCanDoHVT(boolean canDoHVT) {
		this.canDoHVT = canDoHVT;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
