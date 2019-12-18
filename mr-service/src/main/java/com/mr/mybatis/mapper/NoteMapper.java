package com.mr.mybatis.mapper;

import com.mr.mybatis.model.Note;

public interface NoteMapper {
    int deleteByPrimaryKey(Integer nid);

    int insert(Note record);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Integer nid);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);
}