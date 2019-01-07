insert into role (role_id, name) values (nextval('role_sequence'),'USER');
insert into role (role_id, name) values (nextval('role_sequence'),'ADMIN');

insert into appuser (user_id, user_name, password) values (nextval('user_sequence'),'jaxteller', '$2y$10$VidOzZ3anvtJwnXwktq7X.sYsK4qCXJuB6psuue4sL/8ATZFG.1TG');  --jax@yahoo.com
insert into appuser (user_id, user_name, password) values (nextval('user_sequence'),'romanpolansky', '$2y$10$07qR0BoSboN1O4etl0LeYecT9.9DYmFoTZzMFi0pz/xI2l/m7TuWa'); --rompo@gmail.com
insert into appuser (user_id, user_name, password) values (nextval('user_sequence'), 'annehataway', '$2y$10$OI3GF1GPwTTVAa7qaoYsFObtw3l1UCUUC9pO2VhqrHOf.ei1T3sp.'); --anne@live.com
insert into appuser (user_id, user_name, password) values (nextval('user_sequence'), 'jonnydepp', '$2y$10$opifyGB/pPCS1KgNp76Ns.Nx.QjbEUBq4LCK/.GV5jERKzHXNSkNi'); --jonny@depp.com
insert into appuser (user_id, user_name, password) values (nextval('user_sequence'), 'malcomx', '$2y$10$hVshJlllQSUFyHmNqSODueTeMvDbhz0bvKqnUUxPrB45xk1WFVHna'); --malconx@live.com
insert into appuser (user_id, user_name, password) values (nextval('user_sequence'),'admin', '$2y$10$ZBzAwNASpRU0k5kaNpaKkuu3btzucKGJQZAi1c9GjYGTRIYetkKyO'); -- admin

insert into user_role (user_id, role_id) values (1,1);
insert into user_role (user_id, role_id) values (1,11);
insert into user_role (user_id, role_id) values (11,11);
insert into user_role (user_id, role_id) values (21,1);
insert into user_role (user_id, role_id) values (21,11);
insert into user_role (user_id, role_id) values (31,11);
insert into user_role (user_id, role_id) values (41,1);
insert into user_role (user_id, role_id) values (51,11);

insert into post (id, content) values (nextval('post_sequence'), 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
insert into post (id, content) values (nextval('post_sequence'), 'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur');
insert into post (id, content) values (nextval('post_sequence'), 'In volutpat vulputate ante non egestas. Sed ultrices, turpis id accumsan tincidunt, turpis purus efficitur tortor, vitae mollis dolor diam efficitur quam. Praesent varius neque eget est iaculis, sed aliquam elit placerat. Suspendisse non nulla laoreet, efficitur nibh a, suscipit magna. Praesent rutrum facilisis mauris, in semper odio tincidunt vitae. Aliquam tempor arcu eu nibh malesuada varius. Interdum et malesuada fames ac ante ipsum primis in faucibus. Quisque id ante in neque finibus malesuada sed a erat. Proin in euismod nisl. Pellentesque quis vehicula magna.');
insert into post (id, content) values (nextval('post_sequence'), 'Sed lacinia sed nisi nec fermentum. Nulla facilisi. Donec mollis libero a lectus faucibus tempus. Duis non porttitor massa. Ut placerat sit amet augue sed pretium. Nulla tincidunt eleifend ante, non sagittis dui varius vel. Ut tincidunt mi a nunc bibendum bibendum. Proin placerat nisi non viverra accumsan. Cras non pretium tellus, vitae viverra est. Duis ut risus nec dolor imperdiet porta. Praesent eu dui pharetra, rutrum massa nec, placerat augue. Etiam feugiat pellentesque eros at fermentum.');