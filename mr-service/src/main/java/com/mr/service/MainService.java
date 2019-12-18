package com.mr.service;

import com.mr.mybatis.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MainService {
    @Autowired
    NoteMapper noteMapper;
}
