package Structural;

/*

********* PROPERTIES ***********
- structural design pattern
- used when we want to modify functionality of an Objecta at runtime &
  it should not change individual Object functionality
- i.e adding different functionalities in Dress

********* IMPLEMENTATION ***********
- DressDecorator is used to add different styles(sporty, casual, fancy) to Basic Dress

 */

// Blueprint for classes that will have decorators
interface Dress {
    void assemble();
}

// Implements the Dress interface with only the required
// methods from the interface
// Every Dress made will start as a BasicDress

class BasicDress implements Dress {
    @Override
    public void assemble() {
        System.out.println("Basic Dress Features");
    }
}


// Has a "Has a" relationship with Dress. This is an
// Aggregation Relationship

class DressDecorator implements Dress {
    protected Dress dress;

    // Assigns the type instance to this attribute
    // of a Dress
    // All decorators can dynamically customize the Dress
    // instance BasicDress because of this

    public DressDecorator(Dress d) {
        this.dress = d;
    }

    @Override
    public void assemble() {
        dress.assemble();
    }
}

class SportyDress extends DressDecorator {
    public SportyDress(Dress c) {
        super(c);
    }

    // Returns the result of calling assemble() for
    // BasicDress and adds "sporty" to it

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Sporty Dress Features");
    }
}

class CasualDress extends DressDecorator {
    public CasualDress(Dress d) {
        super(d);
    }

    // Returns the result of calling assemble() for
    // BasicDress and adds "casual" to it
    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding casual dress features");
    }
}

class FancyDress extends DressDecorator {
    public FancyDress(Dress c) {
        super(c);
    }

    // Returns the result of calling assemble() for
    // BasicDress and adds "fancy" to it
    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Fancy Dress Features");
    }
}

public class Decorator {

    public static void main(String[] args) {

        // The BasicDress object is sent to the SportyDress constructor
        Dress sportyDress = new SportyDress(new BasicDress());
        sportyDress.assemble();
        System.out.println();

        // The BasicDress object is sent to the FancyDress constructor
        Dress fancyDress = new FancyDress(new BasicDress());
        fancyDress.assemble();
        System.out.println();

        // The BasicDress object is sent to the CasualDress constructor
        Dress casualDress = new CasualDress(new BasicDress());
        casualDress.assemble();
        System.out.println();


        // The BasicDress object is sent to the FancyDress constructor
        // and then to the SportyDress constructor
        Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
        sportyFancyDress.assemble();
        System.out.println();


        // The BasicDress object is sent to the FancyDress constructor
        // and then to the SportyDress constructor
        // and then to the CasualDress constructor
        Dress casualFancyDress = new CasualDress(new SportyDress(new FancyDress(new BasicDress())));
        casualFancyDress.assemble();
    }
}
