package api.lojaapi.core.exceptions;

import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdviced extends ResponseEntityExceptionHandler {

    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<String> handleGenericException(Exception ex) {
    // HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    // return ResponseEntity.status(status).body("Ocorreu um erro interno com o servidor");
    // }

    // @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    // public ResponseEntity<String> handleUnsupportedMidiaType(
    // HttpMediaTypeNotSupportedException ex) {
    // HttpStatus status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
    // return ResponseEntity.status(status).body("Tipo de mídia não suportado");
    // }

    // @ExceptionHandler(MissingServletRequestParameterException.class)
    // public ResponseEntity<String> handleMissingServletRequestParameter(
    // MissingServletRequestParameterException ex) {
    // HttpStatus status = HttpStatus.BAD_REQUEST;
    // return ResponseEntity.status(status)
    // .body("Parâmetro de solicitação ausente: " + ex.getParameterName());
    // }

    // @ExceptionHandler(IllegalArgumentException.class)
    // public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
    // HttpStatus status = HttpStatus.BAD_REQUEST;
    // return ResponseEntity.status(status).body("Argumento inválido");
    // }

    // @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    // public ResponseEntity<String> handleHttpRequestMethodNotSupportedException(
    // HttpRequestMethodNotSupportedException ex) {
    // HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
    // return ResponseEntity.status(status).body("Método não suportado para esta solicitação");
    // }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<Object> handleIOException(IOException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("OCorreu um erro ao processar a imagem " + ex.getMessage());
    }
}
