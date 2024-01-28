
package com.sistema.projetoTgid.repositories;

import com.sistema.projetoTgid.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
