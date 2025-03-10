package io.github.zoowayss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.zoowayss.entity.UserEntity;
import io.github.zoowayss.mapper.UserMapper;
import io.github.zoowayss.service.IUserService;
import io.github.zoowayss.starter.domain.dto.TokenUser;
import io.github.zoowayss.starter.domain.dto.UserAddr;
import io.github.zoowayss.starter.utils.ServletUtils;
import io.github.zoowayss.starter.utils.TimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

    @Override
    public TokenUser getRequestUserInfo(Long uid) {
        UserEntity userEntity = super.getById(uid);
        if (userEntity == null) {
            return null;
        }

        TokenUser ans = new TokenUser();
        BeanUtils.copyProperties(userEntity, ans);
        ans.setUid(uid);
        return ans;
    }

    @Override
    public UserAddr getByEmail(String email) {
        UserEntity userEntity = getUserByEmail(email);
        if (Objects.isNull(userEntity)) {
            return null;
        }
        UserAddr ret = new UserAddr();
        ret.setUid(userEntity.getId());
        BeanUtils.copyProperties(userEntity, ret);
        return ret;

    }

    @Override
    public long registerNewUser(UserAddr userAddr) {
        UserEntity save = new UserEntity();
        BeanUtils.copyProperties(userAddr, save);
        save.setLastLoginTime(TimeUtils.getCurrentTimeMils());
        save.setLastLoginIp(ServletUtils.getClientIp());
        this.save(save);
        return save.getId();
    }

    @Override
    @Transactional
    public void deleteAccount(Long uid) {
        UserEntity update = new UserEntity();
        update.setId(uid);
        update.setDeleted(true);
        super.updateById(update);
    }

    @Override
    public UserAddr getByName(String account) {
        UserEntity entity = super.getOne(new LambdaQueryWrapper<UserEntity>().eq(UserEntity::getAccount, account));
        if (Objects.isNull(entity)) {
            return null;
        }
        UserAddr ret = new UserAddr();
        BeanUtils.copyProperties(entity, ret);
        ret.setUid(entity.getId());
        return ret;
    }

    public UserEntity getUserByEmail(String email) {
        return baseMapper.selectOne(new LambdaQueryWrapper<UserEntity>().eq(UserEntity::getEmail, email).last("limit 1"));
    }


    @Override
    public UserAddr getUserInfo(long uid) {
        UserEntity user = super.getById(uid);
        if (Objects.isNull(user)) {
            return null;
        }

        UserAddr ret = new UserAddr();
        BeanUtils.copyProperties(user, ret);
        ret.setUid(uid);
        return ret;
    }
}