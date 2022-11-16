package kodlama.io.devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@RestController 
@RequestMapping("/api/languages")
public class LanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public LanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(ProgrammingLanguage language) throws Exception{
		programmingLanguageService.add(language);
	}
	
	@PutMapping("/update")
	public void update(ProgrammingLanguage language) {
		programmingLanguageService.update(language);
	}
	
	@DeleteMapping("/delete")
	public void delete(ProgrammingLanguage language) {
		programmingLanguageService.delete(language);
	}
	
	@GetMapping("/{id}")
	public ProgrammingLanguage getById(@PathVariable int id) throws Exception {
		return programmingLanguageService.getById(id);
	}
}
