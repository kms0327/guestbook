-- select
select no, name, password, message, to_char(reg_date,'YYYY-MM-DD HH:MI:SS') from guestbook;

-- insert
insert into guestbook values(GUESTBOOK_SEQ.nextval,'김문성','1234','안녕하세요',SYSDATE);

--delete
delete from guestbook where no = 1 and pass = '1234';

commit;