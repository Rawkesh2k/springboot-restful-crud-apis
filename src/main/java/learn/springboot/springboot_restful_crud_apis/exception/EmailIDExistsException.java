package learn.springboot.springboot_restful_crud_apis.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailIDExistsException extends RuntimeException{

    private String message;

    public EmailIDExistsException(String message)
    {
        super(message);
    }
}
