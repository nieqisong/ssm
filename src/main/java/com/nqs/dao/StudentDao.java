package com.nqs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nqs.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentDao  extends BaseMapper<Student> {
    List<Student> queryStudents();
}
