package org.example.computer;

import org.example.adapter.HdmiVgaAdapterComposition;
import org.example.adapter.HdmiVgaAdapterInheritance;

public class Test {
    public static void main(String[] args) {
        UniteCentrale uniteCentrale=new UniteCentrale();
        uniteCentrale.setVga(new Ecran());
        uniteCentrale.print("Test");
        System.out.println();

        uniteCentrale.setVga(new VideoProjecteur());
        uniteCentrale.print("Test");
        System.out.println();

        HdmiVgaAdapterComposition hdmiVgaAdapterComposition =new HdmiVgaAdapterComposition();
        hdmiVgaAdapterComposition.setHdmi(new TV());
        uniteCentrale.setVga(hdmiVgaAdapterComposition);
        hdmiVgaAdapterComposition.print("Test");
        System.out.println();

        HdmiVgaAdapterInheritance hdmiVgaAdapterInheritance =new HdmiVgaAdapterInheritance();
        uniteCentrale.setVga(hdmiVgaAdapterInheritance);
        hdmiVgaAdapterInheritance.print("Test");
        System.out.println();

        uniteCentrale.setVga(new SuperVP());
        uniteCentrale.print("Test");
        System.out.println();

        HdmiVgaAdapterComposition hdmiVgaAdapterComposition1 =new HdmiVgaAdapterComposition();
        hdmiVgaAdapterComposition1.setHdmi(new SuperVP());
        uniteCentrale.setVga(hdmiVgaAdapterComposition1);
        uniteCentrale.print("Test");
    }
}
