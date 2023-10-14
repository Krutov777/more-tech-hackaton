delete from atm;
insert into atm(
    id, address, all_day, distance, latitude, longitude, metro_station
) values
(1, 'ул. Богородский Вал, д. 6, корп. 1', true, 750, 50.234934, 100.2003, 'м. Московская'),
(1, 'ул. Кастанаевская, д. 25, корп. 1', true, 200, 55.736001, 37.483157, 'м. Московская'),
(1, 'ул. Богородский Вал, д. 6, корп. 1', true, 750, 50.234934, 100.2003, 'м. Московская');

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
      (1, 2, 'AVAILABLE', 'SUPPORTED'),
      (1, 3, 'AVAILABLE', 'SUPPORTED'),
      (2, 2, 'UNAVAILABLE', 'SUPPORTED'),
      (2, 4, 'AVAILABLE', 'UNAVAILABLE');

delete from department;
insert into department(
    id, address, department_type, distance, has_ramp,
    latitude, longitude, metro_station, rko, sale_point_format,
    sale_point_name, status, suo_availability
) values
      (1, 'ул. Богородский Вал, д. 6, корп. 1', 'DEPTYPE', 1000, true, 50.234934, 100.2003, 'м. Московская', 'RKO1', 'Корпоративный', 'Имя', 'AVAILABLE', true),
      (2, 'ул. Богородский Вал, д. 6, корп. 1', 'DEPTYPE', 1000, true, 50.234934, 100.2003, 'м. Московская', 'RKO1', 'Корпоративный', 'Имя', 'AVAILABLE', true),
      (3, 'ул. Богородский Вал, д. 6, корп. 1', 'DEPTYPE', 1000, true, 50.234934, 100.2003, 'м. Московская', 'RKO1', 'Корпоративный', 'Имя', 'AVAILABLE', true);


delete from service_department;
insert into service_department(
    department_id, service_id
) values
      (1, 1),
      (1, 2),
      (2, 2);