package game.server;

import game.client.GamePlayer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameServerInterface extends Remote {
    void tryToJoinGame(GamePlayer client, String token) throws RemoteException;
    void logoutGame(GamePlayer gamePlayer, String token) throws RemoteException;
}
