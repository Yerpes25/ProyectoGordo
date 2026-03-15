package com.example.appBandas;

import com.example.appBandas.modelos.*;
import com.example.appBandas.repositorios.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Clase de configuración encargada de rellenar la base de datos
 * con información de prueba la primera vez que se ejecuta la aplicación.
 */
@Configuration
public class InicializadorDatos {

    @Bean
    public CommandLineRunner poblarBaseDeDatos(
            BandaRepository bandaRepo,
            SeccionRepository seccionRepo,
            VozRepository vozRepo,
            RolCargoRepository cargoRepo,
            InsigniaRepository insigniaRepo,
            UsuarioRepository usuarioRepo,
            InstrumentoRepository instrumentoRepo,
            EventoRepository eventoRepo,
            InventarioRepository inventarioRepo,
            MarchaRepository marchaRepo,
            ContratoRepository contratoRepo,
            TablonAnuncioRepository anuncioRepo,
            VotacionRepository votacionRepo,
            CuotaRepository cuotaRepo,
            PrestamoRepository prestamoRepo,
            LiquidacionRepository liquidacionRepo,
            PartituraRepository partituraRepo
    ) {
        return args -> {
            if (bandaRepo.count() == 0) {
                System.out.println("INICIANDO CARGA DE DATOS DE PRUEBA...");

                // TABLAS MAESTRAS 
                Banda banda = new Banda();
                banda.setNombre("Agrupación Musical Santa Cecilia");
                banda.setCif("G12345678");
                banda.setfFundacion(LocalDate.of(1995, 10, 24));
                bandaRepo.save(banda);

                Seccion seccion = new Seccion();
                seccion.setNombre("Viento Metal");
                seccionRepo.save(seccion);

                Voz voz = new Voz();
                voz.setNombre("Primera Voz");
                vozRepo.save(voz);

                RolCargo cargo = new RolCargo();
                cargo.setNombre("Director Musical");
                cargo.setTipoCargo("Junta Directiva");
                cargo.setLimitePersonas(1);
                cargoRepo.save(cargo);

                Insignia insignia = new Insignia();
                insignia.setNombre("Asistencia Perfecta");
                insignia.setDescripcion("Acudir a todos los ensayos de un mes");
                insignia.setMeta(10);
                insigniaRepo.save(insignia);

                // TABLAS SECUNDARIAS
                Usuario usuario = new Usuario();
                usuario.setNombre("Carlos");
                usuario.setApellidos("García Pérez");
                usuario.setDni("12345678Z");
                usuario.setEmail("carlos@email.com");
                usuario.setPassword("mypassword123");
                usuario.setTelefono("600123456");
                usuario.setRolApp("Musico");
                usuario.setBanda(banda); 
                usuarioRepo.save(usuario);

                Instrumento instrumento = new Instrumento();
                instrumento.setNombre("Trompeta");
                instrumento.setEsViento(true);
                instrumento.setSeccion(seccion);
                instrumentoRepo.save(instrumento);

                Evento evento = new Evento();
                evento.setTipo("Ensayo General");
                evento.setDireccion("Local de la Banda, Nave 4");
                evento.setfHora(LocalDateTime.of(2026, 3, 20, 21, 0));
                evento.setBanda(banda);
                eventoRepo.save(evento);

                Inventario inventario = new Inventario();
                inventario.setTipo("Uniforme");
                inventario.setDescripcion("Chaqueta de Gala (Talla M)");
                inventario.setCodigoQr("QR-UNI-001");
                inventario.setEstado("Disponible");
                inventario.setBanda(banda);
                inventarioRepo.save(inventario);

                Marcha marcha = new Marcha();
                marcha.setNombre("La Pasión");
                marcha.setAutor("Manuel Alejandro");
                marcha.setBanda(banda);
                marchaRepo.save(marcha);

                Contrato contrato = new Contrato();
                contrato.setCliente("Hermandad de la Macarena");
                contrato.setfFirma(LocalDate.of(2026, 1, 15));
                contrato.setImporteTotal(3500.0);
                contrato.setHorasFirmadas(6.5);
                contrato.setBanda(banda);
                contratoRepo.save(contrato);

                TablonAnuncio anuncio = new TablonAnuncio();
                anuncio.setTitulo("Reunión de Componentes");
                anuncio.setMensaje("El viernes tras el ensayo tendremos una reunión importante.");
                anuncio.setRequiereConf(true);
                anuncio.setBanda(banda);
                anuncioRepo.save(anuncio);

                Votacion votacion = new Votacion();
                votacion.setTitulo("Elección de la tela para el nuevo uniforme");
                votacion.setfLimite(LocalDateTime.of(2026, 4, 1, 23, 59, 59));
                votacion.setActiva(true);
                votacion.setBanda(banda);
                votacionRepo.save(votacion);

                // TABLAS FINALES 
                Cuota cuota = new Cuota();
                cuota.setMes(3);
                cuota.setAnio(2026);
                cuota.setImporte(15.0);
                cuota.setEstado("Pagada");
                cuota.setUsuario(usuario);
                cuotaRepo.save(cuota);

                Prestamo prestamo = new Prestamo();
                prestamo.setfSalida(LocalDate.of(2026, 3, 1));
                prestamo.setInventario(inventario);
                prestamo.setUsuario(usuario);
                prestamoRepo.save(prestamo);

                Liquidacion liquidacion = new Liquidacion();
                liquidacion.setImporteAPagar(35.50);
                liquidacion.setfPago(LocalDate.of(2026, 4, 10));
                liquidacion.setContrato(contrato);
                liquidacion.setUsuario(usuario);
                liquidacionRepo.save(liquidacion);

                Partitura partitura = new Partitura();
                partitura.setRutaPDF("https://tuservidor.com/pdf/lapasion_trompeta1.pdf");
                partitura.setRutaAudio("https://tuservidor.com/audio/lapasion.mp3");
                partitura.setMarcha(marcha);
                partituraRepo.save(partitura);

                System.out.println("DATOS DE PRUEBA CARGADOS CORRECTAMENTE EN LA BASE DE DATOS");
            } else {
                System.out.println("LA BASE DE DATOS YA TIENE DATOS");
            }
        };
    }
}