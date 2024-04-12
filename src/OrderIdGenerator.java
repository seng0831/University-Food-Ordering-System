/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author hw
 */
public class OrderIdGenerator {
    private static int orderCounter = 0;
    int numberOfIds = 999;

    public static String generateOrderId() {
        orderCounter++;
        return String.format("OD%03d", orderCounter);
    }
}
