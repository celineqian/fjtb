package com.cq.fjtb.repository;

import com.cq.fjtb.entity.TabuaMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Celine Q
 * @create: 2018-09-16 14:54
 **/
@Repository
public interface TabuaMemberRepository extends JpaRepository<TabuaMember, Long> {

    TabuaMember findByCardNumber(String cardNumber);

}
