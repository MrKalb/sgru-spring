CREATE OR REPLACE FUNCTION function_valid_cpf(text)
  RETURNS boolean AS
$$
DECLARE
 v_string text := $1;
 v_caldv1 int4;
 v_caldv2 int4;
 v_dv1 int4;
 v_dv2 int4;
 v_array1 text[] ;
 v_array2 text[] ;
 v_tst_string int4;
BEGIN
 v_string := translate(v_string, './-', '');

  v_dv1 := (substring(v_string, 10, 1))::int4;
  v_dv2 := (substring(v_string, 11, 1))::int4;
  v_string := substring(v_string, 1, 9);
  /* COLETA DIG VER 1 CPF */
  v_caldv1 := 0;
  FOR va IN 1..9 LOOP
   v_caldv1 := v_caldv1 + ((SELECT substring(v_string, va, 1))::int4 * (11 - va));
  END LOOP;
  v_caldv1 := v_caldv1 % 11;
  IF (v_caldv1 = 0) OR (v_caldv1 = 1) THEN
   v_caldv1 := 0;
  ELSE
   v_caldv1 := 11 - v_caldv1;
  END IF;
  /* COLETA DIG VER 2 CPF */
  v_caldv2 := 0;
  FOR va IN 1..10 LOOP
   v_caldv2 := v_caldv2 + ((SELECT substring((v_string || v_caldv1::text), va, 1))::int4 * (12 - va));
  END LOOP;
  v_caldv2 := v_caldv2 % 11;
  IF (v_caldv2 = 0) OR (v_caldv2 = 1) THEN
   v_caldv2 := 0;
  ELSE
   v_caldv2 := 11 - v_caldv2;
  END IF;
  /* TESTA */
  IF (v_caldv1 = v_dv1) AND (v_caldv2 = v_dv2) THEN
   RETURN TRUE;
  ELSE
   RETURN FALSE;
  END IF;

RETURN FALSE;
END;

$$
  LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION fun_valid_email(text) RETURNS boolean AS
$$
DECLARE
  v_string text := $1;
BEGIN
  IF( (v_string ~ '^[a-z_.-]*.@gmail.com.*$') OR (v_string ~ '^[a-z_.-]*.@gmail.com.*$')
     OR (v_string ~ '^[a-z_.-]*.@gmail.com.*$')) THEN
    return true;
  END IF;
  return false;
END;
$$
  LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION fun_valid_phone(text) returns boolean AS
$$
  DECLARE
  v_string text := $1;
BEGIN
    if(v_string ~'^[0-9]') THEN
      return true;
    END IF;
    return false;

  END ;
$$
  LANGUAGE 'plpgsql';


CREATE OR REPLACE FUNCTION fun_valid_registration_number(text) returns boolean AS
  $$
  DECLARE
    v_string text := $1;
  BEGIN
    if(v_string ~ '^[0-9]') THEN
      return true;
    END IF;
    return false;
  END;

  $$
    LANGUAGE 'plpgsql';


select fun_valid_phone('54991740615');


-------------- VIEW------------------

create or REPLACE VIEW  vw_consumption_all_paid as (
  select p.registration_number as matricula, p.name as nome,
   case
   p.status when 'A' then 'ATIVO'
   when 'I' then 'INATIVO' end as ativo,
    p.email, c.date as data, CASE
    shift when 'T' then 'TARDE'
    when 'M' then 'MANHA'
    when 'N' then 'NOITE'end as turno,
    sum(pg.value)  as total_gasto

  from person p join consumption c on p.id = c.person_id
                join person_group pg on p.group_id = pg.id
  group by p.id,c.date,c.shift
);

create or replace view vw_contribution_all_gain as (
    select p.registration_number as numero_matricula,
    case p.status when 'A' then 'ATIVO'
    when 'I' then 'INATIVO' end as ativo,
    p.email, b.date as data,
    sum(pg.value)
    from person p join wallet w on p.wallet_id = w.id
                  join debt b on b.wallet_id = w.id
                  join person_group pg on pg.id = p.group_id
    group by p.id,b.date
);


-----------------------ROLES-------------------------------------

--DBA Super secure password--
create role admin_dba login 'admin';

create role admin_person login 'admin_person';

create role person login 'person';

grant connect on database sgru to person;
grant connect on database sgru to admin_dba;
grant connect on database sgru to admin_person;

GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO admin_dba;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO admin_dba;

grant insert,update,select on ALL TABLES IN SCHEMA public to admin_person;

grant insert,update,select on consumption,contributions to person;




REVOKE ALL ON DATABASE sgru FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM PUBLIC;

----------------------

drop view vw_consumption_by_person

drop view vw_consumption_all

select * from vw_consumption_by_person('0100161');



