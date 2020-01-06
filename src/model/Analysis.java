package model;

public class Analysis {
	private String name;
	private int time;
	
	public Analysis() {
		
	}
	
	public Analysis(String nameInput, int timeInput)
	{
		name = nameInput;
		setTime(timeInput);
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return name;
	}
}
  