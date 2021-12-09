package assignment08.exercise01_2_3.helper;
import assignment08.exercise01_2_3.model.VisitorEmail;
import assignment08.exercise01_2_3.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;


public class JsonHelper {

    private static JsonHelper instance;

    private JsonHelper() {}

    public static JsonHelper getInstance(){
        if(instance == null){
            instance = new JsonHelper();
        }
        return instance;
    }

    private List<VisitorEmail> visitorEmails;
    private List<User> users;

    public VisitorEmail getEmail(int index){

        Gson gson = new Gson();
        ;
        try {
            FileReader reader = new FileReader("assign8_exercise02.json");
            visitorEmails = gson.fromJson(reader, new TypeToken<List<VisitorEmail>>(){}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return visitorEmails.get(index);

    }

    public  User getUserById(int index)  {
        Gson gson = new Gson();
        FileReader reader = null;
        try {
            reader = new FileReader("assign8_exercise01.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Type userListType = new org.openqa.selenium.json.TypeToken<List<User>>() {}.getType();
        users = gson.fromJson(reader, userListType);
        return users.get(index);
    }
}
