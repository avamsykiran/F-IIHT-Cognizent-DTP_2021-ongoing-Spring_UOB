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

