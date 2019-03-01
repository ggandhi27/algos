package designpattern.command;

import designpattern.command.BankAccountCommand.Operation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BankAccount {

  private Integer balance = 0;

  public void deposit(int amount) {
    this.balance += amount;
  }

  public boolean withDraw(int amount) {
    if (this.balance - amount >= 0) {
      this.balance -= amount;
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "BankAccount{" +
        "balance=" + balance +
        '}';
  }
}

interface command {

  void execute();
}

interface undoCommand {

  void undoExecute();
}

class BankAccountCommand implements command, undoCommand {

  @Override
  public void execute() {
    switch (this.operation) {
      case DEPOSIT:
        bankAccount.deposit(amount);
        break;
      case WITHDRAW:
        succeded = bankAccount.withDraw(amount);
        break;
    }
    System.out.println("DO -> " + bankAccount.toString());
  }

  @Override
  public void undoExecute() {
    if (!succeded) {
      return;
    }
    switch (this.operation) {
      case WITHDRAW:
        bankAccount.deposit(amount);
        break;
      case DEPOSIT:
        bankAccount.withDraw(amount);
        break;
    }
    System.out.println("REDO -> " + bankAccount.toString());
  }

  enum Operation {
    DEPOSIT,
    WITHDRAW
  }

  BankAccount bankAccount;
  Operation operation;
  int amount;
  boolean succeded = true;

  public BankAccountCommand(BankAccount bankAccount,
      Operation operation, int amount) {
    this.bankAccount = bankAccount;
    this.operation = operation;
    this.amount = amount;
  }
}

public class Demo {

  public static void main(String[] args) {

    BankAccount bankAccount = new BankAccount();
    List<BankAccountCommand> bankAccountCommands = new ArrayList<>();
    bankAccountCommands.add(new BankAccountCommand(bankAccount, Operation.DEPOSIT, 1000));
    bankAccountCommands.add(new BankAccountCommand(bankAccount, Operation.DEPOSIT, 100));
    bankAccountCommands.add(new BankAccountCommand(bankAccount, Operation.WITHDRAW, 800));
    bankAccountCommands.add(new BankAccountCommand(bankAccount, Operation.DEPOSIT, 100));
    bankAccountCommands.add(new BankAccountCommand(bankAccount, Operation.WITHDRAW, 500));

    bankAccountCommands.stream().forEach(BankAccountCommand::execute);

    Collections.reverse(bankAccountCommands);
    bankAccountCommands.stream().forEach(BankAccountCommand::undoExecute);
  }
}
