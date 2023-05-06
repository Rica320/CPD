package game.protocols;

public enum CommunicationProtocol {
    PLAY, PLAYER_LEFT, GUESS, QUIT, ERROR, LOGOUT, GAME_WAIT, GAME_STARTED, QUEUE_UPDATE, GAME_END, GUESS_TOO_HIGH, GUESS_TOO_LOW, GUESS_CORRECT, GAME_RESULT, GAME_RECONNECT, MENU_CONNECT, QUEUE_RECONNECT, PLAYGROUND_RECONNECT;


    @Override
    public String toString() {
        return this.name() + "\n";
    }
}
