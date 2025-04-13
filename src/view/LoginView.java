package view;

import listener.LoginListener;
import model.modelData.ModelInterface;
import model.objects.User;
import view.Interface.LoginViewInterface;

public class LoginView extends ParentView implements LoginViewInterface {

    private final ModelInterface model;

    public LoginView(ModelInterface model) {
        this.model = model;
    }

    @Override
    public void startLoginProcess(LoginListener listener) {
        User getUserToLogin = loginProcess();

        if (getUserToLogin != null){
            listener.onValidLogin(getUserToLogin);
        }else {
            System.out.println("Login vorgang wurde abgebrochen.");
        }
    }

    private User loginProcess() {
        boolean validLogin = false;

        while (!validLogin) {
            String userName = getUsername();

            if (userName != null){
                String password = getPassword();

                if (password != null){
                    User userToLogin = model.findUserByUserName(userName);

                    if (userToLogin != null && userToLogin.getUserName().equalsIgnoreCase(userName) && userToLogin.getPassword().equalsIgnoreCase(password)) {
                        return userToLogin;
                    }else {
                        System.out.println("Login Fehlgeschlagen");
                    }

                }else {
                    validLogin = true;
                }
            }else {
                validLogin = true;
            }
        }
        return null;
    }

    private String getUsername() {
        System.out.println("Benutzername: ");
        return this.stringInput(true);
    }

    private String getPassword() {
        System.out.println("Passwort: ");
        return this.stringInput(true);
    }
}