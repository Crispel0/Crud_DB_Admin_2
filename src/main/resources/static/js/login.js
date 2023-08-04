$(document).ready(function(){
	//
});
async function iniciarSesion(){
	information = {}
		
information.email =  document.getElementById("inputEmail").value
information.password = document.getElementById("password").value	
	

   const request = await fetch('api/login', { //call the same method that the function of getUsuarios only change the method
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
        body: JSON.stringify(information)
  });
  const respuesta = await request.text()
  
  if(respuesta != "no concuerdan credenciales"){
	  localStorage.token = respuesta
	  localStorage.email = information.password
	  
	  window.location.href = "/cursos.html"
  }else
  	alert("autoentificacion incorrecta intentalo de nuevo men");

  
    		
}
	


