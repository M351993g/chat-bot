------ message table -----
insert into message values(1,'Hello');
insert into message values(2,'Hi');
insert into message values(3,'Good morning!');
insert into message values(4,'Thanks, bye!');
insert into message values(5,'Goodbye!');
insert into message values(6,'See you');

------ intent table -----
insert into intent values(10,'Greeting');
insert into intent values(20,'Goodbye');
insert into intent values(30,'Delivery status');

------ reply table -----
insert into reply values(5,'Hello :) How can I help you?', 10);
insert into reply values(7,'Goodbye, have a nice day!', 20);

----- intent_message table -----
insert into intent_message (id, message_id, intent_id, confidence) values(50, 1, 10, 81);
insert into intent_message (id, message_id, intent_id, confidence) values(51, 1, 20, 18);
insert into intent_message (id, message_id, intent_id, confidence) values(52, 1, 30, 1);


