package cn.shil.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Id Not Found Exception")
public class IdNotFoundException extends RuntimeException {
}
