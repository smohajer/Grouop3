import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class Account {
  private BigDecimal balance;
  private BigDecimal interest;
  private String accountName;
  private LocalDateTime lastDate;
  private BigDecimal interestEarned;

  public Account(String accounteName) {
    setAccountName(accounteName);
    Log log = new Log(getAccountName);
    String logInfo = log.getLogFile();
    logParser(logInfo);
    LocalDateTime date = getLastDate();
    BigDecimal balance = getBalance();
    BigDecimal interest = getInterest();
    calculateInterestearned(balance, date, interest);
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal newBalance) {
    this.balance = newBalance;
  }
  
  public BigDecimal getInterest(){
    return interest;
  }
  
  public void setInterest(BigDecimal newInterest){
    this.interest=newInterest;
  }
  
  public String getAccountName()
  {
    return accountName;
  }
  
  public void setAccountName(String accountName)
  {
    this.accountName = accountName;
  }
  
  public LocalDateTime getLastDate()
  {
    return lastDate;
  }
  
  public void setLastDate(LocalDateTime lastDate)
  {
    this.lastDate = lastDate;
  }
  
  public BigDecimal getInterestEarned()
  {
    return interestEarned;
  }
  
  public void setInterestEarned(BigDecimal interestEarned)
  {
    this.interestEarned = interestEarned;
  }
}
