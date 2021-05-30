package northwind.kodlamaio.api.controllers;


import northwind.kodlamaio.business.abstracts.UserService;
import northwind.kodlamaio.core.entities.User;
import northwind.kodlamaio.core.utilities.result.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value="/add")
    public ResponseEntity<?> add(@Valid  @RequestBody User user){
        return  ResponseEntity.ok(this.userService.add(user));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationExcepiton(MethodArgumentNotValidException excepitons){
        Map<String,String> validationErrors = new HashMap<String ,String>();
        for(FieldError fieldError : excepitons.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors =new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları");
        return errors;
    }

}
