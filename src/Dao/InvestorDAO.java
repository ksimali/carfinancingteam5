package Dao;

import model.Investor;

public interface InvestorDAO {
    Investor addInvestor(Investor investor);
    Investor getInvestorByEmail(String email);
}
