package rs.banka4.user_service.exceptions.user;

import org.springframework.http.HttpStatus;
import rs.banka4.user_service.exceptions.BaseApiException;

public class InvalidPhoneNumber extends BaseApiException {
    public InvalidPhoneNumber() {
        super(HttpStatus.BAD_REQUEST, null);
    }
}
