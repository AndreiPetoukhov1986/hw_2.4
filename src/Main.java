public class Main {
    public static void main(String[] args) {
       boolean result = Validator.validate("andrei123", "qwertyuiop.", "qwertyuiop.");
       if (result){
           System.out.println("Логин и пароль корректные");
       }
    }
}