package io.github.zoowayss.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author zoowayss
 * @since 2025-01-06 14:28:35
 */
@Getter
@Setter
@TableName(value = "t_user", autoResultMap = true)
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1992331418873290867L;

    /**
     * 用户UID，自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 用户账号
     */
    @TableField("account")
    private String account;

    /**
     * 用户邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 用户密码
     */
    @TableField("password")
    private String password;

    /**
     * 最近登录时间
     */
    @TableField("last_login_time")
    private Long lastLoginTime;

    /**
     * 最近登录IP
     */
    @TableField("last_login_ip")
    private String lastLoginIp;

    /**
     * 用户头像地址
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 谷歌用户的唯一uid
     */
    @TableField("google_user_id")
    private String googleUserId;

    /**
     * 谷歌是否绑定了，0 没有，1 绑定了
     */
    @TableField("google_connected")
    private Boolean googleConnected;

    /**
     * 用户注册时的设备，android/ios
     */
    @TableField("device")
    private String device;

    /**
     * 设备唯一编号
     */
    @TableField("did")
    private String did;

    /**
     * Facebook user id
     */
    @TableField("facebook_user_id")
    private String facebookUserId;

    /**
     * Facebook 是否绑定，0 没有 1 绑定了
     */
    @TableField("facebook_connected")
    private Byte facebookConnected;

    /**
     * 会员等级
     */
    @TableField("level")
    private Integer level;

    /**
     * 连续订阅的开始时间
     */
    @TableField("sub_start_time")
    private Long subStartTime;

    /**
     * 用户订阅过期时间
     */
    @TableField("sub_expire_time")
    private Long subExpireTime;

    /**
     * 是否删除，0：未删除，1：已删除
     */
    @TableField("deleted")
    private Boolean deleted;

    /**
     * 用户创建时间，毫秒
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Long createTime;

    /**
     * 更新时间，毫秒
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;

    @TableField(exist = false)
    private Integer duration;
}
