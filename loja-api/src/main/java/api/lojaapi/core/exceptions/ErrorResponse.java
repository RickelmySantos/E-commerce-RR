package api.lojaapi.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private int status;
    private String mensagem;

}
