package br.com.abner.composite;

public class File implements FileSystemComponent{

    private String name;
    private double size;

    public File(String name, double size){
        this.name = name;
        this.size = size;
    }
    @Override
    public void showDetails() {
        System.out.println("Arquivo: " + name + " | Tamanho: " + size + "KB");
    }
}
