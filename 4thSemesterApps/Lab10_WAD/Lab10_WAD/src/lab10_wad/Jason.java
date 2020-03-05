/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10_wad;

import java.io.StringReader;
import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.json.stream.JsonParser;

/**
 *
 * @author LEGE
 */
public class Jason {

    public static void navigateTree(JsonValue tree, String key) {
        if (key != null) {
            System.out.print("Key " + key + ": ");
        }
        switch (tree.getValueType()) {
            case OBJECT:
                System.out.println("OBJECT");
                JsonObject object = (JsonObject) tree;
                for (String name : object.keySet()) {
                    navigateTree(object.get(name), name);
                }
                break;
            case ARRAY:
                System.out.println("ARRAY");
                JsonArray array = (JsonArray) tree;
                for (JsonValue val : array) {
                    navigateTree(val, null);
                }
                break;
            case STRING:
                JsonString st = (JsonString) tree;
                System.out.println("STRING " + st.getString());
                break;
            case NUMBER:
                JsonNumber num = (JsonNumber) tree;
                System.out.println("NUMBER " + num.toString());
                break;
            case TRUE:
            case FALSE:
            case NULL:
                System.out.println(tree.getValueType().toString());
                break;
        }
    }

    public static String parseObject(JsonObject jo) {
        String s = "";
        JsonParser parser = Json.createParser(new StringReader(jo.toString()));
        while (parser.hasNext()) {
            JsonParser.Event event = parser.next();
            
            switch (event) {
                case START_ARRAY:
                case END_ARRAY:
                case START_OBJECT:
                case END_OBJECT:
                case VALUE_FALSE:
                case VALUE_NULL:
                case VALUE_TRUE:
                    s += (event.toString()) + "\n";
                    break;
                case KEY_NAME:
                    s += (event.toString() + " "
                            + parser.getString() + " - ") + "\n";
                    break;
                case VALUE_STRING:
                case VALUE_NUMBER:
                    s += (event.toString() + " "
                            + parser.getString()) + "\n";
                    break;
            }
        }
        return s;
    }

    public static String getJsonString(JsonObject jo) {
        StringWriter stWriter = new StringWriter();
        JsonWriter jsonWriter = Json.createWriter(stWriter);
        jsonWriter.writeObject(jo);
        jsonWriter.close();

        String jsonData = stWriter.toString();
        return jsonData;
    }

    public static JsonObject createDukeObject() {
        JsonObject model = Json.createObjectBuilder()
                .add("firstName", "Duke")
                .add("lastName", "Java")
                .add("age", 18)
                .add("streetAddress", "100 Internet Dr")
                .add("city", "JavaTown")
                .add("state", "JA")
                .add("postalCode", "12345")
                .add("phoneNumbers", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("type", "mobile")
                                .add("number", "111-111-1111"))
                        .add(Json.createObjectBuilder()
                                .add("type", "home")
                                .add("number", "222-222-2222")))
                .build();

        return model;
    }

    public static void main(String[] args) {
        JsonObject jo = createDukeObject();

        //System.out.println(jo.toString());
        //navigateTree(jo, null);
        //System.out.println(getJsonString(jo));

//        try (JsonWriter jsonWriter = Json.createWriter(stWriter)) {
//            jsonWriter.writeObject(model);
//        }
//
//        String jsonData = stWriter.toString();
//        System.out.println(jsonData);

        System.out.println(parseObject(jo));

    }
}
