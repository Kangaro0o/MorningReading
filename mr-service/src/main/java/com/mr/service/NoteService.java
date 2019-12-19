package com.mr.service;

import com.mr.common.Result;
import com.mr.mybatis.model.Note;
import org.aspectj.weaver.ast.Not;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author lql
 * @date 2019/12/18 23:31
 */

public interface NoteService {
    public boolean saveNote(Note note);
    public List<Note> findByUid(String uid);
    public Note findByNid(Integer nid);
    public boolean deleteByNid(Integer nid);
}
