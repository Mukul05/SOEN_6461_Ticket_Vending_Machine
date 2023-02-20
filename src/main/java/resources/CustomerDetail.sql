create database TicketVendingSystem;

use TicketVendingSystem;

CREATE TABLE CustomerDetails(id bigint PRIMARY KEY auto_increment, firstName varchar(200) not null, lastName varchar(200) not null, email varchar(200) not null, CurrentLocation varchar(200) not null, Destination varchar(200) not null,NumberofTickets bigint,tdate date);
CREATE TABLE TicketType(tickettypeid bigint PRIMARY KEY auto_increment, Source varchar(200) not null, Destination varchar(200) not null, vehicle varchar(200) not null,totalcount bigint);

insert into CustomerDetails values(1,"Arawn","Uchiha","arawnuchiha@gmail.com","Montreal","Toronto",2,20230219);
insert into TicketType values(1,"Montreal","Toronto","Bus",3);
delete from CustomerDetails where id=1;
select * from CustomerDetails
commit;