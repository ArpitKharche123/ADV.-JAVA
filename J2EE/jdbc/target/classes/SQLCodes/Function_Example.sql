--Name: count_by_gender

--To Execute e.g.:

SELECT count_by_gender('female');

--Code: 

DECLARE t_count integer; --declaring the count variable

BEGIN

SELECT COUNT(*) INTO t_count --storing count into the t_count variable
FROM teacher_info
WHERE gender=t_gender;

RETURN t_count;  --returning the t_count

END;