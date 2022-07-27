package com.testmeli.MVP.modelo;

import java.util.List;

public class Atributo {

     private String  attribute_group_name;
     private String  id;
     private String  value_id;
     private String  value_struct;
     private String  attribute_group_id;
     private String  name;
     private String  value_name;
     private List<Valor> values;
     private int     source;

     public Atributo() {
     }

     public Atributo(String attribute_group_name, String id, String value_id, String value_struct, String attribute_group_id, String name, String value_name, List<Valor> values, int source) {
          this.attribute_group_name = attribute_group_name;
          this.id = id;
          this.value_id = value_id;
          this.value_struct = value_struct;
          this.attribute_group_id = attribute_group_id;
          this.name = name;
          this.value_name = value_name;
          this.values = values;
          this.source = source;
     }

     public String getAttribute_group_name() {
          return attribute_group_name;
     }

     public void setAttribute_group_name(String attribute_group_name) {
          this.attribute_group_name = attribute_group_name;
     }

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getValue_id() {
          return value_id;
     }

     public void setValue_id(String value_id) {
          this.value_id = value_id;
     }

     public String getValue_struct() {
          return value_struct;
     }

     public void setValue_struct(String value_struct) {
          this.value_struct = value_struct;
     }

     public String getAttribute_group_id() {
          return attribute_group_id;
     }

     public void setAttribute_group_id(String attribute_group_id) {
          this.attribute_group_id = attribute_group_id;
     }

     public int getSource() {
          return source;
     }

     public void setSource(int source) {
          this.source = source;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getValue_name() {
          return value_name;
     }

     public void setValue_name(String value_name) {
          this.value_name = value_name;
     }

     public List<Valor> getValues() {
          return values;
     }

     public void setValues(List<Valor> values) {
          this.values = values;
     }
}
