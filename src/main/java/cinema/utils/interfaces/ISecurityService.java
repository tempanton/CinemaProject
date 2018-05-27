package cinema.utils.interfaces;


public interface ISecurityService {
    String findLoggedLogin();
    void autoLogin(String login, String password);
}
