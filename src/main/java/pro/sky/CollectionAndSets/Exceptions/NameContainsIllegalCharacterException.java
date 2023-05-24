package pro.sky.CollectionAndSets.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NameContainsIllegalCharacterException extends IOException {
    public NameContainsIllegalCharacterException(){}
}
