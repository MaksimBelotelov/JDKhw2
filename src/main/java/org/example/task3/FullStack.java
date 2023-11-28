package org.example.task3;

public class FullStack extends Developer implements Backend, FrontEnd {
    @Override
    public void codeServer() {
        System.out.println("Fullstack codes server...");
    }

    @Override
    public void brushButtons() {
        System.out.println("Fullstack brushes buttons");
    }
}
