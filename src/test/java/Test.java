import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {

        String day=new SimpleDateFormat("yyMMddhhmmss").format(new Date());

        System.out.println("day = " + day);

    }


}
