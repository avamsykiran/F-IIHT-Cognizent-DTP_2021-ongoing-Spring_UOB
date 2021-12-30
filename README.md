Spring
-----------------------------------------------

    is a dev platform (Nuthsell of almost 18+ frameworks)

    IoC     -   Inversion of Control
    Modular
    Interaperability

    Spring Modules
        Spring Core
            Spring IoC                  Dependency Injection
            Spring Context              Bean Containers
            Spring SpEL                 Spring Expression Lanaguage , Externalized Configuaration
            Spring AOP                  Aspect Oriented Programming
        
        Spring Boot                     Auto-Configuaration + RAD (Rapid Application Development) + Embeded Servers
                                        Serverless application
        Spring Web MVC                  Web Model-View-Controller
        Spring Web Rest                 Rest Api
        Spring ORM                      ORM implementation of JPA
        Spring Data JPA                 Auto-Dynamic Implemnentation of JPA repositories
        Spring Security                 Authentication and Authorization
        Spring Test                     Testing
      
        Spring Cloud                    group of tools needed to develop microservices
        ...etc

     Spring Core
     ----------------------------------------------------------------------

        IoC     implementation of an idea called Dependency Injection.

        Dependecy , otherwise known as Functional Dependency is a relation between two
                    software components that saya that both of those components rely on
                    one anoher to accomplish a functional operation.

                     DAO  <---------->  SERVICE  <-------->    UI

                    A UI component is dependent on a Service component 
                    A Service component is dependent on a DAO component.

        Build Quality of a Solution:
            Legitimancy         (Coding Standards and Comments)
            Reliability         (Fault Tolerence ---- Exception Handling and Logging)
            Maintainability
                        Least Possible Coupling  (inter-dependency of two software components)
                        Highest Possible Cohesion (inter-relativity of two software components)


            interface EmployeeDAO {
                Employee getEmployee(long empid);
                Employee save(Emplopyee emp);
            }

            class EmployeeDAOJdbcImpl implements EmployeeDAO {
                public Employee getEmployee(long empid){
                    //jdbc code....
                }
                public Employee save(Emplopyee emp){
                    //jdbc code...
                }
            }

            class EmployeeDAOORMImpl implements EmployeeDAO {
                public Employee getEmployee(long empid){
                    //orm code....
                }
                public Employee save(Emplopyee emp){
                    //orm code...
                }
            }

            class EmployeeService {

                private EmployeeDAO dao;

                public EmployeeService(){

                }

                public EmployeeService(EmployeeDAO dao){
                    this.dao=dao;
                }

                public void setDAO(EmployeeDAO dao){
                    this.dao=dao;
                }

                ..consuming dao...in service operations
            }

            EmployeeService service1 = new EmployeeService(new EmployeeDAOJdbcImpl()); //constructor injection
            EmployeeService service2 = new EmployeeService(new EmployeeDAOORMImpl());

            EmployeeService service = new EmployeeService();

            service.setDao(new EmployeeDAOJdbcImpl()); //setter injection
            service.setDao(new EmployeeDAOORMImpl());

        
            Containers / Contexts
                is a software component that can manage the lifecycle of a bean.
                where a bean is an object of a software component.
                    EmployeeService             component
                    new EmployeeService()       bean


                the bean is created , supplied, and destroyed by the container / context.

            context - create , supply and destroy the following....
                            ui-beans
                            service-beans
                            dao-beans ...etc

            This setup is called Inversion of Control.  "DONT CALL US, WE WILL CALL YOU"

            Spring Core
                BeanFactory
            Spring Context
                ApplicationContext
                    ClassPathXmlConfigApplicationContext
                    AnnotationConfigApplicationContext
                    WebApplicationContext ....etc


                Configuare the Beans    -> informing the context,
                                                how many beans we need
                                                how are they dependent

                 1. XML based Configuaration

                        bean
                                id                  used to identify the bean
                                class               the component class to which the bean is to be created
                                scope               singleton / prototype / reqeust /session / global-session
                                autowire            none / byName / byType / auto        
                                init-method         any method in the component that has to be executed on
                                                    creating a bean
                                destroy-method      any method in the component that has to be executed on
                                                    destroying a bean
                                factory-method      name of the factory method to be used to create the bean
                                                    in case the constructor is not accessable

                            constructor-arg         used for constructor injection
                                index               0-based index of the arg to which we supply the value
                                type                data type of the arg
                                value               incase the arg is of primitve type like int,float..etc or String
                                ref                 incase of the arg is a bean type, beanId

                             property               used for setter injection
                                name                name of the field being injected 
                                value               incase the field is of primitve type like int,float..etc or String
                                ref                 incase of the field is a bean type, beanId

                    beans.xml
                    ------------------
                        <beans>
                            <bean id="empDAO" class="com.cts.dao.EmployeeDAOJdbcImpl" />

                            <bean id="deptDAO" class="com.cts.dao.DeptDAOJdbcImpl" />

                            <bean id="empService" class="com.cts.service.EmployeeServiceImpl">
                                <constructor-arg index="0" ref="empDAO"/>
                            </bean>

                            <bean id="deptService" class="com.cts.service.DeptServiceImpl">
                                <property name="dao" ref="deptDAO" />
                            </bean>
                        </beans>

                        ApplicationContext context = new ClassPathXmlConfigApplicationContext("beans.xml");
                        EmployeeService empSer = (EmployeeService)context.getBean("empService");
                        
                 2. Annotation Based Configuaration

                    @Configuaration                                                         <beans> </beans>
                    @ComponentScan(basePackage="packageNameThatContainsAllOurComponents")
                    public class AppConfig {

                    }

                    @Component                              <bean id="counter" class="com.cts.service.Counter"/>
                    public class Counter{

                    }

                    @Component("c1")                        <bean id="c1" scope="prototype" 
                    @Scope("prototype")                         class="com.cts.service.Counter"/>
                    public class Counter{

                    }

                    @Component
                        @Service
                        @Repository
                        ..........etc

                    @Autowired                          getter          getter injection byType
                                                        constructor     constructor injection byType
                                                        field           field injection byType

                    @Autowired                          byName
                    @Qualifier("beanId") 

                    externalized field configs using .properties and SpEL
                    ------------------------------------------------------------

                        application.properties
                            key1=value
                            key2=value
                            key3=value

                        @PropertySource("classpath:application.properties") along with @Configuaration

                        @Value("${key1}")
                        public String field1;

                 3. Java Based Configuaration     

                            is not an alternate to Annotation based config...
                            but is a compliment to Annotation based config enabling bean creation for
                            classes coming from a library or api or framework.....

                            @Configuaration  
                            public class AppConfig {

                                @Bean
                                public Scanner scan(){              <bean id="scan" class="java.util.Scanner" />
                                    return new Scanner();
                                }
                            }

    Spring Boot
    ----------------------------------------------------------------------

        another spring module that enables
            1. auto configuaration
            2. rapid application development
            3. embeded servers

        spring core and context     config the packages for scanning teh components and .property files
        spring web mvc              config the dispatcherservlet, internal resource view resolver, request handler ..
        spring security             config the security type, security rules, roles ...
        spring data                 config the validators, datasources, .....
    

        if the above module are sued in conjunction with spring boot, the mentioned configs are automatically made,
        and wtill allow to be customized.

        @SpringBootApplication      =       @Configuaration + @ComponenetScan + @EnableAutoCofig + @ProeprtySource

        application.properties      external configs...

        1. start.spring.io      spring initializer
        2. spring starter project wizard from STS
        3. spring boot cli

    JPA-Hibernate
    ---------------------------------------------------------------------

        JPA is a java ORM specification
            Object Relational Mapping

                                OOP                                 RDBMS
        =====================================================================================================
        EntityDef               class                               table
        Enttity                 object                              record/row
        Property                field                               column
        Behaviours              methods                             ...........

        Relationships
         Has A (Associations)
            Composition                                             emps    eid,fnm,basic,dno,city,street
                                class Address {
                                    int dno
                                    String city
                                    String street
                                }

                                class Employee{
                                    long empId
                                    String fullName;
                                    double basic;
                                    Address address;
                                }

            Aggregation
                OneToOne
                                class Employee{                   emps    eid,fnm,basic
                                    long empId
                                    String fullName;
                                    double basic;
                                    BankAccount salAccount;
                                }

                                class BankAccount {                accs   accNum,ifsc,bank,eid
                                    long accNum
                                    String ifsc;
                                    String bank;
                                    Employee holder;
                                }

                OneToMany       class Department {                depts   deptId,title
                ManyToOne           int deptId
                                    String title
                                    Set<Employee> emps
                                }

                                class Employee{                   emps    eid,fnm,basic,deptId
                                    long empId
                                    String fullName;
                                    double basic;
                                    Department dept;
                                }

                ManyToMany      
                                class Employee{                   emps    eid,fnm,basic
                                    long empId
                                    String fullName;
                                    double basic;
                                    Set<Project> projects;
                                }    
                                                                  emp_prjs  eid,prjid

                                class Project{                    prjs    prjId,title
                                    long projectId
                                    String title
                                    Set<Employee> team
                                }

                                class Employee{                   emps    eid,fnm,basic
                                    long empId
                                    String fullName;
                                    double basic;
                                    Set<Memebership> memeberShips
                                }    

                                class Project{                    prjs    prjId,title
                                    long projectId
                                    String title
                                    Set<Memebership> memeberShips
                                }
                                
                                class MemberShip {                members   msid,empid,prjid,sdate,edate,role
                                    long msId
                                    Employee    teamMember
                                    Project     project
                                    LocalDate   startDate
                                    LocalDate   endDate
                                    String      role
                                }

         Is A (Geenralization)

                                class Employee {                            Single Table
                                    long empid                                  all_emps
                                    String fullName                                 eid,fnm,basic,duration,allowence
                                    double basic
                                }                                           Joined Table
                                                                                emps    eid,fnm,basic
                                class ContractEmployee extends Employee{        cemps   eid,duration
                                    int duration                                mgrs    eid,allowence
                                }
                                                                            Table Per Class
                                class Manager extends Employee {                emps_only   eid,fnam,basic
                                    double allowence                            cemps_only  eid,fnam,basic,duration
                                }                                               mgrs_only   eid,fnam,basic,allowence
    
            Java Perssitence API

                        Java Specifications         Implementations/Providers

                            JDBC                        DB Driver
                            Servlets                    Web Server (Tomcat/WildFly...)
                            JPA                         Hibernate/IBates/....

                    DB  <---> DB Driver <-----> JDBC  <----> Hibernate <----> JPA <---> Application

                @Entity                     class level         
                @Embedable                  class level
                @Table                      class level

                @Inheretence                class level
                @DiscrimatorColumn          class level
                @DiscrimatorValue           class level

                @Column                     Field level
                @Id                         Field level
                @EmbededId                  Field level
                @GeneratedValue             Field level
                @Transiant                  Field level
                @Embeded                    Field level

                @Enumarated                 Field level

                @OneToOne                   Field level
                @OneToMany                  Field level
                @ManyToOne                  Field level
                @ManytoMany                 Field level

                @JoinColumn                 Field level
                @JoinTable                  Field level


                JPA API                                             Hibernate API
                -------------------------------------------         ---------------------------------------
                Persistence::createEntityManagerFactory()               Configuaration::buidlSessionFactory()
                    EntityManagerFactory::createEntityManager()             SessionFactory::createSession()
                        EntityManager::                                         Session::
                            persist(entity)                                         save(entity)
                            remove(entity)                                          delete(entity)
                            merge(eneity)
                            find(class,id)                                          get(class,id)
                            getTranaction()                                         getTransaction()
                                EntityTransaciton::commit()                             Transaction::rollback()
                                EntityTransaciton::rollback()                           Transaction::commit()    
                            createQuery(query)                                      createQeury(query)
                                Query::getResultList()                                  Query.....

                JPQL/HQL                                            SQL
                ---------------------------------------------       --------------------------------------

                SELECT e FROM Employee e                            SELECT * FROM emps

                SELECT e.empId,e.fullName FROM Employee e           SELECT eid,fnm FROM emps

                SELECT e                                            SELECT *
                FROM Employee e                                     FROM emps
                WHERE e.basic between 50000 and 500000              WHERE basic between 50000 and 500000

                SELECT e.fullNamd as ename,e.dept.title as dname    SELECT e.fnm as 'ename',d.title as 'dname'
                FROM Employee e                                     FROM emps e INNER JOIN dept d 
                                                                    ON e.deptId=d.deptId

    Spring Data JPA
    --------------------------------------------------------------

        is a spring orm support module.
        this module provides 
            CrudRepository
                |-- JpaRepository
                        Optional<Entity> findById(id)
                        List<Entity> findAll()
                        Entity save(entity)
                        void delete(entity)
                        void deleteById(id)
                        boolena existsById(id)
                        .....

      existsBy
      findBy
      findAllBy

        class Employee{
            private Long empId;
            private String fullName;
            private Double basic;
            private String mobile;
            private String designation;
            ....
        }       

        interface EmployeeMobileNameModel {
            String getFullName();
            String getMobile();
        }

        interface EmployeeCountByDesignationModel {
            String getDesignation();
            Integer getEmployeeCount();
        }        

        interface EmployeeRepo extends JpaRepository<Employee,Long>{
        
             Optional<Employee> findByMobile(String mobile);  
             List<Employee> findAllByFullName(String fullName); 

             boolean existsByMobile(String mobile);

             @Query("SELECT e FROM Employee e WHERE e.basic BETWEEN :lower AND :upper")
             List<Employee> getAllInBasicRange(Double lower,Double upper);

             @Query("SELECT e.mobile as mobile,e.fullName as fullName FROM Employee e")
             List<EmployeeMobileNameModel> getMobileAndNames();

             @Query("SELECT e.designation as designation,COUNT(e) as employeeCount FROM Employee e GROUP BY e.desingation")
             List<EmployeeCountByDesignationModel> getEmployeeCountByDesignation();
        }

    Spring Web MVC 
    --------------------------------------------------------------


        MVC
        ==================================================================
        REPO <--model--> SERVICE <-model-> Controller (Servlet) <-----REQ
                                            |
                                            | (model)
                                            |
                                            View (JSP) -----------RESP--->
        
        Single Front Controller 
        ==================================================================
        
        REPO <--model--> SERVICE <-model-> Controller <--model---> FrontController  <-----REQ
                                                                        |
                                                                        | (model)
                                                                        |
                                                                        View (JSP) --RESP--->


        Repo        is a POJO that offers Persistence Logic
        Servce      is a POJO that offers Bussiness Logic
        Controller  is a POJO that offers request handling methods (actions)
                        1. this class msut be annoted as @Controller
                        2. the action methods in this class must return
                                a) a view name as string or
                                b) a view name and models as ModelAndView
                        3. these action methods must be annoted with @RequestMapping(value="/url",method=GET/POST)

                    @Controller
                    public class DefaultController {

                        @RequestMapping(value="/index",method=RequestMethod.GET)
                        public String homeAction(){
                            return "home-page";
                        }

                        @RequestMapping(value="/greet",method=RequestMethod.GET)
                        public ModelAndView greetAction(String userName){
                            return new ModelAndView("greet-page","greeting","Hello "+userName);
                        }
                    }

            FrontController is  org.springframework.web.servlet.DispatcherServlet

                    1. it receives all the request from the client
                    2. It uses SimpleUrlHandlerResolver to locate the action and controller
                            mapped to the incoming request.url
                    3. Once the action and controller are identifed, the request parameters are 
                            collected and the action method is executed.
                    4. Using ViewResolver , the DispatcherServlet will lcoate the actual view
                            and will share the model with the view.


            ViewResolver (interface)
                        that can should locate a view given a view-name

                        XmlResourceViewResolver                 .xml    (view-name,view paths)
                        MessageBundleResourceViewResolver       .properties (view-name=view-path)
                        InternalResourceViewResolver
                                prefix      /pages/
                                suffix      .jsp

                                view-path = prefix + view-name + suffix

                                /pages/home-page.jsp
                                /pages/greet-page.jsp



