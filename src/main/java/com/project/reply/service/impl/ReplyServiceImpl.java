package com.project.reply.service.impl;

import com.project.reply.dao.ReplyDao;
import com.project.reply.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyDao replyDao;


}
