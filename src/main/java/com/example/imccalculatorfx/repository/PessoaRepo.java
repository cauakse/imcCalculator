package com.example.imccalculatorfx.repository;

import com.example.imccalculatorfx.entity.Pessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepo implements Serializable {
    private List<Pessoa> list;

    public PessoaRepo() {
        this.list = new ArrayList<>();
    }

    public void add(Pessoa pessoa){
        list.add(pessoa);
    }

    public List<Pessoa> getList(){
        return this.list;
    }
}
