package com.cq.fjtb.repository;

import com.cq.fjtb.entity.TabuaMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Celine Q
 * @create: 2018-09-16 14:54
 **/
@Repository
public interface TabuaMemberRepository extends JpaRepository<TabuaMember, Long> {

    TabuaMember findByCardNumber(String cardNumber);

    @Query("select t from TabuaMember t where t.isValid=1")
    List<TabuaMember> findValidAll();

    @Query("select t from TabuaMember t where t.name like CONCAT('%',:name,'%')")
    List<TabuaMember> findWithPartOfName(@Param("name") String name);

}
