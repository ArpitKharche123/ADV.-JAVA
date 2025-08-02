--Name: insert_teacher_details 

--To Execute e.g.:

CALL insert_teacher_details(1,'Einstein','male',60,'ein@gmail.com','O+');

--Code: 

BEGIN

--query to insert into teacher_info table
INSERT INTO teacher_info
VALUES(
t_id,t_name,t_gender,t_age,t_email,t_blood_group
);

--query to insert into teacher_id_info table
INSERT INTO teacher_id_info
VALUES(
t_id,t_name,t_blood_group
);

END;
