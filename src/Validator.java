import java.util.Objects;

public class Validator {
    private Validator(){

    }
    public static boolean validate(String login, String password, String confirmPassword){
        try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    private static void check(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if(Objects.isNull(login) || login.length()>20) {
            throw new WrongLoginException("Длина логина должна быть меньше или равна 20");
        }
        if(Objects.isNull(password) || password.length()>=20) {
            throw new WrongLoginException("Длина пароля должна быть меньше 20");
        }
        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("Пароли должны совпадать");
        } if (!login.matches("^\\w+$")){
            throw new WrongLoginException("Логин содержит не корректные символы");
        }
        if (!password.matches("^\\w+$")){
            throw new WrongLoginException("Пароль содержит не корректные символы");
        }
    }
}
