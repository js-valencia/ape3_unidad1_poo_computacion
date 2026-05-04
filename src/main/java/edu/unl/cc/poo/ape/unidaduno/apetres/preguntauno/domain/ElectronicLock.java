package edu.unl.cc.poo.ape.unidaduno.apetres.preguntauno.domain;

//author: Domenica Narvaez + TwoCore Team
public class ElectronicLock {
    // Atributos
    private Integer pin;
    private int failedAttempts;
    private boolean locked;

    // Constructor
    public ElectronicLock() {
        this.pin = null;
        this.failedAttempts = 0;
        this.locked = false;
    }

    // Método para configurar la clave
    public boolean configurePin(Integer newPin) {
        // Validamos que no sea nulo y que tenga exactamente 4 dígitos
        if (newPin != null && String.valueOf(newPin).length() == 4) {
            this.pin = newPin;
            return true;
        }
        return false;
    }

    // Método para validar la clave
    public boolean validatePin(Integer enteredPin) {
        // Si ya está bloqueada, no hace falta comprobar nada más
        if (this.locked) {
            return false;
        }

        // Si acierta la clave
        if (this.pin.equals(enteredPin)) {
            this.failedAttempts = 0; // Reinicia los intentos fallidos a 0
            return true;
        } else {
            // Si falla, suma 1 a los intentos fallidos (su memoria)
            this.failedAttempts++;

            // Si llega a 3 errores, cambia su atributo a bloqueada
            if (this.failedAttempts >= 3) {
                this.locked = true;
            }
            return false;
        }
    }

    // Método para consultar si está bloqueada
    public boolean isLocked() {
        return this.locked;
    }

    // Método auxiliar para saber si ya se configuró una clave inicial
    public boolean hasPinConfigured() {
        return this.pin != null;
    }
}
