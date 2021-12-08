package assignment08.exercise01.helper;

import assignment08.exercise01.model.User;
import com.google.gson.Gson;
import org.openqa.selenium.json.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class JsonHelper {
    static List<User> users;


    public static User getUserById(int index)  {
        Gson gson = new Gson();
        FileReader reader = null;
        try {
            reader = new FileReader("assign8_exercise01.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Type userListType = new TypeToken<List<User>>() {}.getType();
        users = gson.fromJson(reader, userListType);
        return users.get(index);

    }
}
