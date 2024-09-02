package br.com.abner;

import br.com.abner.composite.File;
import br.com.abner.composite.Folder;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("Documento.txt", 120);
        File file2 = new File("Foto.png", 3500);
        File file3 = new File("Musica.mp3", 4500);

        Folder personalFolder = new Folder("Pessoal");
        personalFolder.addComponent(file1);
        personalFolder.addComponent(file2);

        Folder musicFolder = new Folder("Músicas");
        musicFolder.addComponent(file3);

        Folder rootFolder = new Folder("Raiz");
        rootFolder.addComponent(personalFolder);
        rootFolder.addComponent(musicFolder);

        rootFolder.showDetails();
    }
}