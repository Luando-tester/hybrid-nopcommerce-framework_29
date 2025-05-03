package data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalContants;

import java.io.File;

public class ProductData {
    public static ProductData getProduct(){
        try{
            ObjectMapper mapper =  new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            return mapper.readValue(new File(GlobalContants.DATA_TEST_PATH + "Product.json"), ProductData.class);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private String price;
    @JsonProperty("description")
    private String description;

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}