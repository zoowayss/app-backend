package io.github.zoowayss.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import io.github.zoowayss.starter.utils.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {

    private static final String CREATE_TIME_NAME = "createTime";

    private static final String UPDATE_TIME_NAME = "updateTime";

    @Override
    public void insertFill(MetaObject metaObject) {
        // 避免使用metaObject.setValue()
        long now = TimeUtils.getCurrentTimeMils();
        setTimeField(metaObject, now, CREATE_TIME_NAME);
        setTimeField(metaObject, now, UPDATE_TIME_NAME);

    }

    private void setTimeField(MetaObject metaObject, Long now, String fieldName) {

        this.setFieldValByName(fieldName, now, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        long now = TimeUtils.getCurrentTimeMils();
        setTimeField(metaObject, now, UPDATE_TIME_NAME);
    }
}
