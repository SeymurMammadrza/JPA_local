package main;

import config.HBConfig;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

public class ManyToManyTest {


    public static void main(String[] args) {
        Session session = HBConfig.buildSessionFactory().openSession();


        try {

            session.beginTransaction();

            Project p=new Project();
            p.setProjectName("test project");
            session.save(p);

            Project p2=new Project();
            p2.setProjectName("test project 123");
            session.save(p2);

            Employee e1=new Employee();
            e1.setEmail("anarxocayev@gmail.com");
            e1.setFullname("anar xocayev");
            Set<Project> set=new HashSet<Project>();
            set.add(p);
            set.add(p2);
            e1.setProjects(set);
            session.save(e1);

            Employee  e2=new Employee();
            e2.setEmail("kamalagayev@gmail.com");
            e2.setFullname("kamal agayev");
            set.add(p);
            set.add(p2);
            e2.setProjects(set);
            session.save(e2);


            session.getTransaction().commit();
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
            if (null != session.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /*
    * Hibernate: create table Employee_Project (employee_id bigint not null, project_id bigint not null, primary key (employee_id, project_id)) engine=InnoDB
Hibernate: create table Employees (id bigint not null auto_increment, email varchar(255), full_name varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table Project (id bigint not null auto_increment, project_name varchar(255), primary key (id)) engine=InnoDB
Hibernate: alter table Employee_Project add constraint FKr3x2r2ld89vyt5k0ufgitjwfs foreign key (project_id) references Project (id)
Hibernate: alter table Employee_Project add constraint FK3y2x2xnfa9d38mea8rh3j18tc foreign key (employee_id) references Employees (id)
    * */
}