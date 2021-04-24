package utils;

import markers.Hour;

public class WorkCalculator {
	
	public void calculaHoraSaida(Hour horaEntrada, Hour horaSaidaAlmoco, Hour horaVoltaAlmoco) {
		Hour saldoManha = new Hour();
		saldoManha = subtraiHora(horaEntrada, horaSaidaAlmoco);
		System.out.println("Horas: " + saldoManha.getHoras() + " Minutos: " + saldoManha.getMinutos());
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
			saldoMinutos = saldoMinutos - 1;
		}
		
		horarioSubtraido.setMinutos(saldoMinutos);
		horarioSubtraido.setHoras(saldoHoras);
		
		return horarioSubtraido;
	}
}
