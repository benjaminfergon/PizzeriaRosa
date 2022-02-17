package com.proyecto.dam.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.dam.model.Mesa;
import com.proyecto.dam.model.Usuario;
import com.proyecto.dam.service.IMesaService;
import com.proyecto.dam.service.IUsuarioService;

@Controller
@RequestMapping("/mesas")
public class MesaController {

	private final Logger LOGGER = LoggerFactory.getLogger(MesaController.class);

	@Autowired
	private IMesaService mesaService;

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("")
	public String create(Model model) {

		return "usuario/reservarMesa";
	}

	@PostMapping("/save")
	public String save(Mesa mesa, HttpSession session, RedirectAttributes flash) throws IOException {
		LOGGER.info("Este es el objeto mesa {}", mesa);

		Usuario u = usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();

		mesa.setUsuario(u);

		mesaService.save(mesa);

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy ");
		String formattedDate = formatter.format(mesa.getFechaReserva());

		if (mesa.getCantidad() > 1) {
			flash.addFlashAttribute("success", "Ha Reservado  " + mesa.getCantidad() + " mesas el día: " + formattedDate
					+ " a las: " + mesa.getHoraReserva());
		} else {
			flash.addFlashAttribute("success",
					"Ha Reservado una mesa el día: " + formattedDate + " a las: " + mesa.getHoraReserva());
		}

		return "redirect:/mesas";
	}

}
