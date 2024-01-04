package org.example;

public class File extends Component {
    File(String name) {
        super(name);
    }
    @Override
    public void show() {
        System.out.println(tab()+"File : "+name);
    }
}
