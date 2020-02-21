package com.kaleldo.validator;

import com.kaleldo.annotation.IsMobile;
import com.kaleldo.pojo.RegexpConstant;
import com.kaleldo.utils.KaleldoUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileValidator implements ConstraintValidator<IsMobile, String> {

    @Override
    public void initialize(IsMobile isMobile) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            } else {
                String regex = RegexpConstant.MOBILE_REG;
                return KaleldoUtil.match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }
}
