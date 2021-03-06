package com.lin.cms.demo.common.aop;

import cn.hutool.core.util.StrUtil;
import com.lin.cms.demo.common.configure.CodeConfig;
import com.lin.cms.demo.vo.UnifyResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * 处理返回结果为 Result 的视图函数
 * 默认的返回均是英文，在此处通过error-code替换成中文
 */
@Aspect
@Component
@Slf4j
public class ResultAspect {


    @Pointcut("execution(public * com.lin.cms.demo.controller..*.*(..))")
    public void handlePlaceholder() {
    }

    @AfterReturning(returning = "ret", pointcut = "handlePlaceholder()")
    public void doAfterReturning(Object ret) throws Throwable {
        if (ret instanceof UnifyResponseVO) {
            UnifyResponseVO result = (UnifyResponseVO) ret;
            int code = result.getCode();
            String message = CodeConfig.getMessage(code);
            if (StrUtil.isNotBlank(message)) {
                result.setMessage(message);
            }
        }
    }
}
