package com.taller.gestion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.gestion.Model.Reparacion;
import com.taller.gestion.Repository.ReparacionRepository;

import java.util.List;
import java.util.Optional;
//Anotamos la clase como un servicio
@Service
public class ReparacionService {
//Declaramos una variable privada de la del tipo ReparacionRepository que interactuará con la base de datos
	@Autowired 
	private ReparacionRepository reparacionRepository;
	
//Guardar reparacion
//El método recibe por parámetro un objeto de tipo(entidad) Reparacion 
	public Reparacion saveReparacion (Reparacion reparacion) {
//Ese objeto es guardado a traves del método save() que facilita el objeto de la interfaz ReparacionRepository
		return reparacionRepository.save(reparacion);
	}
	
//Listar
	public List<Reparacion> findAllReparaciones(){
/*De nuevo a través del objeto de la interfaz ReparacionRepository aplicamos uno de los nétodos que nos facilita dicha 
interfaz en este caso findAll() nos devuelve una lista de todos los elementos*/		
		return reparacionRepository.findAll();
	}
	
//Busca reparacion por su id
	public Reparacion findReparacionById(Long id) {
/*Usaremos un objeto de la Clase Optional ya que es posible que el elemento buscado no se encuentre en la lista, con 
 esto evitaremos errores (NullPointeException) ya que la ausencia de un valor puede ser un resultado posible
 * Cuando trabajamos en el contexto de ReparacionRepository:
 * Optional<Reparacion> es la variable que se declara y optionalReparacion el nombre de dicha variable. Esta variable
 optionalReparacion puede contener un objeto de tipo Reparacion o estar vacío.
 * Finalmente findById() devuelve un elemento Optional<Reparacion> por lo que al buscar por el id el resultado
 puede ser que encuentre una reparación con ese id o que el elemento este vacio (que no lo encuentre)*/
		Optional<Reparacion> optionalReparacion = reparacionRepository.findById(id);
/*Ya que optinonalReparacion es la variable que almacena el resultado de la busqueda podría contener un valor o 
no, usamos el método orElse() que se utiliza para obtener un valor exista o no, en caso que no exista devuelve null*/
		return optionalReparacion.orElse(null);//Devuelve si encuentra o null
	}
	
//Actualiza un elemento reparacion
/*El método devolverá un objeto Reparacion y recibe por parametro la id, y un objeto Reparacion que contiene los 
nuevos datos que se aplicarán al objeto existente sea el usuario o la app*/
	public Reparacion updateReparacion(Long id, Reparacion reparacionActualizada) {
		Optional<Reparacion> optionalReparacion = reparacionRepository.findById(id);//Se busca la reparacion
		if (optionalReparacion.isPresent()) {//Si existe
			Reparacion reparacion = optionalReparacion.get();/*Se obtiene el objeto que representa la reparacion 
			a actualizar y se va modificando en cada atributo*/
			reparacion.setFechaEntrada(reparacionActualizada.getFechaEntrada());
			reparacion.setDescripcion(reparacionActualizada.getDescripcion());
			reparacion.setHorasInvertidas(reparacionActualizada.getHorasInvertidas());
			reparacion.setMaterial(reparacionActualizada.getMaterial());
			reparacion.setVehiculo(reparacionActualizada.getVehiculo());//Asociamos el vehiculo
			reparacion.setEmpleado(reparacionActualizada.getEmpleado());//Asociamos el empleado
			return reparacionRepository.save(reparacion);//Guarda la reparacion actualizada en el repositorio
		}
		return null;//Si el Optional estaba vacío devuelve null
	}
	
//Eliminar una reparacion por su id
	public void deleteById(Long id) {
		reparacionRepository.deleteById(id);
		System.out.println("SE HA ELIMINADO EL REGISTRO DE REPARACION: " + id);
	}
}
