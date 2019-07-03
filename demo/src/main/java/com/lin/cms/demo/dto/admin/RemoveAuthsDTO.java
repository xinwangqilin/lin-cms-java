package com.lin.cms.demo.dto.admin;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class RemoveAuthsDTO {
    @Min(value = 1, message = "分组id必须正整数")
    @NotNull(message = "分组id不可为空")
    private Integer groupId;

    @NotBlank
    @Valid
    private List<String> auths;
}