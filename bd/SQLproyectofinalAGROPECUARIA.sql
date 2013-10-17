-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 07-10-2013 a las 04:03:29
-- Versión del servidor: 5.5.8
-- Versión de PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `proyectofinal`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo_empleado`
--

CREATE TABLE IF NOT EXISTS `cargo_empleado` (
  `id_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `sueldo` float NOT NULL,
  PRIMARY KEY (`id_cargo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Volcar la base de datos para la tabla `cargo_empleado`
--

INSERT INTO `cargo_empleado` (`id_cargo`, `descripcion`, `sueldo`) VALUES
(1, 'ADMINISTRADOR1', 2000),
(14, 'SECRETARIA', 1000),
(15, 'VENDEDOR', 1200),
(16, 'CONTADOR', 800),
(17, 'BODEGUERO', 1000),
(18, 'GERENTE', 1500.5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE IF NOT EXISTS `ciudad` (
  `id_ciudad` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`id_ciudad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`id_ciudad`, `descripcion`) VALUES
(1, 'Escuintla'),
(2, 'Huehuetenango'),
(3, 'Izabal'),
(4, 'Sacatepequez'),
(5, 'Sololá'),
(6, 'Totonicapán'),
(7, 'Alta Verapaz'),
(8, 'Baja Verapaz'),
(9, 'Chimaltenango'),
(10, 'Chiquimulilla'),
(11, 'El Progreso'),
(12, 'Guatemala'),
(13, 'Jalapa'),
(14, 'Jutiapa'),
(15, 'Petén'),
(16, 'Quetzaltenango'),
(17, 'Quiché'),
(18, 'Retalhuleu'),
(19, 'San Marcos'),
(20, 'Santa Rosa'),
(21, 'Suchitepéquez'),
(22, 'Zacapa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` varchar(7) NOT NULL,
  `nit` varchar(15) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nit`, `nombre`, `direccion`, `telefono`) VALUES
('CL55686', '5128099', 'JULIO MALDONADO', 'GUATEMALA', ''),
('CL56776', '9320303', 'KSKSKD', 'KSDKDK', '2020044'),
('CL58587', '1234567', 'CLIENTE PRUEBA', 'MAZATEPRUEBA', '12345678'),
('CL66565', 'C/F', 'YESENIA MARROQUIN', 'ESCUINTLA', '78384930'),
('CL66658', 'C/F', 'JORGE', 'MAZATE', ''),
('CL67576', 'fasdf', 'asdfasd', 'asdfasd', '123423'),
('CL68768', 'C/F', 'MARIO PEREZ', '', '383920230'),
('CL76557', '68626010', 'ALEX SICAL', 'PATULUL', '30714563'),
('CL76765', 'C/F', 'JULIO MALDONADO', 'MAZATE', '78793932'),
('CL76878', '7654321', 'otro cliente', 'saber', '12345678'),
('CL78587', '123444', 'NUEVOCLIE', 'MAZATE', '99999999'),
('CL78758', '5192933', 'JULIO MALDONADO', 'MAZATE', '34553233'),
('CL85568', '72929393', 'RUDY OCHOA', 'MAZATE', '292003040');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_factura`
--

CREATE TABLE IF NOT EXISTS `detalle_factura` (
  `id_factura` varchar(25) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `total` float NOT NULL,
  UNIQUE KEY `id_producto` (`id_producto`),
  UNIQUE KEY `id_factura` (`id_factura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `detalle_factura`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
  `id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `em_nombre` varchar(50) NOT NULL,
  `em_apellido` varchar(50) NOT NULL,
  `em_direccion` varchar(50) NOT NULL,
  `em_telefono` varchar(20) NOT NULL,
  `em_dpi` int(50) NOT NULL,
  `id_ciudad` int(11) NOT NULL,
  `id_cargo` int(11) DEFAULT NULL,
  `user` varchar(50) NOT NULL,
  `clave` varchar(50) NOT NULL,
  `tipo_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_empleado`),
  KEY `id_cargo` (`id_cargo`),
  KEY `id_ciudad` (`id_ciudad`),
  KEY `tipo_usuario` (`tipo_usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=170 ;

--
-- Volcar la base de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`id_empleado`, `em_nombre`, `em_apellido`, `em_direccion`, `em_telefono`, `em_dpi`, `id_ciudad`, `id_cargo`, `user`, `clave`, `tipo_usuario`) VALUES
(140, 'JULIO', 'MALDONADO', '2DA. AV.0-15 ZONA 1', '41665432', 77777777, 21, 1, 'JULIO', 'MALDONADO', 1),
(141, 'JULIAN', 'MALDONADO', '2DA.AV. 0-15 Z1', '7871-8911', 12345678, 21, 1, 'JMALDONADO', 'ADMIN', 0),
(164, 'RUDY', 'OCHOA', 'PATULUL', '888888888', 88888888, 21, 18, 'ROCHOA', '1234', 0),
(168, 'ELENA', 'DE LA ROCA', '2DA.AV. 0-15 Z1', '7871-8911', 44444444, 21, 14, 'ELENA', 'ADMIN', 3),
(169, 'ALEX', 'SICAL', 'PATULUL', '78718911', 2147483647, 1, 1, 'ALEX', '1234', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE IF NOT EXISTS `factura` (
  `id_factura` varchar(25) NOT NULL,
  `id_cliente` varchar(7) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `tipo_pago` int(11) NOT NULL,
  `fecha_factura` date NOT NULL,
  `iva` float NOT NULL,
  `total_factura` float NOT NULL,
  PRIMARY KEY (`id_factura`),
  UNIQUE KEY `id_empleado` (`id_empleado`),
  UNIQUE KEY `tipo_pago` (`tipo_pago`),
  UNIQUE KEY `id_cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `factura`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca_producto`
--

CREATE TABLE IF NOT EXISTS `marca_producto` (
  `id_marca` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`id_marca`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `marca_producto`
--

INSERT INTO `marca_producto` (`id_marca`, `descripcion`) VALUES
(1, 'PURINA'),
(2, 'PEDRIGREE'),
(3, 'NUTRA NUGGETS'),
(4, 'NUEVO'),
(5, 'OTRO'),
(6, 'SUPER CAN');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nivel_user`
--

CREATE TABLE IF NOT EXISTS `nivel_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `nivel` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `nivel_user`
--

INSERT INTO `nivel_user` (`id`, `descripcion`, `nivel`) VALUES
(1, 'ADMINISTRADOR', 1),
(2, 'VENDEDOR', 2),
(3, 'SECRETARIA', 3),
(4, 'GERENTE', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parametros`
--

CREATE TABLE IF NOT EXISTS `parametros` (
  `iva` float NOT NULL,
  `descuento` int(11) NOT NULL,
  `igss` float NOT NULL,
  `isr` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `parametros`
--

INSERT INTO `parametros` (`iva`, `descuento`, `igss`, `isr`) VALUES
(1.12, 5, 4.83, 0.05);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `id_producto` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `precio_costo` float NOT NULL,
  `precio_venta` float NOT NULL,
  `stock` int(11) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  PRIMARY KEY (`id_producto`),
  UNIQUE KEY `id_proveedor` (`id_proveedor`),
  UNIQUE KEY `id_marca` (`id_marca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `descripcion`, `id_marca`, `id_proveedor`, `precio_costo`, `precio_venta`, `stock`, `fecha_ingreso`) VALUES
(1, 'CONCENTRADO', 4, 1, 4, 6.5, 100, '2013-09-26');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE IF NOT EXISTS `proveedor` (
  `id_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_comercial` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(25) NOT NULL,
  `id_ciudad` int(11) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `nombre_contacto` varchar(100) NOT NULL,
  `telefono_contacto` varchar(25) NOT NULL,
  PRIMARY KEY (`id_proveedor`),
  KEY `id_ciudad` (`id_ciudad`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=149 ;

--
-- Volcar la base de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id_proveedor`, `nombre_comercial`, `direccion`, `telefono`, `id_ciudad`, `correo`, `nombre_contacto`, `telefono_contacto`) VALUES
(1, 'ARECA', 'GUATEMALA', '83930223', 11, 'asical@runtime,com.gt', 'JUAN PEREZ', '2949400302'),
(2, 'MALA PAGA2', 'MAZATE', '99999', 21, '@RAMON.COM', 'DON RAMON', '9999'),
(3, 'PURUNA', 'MAZATE', '8888', 12, '@OK.COM', 'PABLO MARMOL', '99999'),
(9, 'PROVEEDOR10', 'REU', '9928282', 18, '@BUENPAGADOR', 'BUENAPAGA', '7654318'),
(71, 'PROVEEDOR1', 'GUATEMALA', '77777777', 12, '@PROVEEDOR', 'JUAN GUTIERREZ', '88888888'),
(146, 'PROVEEDOR2', 'MAZATENANGO', '88888888', 21, '@PROVEEDOR2', 'PEDRO PICAPIEDRA', '111111'),
(147, 'PROVEEDOR3', 'MAZATE', '11111111', 21, '@PROVEEDOR3', 'REINA LEPE', '2222222'),
(148, 'MOLINO SANTA ANA', 'RUE', '99999', 18, '@CORREO', 'LUIS', '9439494');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_pago`
--

CREATE TABLE IF NOT EXISTS `tipo_pago` (
  `tipo_pago` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`tipo_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `tipo_pago`
--


--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `detalle_factura`
--
ALTER TABLE `detalle_factura`
  ADD CONSTRAINT `detalle_factura_ibfk_1` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id_factura`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`id_ciudad`) REFERENCES `ciudad` (`id_ciudad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `empleado_ibfk_2` FOREIGN KEY (`id_cargo`) REFERENCES `cargo_empleado` (`id_cargo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_5` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_ibfk_6` FOREIGN KEY (`tipo_pago`) REFERENCES `tipo_pago` (`tipo_pago`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_ibfk_7` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`id_marca`) REFERENCES `marca_producto` (`id_marca`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD CONSTRAINT `proveedor_ibfk_1` FOREIGN KEY (`id_ciudad`) REFERENCES `ciudad` (`id_ciudad`) ON DELETE CASCADE ON UPDATE CASCADE;
