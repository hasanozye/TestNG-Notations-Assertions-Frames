import com.github.javafaker.Faker;

public class Test {
    public static void main(String[] args) {

        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            if (!faker.witcher().quote().equals(faker.witcher().quote()))
            System.out.println((i + 1) + ". WitcherGafları : " + faker.witcher().quote());
        }

    }


}
