package com.jimiarts.api.spring;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
public class ResponseObject<T>{
    T data;

    List<ResponseFieldError> fieldErrors = null;

    String message;

    public ResponseObject(T data) {
        this.data = data;
    }

    @Getter
    @Setter
    protected static class ResponseFieldError {
        String fieldName;
        String message;
    }

    public void setFieldErrors(BindingResult bindingResult) {
        if (fieldErrors == null) {
            fieldErrors = new ArrayList<>();
        }
        for(FieldError error : bindingResult.getFieldErrors()) {
            ResponseFieldError resultFieldError = new ResponseFieldError();
            resultFieldError.setFieldName(error.getField());
            resultFieldError.setMessage(error.getDefaultMessage());
            fieldErrors.add(resultFieldError);
        }
    }
}
