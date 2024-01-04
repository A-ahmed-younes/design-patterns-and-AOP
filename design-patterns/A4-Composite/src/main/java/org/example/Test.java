package org.example;

public class Test {
    public static void main(String[] args) {
        Folder root = new Folder("/");
        root.addChild(new File("Test.java"));
        root.addChild(new File("config.xml"));
        root.addChild(new File("Adapter.java"));
        Folder entities = (Folder) root.addChild(new Folder("entities"));
        Folder repo = (Folder) root.addChild(new Folder("repositories"));
        entities.addChild(new File("Product.java"));
        entities.addChild(new File("Category.java"));
        repo.addChild(new File("ProductRepository.java"));
        repo.addChild(new File("CategoryRepository.java"));

        root.show();
    }
}
