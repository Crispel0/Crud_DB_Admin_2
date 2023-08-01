// Call the dataTables jQuery plugin
$(document).ready(function() {
	cargarCursos()
  $('#cursos').DataTable();
});

async function cargarCursos(){
	
	
  const request = await fetch('api/cursos', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
    
  });
  
  const cursos = await request.json();
  
  	let listaCursos;
  	
	for(let curso of cursos){ //guarda cada curso de la lista de cursos en listaCursos y los muerstra en la tbala cursos donde cambia el body por lo que contiene htmlTable
	  	botonEliminar = '<a href="#" onclick="eliminarCurso(' + curso.id+ ')" class="btn btn-danger btn-circle align-items-end"><i class="fas fa-trash"></i></a>'

		let htmltable =  '<tr><td>'+curso.id+'</td><td>'+curso.nombre+'</td><td>'+curso.tiempo+'</td><td>'+curso.instructor+
		'</td><td>'+ botonEliminar + '</td></tr>'
		listaCursos += htmltable;
	}	
	
	document.querySelector('#cursos tbody').outerHTML = listaCursos;
	}
	
	 async function eliminarCurso(id){
		 
		const request = await fetch('api/cursos/' + id, {
		    method: 'DELETE',
		    headers: {
		      'Accept': 'application/json',
		      'Content-Type': 'application/json'
		    }
  });
  
  location.reload();
		
  }
  		

	


