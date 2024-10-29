package com.example.imccalculatorfx.util;

import com.example.imccalculatorfx.repository.PessoaRepo;

import java.io.*;

public class Singleton {
    private static PessoaRepo repo = new PessoaRepo();
    public static PessoaRepo getRepositorio(){
        return repo;
    }
    private Singleton() {
    }

    public static boolean save(){
        //serializar o objeto repo
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream;
        try{
        fileOutputStream = new FileOutputStream("dados.obj");
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(repo);
        objectOutputStream.close();
            return true;
        }
        catch (Exception e){}
        return false;
        //gravar o objeto serializado
    }
    public static boolean read(){
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream;
        try{
            fileInputStream = new FileInputStream("dados.obj");
            objectInputStream = new ObjectInputStream(fileInputStream);
            repo=(PessoaRepo) objectInputStream.readObject();
            return true;
        }catch (Exception e){}
        return false;
    }
}
