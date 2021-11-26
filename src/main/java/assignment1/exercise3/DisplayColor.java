package assignment1.exercise3;


import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class DisplayColor {
    @Test(dataProvider = "color")
    public void testTest2(String color, String value) {
        System.out.println(color + ":" + value);
    }

    @DataProvider(name = "color")
    public Object[][] getColor() {
        Color color = new Color();
        List<Color> list = new ArrayList<>();
        Gson gson = new Gson();
        try {
            FileReader fileReader = new FileReader("exercise3.json");
            Type colorListType = new TypeToken<List<Color>>(){}.getType();
            list = gson.fromJson(fileReader, colorListType);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Object[][] listColor = new Object[list.size()][color.getColumnCount()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < color.getColumnCount(); j++) {
                if (j == 0) {
                    listColor[i][j] = list.get(i).getColor();
                } else {
                    listColor[i][j] = list.get(i).getValue();
                }
            }
        }

        return listColor;
    }

}



