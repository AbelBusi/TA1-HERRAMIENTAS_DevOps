package com.meditrack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PrescriptionServiceTest {

    @Test
    void registraUnaRecetaValida() {
        PrescriptionService service = new PrescriptionService();
        Prescription p = service.registrar("P001", "Amoxicilina", 500, 1500);
        assertEquals("P001", p.getPatientId());
        assertEquals(1, service.obtenerPorPaciente("P001").size());
    }

    @Test
    void rechazaDosisQueExcedeElMaximoDiario() {
        PrescriptionService service = new PrescriptionService();
        assertThrows(IllegalStateException.class,
                () -> service.registrar("P002", "Ibuprofeno", 2000, 1200));
    }

    @Test
    void rechazaDatosInvalidos() {
        PrescriptionService service = new PrescriptionService();
        assertThrows(IllegalArgumentException.class,
                () -> service.registrar("", "Paracetamol", 500, 1000));
        assertThrows(IllegalArgumentException.class,
                () -> service.registrar("P003", "Paracetamol", 0, 1000));
    }

    @Test
    void filtraRecetasPorPaciente() {
        PrescriptionService service = new PrescriptionService();
        service.registrar("P001", "Amoxicilina", 500, 1500);
        service.registrar("P004", "Loratadina", 10, 20);

        List<Prescription> resultado = service.obtenerPorPaciente("P001");
        assertEquals(1, resultado.size());
        assertEquals("Amoxicilina", resultado.get(0).getMedication());
    }
}
