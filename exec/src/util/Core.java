package util;

/**
 * @author wangtianchuan 2021/8/10
 */
public class Core {
    private Core(){}

    public static String strTableAdd(String num1, String num2){
        String ans = "0";
        switch (num1){
            case "0" -> ans = num2;
            case "1" -> {
                switch (num2) {
                    case "0" -> ans = "1";
                    case "1" -> ans = "2";
                    case "2" -> ans = "3";
                    case "3" -> ans = "4";
                    case "4" -> ans = "5";
                    case "5" -> ans = "6";
                    case "6" -> ans = "7";
                    case "7" -> ans = "8";
                    case "8" -> ans = "9";
                    case "9" -> ans = "10";
                }
            }
            case "2" -> {
                switch (num2) {
                    case "0" -> ans = "2";
                    case "1" -> ans = "3";
                    case "2" -> ans = "4";
                    case "3" -> ans = "5";
                    case "4" -> ans = "6";
                    case "5" -> ans = "7";
                    case "6" -> ans = "8";
                    case "7" -> ans = "9";
                    case "8" -> ans = "10";
                    case "9" -> ans = "11";
                }
            }
            case "3" -> {
                switch (num2) {
                    case "0" -> ans = "3";
                    case "1" -> ans = "4";
                    case "2" -> ans = "5";
                    case "3" -> ans = "6";
                    case "4" -> ans = "7";
                    case "5" -> ans = "8";
                    case "6" -> ans = "9";
                    case "7" -> ans = "10";
                    case "8" -> ans = "11";
                    case "9" -> ans = "12";
                }
            }
            case "4" -> {
                switch (num2) {
                    case "0" -> ans = "4";
                    case "1" -> ans = "5";
                    case "2" -> ans = "6";
                    case "3" -> ans = "7";
                    case "4" -> ans = "8";
                    case "5" -> ans = "9";
                    case "6" -> ans = "10";
                    case "7" -> ans = "11";
                    case "8" -> ans = "12";
                    case "9" -> ans = "13";
                }
            }
            case "5" -> {
                switch (num2) {
                    case "0" -> ans = "5";
                    case "1" -> ans = "6";
                    case "2" -> ans = "7";
                    case "3" -> ans = "8";
                    case "4" -> ans = "9";
                    case "5" -> ans = "10";
                    case "6" -> ans = "11";
                    case "7" -> ans = "12";
                    case "8" -> ans = "13";
                    case "9" -> ans = "14";
                }
            }
            case "6" -> {
                switch (num2) {
                    case "0" -> ans = "6";
                    case "1" -> ans = "7";
                    case "2" -> ans = "8";
                    case "3" -> ans = "9";
                    case "4" -> ans = "10";
                    case "5" -> ans = "11";
                    case "6" -> ans = "12";
                    case "7" -> ans = "13";
                    case "8" -> ans = "14";
                    case "9" -> ans = "15";
                }
            }
            case "7" -> {
                switch (num2) {
                    case "0" -> ans = "7";
                    case "1" -> ans = "8";
                    case "2" -> ans = "9";
                    case "3" -> ans = "10";
                    case "4" -> ans = "11";
                    case "5" -> ans = "12";
                    case "6" -> ans = "13";
                    case "7" -> ans = "14";
                    case "8" -> ans = "15";
                    case "9" -> ans = "16";
                }
            }
            case "8" -> {
                switch (num2) {
                    case "0" -> ans = "8";
                    case "1" -> ans = "9";
                    case "2" -> ans = "10";
                    case "3" -> ans = "11";
                    case "4" -> ans = "12";
                    case "5" -> ans = "13";
                    case "6" -> ans = "14";
                    case "7" -> ans = "15";
                    case "8" -> ans = "16";
                    case "9" -> ans = "17";
                }
            }
            case "9" -> {
                switch (num2) {
                    case "0" -> ans = "9";
                    case "1" -> ans = "10";
                    case "2" -> ans = "11";
                    case "3" -> ans = "12";
                    case "4" -> ans = "13";
                    case "5" -> ans = "14";
                    case "6" -> ans = "15";
                    case "7" -> ans = "16";
                    case "8" -> ans = "17";
                    case "9" -> ans = "18";
                }
            }
        }
        return ans;
    }

    public static String strTableMulti(String num1, String num2){
        String ans = "0";
        switch (num1){
            case "1" -> {
                switch (num2) {
                    case "1" -> ans = "1";
                    case "2" -> ans = "2";
                    case "3" -> ans = "3";
                    case "4" -> ans = "4";
                    case "5" -> ans = "5";
                    case "6" -> ans = "6";
                    case "7" -> ans = "7";
                    case "8" -> ans = "8";
                    case "9" -> ans = "9";
                }
            }
            case "2" -> {
                switch (num2) {
                    case "1" -> ans = "2";
                    case "2" -> ans = "4";
                    case "3" -> ans = "6";
                    case "4" -> ans = "8";
                    case "5" -> ans = "10";
                    case "6" -> ans = "12";
                    case "7" -> ans = "14";
                    case "8" -> ans = "16";
                    case "9" -> ans = "18";
                }
            }
            case "3" -> {
                switch (num2) {
                    case "1" -> ans = "3";
                    case "2" -> ans = "6";
                    case "3" -> ans = "9";
                    case "4" -> ans = "12";
                    case "5" -> ans = "15";
                    case "6" -> ans = "18";
                    case "7" -> ans = "21";
                    case "8" -> ans = "24";
                    case "9" -> ans = "27";
                }
            }
            case "4" -> {
                switch (num2) {
                    case "1" -> ans = "4";
                    case "2" -> ans = "8";
                    case "3" -> ans = "12";
                    case "4" -> ans = "16";
                    case "5" -> ans = "20";
                    case "6" -> ans = "24";
                    case "7" -> ans = "28";
                    case "8" -> ans = "32";
                    case "9" -> ans = "36";
                }
            }
            case "5" -> {
                switch (num2) {
                    case "1" -> ans = "5";
                    case "2" -> ans = "10";
                    case "3" -> ans = "15";
                    case "4" -> ans = "20";
                    case "5" -> ans = "25";
                    case "6" -> ans = "30";
                    case "7" -> ans = "35";
                    case "8" -> ans = "40";
                    case "9" -> ans = "45";
                }
            }
            case "6" -> {
                switch (num2) {
                    case "1" -> ans = "6";
                    case "2" -> ans = "12";
                    case "3" -> ans = "18";
                    case "4" -> ans = "24";
                    case "5" -> ans = "30";
                    case "6" -> ans = "36";
                    case "7" -> ans = "42";
                    case "8" -> ans = "48";
                    case "9" -> ans = "54";
                }
            }
            case "7" -> {
                switch (num2) {
                    case "1" -> ans = "7";
                    case "2" -> ans = "14";
                    case "3" -> ans = "21";
                    case "4" -> ans = "28";
                    case "5" -> ans = "35";
                    case "6" -> ans = "42";
                    case "7" -> ans = "49";
                    case "8" -> ans = "56";
                    case "9" -> ans = "63";
                }
            }
            case "8" -> {
                switch (num2) {
                    case "1" -> ans = "8";
                    case "2" -> ans = "16";
                    case "3" -> ans = "24";
                    case "4" -> ans = "32";
                    case "5" -> ans = "40";
                    case "6" -> ans = "48";
                    case "7" -> ans = "56";
                    case "8" -> ans = "64";
                    case "9" -> ans = "72";
                }
            }
            case "9" -> {
                switch (num2) {
                    case "1" -> ans = "9";
                    case "2" -> ans = "18";
                    case "3" -> ans = "27";
                    case "4" -> ans = "36";
                    case "5" -> ans = "45";
                    case "6" -> ans = "54";
                    case "7" -> ans = "63";
                    case "8" -> ans = "72";
                    case "9" -> ans = "81";
                }
            }
        }
        return ans;
    }
}
