package main.design.pattern.convert;

import org.springframework.beans.BeanUtils;

/**
 * Description :
 * <br>
 * <br>
 *
 * @author zhili
 * @version 1.0
 * @date 2022/7/13 14:53
 */
public class AbstractModel<D, V> implements ModelConvertor<D, V>{

    @Override
    public D convertToDTO() {
        Object target = new Object();
        BeanUtils.copyProperties(this, target);
        return (D) target;
    }

    @Override
    public V convertToVO() {
        return null;
    }

}
