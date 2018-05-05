package cinema.utils;

public interface ISecurityService {
    String findLoggedLogin();
    void autoLogin(String login, String password);

}
