package model;

public class JavaBeans {
private String cpf;
private String numero;
private String tipo;
private String sttus;
private String categoria;
private String tipoMov;
private String dataInicio;
private String horaInicio;
private String dataFim;
private String horaFim;
private String  mov;
private String em;
private String des;
private String gin;
private String gout;
private String rep;
private String pes;
private String sca;




public JavaBeans(String cpf, String numero, String tipo, String sttus, String categoria, String tipoMov,
		String dataInicio, String horaInicio, String dataFim, String horaFim, String mov, String em, String des,
		String gin, String gout, String rep, String pes, String sca) {
	super();
	this.cpf = cpf;
	this.numero = numero;
	this.tipo = tipo;
	this.sttus = sttus;
	this.categoria = categoria;
	this.tipoMov = tipoMov;
	this.dataInicio = dataInicio;
	this.horaInicio = horaInicio;
	this.dataFim = dataFim;
	this.horaFim = horaFim;
	this.mov = mov;
	this.em = em;
	this.des = des;
	this.gin = gin;
	this.gout = gout;
	this.rep = rep;
	this.pes = pes;
	this.sca = sca;
}




public JavaBeans() {
	super();
	// TODO Auto-generated constructor stub
}




public JavaBeans(String cpf, String mov, String em, String des, String gin, String gout, String rep, String pes,
		String sca) {
	super();
	this.cpf = cpf;
	this.mov = mov;
	this.em = em;
	this.des = des;
	this.gin = gin;
	this.gout = gout;
	this.rep = rep;
	this.pes = pes;
	this.sca = sca;
}




public JavaBeans(String em, String des, String gin, String gout, String rep, String pes, String sca, String mov,
		String dataInicio, String horaInicio, String dataFim, String horaFim, String cpf) {
	super();
	
	
	this.cpf = cpf;
	this.dataInicio = dataInicio;
	this.horaInicio = horaInicio;
	this.dataFim = dataFim;
	this.horaFim = horaFim;
	this.mov = mov;
	this.em = em;
	this.des = des;
	this.gin = gin;
	this.gout = gout;
	this.rep = rep;
	this.pes = pes;
	this.sca = sca;
}




public String getCpf() {
	return cpf;
}




public void setCpf(String cpf) {
	this.cpf = cpf;
}




public String getNumero() {
	return numero;
}




public void setNumero(String numero) {
	this.numero = numero;
}




public String getTipo() {
	return tipo;
}




public void setTipo(String tipo) {
	this.tipo = tipo;
}




public String getSttus() {
	return sttus;
}




public void setSttus(String sttus) {
	this.sttus = sttus;
}




public String getCategoria() {
	return categoria;
}




public void setCategoria(String categoria) {
	this.categoria = categoria;
}




public String getTipoMov() {
	return tipoMov;
}




public void setTipoMov(String tipoMov) {
	this.tipoMov = tipoMov;
}




public String getDataInicio() {
	return dataInicio;
}




public void setDataInicio(String dataInicio) {
	this.dataInicio = dataInicio;
}




public String getHoraInicio() {
	return horaInicio;
}




public void setHoraInicio(String horaInicio) {
	this.horaInicio = horaInicio;
}




public String getDataFim() {
	return dataFim;
}




public void setDataFim(String dataFim) {
	this.dataFim = dataFim;
}




public String getHoraFim() {
	return horaFim;
}




public void setHoraFim(String horaFim) {
	this.horaFim = horaFim;
}




public String getMov() {
	return mov;
}




public void setMov(String mov) {
	this.mov = mov;
}




public String getEm() {
	return em;
}




public void setEm(String em) {
	this.em = em;
}




public String getDes() {
	return des;
}




public void setDes(String des) {
	this.des = des;
}




public String getGin() {
	return gin;
}




public void setGin(String gin) {
	this.gin = gin;
}




public String getGout() {
	return gout;
}




public void setGout(String gout) {
	this.gout = gout;
}




public String getRep() {
	return rep;
}




public void setRep(String rep) {
	this.rep = rep;
}




public String getPes() {
	return pes;
}




public void setPes(String pes) {
	this.pes = pes;
}




public String getSca() {
	return sca;
}




public void setSca(String sca) {
	this.sca = sca;
}






}
