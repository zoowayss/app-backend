package io.github.zoowayss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.zoowayss.entity.UserEntity;
import io.github.zoowayss.starter.service.UserInfoService;
import io.github.zoowayss.starter.service.UserService;

/**
 * @author <a href="https://github.com/zoowayss">zoowayss</a>
 * @version 1.0
 * @since 3/10/25 17:05
 */

public interface IUserService extends IService<UserEntity>, UserService, UserInfoService {
}
