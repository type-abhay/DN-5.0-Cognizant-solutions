# Hands-on 4: Difference Between JPA, Hibernate and Spring Data JPA

## Aim

To understand the difference between JPA, Hibernate and Spring Data JPA by comparing their usage in code.

---

## What I understood

In this hands-on, I understood that JPA, Hibernate and Spring Data JPA are related, but they are not the same.

JPA stands for Java Persistence API. It gives a set of rules or specifications for how Java objects can be stored and managed in a database. JPA itself does not do database operations directly.

Hibernate is the implementation of JPA. It takes those JPA rules and actually performs database operations like insert, update, delete and fetch. Hibernate helps us work with Java objects instead of writing SQL queries manually.

Spring Data JPA is another layer on top of Hibernate. It reduces boilerplate code and makes database operations much easier using repositories and annotations.

---

## Hibernate Code

```java id="i2fmgw"
public Integer addEmployee(Employee employee){
   Session session = factory.openSession();
   Transaction tx = null;
   Integer employeeID = null;

   try {
      tx = session.beginTransaction();
      employeeID = (Integer) session.save(employee); 
      tx.commit();
   } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace(); 
   } finally {
      session.close(); 
   }
   return employeeID;
}
```

### What I noticed

In Hibernate, we need to manually handle session opening, transactions, commit, rollback and closing the session. This gives more control but increases the amount of code.

---

## Spring Data JPA Code

```java id="i8pmts"
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
```

```java id="n2kkmy"
@Autowired
private EmployeeRepository employeeRepository;

@Transactional
public void addEmployee(Employee employee) {
    employeeRepository.save(employee);
}
```

### What I noticed

In Spring Data JPA, a lot of code is reduced. Instead of writing many lines for session and transaction handling, we can directly use repository methods like save().

---

## Comparison

* JPA → Rules / Specification
* Hibernate → Implementation of JPA
* Spring Data JPA → Simplifies Hibernate usage

---

## Conclusion

From this hands-on, I understood that JPA gives the rules, Hibernate implements those rules, and Spring Data JPA makes development easier by reducing boilerplate code. I also understood why Spring Data JPA is preferred in real-world projects because it saves time and makes code cleaner.
