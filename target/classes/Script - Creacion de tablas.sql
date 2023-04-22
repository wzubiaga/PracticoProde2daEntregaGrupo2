SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for equipo
-- ----------------------------
CREATE TABLE `equipo` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `nombre` varchar(110) NOT NULL,
  `descripcion` varchar(110) NOT NULL,
   PRIMARY KEY  (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
-- ----------------------------
-- Records
-- ----------------------------
INSERT INTO `equipo` VALUES ('1', 'Argentina', 'Argentina');
INSERT INTO `equipo` VALUES ('2', 'Arabia Saudita', 'Arabia Saudita');
INSERT INTO `equipo` VALUES ('3', 'Polonia', 'Polonia');
INSERT INTO `equipo` VALUES ('4', 'México', 'México');

-- ----------------------------
-- Table structure for torneo
-- ----------------------------
CREATE TABLE `torneo` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `nroRonda` int(10) unsigned NOT NULL,
  `nombreEquipoA` varchar(110) NOT NULL,
  `nombreEquipoB` varchar(110) NOT NULL,
  `nroGolesA` int(10) unsigned NOT NULL,
  `nroGolesB` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
-- ----------------------------
-- Records
-- ----------------------------
INSERT INTO `torneo` VALUES ('1', '1', 'Argentina', 'Arabia Saudita', '1', '2');
INSERT INTO `torneo` VALUES ('2', '1', 'Polonia', 'México', '0', '0');
INSERT INTO `torneo` VALUES ('3', '2', 'Argentina', 'México', '2', '0');
INSERT INTO `torneo` VALUES ('4', '2', 'Arabia Saudita', 'Polonia', '0', '2');

-- ----------------------------
-- Table structure for pronostico
-- ----------------------------
CREATE TABLE `pronostico` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `apellidoYNombreParticipante` varchar(110) NOT NULL,
  `dniParticipante` int(10) unsigned NOT NULL,
  `nombreEquipoA` varchar(110) NOT NULL,
  `ganaA` tinyint(1) default '0',
  `empate` tinyint(1) default '0',
  `ganaB` tinyint(1) default '0',
  `nombreEquipoB` varchar(110) NOT NULL,
   PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
-- ----------------------------
-- Records
-- ----------------------------
INSERT INTO `pronostico` VALUES ('1', 'Mariana', '23898243', 'Argentina', '1', '0', '0', 'Arabia Saudita');
INSERT INTO `pronostico` VALUES ('2', 'Mariana', '23898243', 'Polonia', '0', '1', '0', 'México');
INSERT INTO `pronostico` VALUES ('3', 'Mariana', '23898243', 'Argentina', '1', '0', '0', 'México');
INSERT INTO `pronostico` VALUES ('4', 'Mariana', '23898243', 'Arabia Saudita', '0', '0', '1', 'Polonia');
INSERT INTO `pronostico` VALUES ('5', 'Pedro', '4434538', 'Argentina', '1', '0', '0', 'Arabia Saudita');
INSERT INTO `pronostico` VALUES ('6', 'Pedro', '4434538', 'Polonia', '0', '0', '1', 'México');
INSERT INTO `pronostico` VALUES ('7', 'Pedro', '4434538', 'Argentina', '1', '0', '0', 'México');
INSERT INTO `pronostico` VALUES ('8', 'Pedro', '4434538', 'Arabia Saudita', '0', '1', '0', 'Polonia');