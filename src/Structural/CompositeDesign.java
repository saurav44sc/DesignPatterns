package Structural;

/*

********* PROPERTIES ***********
- allows to treat individual objects and compositions of objects uniformly
- can have tree like structure
- components can be further divided into smaller components
- we can structure data, or represent the inner working of every part of a
  whole object individually
- four participants: component, leaf, composite, client

********* IMPLEMENTATION ***********
- component:
  composite: peripherals, cabinet, motherboard, computer
  leaf: hdd, mouse, keyboard, ram, cpu

 */

import java.util.ArrayList;
import java.util.List;

// This is an interface for every Leaf
// and Composite we create

interface Component {
    void showPrice();
}

class Leaf implements Component {
    int price;
    String name;

    public Leaf(int price, String name) {
        super();
        this.price = price;
        this.name = name;
    }

    @Override
    public void showPrice() {
        System.out.println(name + " : " + price);
    }
}

class Composite implements Component {
    String name;

    // Contains any Leafs or Composites that are added
    // to this ArrayList
    List<Component> components = new ArrayList<>();

    public Composite(String name) {
        super();
        this.name = name;
    }

    public void addComponent(Component com) {
        components.add(com);
    }

    @Override
    public void showPrice() {
        System.out.println(name);
        // Cycles through and prints any Leafs or Composites added
        // to this Composite ArrayList components
        for(Component c: components) {
            c.showPrice();
        }
    }

}

public class CompositeDesign {

    public static void main(String[] args) {
        Component hd = new Leaf(4000, "HDD");
        Component mouse = new Leaf(400, "mouse");
        Component keyboard = new Leaf(800, "keyboard");
        Component ram = new Leaf(4000, "ram");
        Component cpu = new Leaf(2000, "cpu");

        Composite ph = new Composite("peri");
        Composite cabinet = new Composite("cabinet");
        Composite motherboard = new Composite("motherboard");
        Composite computer = new Composite("computer");

        motherboard.addComponent(cpu);
        motherboard.addComponent(ram);

        ph.addComponent(mouse);
        ph.addComponent(keyboard);

        cabinet.addComponent(hd);
        cabinet.addComponent(motherboard);

        computer.addComponent(ph);
        computer.addComponent(cabinet);

        computer.showPrice();

    }
}

// https://www.youtube.com/watch?v=Q1jZ4TI6MF4&list=PLsyeobzWxl7r2ZX1fl-7CKnayxHJA_1ol&index=9