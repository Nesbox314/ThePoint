package utils;

import markers.Hour;

public class WorkCalculator {
	
	public Hour calculaHoraSaida(Hour horaEntrada, Hour horaSaidaAlmoco, Hour horaVoltaAlmoco) {
		Hour cargaTrabalho = new Hour();
		cargaTrabalho.setHoras(8);
		cargaTrabalho.setMinutos(45);
		
		Hour saldoManha = new Hour();
		saldoManha = subtraiHora(horaEntrada, horaSaidaAlmoco);
		
		Hour saldoHorarioSaida = new Hour();
		saldoHorarioSaida = subtraiHora(saldoManha, cargaTrabalho);
		
		Hour horarioDeSaida = new Hour();
		horarioDeSaida = adicionaHora(saldoHorarioSaida, horaVoltaAlmoco);
		
		return horarioDeSaida;
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
}
