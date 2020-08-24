package ec.com.sigc.preLoad;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ec.com.sigc.entidad.BackOffice;
import ec.com.sigc.entidad.Cliente;
import ec.com.sigc.entidad.Consultor;
import ec.com.sigc.entidad.EstadoConsultoria;
import ec.com.sigc.entidad.Preguntas;
import ec.com.sigc.entidad.RoleSys;
import ec.com.sigc.entidad.Seccion;
import ec.com.sigc.entidad.TipoConsultoria;
import ec.com.sigc.entidad.Usuario;
import ec.com.sigc.repositorio.BackOfficeRepositorio;
import ec.com.sigc.repositorio.ClienteRepositorio;
import ec.com.sigc.repositorio.ConsultorRepositorio;
import ec.com.sigc.repositorio.EstadoConsultoriaRepositorio;
import ec.com.sigc.repositorio.PreguntasRepositorio;
import ec.com.sigc.repositorio.RoleSysRepositorio;
import ec.com.sigc.repositorio.SeccionRepositorio;
import ec.com.sigc.repositorio.UsuarioRepositorio;
import ec.com.sigc.repositorio.TipoConsultoriaRepositorio;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(UsuarioRepositorio usuarioRepositorio, RoleSysRepositorio roleSysRepositorio,
			BackOfficeRepositorio backOfficeRepositorio, ConsultorRepositorio consRepo,
			ClienteRepositorio clienteRepositorio, TipoConsultoriaRepositorio tipoConsRepositorio,
			SeccionRepositorio sectionRepositorio, PreguntasRepositorio questRepositorio, EstadoConsultoriaRepositorio estadoConsultoriaRepositorio) {
		return args -> {
			// roles
			roleSysRepositorio.save(new RoleSys(1, "ADMINISTRADOR"));
			roleSysRepositorio.save(new RoleSys(2, "BACK-OFFICE"));
			roleSysRepositorio.save(new RoleSys(3, "CONSULTOR"));
			roleSysRepositorio.save(new RoleSys(4, "CLIENTE"));
			// administradores
			usuarioRepositorio.save(new Usuario(1, "admin", "admin", "admin@sigc", Long.valueOf("9999999999"), "admin",
					"admin", "UCE", roleSysRepositorio.findById(1).get(), true));
			// back-office
			usuarioRepositorio.save(new Usuario(2, "back", "back", "back@sigc", Long.valueOf("9999999999"), "back",
					"back", "UCE", roleSysRepositorio.findById(2).get(), true));
			backOfficeRepositorio.save(new BackOffice(1, "1721", usuarioRepositorio.findById(2).get()));

			// consultor
			usuarioRepositorio.save(new Usuario(3, "cons", "cons", "cons@sigc", Long.valueOf("9999999999"), "cons",
					"cons", "UCE", roleSysRepositorio.findById(3).get(), true));
			consRepo.save(new Consultor(1, null, usuarioRepositorio.findById(3).get()));

			// cliente
			usuarioRepositorio.save(new Usuario(4, "cli", "cli", "cli@sigc", Long.valueOf("9999999999"), "cli", "cli",
					"UCE", roleSysRepositorio.findById(4).get(), true));
			clienteRepositorio.save(new Cliente(1, "0609", "Lenervil.corp", usuarioRepositorio.findById(4).get()));

			// tipo cuestionarios

			TipoConsultoria tC = tipoConsRepositorio.save(new TipoConsultoria(1, "ISO 9001:2015"));

			// secciones
			Seccion s1 = sectionRepositorio.save(new Seccion(1, "Contexto de la organización	"));
			Seccion s2 = sectionRepositorio.save(new Seccion(2, "Liderazgo"));
			Seccion s3 = sectionRepositorio.save(new Seccion(3, "Planificación	"));
			Seccion s4 = sectionRepositorio.save(new Seccion(4, "Apoyo"));
			Seccion s5 = sectionRepositorio.save(new Seccion(5, "Operación"));
			Seccion s6 = sectionRepositorio.save(new Seccion(6, "Evaluación de desempeño"));
			Seccion s7 = sectionRepositorio.save(new Seccion(7, "Mejora"));

			// preguntas
			questRepositorio.save(new Preguntas(	1	, "	Mantiene un análisis de contexto, donde se han identificado las cuestiones internas y externas que afectan al desarrollo de los productos / servicios de la organización	", "actividad","entregable",s1, tC));
			questRepositorio.save(new Preguntas(	2	, "	Ha identificado las necesidades y expectativas de las partes interesadas de la organización	", "actividad","entregable",s1, tC));
			questRepositorio.save(new Preguntas(	3	, "	Ha determinado medios de seguimiento para asegurar cumplir con las necesidades / expectativas de las partes interesadas	", "actividad","entregable",s1, tC));
			questRepositorio.save(new Preguntas(	4	, "	Ha definido el alcance del sistema integrado de gestión, y definido la no aplicabilidad de clausulas cuando sea apropiado de acuerdo al giro de negocio	", "actividad","entregable",s1, tC));
			questRepositorio.save(new Preguntas(	5	, "	Se ha identificado entradas, salidas, controles, indicadores, recursos, aspectos ambientales, RIESGOS en los distintos procesos definidos y aplicables al SGC	", "actividad","entregable",s1, tC));
			questRepositorio.save(new Preguntas(	6	, "	La alta dirección mantiene un criterio claro sobre la comprensión del SGC, sus implicaciones, asignación de recursos para la mejora y eficacia del sistema	","actividad","entregable",s2, tC));
			questRepositorio.save(new Preguntas(	7	, "	La alta dirección rinde cuentas sobre el rendimiento y eficacia del SGC	","actividad","entregable",s2, tC));
			questRepositorio.save(new Preguntas(	8	, "	La alta dirección comunica al personal sus objetivos, cumplimiento actual y estado de la organización respecto de sus resultados y SGC	","actividad","entregable",s2, tC));
			questRepositorio.save(new Preguntas(	9	, "	Se ha establecido una política de calidad en la organización	","actividad","entregable",s2, tC));
			questRepositorio.save(new Preguntas(	10	, "	Es apropiada al contexto de la organización; incluye compromiso con el cumplimiento de requisitos aplicables y mejora continua	","actividad","entregable",s2, tC));
			questRepositorio.save(new Preguntas(	11	, "	La política se comunica, se mantiene vigente y es entendida por las partes interesadas	","actividad","entregable",s2, tC));
			questRepositorio.save(new Preguntas(	12	, "	Se han asignado  responsabilidades y autoridades para los distintos procesos definidos por la organización	","actividad","entregable",s2, tC));
			questRepositorio.save(new Preguntas(	13	, "	Se tiene definido acciones para abordar los riesgos y oportunidades por cada proceso definido dentro del alcance de la organización, así como del análisis del contexto	", "actividad","entregable",s3, tC));
			questRepositorio.save(new Preguntas(	14	, "	Se encuentra establecido un método para identificiar, evaluar, establecer acciones y analizar eficacia para los riesgos y oportunidades	", "actividad","entregable",s3, tC));
			questRepositorio.save(new Preguntas(	15	, "	Se mantienen objetivos de calidad coherentes con la política, son medibles. Adicional, se ha establecido un método de seguimiento para evaluar cumplimiento y establecer mejoras.	", "actividad","entregable",s3, tC));
			questRepositorio.save(new Preguntas(	16	, "	Se han comunicado los objetivos al personal pertinente	", "actividad","entregable",s3, tC));
			questRepositorio.save(new Preguntas(	17	, "	Se ha definido en los objetivos: Que se va a hacer,  que recursos se requieren,  responsable, finalización y como se evaluaran resultados	", "actividad","entregable",s3, tC));
			questRepositorio.save(new Preguntas(	18	, "	Cuando se determinan cambios en el SGC, estos se llevan a cabo de manera planificada?	", "actividad","entregable",s3, tC));
			questRepositorio.save(new Preguntas(	19	, "	Se han definido recursos para la implementación y  mejora del SGC	","actividad","entregable",s4, tC));
			questRepositorio.save(new Preguntas(	20	, "	Estan definidas las personas necesarias para cumplir cada proceso definido en la organización	","actividad","entregable",s4, tC));
			questRepositorio.save(new Preguntas(	21	, "	Se ha definido y mantenido los equipos, infraestructura, recursos de transporte, y tecnología necesaria para la organización	","actividad","entregable",s4, tC));
			questRepositorio.save(new Preguntas(	22	, "	Se realiza un análisis del clima laboral, se ha establecido acciones para mejorar el ambiente laboral, considerando el trabajo seguro y previniendo riesgos ergonómicos, psicosociales, etc	","actividad","entregable",s4, tC));
			questRepositorio.save(new Preguntas(	23	, "	Se identifican los equipos necesarios de medición para asegurar la calidad de nuestros productos / servicios otorgados	","actividad","entregable",s4, tC));
			questRepositorio.save(new Preguntas(	24	, "	Se ha determinado un método para calibrar, o verificar estos equipos a Intervalos planificados	","actividad","entregable",s4, tC));
			questRepositorio.save(new Preguntas(	25	, "	Existe trazabilidad de medicion que testifique la validéz de los patrones de medición	","actividad","entregable",s4, tC));
			questRepositorio.save(new Preguntas(	26	, "	Si el equipo es calibrado, se tiene la información documentada necesaria para demostrar que el proveedor es competente para realizar dicha actividad	","actividad","entregable",s4, tC));
			questRepositorio.save(new Preguntas(	27	, "	Se ha determinado el conocimiento necesario de la organización, proveniente de las experiencias pasadas, resultados de éxito, fracaso, tomando en cuenta las condiciones cambiantes, para asegurar que ese conocimiento no escape de la misma	","actividad","entregable",s4, tC));
			questRepositorio.save(new Preguntas(	28	, "	Se ha determinado la competencia necesaria del personal para su proceso a desempeñar	","actividad","entregable",s4, tC));
			questRepositorio.save(new Preguntas(	29	, "	El personal es conciente de la política  de calidad,  objetivos de calidad, como aporta a la eficacia del SGC	","actividad","entregable",s4, tC));
			questRepositorio.save(new Preguntas(	30	, "	Mantiene un plan de comunicación que contemple la comunicación tanto interna como externa	","actividad","entregable",s4, tC));
			questRepositorio.save(new Preguntas(	31	, "	Ha definido un procedimiento / mecanismo para asegurar la identificación, disposición, seguridad, ubicación, resguardo, etc de la información documentada	","actividad","entregable",s4, tC));
			questRepositorio.save(new Preguntas(	32	, "	Se ha desarrollado mecanismos de planificación de actividades, tomando en cuenta la información documentada necesaria para respaldar su identificación, comunicación con el cliente y control de cambios	","actividad","entregable",s5, tC));
			questRepositorio.save(new Preguntas(	33	, "	Se han definido mecanismos para la gestión de los Requisitos para los productos / servicios	","actividad","entregable",s5, tC));
			questRepositorio.save(new Preguntas(34,"Se ha planificado el diseño y desarrollo de sus productos/servicios tomando en cuenta las etapas, controles, actividades de verificación y validación; responsabilidades, autoridades, requisitos y recursos necesarios, así como la participación","actividad","entregable",s5, tC));
			questRepositorio.save(new Preguntas(35,"Para el diseño y desarrollo de los productos / servicios, la organización ha establecido mecanismos para determinar las entradas para el diseño y desarrollo tomando en cuenta: Los requisitos funcionales, información de diseños previos, requisitos legales","actividad","entregable",s5, tC));
			questRepositorio.save(new Preguntas(36,"Se han definido controles para el diseño y desarrollo; incluyendo mecanismos para controlar los cambios del diseño y desarrollo conservando información documentada	","actividad","entregable",s5, tC));
			questRepositorio.save(new Preguntas(37,"Se establecen lineamientos para asegurar las salidas del diseño y desarrollo de acuerdo con: Cumplimiento  de  los requisitos de las entradas, adecuacion a los procesos posteriores (Validados),y provisión segura. Se conserva información documentada?","actividad","entregable",s5, tC));
			questRepositorio.save(new Preguntas(38,"Se ha defindo mecanismos para: -Identificar a los proveedores de servicio / productos suministrados externamente	- Seleccionar, aprobar, evaluar y medir el desempeño de dichos proveedores"	,"actividad","entregable",s5, tC));
			questRepositorio.save(new Preguntas(	39	, "	Se han definido los mecanismos y condiciones controladas para cumplir con los requerimientos controlados para la gestión de los productos - servicios que ofrece	","actividad","entregable",s5, tC));
			questRepositorio.save(new Preguntas(	40	, "	Se han establecido mecanismos e información documentada para la verificación / validación de sus productos, considerando los requisitos legales, normativos, reglamentarios y contractuales aplicables	","actividad","entregable",s5, tC));
			questRepositorio.save(new Preguntas(	41	, "	Las salidas no conformes se identifican, se controlan y se establecen acciones 	","actividad","entregable",s5, tC));
			questRepositorio.save(new Preguntas(	42	, "	Se ha identificado que medir en la oganización para medir el desempeño del SGC y sus procesos	","actividad","entregable",s6, tC));
			questRepositorio.save(new Preguntas(	43	, "	Se ha definido un metodo de medición, frecuencia para medición. Adicional se considera acciones preventivas / correctivas de mejora continua cuando los objetivos no se alcanzan	","actividad","entregable",s6, tC));
			questRepositorio.save(new Preguntas(	44	, "	Está definido un mecanismo de evaluación de la satisfacción de las necesidades y expectativas de los clientes, se análiza esta información para la mejora continua	","actividad","entregable",s6, tC));
			questRepositorio.save(new Preguntas(	45	, "	Se ha definido realizar auditorías internas del SGC a intervalos planificados, así como toda la información documentada para demostrar la realización de las auditorías planificadas, así como sus acciones de mejora 	","actividad","entregable",s6, tC));
			questRepositorio.save(new Preguntas(	46	, "	Se ha definido un mecanismo de selección de auditores internos, que contemple ISO 9001:2015	","actividad","entregable",s6, tC));
			questRepositorio.save(new Preguntas(	47	, "	La dirección revisa a intervalos planificados los siguientes puntos: a)el estado de las acciones de las revisiones por la dirección previas; b)los cambios en las cuestiones externas e internas que sean pertinentes al ","actividad","entregable",s6, tC));
			questRepositorio.save(new Preguntas(	48	, "	Se obtienen, de la revisión por la dirección, acciones de mejora y asignación de recursos?	","actividad","entregable",s6, tC));
			questRepositorio.save(new Preguntas(	49	, "	La organización  mejora sus procesos, productos, servicios y eficacia del SGC	","actividad","entregable",s7, tC));
			questRepositorio.save(new Preguntas(	50	, "	Establece acciones de mejora continua frente a los resultados no alcanzados	","actividad","entregable",s7, tC));
			questRepositorio.save(new Preguntas(	51	, "	Se analiza eficacia de las acciones tomadas dentro del SGC	","actividad","entregable",s7, tC));


			// estados consultoria
			estadoConsultoriaRepositorio.save(new EstadoConsultoria(1, "SOLICITADA"));
			estadoConsultoriaRepositorio.save(new EstadoConsultoria(2, "ASIGNADA"));
			estadoConsultoriaRepositorio.save(new EstadoConsultoria(3, "EN PROCESO"));
			estadoConsultoriaRepositorio.save(new EstadoConsultoria(4, "EN ESPERA DE EVIDENCIA"));
			estadoConsultoriaRepositorio.save(new EstadoConsultoria(5, "REVISANDO EVIDENCIA"));
			estadoConsultoriaRepositorio.save(new EstadoConsultoria(6, "FINALIZADA"));
		};
	}
}
