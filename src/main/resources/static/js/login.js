$(document).ready(function(){
	//
});
async function iniciarSesion(){
	informacion = {}
		
informacion.email =  document.getElementById("inputEmail").value
informacion.password = document.getElementById("password").value	
	

   const request = await fetch('api/login', { //call the same method that the function of getUsuarios only change the method
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
        body: JSON.stringify(informacion)
  });
  const respuesta = await request.text()
  
  if(respuesta != "no concuerdan credenciales"){
	  localStorage.token = respuesta
	  localStorage.email = informacion.password
	  
	  window.location.href = "/cursos.html"
  }else
  	alert("autoentificacion incorrecta intentalo de nuevo");

  
    		
}
	


