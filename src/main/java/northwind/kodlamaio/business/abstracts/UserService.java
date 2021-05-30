package northwind.kodlamaio.business.abstracts;

import northwind.kodlamaio.core.entities.User;
import northwind.kodlamaio.core.utilities.result.DataResult;
import northwind.kodlamaio.core.utilities.result.Result;


public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);

}
