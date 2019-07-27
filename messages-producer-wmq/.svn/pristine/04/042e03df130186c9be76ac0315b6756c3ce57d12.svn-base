package ar.com.osde.middleware.es.model;

public enum LevelEnum {

	 Highest(9),  High(7),  Normal(5),  Low(3),  Lowest(1);
	  
	  private int priority;
	  
	  public String toString()
	  {
	    String s = super.toString();
	    return s.substring(0, 1) + s.substring(1).toLowerCase();
	  }
	  
	  public int getPriority()
	  {
	    return this.priority;
	  }
	  
	  private LevelEnum(int priority)
	  {
	    this.priority = priority;
	  }
	
}
