package kr.co.markncompany.markorder.order.repository;

import kr.co.markncompany.markorder.order.Options;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Options, Long> {
}
