/**
 * 用户权限表
 */
DROP TABLE IF EXISTS `users`;
create table `users`(
 `id` bigint(20) NOT NULL primary key,
 `username` varchar(50) not null ,
 `password` varchar(50) not null,
`enabled` tinyint(1) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;;

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `id` bigint(20)  NOT NULL AUTO_INCREMENT,
  `users_id` bigint(20) NOT NULL,
  `authority` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
 constraint fk_authorities_users foreign key(users_id) references users(id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

create unique index ix_auth_userid on `authorities` (`users_id`,`authority`);

INSERT INTO users VALUES ('1', 'admin', '123456', '1');
INSERT INTO users VALUES ('2', 'teacher', '123456', '1');
INSERT INTO users VALUES ('3', 'student', '123456', '1');

INSERT INTO authorities VALUES ('1', '1', 'ROLE_Admin');
INSERT INTO authorities VALUES ('2', '2', 'ROLE_Teacher');
INSERT INTO authorities VALUES ('3', '3', 'ROLE_Student');
