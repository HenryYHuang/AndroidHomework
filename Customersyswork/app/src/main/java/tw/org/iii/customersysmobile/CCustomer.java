package tw.org.iii.customersysmobile;

/**
 * Created by iii on 2017/7/18.
 */

public class CCustomer {
    private  String account;
    private  String name;
    private  String phone;
    private  String email;
    private  String address;

    public CCustomer(String account, String name, String phone, String email, String address) {
        this.setAccount(account);
        this.setName(name);
        this.setPhone(phone);
        this.setEmail(email);
        this.setAddress(address);
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
