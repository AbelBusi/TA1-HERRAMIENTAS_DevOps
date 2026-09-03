package com.meditrack;

/**
 * Representa una receta medica. Logica simplificada (sin framework) que
 * modela la validacion que fallo en produccion segun el Caso 2 del Anexo TA1:
 * una receta se publico sin validar la dosis y el medicamento correctamente.
 */
public class Prescription {

    private final String patientId;
    private final String medication;
    private final double dosageMg;

    public Prescription(String patientId, String medication, double dosageMg) {
        if (patientId == null || patientId.isBlank()) {
            throw new IllegalArgumentException("El id del paciente es obligatorio");
        }
        if (medication == null || medication.isBlank()) {
            throw new IllegalArgumentException("El medicamento es obligatorio");
        }
        if (dosageMg <= 0) {
            throw new IllegalArgumentException("La dosis debe ser mayor a 0 mg");
        }
        this.patientId = patientId;
        this.medication = medication;
        this.dosageMg = dosageMg;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getMedication() {
        return medication;
    }

    public double getDosageMg() {
        return dosageMg;
    }

    /** Umbral simulado de dosis maxima diaria por seguridad del paciente. */
    public boolean excedeDosisMaxima(double maximoDiarioMg) {
        return dosageMg > maximoDiarioMg;
    }
}
