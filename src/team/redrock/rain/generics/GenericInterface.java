package team.redrock.rain.generics;

/**
 * team.redrock.rain.generics.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/4 下午1:02
 */
public interface GenericInterface<T> {
    // ...
}

// 被继承/实现的类型必须要填入具体的类型参数
// 但我们可以在子类/实现类定义一个泛型，再将其填入被继承/实现类的泛型中去，实现泛型类型的继承
class GenericInterfaceImpl<T> implements GenericInterface<T> {

}

// 当然也可以填入一个具体的类型
class GenericInterfaceStringImpl implements GenericInterface<String> {

}