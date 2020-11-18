INSERT INTO users (first_name, last_name, email)
VALUES ('Jan', 'Kowalski', 'jan@kowalski.pl'),
       ('Bob', 'Budowniczy', 'bob@budowniczy.pl');

INSERT INTO tasks (name, date_to_finish, time_to_finish, user_id)
VALUES ( 'umyć okna', '2020-12-20', '12:00', 1 ),
       ('upiec ciasto', '2020-12-23', '21:00', 1),
       ('umyć samochód', '2020-12-23', '20:00', 2);
