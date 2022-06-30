package com.example.spring_boot_memo.validation;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class Staff {
    @Min(value = 0)
    @Max(value = 100)
    public Integer id;

    @NotEmpty(message = "スタッフ名を入力してください")
    @Size(max = 15, message = "スタッフの名前は15字以内で入力してください")
    String name;
}
