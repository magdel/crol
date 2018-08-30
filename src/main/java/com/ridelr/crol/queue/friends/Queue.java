package com.ridelr.crol.queue.friends;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Optional;

@Component
public class Queue {
    private static final Logger log = LoggerFactory.getLogger(Queue.class);
    private volatile boolean isRunning = true;

    public Queue(FriendDao friendDao, TransactionTemplate txTemplate,
                 FriendQueueProcessor friendQueueProcessor) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRunning) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        return;
                    }
                    try {
                        Optional<Friend> friendOptional;
                        do {


                            friendOptional = txTemplate.execute(ts -> friendDao.queryNextForProcess());
                            if (friendOptional.isPresent()) {
                                friendQueueProcessor.addFriends(friendOptional.get());

                            }

                        } while (friendOptional.isPresent());


                    } catch (Throwable ttt) {
                        log.error("On run", ttt);
                    }
                }


            }
        }).start();

    }


}
