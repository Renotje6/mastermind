package masterMind;

public class Colours
{
    public enum ColoursEnum
    {
        red,
        blue,
        yellow,
        purple,
        green,
        orange
    }

    public static boolean enumContainsValue(String value) {
        for(ColoursEnum c : ColoursEnum.values()) {
            if(c.name().equals(value)){
                return true;
            }
        }
        return false;
    }
}
