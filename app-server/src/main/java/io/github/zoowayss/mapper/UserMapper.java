package io.github.zoowayss.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.zoowayss.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}