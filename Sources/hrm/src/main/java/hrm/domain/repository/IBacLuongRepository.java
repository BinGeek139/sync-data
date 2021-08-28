package hrm.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrm.domain.model.entity.Bacluong;

@Repository
public interface IBacLuongRepository extends JpaRepository<Bacluong, Integer> {

}
