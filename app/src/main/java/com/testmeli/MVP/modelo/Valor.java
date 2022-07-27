package com.testmeli.MVP.modelo;

public class Valor {


   private String  source;
   private String  id;
   private String  name;
   private String  struct;

    public Valor(String source, String id, String name, String struct) {
        this.source = source;
        this.id = id;
        this.name = name;
        this.struct = struct;
    }

    public Valor() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStruct() {
        return struct;
    }

    public void setStruct(String struct) {
        this.struct = struct;
    }
}
