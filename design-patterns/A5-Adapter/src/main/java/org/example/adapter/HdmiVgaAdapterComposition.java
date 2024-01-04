package org.example.adapter;

import org.example.computer.HDMI;
import org.example.computer.VGA;


public class HdmiVgaAdapterComposition implements VGA {
    private HDMI hdmi;
    @Override
    public void print(String message) {
        System.out.println("-------------Adapter-------------");
        byte[] msg=message.getBytes();
        hdmi.view(msg);
        System.out.println("-------------Adapter-------------");
    }

    public void setHdmi(HDMI hdmi) {
        this.hdmi = hdmi;
    }
}
