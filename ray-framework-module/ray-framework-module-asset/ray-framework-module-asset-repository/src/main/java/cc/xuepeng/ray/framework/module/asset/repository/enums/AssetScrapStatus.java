package cc.xuepeng.ray.framework.module.asset.repository.enums;

import cc.xuepeng.ray.framework.core.common.domain.enums.BaseEnum;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 资产报废状态枚举
 *
 * @author xuepeng
 */
@Getter
@ToString
@AllArgsConstructor
public enum AssetScrapStatus implements BaseEnum {

    SCRAPPED(0, "已报废"),

    CANCELLED(1, "取消报废");

    /**
     * 查找枚举
     * JsonCreator注解代表Jackson反序列化时使用该方法查找枚举
     *
     * @param code 枚举值
     * @return 枚举
     */
    @JsonCreator
    public static AssetScrapStatus findEnum(final Integer code) {
        for (AssetScrapStatus e : values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    /**
     * 枚举值
     * JsonValue注解代表序列化时使用的值
     * EnumValue注解代表写入数据库的值
     */
    @JsonValue
    @EnumValue
    private final Integer code;

    /**
     * 枚举描述
     */
    private final String desc;

}