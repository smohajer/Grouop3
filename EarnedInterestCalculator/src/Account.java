import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Account {
  private BigDecimal balance;
  private BigDecimal interest;
  private String accountName;
  private LocalDateTime lastDate;
  private BigDecimal interestEarned;
  public Log log;
  
  public BigDecimal getBalance() {
    return balance;
  }
  
  public void setBalance(BigDecimal newBalance) {
    this.balance = newBalance;
  }
  
  public BigDecimal getInterest() {
    return interest;
  }
  
  public void setInterest(BigDecimal newInterest) {
    this.interest = newInterest;
  }
  
  public String getAccountName() {
    return accountName;
  }
  
  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }
  
  public LocalDateTime getLastDate() {
    return lastDate;
  }
  
  public void setLastDate(LocalDateTime lastDate) {
    this.lastDate = lastDate;
  }
  
  public BigDecimal getInterestEarned() {
    return interestEarned;
  }
  
  public void setInterestEarned(BigDecimal interestEarned) {
    this.interestEarned = interestEarned;
  }

  public Account(String accountName) {
    setAccountName(accountName);
    this.log = new Log(getAccountName());
    String logInfo = log.getLogFile();
    logParser(logInfo);
    LocalDateTime date = getLastDate();
    BigDecimal balance = getBalance();
    BigDecimal interest = getInterest();
    calculateInterestEarned(balance, date, interest);
  }

  public void calculateInterestEarned(BigDecimal balance, LocalDateTime date, BigDecimal interest) {
    BigDecimal daysInYear = new BigDecimal("36500");
    int passedDays = calculateDays(date);
    BigDecimal dailyInterestRate = interest.divide(daysInYear, RoundingMode.UNNECESSARY);
    BigDecimal totalInterestRate = dailyInterestRate.multiply(BigDecimal.valueOf(passedDays));
    BigDecimal interestEarnedNow = balance.multiply(totalInterestRate);
    BigDecimal totalInterest = getInterest().add(interestEarnedNow);
    setInterest(totalInterest);
    deposit(interestEarnedNow);
    // TODO: log it
  }

  public void deposit(BigDecimal amount) {
    setBalance(getBalance().add(amount));
  }

  public void withDrawal(BigDecimal amount) {
    if (amount.compareTo(getBalance()) < 0) {
      // TODO: tell user not enough money and try again
    } else {
      setBalance(getBalance().subtract(amount));
    }
  }

  public int calculateDays(LocalDateTime date) {
    return Period.between(LocalDate.now(), date.toLocalDate()).getDays();
  }

  public void logParser(String logInfo) {
    String[] logParts = logInfo.split(" ");
    // TODO: Determine in which order we want to log the information
    // TODO: add each part of the array to setters.
  }
  
}
