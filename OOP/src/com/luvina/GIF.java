package com.luvina;

public class GIF implements iFile{

    @Override
    public void openFile() {
        System.out.println("Open");
    }

    @Override
    public void parseFile() {
        System.out.println("Parse");
    }

    @Override
    public void saveFile() {
        System.out.println("Save");
    }
}
