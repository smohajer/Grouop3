import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Log {
  private String logName;

  public Log(String logName) {
    setLogName(logName);
    if (!logExist(getLogName())) {
      // TODO: Create GUI to create the log string
      // TODO: Create Log with above string
    }
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
