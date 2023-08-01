
async function registrarUsuario(){
	information = {}
		
information.email =  document.getElementById("InputEmail").value
information.password = document.getElementById("Password").value	
	
  const request = await fetch('api/login', { //call the same method that the function of getUsuarios only change the method
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
        body: JSON.stringify(information)
  });
  
  const respuesta = await request.json();
    		
}
	


