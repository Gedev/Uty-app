package technobel.gedev.utyapp.exceptions.models;

public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException() {
        super("L'element recherché n'existe pas");
    }
}
