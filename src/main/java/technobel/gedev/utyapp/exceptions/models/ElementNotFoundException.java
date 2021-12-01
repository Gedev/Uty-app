package technobel.gedev.utyapp.exceptions.models;

import org.springframework.http.HttpStatus;


public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException() {
        super("L'element recherché n'existe pas");
    }
}
