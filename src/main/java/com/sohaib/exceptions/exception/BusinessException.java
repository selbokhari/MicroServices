package com.sohaib.exceptions.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException {

    public enum Cause {
        UTILISATEUR_NON_TROUVE(HttpStatus.NOT_FOUND.value(), "Utilisateur Non Trouvé "),
        UTILISATEUR_EXISTE_DEJA(HttpStatus.NOT_FOUND.value(), "Utilisateur utilisateur existe déjà "),
        MOT_DE_PASSE_NON_VALIDE(HttpStatus.BAD_REQUEST.value(), "Mot de passe non valide ");

        private final int code;
        private final String message;

        Cause(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }

        public int getCode() {
            return this.code;
        }
    }

    private int code;

    public BusinessException(Cause cause) {
        super(cause.getMessage());
        this.code = cause.getCode();
    }

}
