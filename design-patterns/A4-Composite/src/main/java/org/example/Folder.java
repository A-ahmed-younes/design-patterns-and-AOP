package org.example;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Component {
    private List<Component> children = new ArrayList<>();

    Folder(String name) {
        super(name);
    }
    @Override
    public void show() {
        System.out.println(tab()+"Folder : "+name);
        for (Component component:children){
            component.show();
        }
    }
    public Component addChild(Component component){
        component.level=this.level+1;
        children.add(component);
        return component;
    }
}
