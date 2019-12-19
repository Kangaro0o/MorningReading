package com.mr.mybatis.mapper;

import com.mr.mybatis.model.Note;

import java.util.List;

public interface NoteMapper {

    int insert(Note record);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Integer nid);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);

    List<Note> findByUid(String uid);

    public Note findByNid(Integer nid);

    public Integer deleteByNid(Integer nid);
}