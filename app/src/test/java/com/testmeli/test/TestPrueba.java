package com.testmeli.test;
import static org.junit.Assert.*;
import com.testmeli.util.Util;
import org.junit.Test;
import java.nio.charset.StandardCharsets;

public class TestPrueba {

 //verificamos el correcto funcionamiento del metodo para dar formato con punto de miles al
 // precio del producto
    @Test
    public void formatoMilesBien() {
        assertEquals("1.000.000", Util.formatoMiles("1000000"));
    }

    //metodo usado para contar la cantidad de caracteres que el precio para dar el formato
    @Test
    public void tamanoCadena() {
       String prueba = "123456";
       byte[] datos= prueba.getBytes(StandardCharsets.UTF_8);
       assertEquals(6,Util.tamanoCadena(datos));
    }

    //metodo usado para convertir la informacion recibida a un objeto tipo producto
    @Test
    public void convertiJsonBien() {
       String jsonProducto="{\n" +
       "  \"id\": \"MLA1117089595\",\n" +
       "  \"site_id\": \"MLA\",\n" +
       "  \"title\": \"Motorola Moto G6 Play 32 Gb Azul Bueno\",\n" +
       "  \"seller\": {},\n" +
       "  \"price\": 33999,\n" +
       "  \"prices\": {},\n" +
       "  \"sale_price\": null,\n" +
       "  \"currency_id\": \"ARS\",\n" +
       "  \"available_quantity\": 1,\n" +
       "  \"sold_quantity\": 4,\n" +
       "  \"buying_mode\": \"buy_it_now\",\n" +
       "  \"listing_type_id\": \"gold_special\",\n" +
       "  \"stop_time\": \"2041-12-19T04:00:00.000Z\",\n" +
       "  \"condition\": \"new\",\n" +
       "  \"permalink\": \"https://articulo.mercadolibre.com.ar/MLA-1117089595-motorola-moto-g6-" +
               "play-32-gb-azul-bueno-_JM\",\n" +
       "  \"thumbnail\": \"http://http2.mlstatic.com/D_818339-MLA48666151195_122021-O.jpg\",\n" +
       "  \"thumbnail_id\": \"818339-MLA48666151195_122021\",\n" +
       "  \"accepts_mercadopago\": true,\n" +
       "  \"installments\": {},\n" +
       "  \"address\": {\n" +
       "    \"state_id\": \"AR-X\",\n" +
       "    \"state_name\": \"Córdoba\",\n" +
       "    \"city_id\": \"TUxBQ0NBUGNiZGQx\",\n" +
       "    \"city_name\": \"Córdoba\"\n" +
       "  },\n" +
       "  \"shipping\": {},\n" +
       "  \"seller_address\": {},\n" +
       "  \"attributes\": [\n" +
       "    {\n" +
       "      \"name\": \"Marca\",\n" +
       "      \"value_struct\": null,\n" +
       "      \"attribute_group_id\": \"OTHERS\",\n" +
       "      \"values\": [],\n" +
       "      \"attribute_group_name\": \"Otros\",\n" +
       "      \"source\": 4954751883138633,\n" +
       "      \"id\": \"BRAND\",\n" +
       "      \"value_id\": \"2503\",\n" +
       "      \"value_name\": \"Motorola\"\n" +
       "    },\n" +
       "    {\n" +
       "      \"value_struct\": null,\n" +
       "      \"attribute_group_id\": \"OTHERS\",\n" +
       "      \"attribute_group_name\": \"Otros\",\n" +
       "      \"source\": 4954751883138633,\n" +
       "      \"id\": \"ITEM_CONDITION\",\n" +
       "      \"name\": \"Condición del ítem\",\n" +
       "      \"value_id\": \"2230582\",\n" +
       "      \"value_name\": \"Reacondicionado\",\n" +
       "      \"values\": []\n" +
       "    },\n" +
       "    {\n" +
       "      \"value_name\": \"Moto\",\n" +
       "      \"value_struct\": null,\n" +
       "      \"values\": [],\n" +
       "      \"attribute_group_name\": \"Otros\",\n" +
       "      \"id\": \"LINE\",\n" +
       "      \"name\": \"Línea\",\n" +
       "      \"value_id\": \"59187\",\n" +
       "      \"attribute_group_id\": \"OTHERS\",\n" +
       "      \"source\": 1000427007642219\n" +
       "    },\n" +
       "    {\n" +
       "      \"source\": 4954751883138633,\n" +
       "      \"id\": \"MODEL\",\n" +
       "      \"value_id\": \"2876818\",\n" +
       "      \"value_name\": \"G6 Play\",\n" +
       "      \"value_struct\": null,\n" +
       "      \"attribute_group_name\": \"Otros\",\n" +
       "      \"name\": \"Modelo\",\n" +
       "      \"values\": [],\n" +
       "      \"attribute_group_id\": \"OTHERS\"\n" +
       "    }\n" +
       "  ],\n" +
       "  \"original_price\": null,\n" +
       "  \"category_id\": \"MLA1055\",\n" +
       "  \"official_store_id\": null,\n" +
       "  \"domain_id\": \"MLA-CELLPHONES\",\n" +
       "  \"catalog_product_id\": \"MLA9413721\",\n" +
       "  \"tags\": [],\n" +
       "  \"order_backend\": 1,\n" +
       "  \"use_thumbnail_id\": false,\n" +
       "  \"offer_score\": null,\n" +
       "  \"offer_share\": null,\n" +
       "  \"match_score\": null,\n" +
       "  \"winner_item_id\": null,\n" +
       "  \"melicoin\": null,\n" +
       "  \"discounts\": null\n" +
       "    }";

        // si el resultado el diferente de null significa que se obtuvo el objeto producto
        assertNotEquals(null, Util.convertiJson(jsonProducto));

    }



     //metodo usado para probar en caso de obtener una respuesta vacia por parte del servidor
    @Test
    public void convertiJsonFalla() {
        String jsonProducto="  ";
        // si el resultado es null significa que ocurrio un error
        assertNull(Util.convertiJson(jsonProducto));
    }


    //metodo usado para probar el reemplazo de caracteres ingresados por el usuario
    @Test
    public void reemplazarcaracteres(){
       assertEquals("%20%20%20%20%20NnAEIOUaeiou",Util.remplazarCaracteresEspeciales(" ?¿¡!ÑñÁÉÍÓÚáéíóú"));
    }


   }