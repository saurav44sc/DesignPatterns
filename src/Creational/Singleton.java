package Creational;

/*

********* PROPERTIES ***********
- creational design pattern
- only one instance of the class should exist
- other classes should be able to get instance of Singleton class
- used in logging, cache, session, drivers

********* IMPLEMENTATION ***********
- constructor should be private
- instance type : private static
- public method for returning instance

********* INITIALISATION TYPE ***********
- Eager initialisation
- Lazy initialisation
- Thread safe method initialisation
- Thread safe block initialisation

 */


// Eager initialisation
class SingletonEager {
    private static SingletonEager instance = new SingletonEager();

    private SingletonEager() {

    }

    public static SingletonEager getInstance() {
        return instance;
    }
}


// Lazy initialisation
// This is the widely used one
class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {

    }

    public static SingletonLazy getInstance() {
        // not thread safe - because multiple threads can access -
        // getInstance() at a time
        if(instance == null) {
            instance = new SingletonLazy();
        }

        return instance;
    }
}


// Thread safe method initialisation
class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod instance;

    private SingletonSynchronizedMethod() {

    }

    public static synchronized SingletonSynchronizedMethod getInstance() {
        // thread safe - because one thread can only access at a time
        // once one thread completes then another thread get access
        if(instance == null) {
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }
}


// Thread safe block initialisation
class SingletonSynchronized {
    private static SingletonSynchronized instance;

    private SingletonSynchronized() {

    }

    public static SingletonSynchronized getInstance() {

        if(instance == null) {
            synchronized (SingletonSynchronized.class) {
                if(instance == null) {
                    instance = new SingletonSynchronized();
                }
            }
        }
        return instance;
    }
}


public class Singleton {

    public static void main(String[] args) {
//        SingletonEager instance1 = SingletonEager.getInstance()
//        SingletonLazy instance1 = SingletonLazy.getInstance();
//        SingletonSynchronizedMethod instance1 = SingletonSynchronizedMethod.getInstance();
        SingletonSynchronized instance1 = SingletonSynchronized.getInstance();

        System.out.println(instance1);

//        SingletonEager instance2 = SingletonEager.getInstance();
//        SingletonLazy instance2 = SingletonLazy.getInstance();
//        SingletonSynchronizedMethod instance2 = SingletonSynchronizedMethod.getInstance();
        SingletonSynchronized instance2 = SingletonSynchronized.getInstance();

        System.out.println(instance2);
    }
}
