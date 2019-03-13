DROP PROCEDURE IF EXISTS getUserByNames$
CREATE procedure getUserByNames (IN var1 VARCHAR(45) )
BEGIN
select * from users where userName = var1;
end;