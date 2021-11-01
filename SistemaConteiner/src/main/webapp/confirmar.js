/**
 * Confirmação de exclusão de registro
 */




function confirmarC(){
	
	let numero = document.querySelector("#numero").value;
	let resposta = confirm("Confirma a exclusao desse registro?")
	if(resposta === true){
		window.location.href = "deleteConteiner?numero" + numero
	}
	
}
function confirmarM(){

	
	
		
	let resposta = confirm("Confirma a exclusao desse registro?")
	if(resposta === true){
		
		window.location.href = "deletaMovimentacao"
	}
	
}