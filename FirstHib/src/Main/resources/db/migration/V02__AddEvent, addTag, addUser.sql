CREATE TABLE `event` (
  `id` bigint(20) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `discriptionEvent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `tag` (
  `id` bigint(20) NOT NULL,
  `tagName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
 ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `AGE` int(11) DEFAULT NULL,
  `PERSON` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
 ENGINE=InnoDB DEFAULT CHARSET=latin1;