// Call the dataTables jQuery plugin
$(document).ready(function() {
	cargarCursos()
  $('#cursos').DataTable();
});

function cargarHeaders (){
	return {
		      'Accept': 'application/json',
		      'Content-Type': 'application/json',
		      'Authorization': localStorage.tokenJwt
	}
}

async function cargarCursos(){
	
	
  const request = await fetch('api/cursos', {
    method: 'GET',
    headers: cargarHeaders()
    
  });
  
  const cursos = await request.json();
  
  	let listaCursos;

  	//guarda cada curso de la lista de cursos en listaCursos y los muerstra en la tbala cursos donde cambia el body por lo que contiene htmlTable
	for(let curso of cursos){ 
		emailvalido = curso.email == null ? "-" : curso.email;

	  	botonEliminar = '<a href="#" onclick="eliminarCurso(' + curso.id+ ')" class="btn btn-danger btn-circle align-items-end"><i class="fas fa-trash"></i></a>'
		
		let htmltable =  '<tr><td>'+curso.id+'</td><td>'+curso.nombre+'</td><td>'+curso.tiempo+'</td><td>'+curso.instructor+
		'</td><td>'+ emailvalido +'</td><td>'+ botonEliminar + '</td></tr>'
		listaCursos += htmltable;
	}	
	
	document.querySelector('#cursos tbody').outerHTML = listaCursos;
}
	
	 async function eliminarCurso(id){
		 
		request = await fetch('api/cursos/' + id, {
		    method: 'DELETE',
		    headers: cargarHeaders()
  });
  
 location.reload();
}
  
  
		
  
  		

	


