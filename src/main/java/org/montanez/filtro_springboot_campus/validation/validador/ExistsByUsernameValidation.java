package org.montanez.filtro_springboot_campus.validation.validador;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.montanez.filtro_springboot_campus.service.UsuarioService;
import org.montanez.filtro_springboot_campus.validation.annotation.ExistsByUsername;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsByUsernameValidation implements
        ConstraintValidator<ExistsByUsername, String> {

    @Autowired
    private UsuarioService service;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (service == null) {
            return true;
        }
        return !service.existsByUsername(username);
    }

}
