package listener;

import model.objects.User;

public interface LoginListener {

    void onValidLogin(User loggedInUser);

}
