package rs.banka4.user_service.exceptions.jwt;

import org.springframework.http.HttpStatus;
import rs.banka4.user_service.exceptions.BaseApiException;

public class RefreshTokenRevoked extends BaseApiException {
    public RefreshTokenRevoked() {
        super(HttpStatus.CONFLICT, null);
    }
}
