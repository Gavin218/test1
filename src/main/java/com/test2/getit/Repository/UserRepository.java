package com.test2.getit.Repository;

import com.test2.getit.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: UserRepository
 * @Description:
 * @Author Chen Gavin
 * @Date 2021/10/13
 * @Version 1.0
 *  {@link User}
 */

@Repository
public class UserRepository {

    private final ConcurrentMap<Integer, User> repository
            = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator =
            new AtomicInteger();


    public boolean save(User user){

        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id, user) == null;
    }

    public Collection<User> findAll(){
        return repository.values();
    }

}
