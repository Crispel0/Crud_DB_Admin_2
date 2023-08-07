
async function registrarUsuario(){
	information = {}
		
	information.nombre = document.getElementById("primerNombre").value
	information.tiempo = document.getElementById("tiempo").value
	information.instructor = document.getElementById("instructor").value
	information.email = document.getElementById("email").value
	information.password = document.getElementById("password").value

	
	
  const request = await fetch('api/cursos', { //call the same method that the function of getUsuarios only change the method
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
        body: JSON.stringify(information) //take the dates and convert this dates in JSON for middle of the function stringify
  });
  
  alert("Correctamente Registrado")
  window.location.href= "login.html"

}
	


