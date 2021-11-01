/**
 * VALIDACAO DE FORMULARIO
 */


function validar(){
	if(frmConteiner){
		let cpf = frmConteiner.cpf.value
		let numero = frmConteiner.numero.value
		
		
		if(!isNaN(numero.substr(0,3))){
			alert("Preencha o numero do conteiner corretamente ex: ABCD1234567")
			frmConteiner.numero.focus()
			return false
		}else if(isNaN(numero.substr(4,10))){
			alert("Preencha o numero do conteiner corretamente ex: ABCD1234567")
			frmConteiner.numero.focus()
			return false
		} else if((cpf === "")||(cpf.length<11)) {
			alert("Preencha o numero do Cpf corretamente!")
			frmConteiner.cpf.focus()
			return false
		} else {
			document.forms["frmConteiner"]
		}
	}
}