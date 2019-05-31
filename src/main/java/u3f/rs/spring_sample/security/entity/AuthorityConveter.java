package u3f.rs.spring_sample.security.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class AuthorityConveter implements AttributeConverter<Authority,Integer> {
    @Override
    public Authority convertToEntityAttribute(Integer id) {
        return Authority.fromId(id);
    }

    @Override
    public Integer convertToDatabaseColumn(Authority authority) {
        return authority.getId();
    }
}
