package main.design.pattern.convert;

/**
 * Description :
 * <br>
 * <br>
 *
 * @author zhili
 * @version 1.0
 * @date 2022/7/13 14:49
 */
public interface ModelConvertor<D, V> {

    D convertToDTO();

    V convertToVO();

}
