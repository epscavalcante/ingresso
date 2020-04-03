package ingresso.runner;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import ingresso.dto.EstadoDto;
import ingresso.dto.MunicipioDto;
import ingresso.model.Bank;
import ingresso.model.BankAccountType;
import ingresso.model.City;
import ingresso.model.CivilState;
import ingresso.model.Deficiency;
import ingresso.model.Gender;
import ingresso.model.InstitutionType;
import ingresso.model.Modality;
import ingresso.model.Nationality;
import ingresso.model.Pole;
import ingresso.model.Race;
import ingresso.model.Sex;
import ingresso.model.State;
import ingresso.model.SuperiorCourse;
import ingresso.repository.BankAccountTypeRepository;
import ingresso.repository.BankRepository;
import ingresso.repository.CityRepository;
import ingresso.repository.CivilStateRepository;
import ingresso.repository.DeficiencyRepository;
import ingresso.repository.GenderRepository;
import ingresso.repository.InstitutionTypeRepository;
import ingresso.repository.ModalityRepository;
import ingresso.repository.NationalityRepository;
import ingresso.repository.PoleRepository;
import ingresso.repository.RaceRepository;
import ingresso.repository.SexRepository;
import ingresso.repository.StateRepository;
import ingresso.repository.SuperiorCourseRepository;

@Configuration
public class AppRunner implements ApplicationRunner {

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private BankRepository bankRepository;

	@Autowired
	private BankAccountTypeRepository bankAccountTypeRepository;

	@Autowired
	private CivilStateRepository civilStateRepository;

	@Autowired
	private DeficiencyRepository deficiencyRepository;

	@Autowired
	private GenderRepository genderRepository;

	@Autowired
	private NationalityRepository nationalityRepository;

	@Autowired
	private PoleRepository poleRepository;

	@Autowired
	private RaceRepository raceRepository;

	@Autowired
	private SexRepository sexRepository;

	@Autowired
	private SuperiorCourseRepository superiorCourseRepository;

	@Autowired
	private InstitutionTypeRepository institutionTypeRepository;

	@Autowired
	private ModalityRepository modalityRepository;

	@Transactional
	@Override
	public void run(ApplicationArguments args) throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";
		EstadoDto[] estados = restTemplate.getForObject(url, EstadoDto[].class);
		List<State> states = Stream.of(estados).map(e -> new State(e.getId(), e.getNome(), e.getSigla()))
				.collect(Collectors.toList());
		stateRepository.saveAll(states);

		for (State state : states) {
			url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/".concat(state.getId().toString())
					.concat("/municipios");
			MunicipioDto[] municipios = restTemplate.getForObject(url, MunicipioDto[].class);
			List<City> cities = Stream.of(municipios).map(m -> new City(m.getId(), m.getNome(), state))
					.collect(Collectors.toList());
			cityRepository.saveAll(cities);
		}

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		File file = new ClassPathResource("json/bank.json").getFile();
		List<Bank> banks = List.of(objectMapper.readValue(file, Bank[].class));
		bankRepository.saveAll(banks);

		file = new ClassPathResource("json/bankAccountType.json").getFile();
		List<BankAccountType> bankAccountTypes = List.of(objectMapper.readValue(file, BankAccountType[].class));
		bankAccountTypeRepository.saveAll(bankAccountTypes);

		file = new ClassPathResource("json/civilState.json").getFile();
		List<CivilState> civilStates = List.of(objectMapper.readValue(file, CivilState[].class));
		civilStateRepository.saveAll(civilStates);

		file = new ClassPathResource("json/deficiency.json").getFile();
		List<Deficiency> deficiencies = List.of(objectMapper.readValue(file, Deficiency[].class));
		deficiencyRepository.saveAll(deficiencies);

		file = new ClassPathResource("json/gender.json").getFile();
		List<Gender> genders = List.of(objectMapper.readValue(file, Gender[].class));
		genderRepository.saveAll(genders);

		file = new ClassPathResource("json/nationality.json").getFile();
		List<Nationality> nationalities = List.of(objectMapper.readValue(file, Nationality[].class));
		nationalityRepository.saveAll(nationalities);

		file = new ClassPathResource("json/pole.json").getFile();
		List<Pole> poles = List.of(objectMapper.readValue(file, Pole[].class));
		poleRepository.saveAll(poles);

		file = new ClassPathResource("json/race.json").getFile();
		List<Race> races = List.of(objectMapper.readValue(file, Race[].class));
		raceRepository.saveAll(races);

		file = new ClassPathResource("json/sex.json").getFile();
		List<Sex> sexes = List.of(objectMapper.readValue(file, Sex[].class));
		sexRepository.saveAll(sexes);

		file = new ClassPathResource("json/superiorCourse.json").getFile();
		List<SuperiorCourse> superiorCourses = List.of(objectMapper.readValue(file, SuperiorCourse[].class));
		superiorCourseRepository.saveAll(superiorCourses);

		file = new ClassPathResource("json/institutionType.json").getFile();
		List<InstitutionType> institutionTypes = List.of(objectMapper.readValue(file, InstitutionType[].class));
		institutionTypeRepository.saveAll(institutionTypes);

		file = new ClassPathResource("json/modality.json").getFile();
		List<Modality> modalities = List.of(objectMapper.readValue(file, Modality[].class));
		modalityRepository.saveAll(modalities);
	}

}
