package com.tcs.certificacion.RetoTCSAPIREST.utils;

import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;


public class CrearBody {

    private String plantillaRuta;
    
    public CrearBody(String plantillaRuta, String endPoint){

        this.plantillaRuta = plantillaRuta;
    }

    public static CrearBody conLaPlantilla(String plantilla)
    {
        return new CrearBody(plantilla,null);
    }

    public static  CrearBody conElEndPoint(String endPoint){

        return new CrearBody(null,endPoint);
    }

    public String yLosValores(List<Map<String,String>> values){
        String nuevaPlantilla = parseJson(plantillaRuta);
        for (Map<String,String> value: values) {
            for (Map.Entry<String, String> entry : value.entrySet()) {
                String k = entry.getKey();
                String v = entry.getValue();
                String key = "${" + k + "}";
                nuevaPlantilla = nuevaPlantilla.replace(key, v);
            }
        }
        return nuevaPlantilla;
    }

    public String parseJson(String ruta){
        String resultStr="";
        try {
            resultStr=readFileAsString(ruta);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return resultStr;
        }
    }

    public static String readFileAsString(String fileName)throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }
}
