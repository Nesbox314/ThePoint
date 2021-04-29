package utils;

import markers.Hour;

public class WorkCalculator {
	
	DateConverter dateConverter = new DateConverter();
	private Hour cargaTrabalho;
	
	public WorkCalculator(){
		setCargaTrabalho(new Hour(8, 45));
	}
	
	public Hour calculaHoraSaida(Hour horaEntrada, Hour horaSaidaAlmoco, Hour horaVoltaAlmoco) {
		Hour saldoManha = new Hour();
		saldoManha = subtraiHora(horaEntrada, horaSaidaAlmoco);
		
		Hour saldoHorarioSaida = new Hour();
		saldoHorarioSaida = subtraiHora(saldoManha, cargaTrabalho);
		
		Hour horarioDeSaida = new Hour();
		horarioDeSaida = adicionaHora(saldoHorarioSaida, horaVoltaAlmoco);
		
		return horarioDeSaida;
	}
	
	public void calculaHoraExtra(Hour horaEntrada, Hour horaSaidaAlmoco, Hour horaVoltaAlmoco, Hour horaSaida) {
		
		Hour saldoManha = new Hour();
		saldoManha = subtraiHora(horaEntrada, horaSaidaAlmoco);
		
		Hour saldoTarde = new Hour();
		saldoTarde = subtraiHora(horaVoltaAlmoco, horaSaida);
		
		Hour tempoTrabalhado = new Hour();
		tempoTrabalhado = adicionaHora(saldoManha, saldoTarde);

		subtraiHoraExtra(cargaTrabalho, tempoTrabalhado, horaSaida);
	}
	
	public Hour subtraiHora(Hour horaInicial, Hour horaFinal) {
		Hour horarioSubtraido = new Hour();
		
		//pegando os minutos
		int minutosInicial = horaInicial.getMinutos();
		int minutosFinal = horaFinal.getMinutos();
		//pegando as horas
		int horasInicial = horaInicial.getHoras();
		int horasFinal = horaFinal.getHoras();
		
		int saldoMinutos = minutosFinal - minutosInicial;
		int saldoHoras = horasFinal - horasInicial;
		
		if(saldoMinutos < 0) {
			saldoMinutos = saldoMinutos + 60;
			saldoHoras = saldoHoras - 1;
		}
		
		horarioSubtraido.setMinutos(saldoMinutos);
		horarioSubtraido.setHoras(saldoHoras);
		
		return horarioSubtraido;
	}
	
	public void subtraiHoraExtra(Hour horaInicial, Hour horaFinal, Hour horaSaida) {
		Boolean fezHoraExtra = identificadorDeHoraExtra(horaInicial, horaFinal);
		Hour quantidade = new Hour();
		
		if(fezHoraExtra == true) {
			quantidade = subtraiHora(horaInicial, horaFinal);
			System.out.println("Você fez horas positivas!");
			System.out.println("Início: " + dateConverter.dateFormatter(dateConverter.converteFormatoData(horaSaida)));
			System.out.println("Total: " + quantidade.getHoras() + "h" + quantidade.getMinutos() + "m");
		}
		
		if(fezHoraExtra == false) {
			quantidade = subtraiHora(horaFinal, horaInicial);
			System.out.println("Você fez horas negativas!");
			System.out.println("Início: " + dateConverter.dateFormatter(dateConverter.converteFormatoData(horaSaida)));
			System.out.println("Total: -" + quantidade.getHoras() + "h" + quantidade.getMinutos() + "m");
		}
	}
	
	public Hour adicionaHora(Hour horaInicial, Hour horaFinal) {
		Hour horarioSomado = new Hour();
		
		//pegando os minutos
		int minutosInicial = horaInicial.getMinutos();
		int minutosFinal = horaFinal.getMinutos();
		//pegando as horas
		int horasInicial = horaInicial.getHoras();
		int horasFinal = horaFinal.getHoras();
		
		int saldoMinutos = minutosFinal + minutosInicial;
		int saldoHoras = horasFinal + horasInicial;
		
		if(saldoMinutos >= 60) {
			saldoHoras = saldoHoras + 1;
			saldoMinutos = saldoMinutos - 60;
		}
		
		horarioSomado.setMinutos(saldoMinutos);
		horarioSomado.setHoras(saldoHoras);
		
		return horarioSomado;
	}
	
	public Boolean identificadorDeHoraExtra(Hour horaInicial, Hour horaFinal) {
		Hour horaExtraIdentify = subtraiHora(horaInicial, horaFinal);
		
		if(horaExtraIdentify.getHoras() == 0 ) {
			if(horaExtraIdentify.getMinutos() > 0) {
				return true;
			}
			 return false;
		}
		
		if(horaExtraIdentify.getHoras() < 0 ) {
			 return false;
		} else {
			return true;
		}
		
	}

	public Hour getCargaTrabalho() {
		return cargaTrabalho;
	}

	public void setCargaTrabalho(Hour cargaTrabalho) {
		this.cargaTrabalho = cargaTrabalho;
	}
}
