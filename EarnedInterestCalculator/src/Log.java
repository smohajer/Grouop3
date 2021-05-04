import java.io.*;

public class Log {
  private String logName;

  public Log(String logName) {
    setLogName(logName);
    if (!logExist(getLogName())) {
      // TODO: Create GUI to create the log string
      // TODO: Create Log with above string
    }
  }

  private boolean logExist(String logName) {
    File logFile=new File(logName);
    return logFile.exists();
  }

  public String getLogName() {
    return logName;
  }

  public void setLogName(String logName) {
    this.logName = logName;
  }

  public String getLogFile() {
    String logString = "";
    try {
      BufferedReader reader = new BufferedReader(new FileReader(getLogName()));
      logString = reader.readLine();
    } catch (FileNotFoundException e) {
      // TODO: what exceptions do
    } catch (IOException f) {
      // TODO: what f will do
    }
    return logString;
  }
}
