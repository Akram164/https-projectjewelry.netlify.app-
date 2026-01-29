package com.myorganisation.nexify.repository;


import com.myorganisation.nexify.model.InternalData;
import org.hibernate.Internal;
import org.springframework.stereotype.Repository;

@Repository
public interface internalDataRepository extends jpaRepository <InternalData,Long> {
}
