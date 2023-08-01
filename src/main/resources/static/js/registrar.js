
async function registrarUsuario(){
	information = {}
		
	information.nombre = document.querySelector("#primerNombre").value
	information.tiempo = document.querySelector("#tiempo").value
	information.instructor = document.querySelector("#instructor").value
	information.instructor = document.querySelector("#email").value
	information.instructor = document.querySelector("#password").value

	
	
  const request = await fetch('api/cursos', { //call the same method that the function of getUsuarios only change the method
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
        body: JSON.stringify(information) //take the dates and convert this dates in JSON for middle of the function stringify
  });
     		
}
location.reload() 
	


