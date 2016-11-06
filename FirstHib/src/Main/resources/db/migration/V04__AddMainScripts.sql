ALTER TABLE event CHANGE id id BIGINT AUTO_INCREMENT;
INSERT INTO Event (date, discriptionEvent)
VALUES (NULL, 'The Empire strikes back' );
INSERT INTO Event (date, discriptionEvent)
VALUES (sysdate(), 'The Phantom Menace');
INSERT INTO Event (date, discriptionEvent)
VALUES (sysdate(), 'Why so series?');

ALTER TABLE Tag CHANGE id id BIGINT AUTO_INCREMENT;
INSERT INTO Tag (tagName)
VALUE ('Star Wars');
INSERT INTO Tag (tagName)
VALUE ('Dark Knight');

ALTER TABLE User CHANGE id id BIGINT AUTO_INCREMENT;
INSERT INTO User (Age, Person)
VALUES (NULL, 'Hulk');
INSERT INTO User (Age, Person)
VALUES (NULL, 'Iron man');