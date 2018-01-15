CREATE  TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(50) NOT NULL,
  CONSTRAINT uc_user_name UNIQUE (user_name),
  PRIMARY KEY (id));
