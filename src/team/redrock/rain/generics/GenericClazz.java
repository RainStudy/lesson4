package team.redrock.rain.generics;

/**
 * team.redrock.rain.generics.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/4 下午12:49
 */
public class GenericClazz<T extends Number> {

    private T element;

    public T get() {
        return this.element;
    }

    public void set(T element) {
        this.element = element;
    }

}
