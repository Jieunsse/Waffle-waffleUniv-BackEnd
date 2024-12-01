package gdg.waffle.BE.common.base;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.FieldError;

@Getter
@Builder
@RequiredArgsConstructor
public class ValidationErrorResponse {
    private final String field;
    private final String message;

    public static ValidationErrorResponse of(final FieldError fieldError) {
        return ValidationErrorResponse.builder()
                .field(fieldError.getField())
                .message(fieldError.getDefaultMessage())
                .build();
    }

    public static ValidationErrorResponse createNotNull(final String field) {
        return ValidationErrorResponse.builder()
                .field(field)
                .message(String.format("%s 필드는 필수 입니다.", field))
                .build();
    }


}
