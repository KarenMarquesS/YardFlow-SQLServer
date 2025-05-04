package org.example.yardflow.repository;//package org.example.parkflow.repository;
//
//import org.example.parkflow.model.Patio;
//import org.example.parkflow.model.SetorEnum;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface PatioRepositorio extends JpaRepository<Patio, Integer> {
//
//    @Query("from Patio pT where pT.setor = :SetorEnum")
//    List<Patio> findBySetor(SetorEnum setor);
//
//    @Query("from Patio pT where pT.vagas = :idVagas")
//    List<Patio> findByVagas(int idVagas);
//
//    @Query("from Patio pT where pT.moto = :idMoto")
//    List<Patio> findByMoto(int idMoto);
//
//}
