package App.Controllers;


import App.Models.PhoneUser;
import App.Services.DBService;
import App.Services.Interfaces.IGetUsers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.sql.SQLException;

@RestController
public class PhoneModelsController {

    @Value("${db_url_path}")
    private String dbUrlPath;

    @RequestMapping("/api/pnomemodels")
    public Iterable<PhoneUser> getPhoneModels() throws SQLException, ClassNotFoundException {
        IGetUsers iGetUsers = new DBService(dbUrlPath);
        return iGetUsers.getAllElements();
    }

    @RequestMapping("/api/phonemodelsbyname")
    public Iterable<PhoneUser> getPhoneModelsByName(@RequestParam(value = "name",defaultValue = "666666666666666666") String name) throws SQLException, ClassNotFoundException {
        IGetUsers iGetUsers = new DBService(dbUrlPath);
        return iGetUsers.getElementByName(name);
    }

    @RequestMapping("/api/phonemodeslbynumber")
    public Iterable<PhoneUser> getPhoneModelsByNumber(@RequestParam(value = "number",defaultValue = "666666666666666666") String number) throws SQLException, ClassNotFoundException {
        IGetUsers iGetUsers = new DBService(dbUrlPath);
        return iGetUsers.getElementByPhone(number);
    }

}
