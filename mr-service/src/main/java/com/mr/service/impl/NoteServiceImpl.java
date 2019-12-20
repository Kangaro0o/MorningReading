package com.mr.service.impl;

import com.mr.mybatis.mapper.NoteMapper;
import com.mr.mybatis.model.Note;
import com.mr.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lql
 * @date 2019/12/18 23:32
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteMapper noteMapper;
    @Override
    public boolean saveNote(Note note) {

        return noteMapper.insert(note)!=0;
    }

    @Override
    public List<Note> findByUid(String uid) {
        return  noteMapper.findByUid(uid);
    }

    @Override
    public Note findByNid(Integer nid) {
        return noteMapper.findByNid(nid);

    }

    @Override
    public boolean deleteByNid(Integer nid) {

        return noteMapper.deleteByNid(nid)!=0;
    }

    @Override
    public boolean updateNote(Note note) {
        return noteMapper.updateByPrimaryKeySelective(note)!=0;
    }
}
