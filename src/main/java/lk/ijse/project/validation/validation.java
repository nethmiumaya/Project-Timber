package lk.ijse.project.validation;

public class validation {
    public static boolean checkEmployeeId(String id) {
        return id.matches("E\\d{3}");
    }

    public static boolean checkPhoneNumber(String number) {
        return number.matches("0\\d{9}");
    }
    public static boolean checkCustomerId(String id){
        return id.matches("C\\d{3}");
    }
    public static boolean checkItemCode(String id){
        return id.matches("I\\d{3}");
    }
    public static boolean checkBookingId(String id) {
        return id.matches("B\\d{3}");
    }
    public static boolean checkNic(String nic){return nic.matches("[0-9]{10}");}

    public static boolean checkemail(String email){return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");}
}
