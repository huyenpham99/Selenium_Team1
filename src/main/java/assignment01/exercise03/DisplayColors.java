package assignment01.exercise03;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DisplayColors {

    @Test(dataProvider = "abc")
    public void printColor(String color, String value) {
        System.out.println("Color:" + color + " Value:" + value + "\n");
    }


    @DataProvider(name="abc")
    public Object[][] getData() {
        Color color = new Color();
        List<Color> colors = new ArrayList<>();
        try {
            FileReader reader = new FileReader("assign1_exercise03.json");
            Gson gson = new Gson();
            Type colorListType = new TypeToken<List<Color>>() {}.getType();
            colors = gson.fromJson(reader, colorListType);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Object[][] data = new Object[colors.size()][color.getColumnCount()];

        for (int i = 0; i < colors.size(); i++) {
            for (int j = 0; j < color.getColumnCount(); j++) {
                if (j == 0) {
                    data[i][j] = colors.get(i).getColor();
                } else {
                    data[i][j] = colors.get(i).getValue();
                }
            }
        }


        return data;
    }
}
