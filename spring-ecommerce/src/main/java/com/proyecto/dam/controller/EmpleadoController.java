package com.proyecto.dam.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.dam.model.Empleado;
import com.proyecto.dam.model.Usuario;
import com.proyecto.dam.service.IEmpleadoService;
import com.proyecto.dam.service.IUsuarioService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

	static List<String> cargoList = null;

	static {
		cargoList = new ArrayList<>();
		cargoList.add("Gerente");
		cargoList.add("Responsable de compras");
		cargoList.add("Jefe de cocina");
		cargoList.add("Jefe de turno o sección");
		cargoList.add("Cocinero");
		cargoList.add("Ayudante de cocina");
		cargoList.add("Jefe de sala");
		cargoList.add("Responsable de turno");
		cargoList.add("Encargado de caja");
		cargoList.add("Camarero de mesa");
		cargoList.add("Camarero de barra");
		cargoList.add("Equipo limpieza");
		cargoList.add("Equipo vigilancia");
		cargoList.add("Equipo aparca coches");

	}

	private final Logger LOGGER = LoggerFactory.getLogger(EmpleadoController.class);

	@Autowired
	private IEmpleadoService empleadoService;

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("empleados", empleadoService.findAll());
		return "empleados/show";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("cargoList", cargoList);
		return "empleados/create";
	}

	@PostMapping("/save")
	public String save(Empleado empleado, HttpSession session, RedirectAttributes flash) throws IOException {
		LOGGER.info("Este es el objeto empleado {}", empleado);

		Usuario u = usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();

		empleado.setUsuario(u);

		empleadoService.save(empleado);
		flash.addFlashAttribute("success", "Empleado guardado correctamente");
		return "redirect:/empleados";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Empleado empleado = new Empleado();
		Optional<Empleado> optionalProducto = empleadoService.get(id);
		empleado = optionalProducto.get();

		LOGGER.info("Empleado buscado: {}", empleado);
		model.addAttribute("cargoList", cargoList);
		model.addAttribute("empleado", empleado);

		return "empleados/edit";
	}

	@PostMapping("/update")
	public String update(Empleado empleado, RedirectAttributes flash) throws IOException {
		empleadoService.update(empleado);
		flash.addFlashAttribute("success", "Empleado con el id " + empleado.getId() + " actualizado correctamente");
		return "redirect:/empleados";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, RedirectAttributes flash) {

		empleadoService.delete(id);
		flash.addFlashAttribute("success", "Empleado borrado correctamente");
		return "redirect:/empleados";
	}

}
