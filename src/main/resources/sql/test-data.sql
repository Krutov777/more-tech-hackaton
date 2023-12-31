delete from atm;
insert into atm(
    id, address, all_day, distance, latitude, longitude, metro_station
) values
(1, 'ул. Богородский Вал, д. 6, корп. 1', true, 750, 59.56, 30.1850, 'м. Московская'),
(2, 'ул. Кастанаевская, д. 25, корп. 1', true, 200, 60, 30.5, 'м. Московская'),
(3, 'ул. Богородский Вал, д. 6, корп. 1', true, 750, 58, 31.2003, 'м. Московская'),
(4, 'ул. Богородский Вал, д. 6, корп. 1', true, 750, 53.234934, 60, 'м. Московская'),
(5, 'ул. Богородский Вал, д. 6, корп. 1', true, 750, 61, 40, 'м. Московская'),
(6, 'ул. Богородский Вал, д. 6, корп. 1', true, 750, 62.234934, 70.2003, 'м. Московская');

delete from service;
insert into service(
    id, name
) values
    (1, 'Снять наличные'),
    (2, 'Пополнить счет'),
    (3, 'Вклад'),
    (4, 'Кредит'),
    (5, 'Ипотека');

delete from service_atm;
insert into service_atm(
    atm_id, service_id, service_activity, service_capacity
) values
      (1, 1, 'AVAILABLE', 'SUPPORTED'),
      (1, 2, 'AVAILABLE', 'SUPPORTED'),
      (2, 1, 'UNAVAILABLE', 'SUPPORTED'),
      (2, 2, 'AVAILABLE', 'UNAVAILABLE'),
      (3, 1, 'AVAILABLE', 'UNAVAILABLE'),
      (3, 2, 'AVAILABLE', 'UNAVAILABLE');

delete from department;
insert into department(
    id, address, department_type, distance, has_ramp,
    latitude, longitude, metro_station, rko, sale_point_format,
    sale_point_name, status, suo_availability, department_type_id
) values
      (1, 'ул. Богородский Вал, д. 6, корп. 1', 'DEPTYPE', 1000, true, 59.56, 30.1850, 'м. Московская', 'RKO1', 'Корпоративный', 'Имя', 'AVAILABLE', true, 1),
      (2, 'ул. Богородский Вал, д. 6, корп. 1', 'DEPTYPE', 1000, true, 60, 30.5, 'м. Московская', 'RKO1', 'Корпоративный', 'Имя', 'AVAILABLE', true, 2),
      (3, 'ул. Богородский Вал, д. 6, корп. 1', 'DEPTYPE', 1000, true, 58, 31.2003, 'м. Московская', 'RKO1', 'Корпоративный', 'Имя', 'AVAILABLE', true, 3),
      (4, 'ул. Богородский Вал, д. 6, корп. 1', 'DEPTYPE', 1000, true, 53.234934, 60, 'м. Московская', 'RKO1', 'Корпоративный', 'Имя', 'AVAILABLE', true, 3),
      (5, 'ул. Богородский Вал, д. 6, корп. 1', 'DEPTYPE', 1000, true, 61, 40, 'м. Московская', 'RKO1', 'Корпоративный', 'Имя', 'AVAILABLE', true, 3),
      (6, 'ул. Богородский Вал, д. 6, корп. 1', 'DEPTYPE', 1000, true, 62.234934, 70.2003, 'м. Московская', 'RKO1', 'Корпоративный', 'Имя', 'AVAILABLE', true, 3),
      (7, 'ул. Богородский Вал, д. 6, корп. 1', 'DEPTYPE', 1000, true, 57, 56, 'м. Московская', 'RKO1', 'Корпоративный', 'Имя', 'AVAILABLE', true, 3),
      (8, 'ул. Богородский Вал, д. 6, корп. 1', 'DEPTYPE', 1000, true, 58, 35.2, 'м. Московская', 'RKO1', 'Корпоративный', 'Имя', 'AVAILABLE', true, 3);


delete from service_department;
insert into service_department(
    department_id, service_id
) values
      (1, 1), (1, 2), (1, 3), (1, 4), (1, 5),
      (2, 1), (2, 2), (2, 3), (2, 4), (2, 5),
      (3, 1), (3, 2), (3, 3), (3, 4), (3, 5),
      (4, 1), (4, 2), (4, 3), (4, 4), (4, 5),
      (5, 1), (5, 2), (5, 3), (5, 4), (5, 5);


delete from client_type;
insert into client_type(
    id, name
) values
    (1, 'Малый бизнес'),
    (2, 'Средний бизнес'),
    (3, 'ВИП'),
    (4, 'Обычный клиент');

delete from client_type_department;
insert into client_type_department(
    department_id, client_type_id
) values
      (1, 1),
      (1, 2),
      (2, 2),
	  (3, 3),
	  (3, 4);

delete from open_hours;
insert into open_hours(
	day, start_time, end_time, type_work, department_id
) values
	('MONDAY', '09:00:00', '18:00:00', 'INDIVIDUAL', 1),
	('TUESDAY', '09:00:00', '18:00:00', 'INDIVIDUAL', 1),
	('WEDNESDAY', '09:00:00', '18:00:00', 'INDIVIDUAL', 1),
	('THURSDAY', '09:00:00', '18:00:00', 'INDIVIDUAL', 1),
	('FRIDAY', '09:00:00', '18:00:00', 'INDIVIDUAL', 1),
	('SATURDAY', '09:00:00', '18:00:00', 'INDIVIDUAL', 1),
	('SUNDAY', '09:00:00', '18:00:00', 'INDIVIDUAL', 1),
	('MONDAY', '09:00:00', '18:00:00', 'LEGAL', 1),
	('TUESDAY', '09:00:00', '18:00:00', 'LEGAL', 1),
	('WEDNESDAY', '09:00:00', '18:00:00', 'LEGAL', 1),
	('THURSDAY', '09:00:00', '18:00:00', 'LEGAL', 1),
	('FRIDAY', '09:00:00', '18:00:00', 'LEGAL', 1),
	('SATURDAY', '09:00:00', '18:00:00', 'LEGAL', 1),
	('SUNDAY', null , null , 'LEGAL', 1),
	('MONDAY', '10:00:00', '21:00:00', 'INDIVIDUAL', 2),
	('TUESDAY', '10:00:00', '21:00:00', 'INDIVIDUAL', 2),
	('WEDNESDAY', '10:00:00', '21:00:00', 'INDIVIDUAL', 2),
	('THURSDAY', '10:00:00', '21:00:00', 'INDIVIDUAL', 2),
	('FRIDAY', '10:00:00', '21:00:00', 'INDIVIDUAL', 2),
	('SATURDAY', '10:00:00', '21:00:00', 'INDIVIDUAL', 2),
	('SUNDAY', null, null, 'INDIVIDUAL', 2),
	('MONDAY', '11:00:00', '21:00:00', 'LEGAL', 2),
	('TUESDAY', '11:00:00', '21:00:00', 'LEGAL', 2),
	('WEDNESDAY', '11:00:00', '21:00:00', 'LEGAL', 2),
	('THURSDAY', '11:00:00', '21:00:00', 'LEGAL', 2),
	('FRIDAY', '11:00:00', '21:00:00', 'LEGAL', 2),
	('SATURDAY', null, null, 'LEGAL', 2),
	('SUNDAY', null , null , 'LEGAL', 2),
	('MONDAY', '12:00:00', '18:00:00', 'INDIVIDUAL', 3),
	('TUESDAY', '12:00:00', '18:00:00', 'INDIVIDUAL', 3),
	('WEDNESDAY', '12:00:00', '18:00:00', 'INDIVIDUAL', 3),
	('THURSDAY', '12:00:00', '18:00:00', 'INDIVIDUAL', 3),
	('FRIDAY', '12:00:00', '18:00:00', 'INDIVIDUAL', 3),
	('SATURDAY', '12:00:00', '18:00:00', 'INDIVIDUAL', 3),
	('SUNDAY', null, null, 'INDIVIDUAL', 3),
	('MONDAY', '12:00:00', '18:00:00', 'LEGAL', 3),
	('TUESDAY', '12:00:00', '18:00:00', 'LEGAL', 3),
	('WEDNESDAY', '12:00:00', '18:00:00', 'LEGAL', 3),
	('THURSDAY', '12:00:00', '18:00:00', 'LEGAL', 3),
	('FRIDAY', '12:00:00', '18:00:00', 'LEGAL', 3),
	('SATURDAY', null, null, 'LEGAL', 3),
	('SUNDAY', null , null , 'LEGAL', 3);

delete from department_type;
insert into department_type(
    id, name
) values
    (1, 'Универсальный'),
    (2, 'Стандарт'),
    (3, 'Розничный (РБ)'),
    (4, 'Микро (РБ)'),
	(5, 'Мини_расш'),
	(6, 'Корпоративный'),
	(7, 'Привилегия (РБ)'),
	(8, 'Стандарт+бизнес отдел'),
	(9, 'Прайм (РБ)'),
	(10, 'Филиал'),
	(11, 'Брокер'),
	(12, 'Микро 2(3)');
