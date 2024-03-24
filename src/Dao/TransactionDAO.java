package Dao;

import model.Transaction;

import java.util.ArrayList;

public interface TransactionDAO {
    Transaction addTransaction(Transaction transaction);
    ArrayList<Transaction> getAllTransactionsByInvestorId(int investorId);
}
