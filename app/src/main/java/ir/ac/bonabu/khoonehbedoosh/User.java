package ir.ac.bonabu.khoonehbedoosh;


/**
 * Created by Abolfazl 7x on 1/25/2018.
 */

public class User {
    public static class signUp {
        String name = "";
        String lastname = "";
        String username = "";
        String email = "";
        String password = "";
        String phone = "";
        String nacode = "";
        String city = "";
        String user_type="";

        public String getName() {
            return name;
        }

        public String getLastname() {
            return lastname;
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getPhone() {
            return phone;
        }

        public String getNacode() {
            return nacode;
        }

        public String getCity() {
            return city;
        }
        public String getType(){return user_type;}

        public signUp(String name, String lastname, String username, String email, String password, String phone,String user_type) {
            this.name = name;
            this.lastname = lastname;
            this.username = username;
            this.email = email;
            this.password = password;
            this.phone = phone;
            this.nacode = nacode;
            this.user_type=user_type;
        }
    }

    public static class signIn {
        String username = "";
        String password = "";


        public String getPassword() {
            return password;
        }

        public String getUsername() {
            return username;
        }


        public signIn(String username, String password) {

            this.username = username;
            this.password = password;

        }
    }

    public static class setLocation {
        String name = "";
        String gps = "";
        String state = "";
        String bathroom = "";
        String wc = "";
        String poll = "";
        String parking = "";
        String mobl = "";
        String kitchen = "";
        String heater = "";
        String aircon = "";
        String tv = "";
        String wifi = "";
        String elevator = "";
        String refrigriat = "";
        String user_id = "";

        public String getName()    {
            return name;
        }

        public String getGps() {
            return gps;
        }

        public String getState() {
            return state;
        }

        public String getBathroom() {
            return bathroom;
        }

        public String getWc() {
            return wc;
        }

        public String getPoll() {
            return poll;
        }

        public String getParking() {
            return parking;
        }

        public String getMobl() {
            return mobl;
        }

        public String getKitchen() {
            return kitchen;
        }

        public String getHeater() {
            return heater;
        }

        public String getAircon() {
            return aircon;
        }

        public String getTv() {
            return tv;
        }

        public String getWifi() {
            return wifi;
        }

        public String getElevator() {
            return elevator;
        }

        public String getRefrigriat() {
            return refrigriat;
        }

        public String getUser_id() {
            return user_id;
        }

        public setLocation(String name, String gps, String state, String bathroom, String wc, String poll, String parking, String mobl, String kitchen,
                           String heater, String aircon, String tv, String wifi, String elevator, String refrigriat, String user_id) {
            this.name = name;
            this.gps = gps;
            this.state = state;
            this.bathroom = bathroom;
            this.wc = wc;
            this.poll = poll;
            this.parking = parking;
            this.mobl = mobl;
            this.kitchen = kitchen;
            this.heater = heater;
            this.aircon = aircon;
            this.tv = tv;
            this.wifi = wifi;
            this.elevator = elevator;
            this.refrigriat = refrigriat;
            this.user_id = user_id;


        }
    }
}