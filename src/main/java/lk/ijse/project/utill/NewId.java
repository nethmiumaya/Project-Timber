package lk.ijse.project.utill;

import java.util.ArrayList;

public class NewId {

        public static String newId(ArrayList<String> list, GetType getType) {
            String lastId = null;
            for (int i = 0; i < list.size(); i++) {
                lastId = String.valueOf(list.get(i));
            }

            switch (getType) {
                case EMPLOYEE:
                    try {
                        String[] split = lastId.split("E0");
                        int idNum = Integer.parseInt(split[1]);
                        idNum++;
                        return "E00" + idNum;
                    } catch (Exception e) {
                        return "E01";
                    }

                case CUSTOMERORDER:
                    try {
                        String[] split = lastId.split("H0");
                        int idNum = Integer.parseInt(split[1]);
                        idNum++;
                        return "H0" + idNum;
                    } catch (Exception e) {
                        return "H01";
                    }

                case DELIVER:
                    try {
                        String[] split = lastId.split("D0");
                        int idNum = Integer.parseInt(split[1]);
                        idNum++;
                        return "D0" + idNum;
                    } catch (Exception e) {
                        return "D01";
                    }

                case ITEM:
                    try {
                        String[] split = lastId.split("I0");
                        int idNum = Integer.parseInt(split[1]);
                        idNum++;
                        return "I0" + idNum;
                    } catch (Exception e) {
                        return "I01";
                    }

                default:
                    return null;
            }


        }

        public enum GetType {
            EMPLOYEE, CUSTOMERORDER, DELIVER, ITEM
        }
    }


