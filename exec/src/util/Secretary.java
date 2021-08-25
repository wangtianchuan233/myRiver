package util;

/**
 * @author wangtianchuan 2021/8/24
 */
public class Secretary {
    public static String bracketToCurly(String src) {
        return src.replace('[', '{').replace(']', '}');
    }
}
