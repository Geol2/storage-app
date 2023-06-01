DROP TABLE IF EXISTS member;

CREATE TABLE member (
  `user_id` varchar(10) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`user_id`)
);