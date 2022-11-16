package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	private ProgrammingLanguageRepository languageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		if (programmingLanguage.getName().isEmpty()) {
			throw new Exception("Language name cannot be empty");
		} else if (isAlreadyExist(programmingLanguage.getName())) {
			throw new Exception("Language name is already exist");
		} else {
			languageRepository.add(programmingLanguage);
		}

	}

	private boolean isAlreadyExist(String name) {
		for (ProgrammingLanguage language : languageRepository.getAll()) {
			if (language.getName().equals(name)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		languageRepository.update(programmingLanguage);
	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) {
		languageRepository.delete(programmingLanguage);
	}

	@Override
	public ProgrammingLanguage getById(int id) throws Exception {
		return languageRepository.getById(id);
	}

}
