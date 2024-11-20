package org.calendarium.calendarium.service;

import org.calendarium.calendarium.entity.Group;
import org.calendarium.calendarium.repo.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS, readOnly = false, timeout = 30)
public class GroupService {
    @Autowired
    GroupRepository groupRepository;

    public Optional<Group> getGroupByGroupNumber(Integer groupNumber){
       List<Group> groupsByNumber =  groupRepository.findByGroupNumber(groupNumber);
       if(groupsByNumber == null || groupsByNumber.isEmpty()) {
           return Optional.empty();
       }
       return Optional.of(groupsByNumber.get(0));
    }
}
