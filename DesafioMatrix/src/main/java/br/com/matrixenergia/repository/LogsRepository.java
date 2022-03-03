package br.com.matrixenergia.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.matrixenergia.model.Logs;

@Repository
public interface LogsRepository extends JpaRepository<Logs,Long>{
	public List<Logs>findAllByIp(String ip);
	public List<Logs> findByIpAndDataGreaterThanEqualAndDataLessThanEqual(String ip, Date start, Date end);
	public List<Logs> findByDataGreaterThanEqualAndDataLessThanEqual(Date start, Date end);
	
}
