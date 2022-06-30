#Group 12 
#Submitted by:- Naman Jain(20UCS122), Naman Jain(20UCS125) , Priyadarshini Sankar(20UCS149), Manav Jangid(20UCS111)
#Restaurant Database System.
#Submitted to:- Mr Ram Prakash Sharma.
#Date 30-11-2021.
Create database r;
use r;
#drop database r;
#

CREATE TABLE WAITER(WTR_ID int(3) Primary key AUTO_INCREMENT, NAME Varchar(10), AGE int(2), GENDER VARCHAR(1) check(GENDER in ('M','F')),Salary int,BUSY INT(1) check(BUSY IN (0,1)));
CREATE TABLE TABLES(TABLE_ID INT(3) PRIMARY KEY, STATUS INT(1) check(STATUS IN (0,1)),WTR_ID int(3),CUSTOMER_ID INT(3),FOREIGN KEY (WTR_ID) references waiter(WTR_ID));
CREATE TABLE CUSTOMERS(CUSTOMER_ID INT(3) PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20),CST_NO INT, TABLE_ID INT(3),BILL_AMOUNT int,FOREIGN KEY (TABLE_ID) references TABLES(TABLE_ID));
CREATE TABLE MENU(ITEM_ID INT(3) primary key auto_increment, ITEM_NAME VARCHAR(50), PRICE INT);
CREATE TABLE ORDERS(ITEM_ID INT(3), CUSTOMER_ID int(3), QUANTITY int, FOREIGN KEY(CUSTOMER_ID) references customers(CUSTOMER_ID));



delimiter //
create trigger assign_table before insert on CUSTOMERS
for each row
	begin 
    set new.TABLE_ID=(select TABLE_ID from TABLES where status in (0) limit 1);
    update tables 
    set status=1, WTR_ID=(select WTR_ID from WAITER where BUSY=0 limit 1), CUSTOMER_ID=new.CUSTOMER_ID
    where new.TABLE_ID=tables.TABLE_ID;
    update waiter 
    set busy=1
    where (Select tables.WTR_ID from tables where new.CUSTOMER_ID=tables.CUSTOMER_ID)=waiter.WTR_ID;
    end;//
delimiter ;
DELIMITER //



CREATE PROCEDURE GENERATE_BILL(x int(3))
BEGIN
	update tables 
    set status=0
    where Table_ID=x;
    #
    UPDATE WAITER
    set busy=0
    where (select WTR_ID from tables where TABLE_ID=x)=WTR_ID;
    #
    update customers
    set BILL_AMOUNT=(Select sum(Price*Quantity) from orders as m, MENU 
    where Customer_ID=(select Customer_ID from tables where TABLE_ID=x) and m.ITEM_ID=MENU.ITEM_ID)
    where CUSTOMER_ID=(select Customer_ID from tables where TABLE_ID=x);
    # 
    Select CUSTOMER_ID,BILL_AMOUNT from customers where CUSTOMER_ID=(select Customer_ID from tables where TABLE_ID=x);
    delete from orders
    where customer_id=(select Customer_ID from tables where TABLE_ID=x);
END //

DELIMITER ;
 


insert into tables (TABLE_ID,STATUS) VALUES (1,0);
insert into tables (TABLE_ID,STATUS) VALUES (2,0);
insert into tables (TABLE_ID,STATUS) VALUES (3,0);
insert into tables (TABLE_ID,STATUS) VALUES (4,0);
insert into tables (TABLE_ID,STATUS) VALUES (5,0);
insert into tables (TABLE_ID,STATUS) VALUES (6,0);
insert into tables (TABLE_ID,STATUS) VALUES (7,0);
insert into tables (TABLE_ID,STATUS) VALUES (8,0);



insert into menu(ITEM_NAME,price) values('Paneer Tikka Ajwaini',100);
insert into menu(ITEM_NAME,price) values('Bhutta Amritsari',200);
insert into menu(ITEM_NAME,price) values('Vegetable Salt and Pepper',300);
insert into menu(ITEM_NAME,price) values('Khumb Palak ka Shorba',400);
insert into menu(ITEM_NAME,price) values('Grilled Eggplant and Zucchini Salad',500);
insert into menu(ITEM_NAME,price) values('Dahi Bhalla',600);
insert into menu(ITEM_NAME,price) values('Paneer Zafrani',700);
insert into menu(ITEM_NAME,price) values('Garlic Naan',800);









call generate_bill(1);
SELECT * FROM CUSTOMERS;
SELECT * FROM tables;
select * from waiter;
select * from orders;