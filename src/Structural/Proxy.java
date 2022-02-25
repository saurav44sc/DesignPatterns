package Structural;

/*

********* PROPERTIES ***********
- structural design pattern
- used when we want to control access i.e Databases, we would want to
  control the 'delete' query available only for certain users like admin


********* IMPLEMENTATION ***********
- in general, we've class which is executing interface executer method,
  which is executing all commands
- to control this, we add a Proxy class which implements the same interface
  and write the conditions for 'admin' user before proceeding to actual executer

 */


// This interface will contain just those methods
// that we want the proxy to provide access to

interface DatabaseExecuter {
    void executeDatabase(String query) throws Exception;
}

class DatabaseExecuterImple implements DatabaseExecuter {

    @Override
    public void executeDatabase(String query) throws Exception {
        System.out.println("Going to execute Query: " + query);
    }
}

class DatabaseExecuterProxy implements DatabaseExecuter {
    boolean isAdmin = false;
    DatabaseExecuterImple dbExecuter;

    public DatabaseExecuterProxy(String name, String password) {
        if(name == "Admin" && password == "Admin@123") {
            isAdmin = true;
        }
        dbExecuter = new DatabaseExecuterImple();
    }

    @Override
    public void executeDatabase(String query) throws Exception {
        if(isAdmin) {
            dbExecuter.executeDatabase(query);
        }
        else {
            if(query.equals("DELETE")) {
                throw new Exception("DELETE not allowed for non-admin user");
            }
            else {
                dbExecuter.executeDatabase(query);
            }
        }
    }
}

public class Proxy {

    public static void main(String[] args) throws Exception {
        DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuter.executeDatabase("ADD");

//        DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
//        nonAdminExecuterDELETE.executeDatabase("DELETE");

        DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
        adminExecuter.executeDatabase("DELETE");
    }
}
