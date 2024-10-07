create table if not exists company(
    id UUID primary key,
    name varchar not null
);

insert into company values ('ee1ecde8-f553-4114-ae4b-b63b83f9e9c9', 'Tecla');

create table if not exists department(
    id UUID primary key,
    name varchar not null,
    company_id UUID,
    constraint fk_company
        foreign key(company_id)
            references company(id)
);

insert into department values('3d6e935c-d2da-45ec-9802-fcd6aba2eb74', 'IT department', 'ee1ecde8-f553-4114-ae4b-b63b83f9e9c9');

create table if not exists team(
    id UUID primary key,
    name varchar not null,
    department_id UUID,
    constraint fk_department
        foreign key(department_id)
            references department(id)
);

insert into team values('d09ccff1-d383-4cbe-8e0d-985bc0d5f5db', 'Fun folks', '3d6e935c-d2da-45ec-9802-fcd6aba2eb74');

create table if not exists project(
    id UUID primary key,
    name varchar not null
);

insert into project values ('44676388-3b8b-4946-a5b9-a4048a1d7613', 'Medical print service');
insert into project values ('ac3757bf-c0ce-441b-9be0-06767a6940bf', 'Government insurance service');

create table if not exists project_team(
    team_id UUID not null,
    project_id UUID not null,
    primary key(team_id, project_id),
    constraint fk_project_team_team_id
        foreign key(team_id)
            references team(id),
    constraint fk_project_team_project_id
            foreign key(project_id)
                references project(id)
);

insert into project_team values ('d09ccff1-d383-4cbe-8e0d-985bc0d5f5db', '44676388-3b8b-4946-a5b9-a4048a1d7613');
insert into project_team values ('d09ccff1-d383-4cbe-8e0d-985bc0d5f5db', 'ac3757bf-c0ce-441b-9be0-06767a6940bf');

create table if not exists manager(
    id UUID primary key,
    firstname varchar not null,
    lastname varchar not null,
    phone_number varchar
);

insert into manager values ('7a1daf93-d6be-488e-aae4-488a4c97dfe8', 'Jan', 'Kowalski', '+48111111111');

create table if not exists project_manager(
    project_id UUID not null,
    manager_id UUID not null,
    primary key(project_id, manager_id),
    constraint fk_project_manager_project_id
        foreign key(project_id)
            references project(id),
    constraint fk_project_manager_manager_id
        foreign key(manager_id)
            references manager(id)
);

insert into project_manager values ('44676388-3b8b-4946-a5b9-a4048a1d7613', '7a1daf93-d6be-488e-aae4-488a4c97dfe8');