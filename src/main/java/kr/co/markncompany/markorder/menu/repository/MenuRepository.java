package kr.co.markncompany.markorder.menu.repository;

import kr.co.markncompany.markorder.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepository extends JpaRepository<Menu, String> {

    @Query(nativeQuery = true, value = "select common_seq('ME0001')")
    int getSeq();

}
