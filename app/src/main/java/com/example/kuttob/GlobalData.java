package com.example.kuttob;

//this java class is created so data in the defined variables below can be accessed by any java file within the umbrella of the project.
public class GlobalData {
    public static String selectedDoc;
    public static Integer bookCover;
    public static Double finalTotal = 0.0;

    public static Double getFinalTotal() {
        return finalTotal;
    }

    public static void setFinalTotal(Double finalTotal) {
        GlobalData.finalTotal = finalTotal;
    }
}
