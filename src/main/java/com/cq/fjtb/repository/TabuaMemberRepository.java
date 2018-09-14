package com.cq.fjtb.repository;

import com.cq.fjtb.entity.TabuaMember;
import org.springframework.data.repository.CrudRepository;

public interface TabuaMemberRepository extends CrudRepository<TabuaMember, Long> {

    TabuaMember findByCardNumber(String cardNumber);

}
