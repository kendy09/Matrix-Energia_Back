package Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.matrixenergia.model.Logs;
import br.com.matrixenergia.repository.LogsRepository;


@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	LogsRepository logsRepository;
	
	@Autowired
	Logs logs;
	
	public void cadastrar() {
		
	
		
		String caminho = "C:\\Windows\\acess.log";
		try (BufferedReader br =new BufferedReader(new FileReader(caminho)); ) {
			String linha = br.readLine();

				while (linha != null) {

				String[] vect = linha.split("\\|");
				Date data = null;
				SimpleDateFormat inputFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
				try {
					data = inputFormat.parse(vect[0]);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				String ip = vect[1];
				String request = vect[2];
				int status = Integer.parseInt(vect[3]);
				String userAgent = vect[4];
				logs.setData(data);
				logs.setIp(ip);
				logs.setRequest(request);
				logs.setStatus(status);
				logs.setUserAgent(userAgent);
				logsRepository.save(logs);
				linha = br.readLine();
			}
			
		} catch (IOException e) {
			System.out.println("Erro:" + e.getMessage());
		}
	}
	
	@GetMapping("/ip/{ip}/data/{start}/{end}")
	public ResponseEntity<List<Logs>>findByDataAndIP(@RequestParam("ip") String ip,@RequestParam("start") Date start,@RequestParam("end") Date end){
		return ResponseEntity.ok(logsRepository.findByIpAndDataGreaterThanEqualAndDataLessThanEqual(ip, start, end));
	}
}
