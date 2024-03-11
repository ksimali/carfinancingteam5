package Dao;

import model.Client;

public interface ClientDAO {
    Client addClient(Client client);
    Client getClientByEmail(String email);
}
