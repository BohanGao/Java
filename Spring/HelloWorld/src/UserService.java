public class UserService {
    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("UserService adding.");
        userDao.update();
    }
}
