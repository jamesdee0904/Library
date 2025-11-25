package Methods;

import java.util.HashMap;

public abstract class Account {
    HashMap<String, String> account = new HashMap<>();
    public void accounts() {
        account.put("24-33110@g.batstate-u.edu.ph", "24-33110");
        account.put("24-35142@g.batstate-u.edu.ph", "24-35142");
        account.put("24-35016@g.batstate-u.edu.ph", "24-35016");
        account.put("24-31492@g.batstate-u.edu.ph", "24-31492");
        account.put("24-30487@g.batstate-u.edu.ph", "24-30487");
        account.put("24-36497@g.batstate-u.edu.ph", "24-36497");
        account.put("24-37104@g.batstate-u.edu.ph", "24-37104");
        account.put("24-33429@g.batstate-u.edu.ph", "24-33429");
        account.put("23-39178@g.batstate-u.edu.ph", "24-39132");
        account.put("24-31948@g.batstate-u.edu.ph", "24-31948");
        account.put("24-33077@g.batstate-u.edu.ph", "24-33077");
        account.put("24-31341@g.batstate-u.edu.ph", "24-31341");
        account.put("24-38616@g.batstate-u.edu.ph", "24-38616");
        account.put("24-39973@g.batstate-u.edu.ph", "24-39973");
    }
    public abstract void login();
    public abstract void book();
}
