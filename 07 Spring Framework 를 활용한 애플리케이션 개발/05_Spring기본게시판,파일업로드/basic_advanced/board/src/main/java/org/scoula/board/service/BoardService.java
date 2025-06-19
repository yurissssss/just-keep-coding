package org.scoula.board.service;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    public List<BoardDTO> getList();

    public BoardDTO get(Long no);

    public void create(BoardDTO board);

    public boolean update(BoardDTO board);

    public boolean delete(Long no);

    //하나의 첨부파일정보를알고자하는경우
    public BoardAttachmentVO getAttachment(Long no);

    //첨부파일을삭제하고자하는경우
    public boolean deleteAttachment(Long no);
}