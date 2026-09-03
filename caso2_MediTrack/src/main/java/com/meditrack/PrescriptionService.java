package com.meditrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio del modulo de recetas. Representa, de forma simplificada, la
 * pieza del sistema que en el caso real quedo caida 6 horas tras un
 * despliegue sin pruebas automatizadas suficientes.
 */
public class PrescriptionService {

    private final List<Prescription> prescriptions = new ArrayList<>();

    public Prescription registrar(String patientId, String medication, double dosageMg, double maximoDiarioMg) {
        Prescription prescription = new Prescription(patientId, medication, dosageMg);
        if (prescription.excedeDosisMaxima(maximoDiarioMg)) {
            throw new IllegalStateException(
                    "La dosis indicada excede el maximo diario permitido para " + medication);
        }
        prescriptions.add(prescription);
        return prescription;
    }

    public List<Prescription> obtenerPorPaciente(String patientId) {
        List<Prescription> resultado = new ArrayList<>();
        for (Prescription p : prescriptions) {
            if (p.getPatientId().equals(patientId)) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}
