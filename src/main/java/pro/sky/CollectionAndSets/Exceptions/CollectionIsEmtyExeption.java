package pro.sky.CollectionAndSets.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CollectionIsEmtyExeption extends RuntimeException{
    public CollectionIsEmtyExeption (){}

}
