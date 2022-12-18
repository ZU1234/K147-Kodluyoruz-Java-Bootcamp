package prototype;

public interface IClonablePrototype <T> extends Cloneable{
    T clone() throws CloneNotSupportedException;

}
