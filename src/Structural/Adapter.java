package Structural;

/*

********* PROPERTIES ***********
- allows 2 incompatible interfaces to work together
- used when client expects a (target) interface
- tha Adapter class allows the use of the available interface and the
  target interface
- any class can work together as long as Adapter solves the issue that all
  class must implement every method defined by the shared interface

********* IMPLEMENTATION ***********
- Target: Pen(Interface)
- Adapter: PenAdapter
- Adaptee: PilotPen

 */


// This is the Target Interface : This is what the client
// expects to work with. It is the adapters job to make new
// classes compatible with this one.

interface Pen {
    void write(String str);
}


// NormalPen implements Pen perfectly
class NormalPen implements Pen {

    @Override
    public void write(String str) {
        System.out.println(str);
    }
}

// PilotPen is given by client, and we won't touch this
// This is the Adaptee. The Adapter sends method calls
// to objects that use the Pen interface
// to the right methods defined in PilotPen

class PilotPen {
    public void mark(String str) {
        System.out.println(str);
    }
}


// The Adapter must provide an alternative action for
// the methods that need to be used because
// Pen was implemented.
// This adapter does this by containing an object
// of the same type as the Adaptee (PilotPen)
// All calls to Pen methods are sent
// instead to methods used by PilotPen

class PenAdapter implements Pen {
    PilotPen pp;

    public PenAdapter(PilotPen pp) {
        this.pp = pp;
    }

    @Override
    public void write(String str) {
        pp.mark(str);
    }
}


public class Adapter {

    public static void main(String[] args) {

        NormalPen normalPen = new NormalPen();
        normalPen.write("this is normal pen");

        PilotPen pilotPen = new PilotPen();
        pilotPen.mark("this is pilot pen");

        PenAdapter penAdapter = new PenAdapter(pilotPen);
        penAdapter.write("pilot pen through adapter");
    }
}
