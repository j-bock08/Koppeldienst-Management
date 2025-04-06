package controller;

import model.modelData.Model;
import model.modelData.ModelInterface;
import model.objects.Rank;
import view.Interface.LoginViewInterface;
import view.LoginView;

public class Controller {

    private final ModelInterface model = new Model();

    public void startProgram(){
        initData();
        mainMenue();
    }

    private void initData(){
        model.initData();
    }

    private void mainMenue(){
        LoginViewInterface login = new LoginView(model);
        login.startLoginProcess(loggedInUser -> {
            model.setCurrentUser(loggedInUser);
            checkAccountStatus();
        });
    }

    private void checkAccountStatus(){
        if (model.getCurrentUser().getRank() == Rank.Admin){
            adminMainMenue();
        }else {
            userMainMenue();
        }
    }

    private void adminMainMenue(){
        //todo ausbauen
    }

    private void userMainMenue(){
        //todo ausbauen
    }

}
