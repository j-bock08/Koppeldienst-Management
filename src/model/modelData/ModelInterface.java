package model.modelData;

import model.objects.User;

public interface ModelInterface {

    void initData();

    void closeProgram();

    User getCurrentUser();
    void setCurrentUser(User currentUser);

    User findUserByUserName(String username);
}