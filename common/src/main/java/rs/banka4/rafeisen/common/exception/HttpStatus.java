package rs.banka4.rafeisen.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpStatus {
    OK(200),
    CREATED(201),
    ACCEPTED(202),
    NO_CONTENT(204),

    MOVED_PERMANENTLY(301),
    FOUND(302),
    NOT_MODIFIED(304),

    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    CONFLICT(409),
    TOO_MANY_REQUESTS(429),

    INTERNAL_SERVER_ERROR(500);

    private final int code;
}
