package br.com.log.aplicacao;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.com.agenda.model.Log;
import br.com.log.dao.LogsDAO;


public class Main {

	public static void main(String[] args) {
		
		LogsDAO logDao = new LogsDAO();

		String caminho = "C:\\Users\\Japa\\Downloads\\access.log";
		try (BufferedReader br = new BufferedReader(new FileReader(caminho));) {
			String linha = br.readLine();

			while (linha != null) {

				String[] vect = linha.split("\\|");
				System.out.println(vect[0]);
				String data = vect[0];
				String ip = vect[1];
				String request = vect[2];
				int status = Integer.parseInt(vect[3]);
				String userAgent = vect[4];

				Log logs = new Log();
				logs.setData(data);
				logs.setIp(ip);
				logs.setRequest(request);
				logs.setStatus(status);
				logs.setUser_agent(userAgent);
				logDao.save(logs);
			}
		} catch (IOException e) {
			System.out.println("Erro:" + e.getMessage());
		}

	}
	
}
