package northwind.kodlamaio.business.concretes;

import northwind.kodlamaio.business.abstracts.UserService;
import northwind.kodlamaio.core.dataAccess.UserDao;
import northwind.kodlamaio.core.entities.User;
import northwind.kodlamaio.core.utilities.result.DataResult;
import northwind.kodlamaio.core.utilities.result.Result;
import northwind.kodlamaio.core.utilities.result.SuccessDataResult;
import northwind.kodlamaio.core.utilities.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Kullanıcı Eklendi");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return  new SuccessDataResult<User>(this.userDao.findByEmail(email),"kullanıcı listelendi");
    }
}
