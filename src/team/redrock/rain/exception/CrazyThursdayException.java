package team.redrock.rain.exception;

/**
 * team.redrock.rain.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/10/30 下午8:29
 */
public class CrazyThursdayException extends Exception {
    public CrazyThursdayException() {
        super("KFC CRAZY THURSDAY 50$ required");
    }

    public static void main(String[] args) throws CrazyThursdayException {
        throw new CrazyThursdayException();
    }
}
