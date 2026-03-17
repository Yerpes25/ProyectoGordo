package com.example.appBandas;

import com.example.appBandas.modelos.*;
import com.example.appBandas.modelos.comunicacion.GaleriaMultimedia;
import com.example.appBandas.modelos.comunicacion.LecturaAnuncio;
import com.example.appBandas.modelos.comunicacion.LecturaAnuncioId;
import com.example.appBandas.modelos.comunicacion.TablonAnuncio;
import com.example.appBandas.modelos.comunicacion.Votacion;
import com.example.appBandas.modelos.comunicacion.Voto;
import com.example.appBandas.modelos.comunicacion.VotoId;
import com.example.appBandas.modelos.economia.Cuota;
import com.example.appBandas.modelos.economia.Liquidacion;
import com.example.appBandas.modelos.eventos.Asistencia;
import com.example.appBandas.modelos.eventos.AsistenciaId;
import com.example.appBandas.modelos.eventos.Evento;
import com.example.appBandas.modelos.institucion.Banda;
import com.example.appBandas.modelos.institucion.Contrato;
import com.example.appBandas.modelos.logistica.AsignacionBorla;
import com.example.appBandas.modelos.logistica.AsignacionBorlaId;
import com.example.appBandas.modelos.logistica.Instrumento;
import com.example.appBandas.modelos.logistica.Inventario;
import com.example.appBandas.modelos.logistica.Mantenimiento;
import com.example.appBandas.modelos.logistica.Prestamo;
import com.example.appBandas.modelos.logistica.UsuarioInstrumento;
import com.example.appBandas.modelos.logistica.UsuarioInstrumentoId;
import com.example.appBandas.modelos.musica.InstrumentoVoz;
import com.example.appBandas.modelos.musica.InstrumentoVozId;
import com.example.appBandas.modelos.musica.Marcha;
import com.example.appBandas.modelos.musica.Partitura;
import com.example.appBandas.modelos.musica.Seccion;
import com.example.appBandas.modelos.musica.Voz;
import com.example.appBandas.modelos.usuarios.Insignia;
import com.example.appBandas.modelos.usuarios.RolCargo;
import com.example.appBandas.modelos.usuarios.Usuario;
import com.example.appBandas.modelos.usuarios.UsuarioCargo;
import com.example.appBandas.modelos.usuarios.UsuarioCargoId;
import com.example.appBandas.modelos.usuarios.UsuarioInsignia;
import com.example.appBandas.modelos.usuarios.UsuarioInsigniaId;
import com.example.appBandas.modelos.viajes.PasajeroVehiculo;
import com.example.appBandas.modelos.viajes.PasajeroVehiculoId;
import com.example.appBandas.modelos.viajes.VehiculoCompartido;
import com.example.appBandas.repositorios.comunicacion.GaleriaMultimediaRepository;
import com.example.appBandas.repositorios.comunicacion.LecturaAnuncioRepository;
import com.example.appBandas.repositorios.comunicacion.TablonAnuncioRepository;
import com.example.appBandas.repositorios.comunicacion.VotacionRepository;
import com.example.appBandas.repositorios.comunicacion.VotoRepository;
import com.example.appBandas.repositorios.economia.CuotaRepository;
import com.example.appBandas.repositorios.economia.LiquidacionRepository;
import com.example.appBandas.repositorios.eventos.AsistenciaRepository;
import com.example.appBandas.repositorios.eventos.EventoRepository;
import com.example.appBandas.repositorios.institucion.BandaRepository;
import com.example.appBandas.repositorios.institucion.ContratoRepository;
import com.example.appBandas.repositorios.logistica.AsignacionBorlaRepository;
import com.example.appBandas.repositorios.logistica.InstrumentoRepository;
import com.example.appBandas.repositorios.logistica.InventarioRepository;
import com.example.appBandas.repositorios.logistica.MantenimientoRepository;
import com.example.appBandas.repositorios.logistica.PrestamoRepository;
import com.example.appBandas.repositorios.logistica.UsuarioInstrumentoRepository;
import com.example.appBandas.repositorios.musica.InstrumentoVozRepository;
import com.example.appBandas.repositorios.musica.MarchaRepository;
import com.example.appBandas.repositorios.musica.PartituraRepository;
import com.example.appBandas.repositorios.musica.SeccionRepository;
import com.example.appBandas.repositorios.musica.VozRepository;
import com.example.appBandas.repositorios.usuarios.InsigniaRepository;
import com.example.appBandas.repositorios.usuarios.RolCargoRepository;
import com.example.appBandas.repositorios.usuarios.UsuarioCargoRepository;
import com.example.appBandas.repositorios.usuarios.UsuarioInsigniaRepository;
import com.example.appBandas.repositorios.usuarios.UsuarioRepository;
import com.example.appBandas.repositorios.viajes.PasajeroVehiculoRepository;
import com.example.appBandas.repositorios.viajes.VehiculoCompartidoRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Clase de configuración encargada de rellenar la base de datos
 * con información de prueba la primera vez que se ejecuta la aplicación.
 * Atrapa las entidades guardadas para asegurar la generación de IDs.
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
            PartituraRepository partituraRepo,
            MantenimientoRepository mantenimientoRepo,
            GaleriaMultimediaRepository galeriaRepo,
            VehiculoCompartidoRepository vehiculoCompartidoRepo,
            LecturaAnuncioRepository lecturaAnuncioRepo,
            PasajeroVehiculoRepository pasajeroVehiculoRepo,
            AsignacionBorlaRepository asignacionBorlaRepo,
            UsuarioInsigniaRepository usuarioInsigniaRepo,
            UsuarioCargoRepository usuarioCargoRepo,
            InstrumentoVozRepository instrumentoVozRepo,
            UsuarioInstrumentoRepository usuarioInstrumentoRepo,
            AsistenciaRepository asistenciaRepo,
            VotoRepository votoRepo
    ) {
        return args -> {
            if (bandaRepo.count() == 0) {
                System.out.println("⏳ INICIANDO CARGA DE DATOS DE PRUEBA COMPLETA...");

                // 1. TABLAS MAESTRAS (Arapamos el ID al guardar)
                Banda banda = new Banda();
                banda.setNombre("Agrupación Musical Santa Cecilia");
                banda.setCif("G12345678");
                banda.setfFundacion(LocalDate.of(1995, 10, 24));
                banda = bandaRepo.save(banda);

                Seccion seccion = new Seccion();
                seccion.setNombre("Viento Metal");
                seccion = seccionRepo.save(seccion);

                Voz voz = new Voz();
                voz.setNombre("Primera Voz");
                voz = vozRepo.save(voz);

                RolCargo cargo = new RolCargo();
                cargo.setNombre("Director Musical");
                cargo.setTipoCargo("Junta Directiva");
                cargo.setLimitePersonas(1);
                cargo = cargoRepo.save(cargo);

                Insignia insignia = new Insignia();
                insignia.setNombre("Asistencia Perfecta");
                insignia.setDescripcion("Acudir a todos los ensayos de un mes");
                insignia.setMeta(10);
                insignia = insigniaRepo.save(insignia);

                // 2. TABLAS SECUNDARIAS
                Usuario usuario1 = new Usuario();
                usuario1.setNombre("Carlos");
                usuario1.setApellidos("García Pérez");
                usuario1.setDni("12345678Z");
                usuario1.setEmail("carlos@email.com");
                usuario1.setPassword("mypassword123");
                usuario1.setTelefono("600123456");
                usuario1.setRolApp("Musico");
                usuario1.setBanda(banda); 
                usuario1 = usuarioRepo.save(usuario1);

                Usuario usuario2 = new Usuario();
                usuario2.setNombre("Laura");
                usuario2.setApellidos("Martínez Ruiz");
                usuario2.setDni("87654321B");
                usuario2.setEmail("laura@email.com");
                usuario2.setPassword("mypassword123");
                usuario2.setTelefono("611223344");
                usuario2.setRolApp("Musico");
                usuario2.setBanda(banda);
                usuario2 = usuarioRepo.save(usuario2);

                Instrumento instrumento = new Instrumento();
                instrumento.setNombre("Trompeta");
                instrumento.setEsViento(true);
                instrumento.setSeccion(seccion);
                instrumento = instrumentoRepo.save(instrumento);

                Evento evento = new Evento();
                evento.setTipo("Ensayo General");
                evento.setDireccion("Local de la Banda, Nave 4");
                evento.setfHora(LocalDateTime.of(2026, 3, 20, 21, 0));
                evento.setBanda(banda);
                evento = eventoRepo.save(evento);

                Inventario inventario = new Inventario();
                inventario.setTipo("Uniforme");
                inventario.setDescripcion("Chaqueta de Gala (Talla M)");
                inventario.setCodigoQr("QR-UNI-001");
                inventario.setEstado("Disponible");
                inventario.setBanda(banda);
                inventario = inventarioRepo.save(inventario);

                Marcha marcha = new Marcha();
                marcha.setNombre("La Pasión");
                marcha.setAutor("Manuel Alejandro");
                marcha.setBanda(banda);
                marcha = marchaRepo.save(marcha);

                Contrato contrato = new Contrato();
                contrato.setCliente("Hermandad de la Macarena");
                contrato.setfFirma(LocalDate.of(2026, 1, 15));
                contrato.setImporteTotal(3500.0);
                contrato.setHorasFirmadas(6.5);
                contrato.setBanda(banda);
                contrato = contratoRepo.save(contrato);

                TablonAnuncio anuncio = new TablonAnuncio();
                anuncio.setTitulo("Reunión de Componentes");
                anuncio.setMensaje("El viernes tras el ensayo tendremos una reunión importante.");
                anuncio.setRequiereConf(true);
                anuncio.setBanda(banda);
                anuncio = anuncioRepo.save(anuncio);

                Votacion votacion = new Votacion();
                votacion.setTitulo("Elección de la tela para el nuevo uniforme");
                votacion.setfLimite(LocalDateTime.of(2026, 4, 1, 23, 59, 59));
                votacion.setActiva(true);
                votacion.setBanda(banda);
                votacion = votacionRepo.save(votacion);

                VehiculoCompartido vehiculo = new VehiculoCompartido();
                vehiculo.setEvento(evento);
                vehiculo.setUsuario(usuario1); 
                vehiculo.setPlazasTotales(4);
                vehiculo.setPlazasDisponibles(3);
                vehiculo = vehiculoCompartidoRepo.save(vehiculo);

                // 3. TABLAS FINALES (Simples)
                Cuota cuota = new Cuota();
                cuota.setMes(3);
                cuota.setAnio(2026);
                cuota.setImporte(15.0);
                cuota.setEstado("Pagada");
                cuota.setUsuario(usuario1);
                cuotaRepo.save(cuota);

                Prestamo prestamo = new Prestamo();
                prestamo.setfSalida(LocalDate.of(2026, 3, 1));
                prestamo.setInventario(inventario);
                prestamo.setUsuario(usuario1);
                prestamoRepo.save(prestamo);

                Liquidacion liquidacion = new Liquidacion();
                liquidacion.setImporteAPagar(35.50);
                liquidacion.setfPago(LocalDate.of(2026, 4, 10));
                liquidacion.setContrato(contrato);
                liquidacion.setUsuario(usuario1);
                liquidacionRepo.save(liquidacion);

                Partitura partitura = new Partitura();
                partitura.setRutaPDF("https://tuservidor.com/pdf/lapasion_trompeta1.pdf");
                partitura.setRutaAudio("https://tuservidor.com/audio/lapasion.mp3");
                partitura.setMarcha(marcha);
                partituraRepo.save(partitura);

                Mantenimiento mantenimiento = new Mantenimiento();
                mantenimiento.setArticulo(inventario);
                mantenimiento.setfAviso(LocalDate.now());
                mantenimiento.setDescripcion("Falta un botón en la chaqueta de gala.");
                mantenimientoRepo.save(mantenimiento);

                GaleriaMultimedia galeria = new GaleriaMultimedia();
                galeria.setEvento(evento);
                galeria.setRutaArchivo("https://miservidor.com/fotos/ensayo1.jpg");
                galeria.setTipo("Imagen");
                galeriaRepo.save(galeria);

                // 4. TABLAS CON CLAVES COMPUESTAS (Relaciones N a M)
                LecturaAnuncio lectura = new LecturaAnuncio();
                lectura.setId(new LecturaAnuncioId(usuario1.getIdUsuario(), anuncio.getIdAnuncios()));
                lectura.setUsuario(usuario1);
                lectura.setAnuncio(anuncio);
                lectura.setfLectura(LocalDateTime.now());
                lecturaAnuncioRepo.save(lectura);

                PasajeroVehiculo pasajero = new PasajeroVehiculo();
                pasajero.setId(new PasajeroVehiculoId(usuario2.getIdUsuario(), vehiculo.getIdVehiculo()));
                pasajero.setUsuario(usuario2); 
                pasajero.setVehiculo(vehiculo);
                pasajeroVehiculoRepo.save(pasajero);

                AsignacionBorla asignacionBorla = new AsignacionBorla();
                asignacionBorla.setId(new AsignacionBorlaId(usuario1.getIdUsuario(), usuario2.getIdUsuario()));
                asignacionBorla.setAbanderado(usuario1); 
                asignacionBorla.setBorla(usuario2);      
                asignacionBorlaRepo.save(asignacionBorla);

                UsuarioInsignia usuarioInsignia = new UsuarioInsignia();
                usuarioInsignia.setId(new UsuarioInsigniaId(usuario1.getIdUsuario(), insignia.getIdInsignia()));
                usuarioInsignia.setUsuario(usuario1);
                usuarioInsignia.setInsignia(insignia);
                usuarioInsignia.setfObtencion(LocalDate.now());
                usuarioInsigniaRepo.save(usuarioInsignia);

                UsuarioCargo usuarioCargo = new UsuarioCargo();
                usuarioCargo.setId(new UsuarioCargoId(usuario1.getIdUsuario(), cargo.getIdCargo()));
                usuarioCargo.setUsuario(usuario1);
                usuarioCargo.setCargo(cargo);
                usuarioCargoRepo.save(usuarioCargo);

                InstrumentoVoz instrumentoVoz = new InstrumentoVoz();
                instrumentoVoz.setId(new InstrumentoVozId(instrumento.getIdInstrumento(), voz.getIdVoz()));
                instrumentoVoz.setInstrumento(instrumento);
                instrumentoVoz.setVoz(voz);
                instrumentoVoz = instrumentoVozRepo.save(instrumentoVoz);

                UsuarioInstrumento usuarioInstrumento = new UsuarioInstrumento();
                usuarioInstrumento.setId(new UsuarioInstrumentoId(usuario1.getIdUsuario(), instrumento.getIdInstrumento(), voz.getIdVoz()));
                usuarioInstrumento.setUsuario(usuario1);
                usuarioInstrumento.setInstrumentoVoz(instrumentoVoz);
                usuarioInstrumento.setEsSolista(true);
                usuarioInstrumento.setEsMaza(false);
                usuarioInstrumentoRepo.save(usuarioInstrumento);

                Asistencia asistencia = new Asistencia();
                asistencia.setId(new AsistenciaId(usuario1.getIdUsuario(), evento.getIdEvento()));
                asistencia.setUsuario(usuario1);
                asistencia.setEvento(evento);
                asistencia.setEstado("Asiste");
                asistencia.setObservacion("Llegaré 5 minutos tarde");
                asistenciaRepo.save(asistencia);

                Voto voto = new Voto();
                voto.setId(new VotoId(usuario1.getIdUsuario(), votacion.getIdVotacion()));
                voto.setUsuario(usuario1);
                voto.setVotacion(votacion);
                voto.setOpcion("Tela transpirable azul marino");
                votoRepo.save(voto);

                System.out.println("✅ DATOS DE PRUEBA CARGADOS CORRECTAMENTE EN LA BASE DE DATOS");
            } else {
                System.out.println("⚡ LA BASE DE DATOS YA TIENE DATOS. SE OMITE LA CARGA INICIAL.");
            }
        };
    }
}