package naeem.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserService {

    UserDao userDao;

    public UserService() {
        userDao = UserDao.instance;
    }

    public void createUser(User user) {
        userDao.getUsers().put(user.getId(), user);
    }

    public User getUser(String id) {
        return userDao.getUsers().get(id);
    }

    public Map<String, User> getUsers() {
        return userDao.getUsers();
    }

    public List<User> getUserAsList() {
        List<User> animalList = new ArrayList<User>();
        animalList.addAll(userDao.getUsers().values());
        return animalList;
    }

    public int getUsersCount() {
        return userDao.getUsers().size();
    }

    public void deleteUser(String id) {
        userDao.getUsers().remove(id);
    }

}
