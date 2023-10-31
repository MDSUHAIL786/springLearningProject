for hibernate steps:
add dependency in pom.xml
make hibernate.cfg.xml file
add hibernate properties in hibernate.cfg.xml file
make pojo class like student.java and add annotation in it
add mapping of pojo class in hibernate.cfg.xml file
make main class and write code for save data in database
make session factory and session object and transaction object
```


some important annotations
@Entity
@Table
@Id
@Column
@Transient   //this will tell hibernate to not save this field in database
@OneToOne
@OneToMany
@ManyToOne
@ManyToMany
@JoinColumn
@JoinTable
@Lob    //for large object
@Temporal(TemporalType.DATE)  //    //for date and time -- this will tell hibernate to save date and time in database in format.



//get and load
get() method will return null if object is not found in database or in cache
load() method will throw exception if object is not found in database or in cache

get() method will hit database every time if not found in cache
load() method will hit database only when we use object data like object.getId() or object.getName() etc. otherwise it return proxy(means copy of object with null values) object also called lazy intialization.


//@Embeddable -- this annotation is used to save object of another class in database-- see program for more details
