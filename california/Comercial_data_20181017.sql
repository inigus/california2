-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         5.7.21 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para comercial
CREATE DATABASE IF NOT EXISTS `comercial` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `comercial`;

-- Volcando estructura para tabla comercial.book
CREATE TABLE IF NOT EXISTS `book` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla comercial.book: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` (`id`, `name`) VALUES
	(24, 'Book A'),
	(25, 'Book A');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

-- Volcando estructura para tabla comercial.book_publisher
CREATE TABLE IF NOT EXISTS `book_publisher` (
  `book_id` int(10) unsigned NOT NULL,
  `publisher_id` int(10) unsigned NOT NULL,
  `published_date` datetime DEFAULT NULL,
  PRIMARY KEY (`book_id`,`publisher_id`),
  KEY `fk_bookpublisher_publisher_idx` (`publisher_id`),
  CONSTRAINT `fk_bookpublisher_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_bookpublisher_publisher` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla comercial.book_publisher: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `book_publisher` DISABLE KEYS */;
INSERT INTO `book_publisher` (`book_id`, `publisher_id`, `published_date`) VALUES
	(24, 22, '2017-05-10 12:22:06'),
	(24, 23, '2017-05-10 12:22:06'),
	(25, 22, '2017-05-10 12:22:28'),
	(25, 23, '2017-05-10 12:22:28');
/*!40000 ALTER TABLE `book_publisher` ENABLE KEYS */;

-- Volcando estructura para tabla comercial.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCliente` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla comercial.cliente: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`idCliente`, `nombreCliente`) VALUES
	(1, 'Inigo'),
	(2, 'Inigo'),
	(3, 'Inigo');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla comercial.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `poblacion` varchar(50) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `esPrescriptor` char(1) DEFAULT NULL,
  `fechaAlta` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla comercial.clientes: ~133 rows (aproximadamente)
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`idCliente`, `nombre`, `apellidos`, `poblacion`, `telefono`, `mail`, `descripcion`, `esPrescriptor`, `fechaAlta`) VALUES
	(1, 'Vicente', 'Tercero Fernandez', 'Ermua', '', '', 'Es un centro de fisio-masaje. Pertenece a IRCOI', '1', '2017-05-04 17:42:24'),
	(2, 'Amaia (Txiribita)', 'Del Rio', 'Bilbao-Casco Viejo', '', '', 'Novaline.  Daniel 682137357', '0', '2017-05-04 17:42:24'),
	(3, 'Daniel', 'Peciña', 'Gernika', '', '682137357', 'Pasa consulta en: Gernica-Amaia, Casco-Viejo, Amorebieta', '1', '2017-05-04 17:42:24'),
	(4, 'Beñat', 'Zarandona', 'Durango', '', '', 'Mucha entrada de gente', '0', '2017-05-04 17:42:24'),
	(5, 'Maie', 'Gonzalez', 'Beriatua', '', '', 'Es un Gabinete. Tiene Solgarr, Lamberts, Nutergia…..   En el entro se pasan distintas consultas. Dietista, masaje,… Estuvo en la reunión de Garbiñe con LAUDI. No pasa consulta los viernes.', '0', '2017-05-04 17:42:24'),
	(6, 'Idoia', 'Geranabarrena', 'Ondarroa', '', '', 'Centro muy bien montado. Idoia interesada en testar-kinesologia y quiza podría asistir a algún curso de LAURI', '0', '2017-05-04 17:42:24'),
	(7, 'Alejandro', 'Fraile Misas', 'Santander', '', '', 'Vende productos de Gym', '0', '2017-05-04 17:42:24'),
	(8, 'Ohiana', 'Beldarraín', 'Sopelana', '', '', 'Pasa consulta el padre, habría que quedar con él.', '0', '2017-05-04 17:42:24'),
	(9, 'Beatriz', 'Caso Frías', 'Bilbao', '', '', 'pasar de 14:00 a 16:30', '0', '2017-05-04 17:42:24'),
	(10, 'José Ignacio', '', 'Castro Urdiales', '', '', 'Abrira centro a primeros de Junio', '0', '2017-05-04 17:42:24'),
	(11, 'Lorenzo', 'Herb. Leizuri', 'Bilbao-santutxu', '', '0', 'Tiene varios centros. ND. Mungia, Diaz de haro', '0', '2017-05-04 17:42:24'),
	(12, 'Aintzane, Miren, Sara', '', 'Bilbao Autonomia', '', '0', 'Tienen los centros de Autonomia y la Peña', '0', '2017-05-04 17:42:24'),
	(13, 'Yoday Natural', '', 'Bilbao', '', '0', 'Nos trabajan bien el Regenpol', '0', '2017-05-04 17:42:24'),
	(14, 'Elisabeth', 'Basagoiti', 'Amorebieta', '', '0', 'pasa consulta Daniel peciña', '0', '2017-05-04 17:42:24'),
	(15, 'Luz Divina', 'Gonzalez', 'Bilbao-San Ign', '', '0', 'No quiere saber nada de nosotros.', '0', '2017-05-04 17:42:24'),
	(16, 'Isabel', 'Peinado Ruiz', 'Astrabudua', '', '0', 'tiene varias consultas. Posibilidad de…', '0', '2017-05-04 17:42:24'),
	(17, 'Susana', 'Corta  Saez', 'Basauri', '', '0', 'Problemas de pago', '0', '2017-05-04 17:42:24'),
	(18, 'Ziortza', 'Mtez. Arrieta', 'Basauri', '', '0', 'Operación Basura, ofertas', '0', '2017-05-04 17:42:24'),
	(19, 'M.P', 'Uriarte', 'Bermeo', '', '0', '', '0', '2017-05-04 17:42:24'),
	(20, 'Estibaliz', 'Arroyo Martín', 'Bilbao', '', '0', 'Centro de estética, ha bajado mucho.', '0', '2017-05-04 17:42:24'),
	(21, 'Egoitz', 'Eguiluz', 'Bilbao-Santutxu', '', '0', 'Tienen 2 Nectar', '0', '2017-05-04 17:42:24'),
	(22, 'Amaia Etbebarria', 'Etxebarria', 'Bilbao-Casco Viejo', '', '0', '', '1', '2017-05-04 17:42:24'),
	(23, 'Isabel (Artemisa)', 'Lecanda', 'Bilbao', '', '0', 'Ahora esta su hijo Nline', '0', '2017-05-04 17:42:24'),
	(24, 'Blanqui', 'Sanz', 'Bilbao-Concha', '', '0', '', '0', '2017-05-04 17:42:24'),
	(25, 'Nerea', 'Vallina Castro', 'Bilbao-San Ignacio', '', '0', '', '0', '2017-05-04 17:42:24'),
	(26, 'Marta', 'Velasco Montero', 'Bilbao-Otxarkoaga', '', '0', 'Los padres son clientes de manuel.', '0', '2017-05-04 17:42:24'),
	(27, 'Txema', 'Mairena Perez', 'Elorrio', '', '0', 'Pasa consulta Myrian Sarasua', '0', '2017-05-04 17:42:24'),
	(28, 'Leire', 'Otadui Arteaga', 'Elorrio', '', '0', '', '0', '2017-05-04 17:42:24'),
	(29, 'Cristina', 'Garcia Perez', 'Ermua', '', '0', 'Es dietista.', '0', '2017-05-04 17:42:24'),
	(30, 'Raul', 'de Francisco', 'Galdacano', '', '0', '', '0', '2017-05-04 17:42:24'),
	(31, 'Amaia', 'Sanchez Valdelvira', 'Gernika', '', '0', '', '0', '2017-05-04 17:42:24'),
	(32, 'Rosario', 'Fernandez Vidal', 'Leioa', '', '0', 'No quiere saber de nosotros.', '0', '2017-05-04 17:42:24'),
	(33, 'Yolanda', 'Gayo Martín', 'Leioa', '', '0', '', '0', '2017-05-04 17:42:24'),
	(34, 'Sofia', 'Valle Rodriguez', 'Balmaseda', '', '0', '', '0', '2017-05-04 17:42:24'),
	(35, 'Arantza', 'Larrazabal', 'Bilbao-Zorroza', '', '0', 'Pasa consulta Amaia Etxebarria', '0', '2017-05-04 17:42:24'),
	(36, 'M.J. Fraile', 'Fraile', 'Getxo-Algorta', '', '0', 'empleada `por las mañanas', '0', '2017-05-04 17:42:24'),
	(37, 'Ainara', 'Berridi', 'Bilbao', '', '0', 'Consulta en Bermeo, Santurce, Eguia', '1', '2017-05-04 17:42:24'),
	(38, 'Gral Eguia, 1', '', 'Bilbao', '', '0', '', '0', '2017-05-04 17:42:24'),
	(39, 'MªAsun', '', 'Bilbao.Sabino Arana', '', '0', 'Antiguo Ventana Natural', '0', '2017-05-04 17:42:24'),
	(40, 'Herb. San Amaro', '', 'Burgos', '', '0', '', '0', '2017-05-04 17:42:24'),
	(41, 'Leticia', 'Perez Vicario', 'Burgos', '', '0', 'Centro de Fisio, a partir 18:00 Nutergia', '0', '2017-05-04 17:42:24'),
	(42, 'Aure', 'Garcia Tome', 'Burgos', '', '0', 'es la mujer de Julio', '0', '2017-05-04 17:42:24'),
	(43, 'Julio', 'Fernandez', 'Burgos', '', '0', '', '0', '2017-05-04 17:42:24'),
	(44, 'Jesus Maria', 'Alonso', 'Burgos', '', '0', 'Operaciones recogida.', '0', '2017-05-04 17:42:24'),
	(45, 'Muba Terapias', '', 'Salamanca', '', '0', 'Joaquin y Joaquina', '1', '2017-05-04 17:42:24'),
	(46, 'Mª Luz', '', 'Salamanca', '', '0', 'NaturDiez', '0', '2017-05-04 17:42:24'),
	(47, 'Miguel', '', 'Valladolid', '', '0', 'quiere trabajar Acción Naturista', '0', '2017-05-04 17:42:24'),
	(48, 'Diez-Perez', '', 'Zamora', '', '0', '', '0', '2017-05-04 17:42:24'),
	(49, 'La Nueva Tierra', 'Dana', 'Munguia', '', '0', 'Curación Chamanica', '0', '2017-05-04 17:42:24'),
	(50, 'Bioleta Munduan', '', 'Munguia', '', '0', 'Tambien tienen centro en Zorroza mt y Ju, Zuriñeen Munguia', '0', '2017-05-04 17:42:24'),
	(51, 'Mariam', '', 'Plencia', '', '0', 'Marina y Daniel Peciña', '0', '2017-05-04 17:42:24'),
	(52, 'Ruth', 'Dominguez', 'Bilbao-Miribilla', '', '0', 'Centro Estetico', '0', '2017-05-04 17:42:24'),
	(53, 'Llanten', '', 'Bilbao-Santutxu', '', '0', 'Tiene poco genero, pensar como entrar. Ofertas', '0', '2017-05-04 17:42:24'),
	(54, 'Hnas. Saez', '', 'Portugalete', '', '0', 'Pasan Bastante', '0', '2017-05-04 17:42:24'),
	(55, 'Omago', 'Ana, Bego, Ander', 'Gernika', '', '0', 'Pocoas posibilidades insistir', '0', '2017-05-04 17:42:24'),
	(56, 'Mikel Arantzegi', '', 'Bilbao-Casco V.', '', '0', 'Osteopata, Kinesologo. Su hermana médico en Tolosa', '1', '2017-05-04 17:42:24'),
	(57, 'Jose Alberto', '', 'Ermua', '', '0', 'Es un fisio. Aceite Almendras, Cartipol', '0', '2017-05-04 17:42:24'),
	(58, 'Mercedes Duran', '', 'Vitoria', '', '0', 'Dietista con centro Nutratek', '0', '2017-05-04 17:42:24'),
	(59, 'Tierra Viva', '', 'Vitoria', '', '0', 'Alimentación Ecológica. Visitar a los dueños en Bilbao.', '0', '2017-05-04 17:42:24'),
	(60, 'Moieses sarasua. Centro sarasua', '', 'Vitoria', '', '0', '', '0', '2017-05-04 17:42:24'),
	(61, 'Monica Vidal Vip Spa', '', 'Vitoria', '', '0', 'Es un centro de Belleza', '0', '2017-05-04 17:42:24'),
	(62, 'Marina Guerrero', '', 'Vitoria', '', '0', '', '0', '2017-05-04 17:42:24'),
	(63, 'Silvia', '', 'Vitoria', '', '0', 'Centro a la vuelta de C Rioja', '0', '2017-05-04 17:42:24'),
	(64, 'Centro Luz Amazonas', 'Pilar (terapeuta) Petra (dep)', 'Valladolid', '', '983257762', '. Llamar primero para quedar con Pilar', '0', '2017-05-04 17:42:24'),
	(65, 'Coop l77 coop v', 'Irene', 'Valladolid', '', '983046150', 'Tinen 3 tiendas, compran en Alicante.', '0', '2017-05-04 17:42:24'),
	(66, 'Herbolario Dharma', '', 'Palencia', '', '0', '', '0', '2017-05-04 17:42:24'),
	(67, 'Gustavo Echeveste', '', 'Palencia', '', '0', '', '0', '2017-05-04 17:42:24'),
	(68, 'Avd. San Telmo', '', 'Palencia.', '', '0', '', '0', '2017-05-04 17:42:24'),
	(69, 'Herbolario CID', '', 'Palencia', '', '0', 'Todo NovaDiet', '0', '2017-05-04 17:42:24'),
	(70, 'cFlorida Blanca', '', 'Palencia.', '', '0', '', '0', '2017-05-04 17:42:24'),
	(71, 'Marivi Salas', '', 'Bilbao', '', '0', 'Pasa consulta en cGral. Concha', '1', '2017-05-04 17:42:24'),
	(72, 'Herbolario Trenti', '', 'Reinosa', '', '0', 'Consulta NovaLine', '0', '2017-05-04 17:42:24'),
	(73, 'Sara Argueso', '', 'Reinosa', '', '0', '', '1', '2017-05-04 17:42:24'),
	(74, 'Mariano Cobo', '', 'Castro Urdiales', '', '0', 'Pasa consulta en castro y Santoña. Cursos en Amorebieta.', '1', '2017-05-04 17:42:24'),
	(75, 'MariFe', 'Menendez', 'Bilbao Los Fueros', '', '0', '', '0', '2017-05-04 17:42:24'),
	(76, 'Javier', 'Cobo Pinto', 'Castro Urdiales', '', '0', 'Bien situado, su hermano terapeuta', '0', '2017-05-04 17:42:24'),
	(77, 'Aida', 'Angel Gutierrez', 'Portugalete Repelega', '', '0', 'Pasa consulta Daniel Peciña', '0', '2017-05-04 17:42:24'),
	(78, 'Iciar', '', 'Portugalete Repelega', '', '0', 'Pasa consulta Raul de galdacano', '0', '2017-05-04 17:42:24'),
	(79, 'Juan Miguel', 'Peña', 'Santurce', '', '0', '', '0', '2017-05-04 17:42:24'),
	(80, 'Elena', 'Jorrin', 'Bilbao Casco Viejo', '', '0', 'Dietista. Acción Naturista', '1', '2017-05-04 17:42:24'),
	(81, 'Centro Medico Biona', '', 'Bilbao Casco Viejo', '', '0', '', '1', '2017-05-04 17:42:24'),
	(82, 'Santoña (Mariam)', 'Eco-Salud', 'Santoña', '', '0', 'es un centro de Prodibios. Hablar con Rafael 942585615', '0', '2017-05-04 17:42:24'),
	(83, 'Belen Cobo', '', 'Solares', '', '0', 'Se va a quedar con el centro. Miercoles mercadillo. Buscarle un dietista.', '0', '2017-05-04 17:42:24'),
	(84, 'Ana (natural-mente)', 'Laredo', 'Laredo', '', '0', 'Muy maja posibilidades', '0', '2017-05-04 17:42:24'),
	(85, 'EMEICJAC Raquel', '', 'Laredo', '', '0', 'Tiene mas centros en Santander. cPerines, 14. 942372027', '0', '2017-05-04 17:42:24'),
	(86, 'Pili- Naturalia', '', 'Algorta', '', '0', 'Tiene nuestros productos en el escaparate.', '0', '2017-05-04 17:42:24'),
	(87, 'Rafaela Mardaras', '', 'Santander', '', '0', 'Es prescriptora y tiene varios centros.', '1', '2017-05-04 17:42:24'),
	(88, 'Javier Cobo', '', 'Castro Urdiales', '', '0', 'Es el hermano del Naturopata', '0', '2017-05-04 17:42:24'),
	(89, 'Angel Fernandez', '', 'Lekeitio', '', '0', '', '0', '2017-05-04 17:42:24'),
	(90, 'Iratxe', '', 'Llodio', '', '0', '', '0', '2017-05-04 17:42:24'),
	(91, 'Jesus Mames', 'Mames', 'Bilbao San Ignacio', '', '0', 'Hay que buscarle algo', '1', '2017-05-04 17:42:24'),
	(92, 'David …', '', 'Bilbao San Ignacio', '', '0', '', '0', '2017-05-04 17:42:24'),
	(93, 'Miriam Sarasua', '', 'Vitoria', '', '676323138', 'Médico. Vitoria, Elorrio', '1', '2017-05-04 17:42:24'),
	(94, 'Centro Zenith', '', 'Bilbao-Indautxu', '', '0', 'Muchas terapias.', '0', '2017-05-04 17:42:24'),
	(95, 'Lorena', '', 'bilbao-Indautxu', '', '0', 'Terapeuta centro Zenith', '1', '2017-05-04 17:42:24'),
	(96, 'Rafaela Mardaras.La Salud', '', 'Santander', '', '0', 'Tiene Varios centros.Hijo Jose federico.', '0', '2017-05-04 17:42:24'),
	(97, 'Marivi Salas', '', 'Gallarta', '', '0', 'Biomar, Los Corrales, Baracaldo.', '1', '2017-05-04 17:42:24'),
	(98, 'Amparo', '"Sol"', 'Basauri', '', '0', 'Le he pasado todas las ofertas', '0', '2017-05-04 17:42:24'),
	(99, 'Itziar', 'Centro Dalud Armonia', 'Basauri', '', '0', 'Pasa consulta cerca de Sol', '1', '2017-05-04 17:42:24'),
	(100, 'Agurtzane', 'De Llodio', '', '', '60937003', 'Pasando consulta en llodio y Basauri, buscandose la vida', '1', '2017-05-04 17:42:24'),
	(101, 'Santiveri', 'Alicia, Gerardo', 'Arrigorriaga', '', '0', 'Insistir', '0', '2017-05-04 17:42:24'),
	(102, 'Raquel', '', 'Arrigorriaga', '', '0', 'bañadores y dietetica', '0', '2017-05-04 17:42:24'),
	(103, 'Javier Davalillo', '', 'Bilbao', '', '0', 'Medico. Muy serio, complicado entrar', '1', '2017-05-04 17:42:24'),
	(104, 'Jose María Beldarrain', '', 'Sopelana', '', '0', 'pasa consulta en el centro de su hija', '1', '2017-05-04 17:42:24'),
	(105, 'Txema Urtiaga', '', '', '', '0', '', '1', '2017-05-04 17:42:24'),
	(107, 'Muñoz (Lorena)', '', 'Vitoria', '', '0', 'Pasa consulta Txema Urtiaga.', '0', '2017-05-04 17:42:24'),
	(108, 'Herboristeria Goya', '', 'Baracaldo', '', '0', 'Miercoles tarde no, pasar a ultima hora', '0', '2017-05-04 17:42:24'),
	(109, 'Maribel cArrandi', '', 'Baracaldo', '', '0', 'Maribel a ultimas horas', '0', '2017-05-04 17:42:24'),
	(110, 'Lola', '', 'Galdacano', '', '0', '', '0', '2017-05-04 17:42:24'),
	(111, 'Javier Baños', '', 'Durango', '', '0', '', '0', '2017-05-04 17:42:24'),
	(112, 'Amaia Zalba', '', 'Durango', '', '0', 'Ella es dietista pasa consulta. Consulta Peciña', '0', '2017-05-04 17:42:24'),
	(113, 'Naturalia-Pilar', 'Castro', 'Getxo-Algorta', '', '0', 'Tiene alguna cosa nuestra', '0', '2017-05-04 17:42:24'),
	(114, 'Beatriz', 'Jauregui', 'Getxo-Algorta', '', '0', '', '0', '2017-05-04 17:42:24'),
	(115, 'Chusla', '', 'Getxo-Algorta', '', '0', '', '0', '2017-05-04 17:42:24'),
	(116, 'Beatriz csarrikobaso', 'Villanueva', 'Getxo-Algorta', '', '0', '', '0', '2017-05-04 17:42:24'),
	(117, 'Jose Antonio', '', 'Valladolid', '', '0', '', '0', '2017-05-04 17:42:24'),
	(118, 'Javi- La Salud', '', 'Cabezon de la Sal', '', '0', '', '0', '2017-05-04 17:42:24'),
	(119, 'Lucia (china)', '', 'Bilbao-Areilza', '', '0', 'lista de precios. Exportar', '0', '2017-05-04 17:42:24'),
	(120, 'Zulema', '', 'Pielagos', '', '0', 'Poner dietista', '0', '2017-05-04 17:42:24'),
	(121, 'Zulema', '', 'Renedo (Cantabria)', '', '0', 'centro nuevo, meter Peso', '0', '2017-05-04 17:42:24'),
	(122, 'Luis-kinga', 'Te gusta cuidarte', '', '', '0', 'insistir en productos, referenciado en Salamanca.', '1', '2017-05-04 17:42:24'),
	(123, 'Karen Jorge', '', 'Vitoria', '', '0', 'Pasa consulta como dietista en una farmacia, trabaja en ella a jornada completa.', '1', '2017-05-04 17:42:24'),
	(124, 'Biomafer', '', 'Miranda de Ebro', '', '0', '', '0', '2017-05-04 17:42:24'),
	(125, 'Jose Antonio-Medicatrix', '', 'Valladolid', '', '0', '', '0', '2017-05-04 17:42:24'),
	(126, 'Ainhoa', '', 'Lekeitio', '', '0', 'es una parafarmacia', '0', '2017-05-04 17:42:24'),
	(127, 'Conchi Fdez Abad', '', 'Santurce', '', '0', 'medico', '1', '2017-05-04 17:42:24'),
	(128, 'Amaia', '', 'Leioa', '', '0', 'pasa consulta: Villarcayo, Leioa, Bilbao, Amorebieta', '1', '2017-05-04 17:42:24'),
	(129, 'Nuali', '', 'Santander', '', '0', 'Centro con venta y prescripcion.', '1', '2017-05-04 17:42:24'),
	(130, 'Maria Isabel', 'Mabel', 'Laredo', '', '0', 'Ha cogido el centro de Ana(debajo de casa)', '0', '2017-05-04 17:42:24'),
	(131, 'María del carmen', '', 'Castro Urdiales', '', '0', 'en Ardigales, tiene cosas de Plantapol.', '0', '2017-05-04 17:42:24'),
	(132, 'Herboristeria Kala', 'Iñaki', 'Baracaldo-Cruces', '', '0', 'Costara, compra todo a Bedar', '0', '2017-05-04 17:42:24'),
	(133, 'Herboristeria Villahoz', 'Rosario (Charo)', 'Baracaldo-Cruces', '', '0', 'Hay que machacar. Dietisa', '0', '2017-05-04 17:42:24'),
	(134, 'Luis Rodero', '', 'Santander', '', '0', 'Terapeuta, dar la brasa', '1', '2017-05-04 17:42:24');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;

-- Volcando estructura para tabla comercial.factura
CREATE TABLE IF NOT EXISTS `factura` (
  `idFactura` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `FK2223DF588D49334E` (`idCliente`),
  CONSTRAINT `FK2223DF588D49334E` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla comercial.factura: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` (`idFactura`, `idCliente`) VALUES
	(1, 1),
	(2, 3),
	(3, 3);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;

-- Volcando estructura para tabla comercial.lineafactura
CREATE TABLE IF NOT EXISTS `lineafactura` (
  `numLinea` int(11) NOT NULL,
  `numProducto` int(11) NOT NULL,
  `idFactura` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  PRIMARY KEY (`numLinea`,`idFactura`),
  KEY `FK4F8EAFEB37EA66A6` (`idProducto`),
  KEY `FK4F8EAFEBA488B64A` (`idFactura`),
  CONSTRAINT `FK4F8EAFEB37EA66A6` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`),
  CONSTRAINT `FK4F8EAFEBA488B64A` FOREIGN KEY (`idFactura`) REFERENCES `factura` (`idFactura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla comercial.lineafactura: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `lineafactura` DISABLE KEYS */;
INSERT INTO `lineafactura` (`numLinea`, `numProducto`, `idFactura`, `idProducto`) VALUES
	(1, 2, 1, 1),
	(2, 14, 1, 1),
	(3, 33, 2, 3),
	(4, 44, 2, 3),
	(5, 55, 2, 3);
/*!40000 ALTER TABLE `lineafactura` ENABLE KEYS */;

-- Volcando estructura para tabla comercial.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCliente` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla comercial.producto: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`idProducto`, `nombreCliente`) VALUES
	(1, 'pan'),
	(2, 'leche'),
	(3, 'pan'),
	(4, 'leche'),
	(5, 'pan'),
	(6, 'leche');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

-- Volcando estructura para tabla comercial.propiedades
CREATE TABLE IF NOT EXISTS `propiedades` (
  `idPropiedad` int(11) NOT NULL AUTO_INCREMENT,
  `propiedad` varchar(50) NOT NULL,
  `entidad` varchar(50) NOT NULL,
  PRIMARY KEY (`idPropiedad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla comercial.propiedades: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `propiedades` DISABLE KEYS */;
INSERT INTO `propiedades` (`idPropiedad`, `propiedad`, `entidad`) VALUES
	(1, 'muestras', 'visita'),
	(2, 'presentado', 'visita');
/*!40000 ALTER TABLE `propiedades` ENABLE KEYS */;

-- Volcando estructura para tabla comercial.publisher
CREATE TABLE IF NOT EXISTS `publisher` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla comercial.publisher: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
INSERT INTO `publisher` (`id`, `name`) VALUES
	(22, 'Publisher A'),
	(23, 'Publisher B');
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;

-- Volcando estructura para tabla comercial.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `lastAccess` date DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `lastAccess` (`lastAccess`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla comercial.user: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Volcando estructura para tabla comercial.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `lastAccess` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla comercial.users: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `password`, `mail`, `name`, `lastAccess`) VALUES
	(1, 'inigo', 'fernandezarce@gmail.com', 'inigo', '2018-09-09 10:52:43');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Volcando estructura para tabla comercial.visitas
CREATE TABLE IF NOT EXISTS `visitas` (
  `idVisita` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) NOT NULL DEFAULT '0',
  `descripcion` varchar(200) DEFAULT '0',
  `fecha` datetime DEFAULT NULL,
  `fechaProxima` datetime DEFAULT NULL,
  `compra` char(1) DEFAULT '0',
  PRIMARY KEY (`idVisita`),
  KEY `FK1BD232BD5B2A1D3E` (`idCliente`),
  CONSTRAINT `FK1BD232BD5B2A1D3E` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla comercial.visitas: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `visitas` DISABLE KEYS */;
INSERT INTO `visitas` (`idVisita`, `idCliente`, `descripcion`, `fecha`, `fechaProxima`, `compra`) VALUES
	(8, 27, ' modificada VIERNES MODIFICADA', '2017-05-09 00:00:00', '2017-05-09 00:00:00', '1'),
	(9, 2, 'descripcion de la visita', '2017-05-09 20:57:55', '2017-05-09 23:44:35', '1'),
	(10, 13, 'descripcion de la visita', '2017-05-10 11:16:30', '2017-05-10 14:03:10', '1'),
	(11, 6, 'descripcion de la visita', '2017-05-10 11:30:00', '2017-05-10 14:16:00', '1'),
	(12, 1, 'descripcion de la visita', '2017-05-10 13:41:56', '2017-05-10 16:28:36', '1'),
	(13, 18, 'Esto es una descripcion maravillosa.', '2017-05-16 11:29:00', '2017-05-25 00:00:00', NULL),
	(14, 4, 'des de beñat', '2017-05-16 00:00:00', '2017-05-23 00:00:00', NULL),
	(15, 4, 'fasdfas', '2017-05-03 00:00:00', '2017-05-02 00:00:00', NULL),
	(16, 5, 'descripcion de la visita', '2017-05-18 14:00:00', '2017-05-25 16:00:00', NULL),
	(17, 1, 'Descrip nuevo', '2017-05-05 00:00:00', '2017-05-06 00:00:00', NULL),
	(18, 134, NULL, NULL, NULL, NULL),
	(19, 3, 'Descripcion de la visita de  Daniel', '2018-10-14 00:00:00', '2018-10-21 00:00:00', '0'),
	(20, 10, 'Estoez la ded', '2018-10-17 00:00:00', '2018-10-23 00:00:00', '0');
/*!40000 ALTER TABLE `visitas` ENABLE KEYS */;

-- Volcando estructura para tabla comercial.visitas_propiedades
CREATE TABLE IF NOT EXISTS `visitas_propiedades` (
  `idVisita` int(11) NOT NULL,
  `idPropiedad` int(11) NOT NULL,
  `orden` int(11) NOT NULL,
  `valor` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idVisita`,`idPropiedad`,`orden`),
  KEY `FK87284394B8217B63` (`idPropiedad`),
  KEY `FK872843941D30C15B` (`idVisita`),
  CONSTRAINT `FK872843941D30C15B` FOREIGN KEY (`idVisita`) REFERENCES `visitas` (`idVisita`),
  CONSTRAINT `FK87284394B8217B63` FOREIGN KEY (`idPropiedad`) REFERENCES `propiedades` (`idPropiedad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla comercial.visitas_propiedades: ~31 rows (aproximadamente)
/*!40000 ALTER TABLE `visitas_propiedades` DISABLE KEYS */;
INSERT INTO `visitas_propiedades` (`idVisita`, `idPropiedad`, `orden`, `valor`) VALUES
	(9, 1, 1, 'muestra_1'),
	(9, 1, 2, 'muestra_2'),
	(9, 2, 1, 'producto_1'),
	(9, 2, 2, 'producto_2'),
	(10, 1, 1, 'muestra_1'),
	(10, 1, 2, 'muestra_2'),
	(10, 2, 1, 'producto_1'),
	(10, 2, 2, 'producto_2'),
	(12, 1, 1, 'muestra_1'),
	(12, 1, 2, 'muestra_2'),
	(12, 2, 1, 'producto_1'),
	(12, 2, 2, 'producto_2'),
	(13, 1, 1, 'muestra 1'),
	(13, 1, 2, 'otra muestra'),
	(13, 2, 1, 'Producto 1'),
	(13, 2, 2, 'Producto 2'),
	(14, 1, 1, 'm1'),
	(14, 2, 1, 'p1'),
	(15, 1, 1, 'aa'),
	(15, 2, 1, 'ddd'),
	(17, 1, 1, 'm11'),
	(17, 2, 1, 'p11'),
	(19, 1, 1, 'muestra 1'),
	(19, 1, 2, 'muestra 2'),
	(19, 1, 3, 'muestra 3'),
	(19, 2, 1, 'presentado 1'),
	(19, 2, 2, 'presentado2'),
	(20, 1, 1, 'Tens'),
	(20, 1, 2, 'Otro as'),
	(20, 2, 1, 'Gr23'),
	(20, 2, 2, 'Ut 25');
/*!40000 ALTER TABLE `visitas_propiedades` ENABLE KEYS */;

-- Volcando estructura para tabla comercial.visitas_visitas_propiedades
CREATE TABLE IF NOT EXISTS `visitas_visitas_propiedades` (
  `visitas_idVisita` int(11) NOT NULL,
  `propiedadesVisita_idPropiedad` int(11) NOT NULL,
  `propiedadesVisita_idVisita` int(11) NOT NULL,
  `propiedadesVisita_orden` int(11) NOT NULL,
  PRIMARY KEY (`visitas_idVisita`,`propiedadesVisita_idPropiedad`,`propiedadesVisita_idVisita`,`propiedadesVisita_orden`),
  UNIQUE KEY `propiedadesVisita_idPropiedad` (`propiedadesVisita_idPropiedad`,`propiedadesVisita_idVisita`,`propiedadesVisita_orden`),
  KEY `FKA7E94312E554849D` (`visitas_idVisita`),
  KEY `FKA7E94312D4446474` (`propiedadesVisita_idPropiedad`,`propiedadesVisita_idVisita`,`propiedadesVisita_orden`),
  CONSTRAINT `FKA7E94312D4446474` FOREIGN KEY (`propiedadesVisita_idPropiedad`, `propiedadesVisita_idVisita`, `propiedadesVisita_orden`) REFERENCES `visitas_propiedades` (`idPropiedad`, `idVisita`, `orden`),
  CONSTRAINT `FKA7E94312E554849D` FOREIGN KEY (`visitas_idVisita`) REFERENCES `visitas` (`idVisita`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla comercial.visitas_visitas_propiedades: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `visitas_visitas_propiedades` DISABLE KEYS */;
/*!40000 ALTER TABLE `visitas_visitas_propiedades` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
