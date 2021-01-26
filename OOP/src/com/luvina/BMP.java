package com.luvina;

public class BMP implements iFile{
    @Override
    public void openFile() {
        System.out.println("Open");
    }

    @Override
    public void parseFile() {
        System.out.println("parse");
    }

    @Override
    public void saveFile() {
        System.out.println("save");
    }
}
