package org.example.computer;

public class SuperVP implements HDMI, VGA{
    @Override
    public void view(byte[] data) {
        System.out.println("==========SuperVP Hdmi==========");
        System.out.println(new String(data));
        System.out.println("==========SuperVP Hdmi==========");
    }

    @Override
    public void print(String message) {
        System.out.println("==========SuperVP VGA==========");
        System.out.println(message);
        System.out.println("==========SuperVP VGA==========");
    }
}
