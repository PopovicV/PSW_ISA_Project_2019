package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.Dijagnoza;
import isapsw.team55.ClinicalCenter.domain.Korisnik;
import isapsw.team55.ClinicalCenter.domain.Pacijent;
import isapsw.team55.ClinicalCenter.service.DijagnozaService;
import isapsw.team55.ClinicalCenter.service.PacijentService;
import isapsw.team55.ClinicalCenter.service.ZdravstveniKartonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.util.List;

@Controller
@RequestMapping(value = "api/dijagnoza")
public class DijagnozaController {

    @Autowired
    private DijagnozaService dijagnozaService;

    @Autowired
    private ZdravstveniKartonService zdravstveniKartonService;

    @Autowired
    private PacijentService pacijentService;


    }
