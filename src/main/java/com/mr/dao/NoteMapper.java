package com.mr.dao;

import com.mr.model.Note;

public interface NoteMapper {
    int deleteByPrimaryKey(Integer nid);

    int insert(Note record);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Integer nid);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);
}