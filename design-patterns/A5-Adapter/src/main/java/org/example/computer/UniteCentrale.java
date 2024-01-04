package org.example.computer;

public class UniteCentrale {
    public VGA vga;

    public void print(String message) {
        vga.print(message);
    }

    public void setVga(VGA vga) {
        this.vga = vga;
    }
}
