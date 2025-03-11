package endpoints.springboot.controller;

import endpoints.springboot.exception.ProdutoNullException;
import endpoints.springboot.exception.ProdutoPriceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProdutoNullException.class)
    public ResponseEntity<Object> errorNull(){

        Map<String,Object> body = new HashMap<String, Object>();

        body.put("message", "Preencha todos os campos!!");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ProdutoPriceException.class)
    public ResponseEntity<Object> errorPrice(){

        Map<String,Object> body = new HashMap<String, Object>();

        body.put("message", "Preço Inválido!");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }


}
