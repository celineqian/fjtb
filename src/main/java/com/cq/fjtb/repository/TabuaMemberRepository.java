package com.cq.fjtb.repository;

import com.cq.fjtb.entity.TabuaMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TabuaMemberRepository extends JpaRepository<TabuaMember, Long> {

    TabuaMember findByCardNumber(String cardNumber);


//    TabuaMember findByName(String name);

}
