package homeWork_3;

import java.util.HashMap;
import java.util.Map;

public class RegisterBean {
    private String name;
    private String password;
    private String Password2;
    private String email;


    public static Map<String,String> errors = new HashMap<>();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return Password2;
    }

    public void setPassword2(String password2) {
        Password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Map<String,String> getErrors(){
        return errors;
    }
    public boolean isValid(){
        boolean flag = false;
        if (isNull(this.name)){
            flag = true;
            errors.put("name","用户名不能为空");

        }
        if (isNull(this.password)){
            flag = true;
            errors.put("password","密码不能为空");

        }
        if (isNull(this.Password2)){
            flag = true;
            errors.put("password2","不能为空");

        }

        return flag;
    }


    private boolean isNull(String str){
        if (str == null || " ".equals(str.replaceAll(" ",""))){
            return  true;
        }
        return false;
    }
}
