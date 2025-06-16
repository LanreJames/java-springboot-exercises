package com.crystalcrumbs.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crystalcrumbs.model.Vaccine;

//import jakarta.transaction.Transactional;

@Repository
public interface IVaccineRepo extends JpaRepository<Vaccine, Integer> 
{
	@Query("from Vaccine where vaccinecompany=:company")
	public List <Vaccine> searchByVaccineCompany(String company);
	
	@Query("From Vaccine where vaccinecompany IN (:c1, :c2)")
	public List <Vaccine> searchByVaccineCompanies(@Param ("c1") String comp1,@Param ("c2") String comp2);
	
	@Query("Select vaccineName from Vaccine where cost BETWEEN :minPrice AND :maxPrice")
	public List<String> searchByVaccineCost(Double minPrice, Double maxPrice);
	
	@Transactional
	@Modifying
	@Query("Update Vaccine SET cost = :newCost where vaccineName=:VaccineName")
	public int updateCostByVaccineName(Double newCost,String VaccineName);
	
	
	@Transactional
	@Modifying
	@Query("Update Vaccine SET vaccineName = :newVaccineName where id=:id")
	public int updateVaccineById(String newVaccineName, Integer id);
	
	@Transactional
	@Modifying
	@Query("Delete from Vaccine where vaccineName=:VaccineName")
	public int deleteVaccineByVaccineName(@Param("VaccineName")String name);
	
	
	@Transactional
	@Modifying
	@Query(value="Insert into vaccine (`id`,`vaccine_name`,`vaccinecompany`,`cost`) values(?,?,?,?)",nativeQuery=true)
	public int insertVaccineInfo(Integer id, String vaccineName, String vaccinecompany, Double cost);
}