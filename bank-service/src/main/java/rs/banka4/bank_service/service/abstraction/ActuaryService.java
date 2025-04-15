package rs.banka4.bank_service.service.abstraction;

import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import rs.banka4.bank_service.domain.actuaries.db.dto.ActuaryPayloadDto;
import rs.banka4.bank_service.domain.response.CombinedResponse;
import rs.banka4.bank_service.domain.response.LimitPayload;

public interface ActuaryService {
    void createNewActuary(ActuaryPayloadDto dto);

    void changeActuaryDetails(UUID actuaryId, ActuaryPayloadDto dto);

    void updateLimit(UUID actuaryId, LimitPayload dto);

    Page<CombinedResponse> search(
        Authentication auth,
        String firstName,
        String lastName,
        String email,
        String position,
        int page,
        int size
    );

    void resetUsedLimit(UUID actuaryId);
}
