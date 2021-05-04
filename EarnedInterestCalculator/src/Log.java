import java.io.*;

public class Log {
  private String logName;

  public String getLogName() {
    return logName;
  }

  public void setLogName(String logName) {
    this.logName = logName;
  }

  public Log(String logName) {
    setLogName(logName);
    if (!logExist(logName)) {
      // TODO: Create GUI to create the log string
      createLog(logName);
    }
    // TODO: return logString to Account Contructor
  }

  private boolean logExist(String logName) {
    File logFile = new File(logName);
    return logFile.exists();
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

  public void createLog(String logName) {
    File logFile = new File(logName);
    try {
      logFile.createNewFile();
    } catch (IOException e) {
      // TODO: what this exception will do
    }
  }
}
