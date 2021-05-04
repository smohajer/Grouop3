public class Log
{
	private String logName;
	
	public Log(String logName){
		setLogName(logName);
		if (!logExist(getLogName())){
			//TODO: Create GUI to create the log string
			//TODO: Create Log with above string
		}
	}
	
	public String getLogName()
	{
		return logName;
	}
	
	public void setLogName(String logName)
	{
		this.logName = logName;
	}
	

}
