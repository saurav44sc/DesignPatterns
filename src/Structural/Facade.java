package Structural;

/*

********* PROPERTIES ***********
- structural design pattern
- used when there are multiple interfaces of similar kind of jobs, then we
  add a Facade interface, which provide better interface to these interface
  & clients. It basically helps in routing to related interface
- e.g Drivers - chrome & firefox, Databases

********* IMPLEMENTATION ***********
- we implement a Facade helper class, which will route to method related to
  specific class based on input

 */

import java.sql.Driver;

class Firefox {
    public static Driver getFirefoxDriver() {
        return null;
    }

    public static void genereateHTMLReport(String test, Driver driver) {
        System.out.println("Generating HTML report for Firefox Driver");
    }

    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Generating JUNIT Report for Firefox Driver");
    }
}

class Chrome {
    public static Driver getChromeDriver() {
        return null;
    }

    public static void genereateHTMLReport(String test, Driver driver) {
        System.out.println("Generating HTML report for Chrome Driver");
    }

    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Generating JUNIT Report for Chrome Driver");
    }
}

// The Facade Design Pattern decouples or separates the client
// from all the subcomponents
// The Facades aim is to simplify interfaces, so we don't have
// to worry about what is going on under the hood

class WebExplorerHelperFacade {
    public static void generateReport(String explorer, String report, String test) {
        Driver driver = null;
        switch (explorer) {
            case "firefox":
                driver = Firefox.getFirefoxDriver();
                switch (report) {
                    case "html":
                        Firefox.genereateHTMLReport(test, driver);
                        break;
                    case "junit":
                        Firefox.generateJUnitReport(test, driver);
                        break;
                }
                break;
            case "chrome":
                switch (report) {
                    case "html":
                        Chrome.genereateHTMLReport(test, driver);
                        break;
                    case "junit":
                        Chrome.generateJUnitReport(test, driver);
                        break;
                }
                break;
        }
    }
}

public class Facade {

    public static void main(String[] args) {
        String test = "CheckElementPresent";

        WebExplorerHelperFacade.generateReport("firefox", "html", test);
        WebExplorerHelperFacade.generateReport("firefox", "junit", test);
        WebExplorerHelperFacade.generateReport("chrome", "html", test);
        WebExplorerHelperFacade.generateReport("chrome", "junit", test);

    }
}

// Another example
// https://www.newthinktank.com/2012/09/facade-design-pattern-tutorial/