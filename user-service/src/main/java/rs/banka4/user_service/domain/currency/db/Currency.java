package rs.banka4.user_service.domain.currency.db;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import rs.banka4.user_service.exceptions.account.InvalidCurrency;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "currencies")
public class Currency {

    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String symbol;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean active;

    @Enumerated(EnumType.STRING)
    private Code code;

    public enum Code {
        RSD,
        EUR,
        USD,
        CHF,
        JPY,
        AUD,
        CAD,
        GBP;

        @JsonCreator
        public static Code fromString(String raw) {
            try {
                return Code.valueOf(raw);
            } catch (IllegalArgumentException | NullPointerException e) {
                throw new InvalidCurrency("Invalid currency code: " + raw);
            }
        }
    }

    @Override
    public String toString() {
        return "Currency{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass =
            o instanceof HibernateProxy
                ? ((HibernateProxy) o).getHibernateLazyInitializer()
                    .getPersistentClass()
                : o.getClass();
        Class<?> thisEffectiveClass =
            this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer()
                    .getPersistentClass()
                : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Currency currency = (Currency) o;
        return getId() != null && Objects.equals(getId(), currency.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
            ? ((HibernateProxy) this).getHibernateLazyInitializer()
                .getPersistentClass()
                .hashCode()
            : getClass().hashCode();
    }
}
