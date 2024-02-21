/*
  This is your site JavaScript code - you can add interactivity!
*/
//iife
let employees = (async()=>{
const response = await window.fetch("http://localhost:8080/getAll",{
			method:"GET",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },})
   return await response.json()})()
employees.then((r)=>{
	 var list = r.sort((e1,e2)=>e1.empId-e2.empId);
	 //console.log(list)
	const placement = document.getElementById("placement");
	placement.innerHTML="";
	var all = list.map((e)=>`<tr><td>${e.empId}</td><td>${e.salary}</td><td>${e.firstName}</td><td>${e.lastName}</td></tr>`)
	.reduce((accum,curr)=>accum+curr)
	placement.innerHTML=all
	const forms = document.getElementsByTagName("form");
	const buttons = document.getElementsByTagName("button");
	let stuff = []
	stuff[0]=forms.item(0)
	stuff[1]=forms.item(1)
	stuff[2]=document.getElementsByTagName("table").item(0)
	stuff[3]=forms.item(2)
	stuff[4]=forms.item(3)
	//console.log(buttons)
	function get(empId){
		var id = empId
		var e 
		for(emp of r){
			//console.log(emp, id)
			if(id==emp.empId)
				e=emp
		}
		//console.log(r,e)
		if(e) {
			placement.innerHTML=`<tr><td>${e.empId}</td><td>${e.salary}</td><td>${e.firstName}</td><td>${e.lastName}</td></tr>`
			buttons.item(1).classList.toggle('dipped')
			stuff[1].className='toggle'
			stuff[2].className=''
		}
		else{ alert("Get Error: Doesn't exist with id"+id+".Consider making one")}
	}
	function getAll(){
		placement.innerHTML="";
		var text = list.map((e)=>`<tr><td>${e.empId}</td><td>${e.salary}</td><td>${e.firstName}</td><td>${e.lastName}</td></tr>`).reduce((accum,curr)=>accum+curr)
		placement.innerHTML=text
	}
	function exist(id){
		for(emp of r){
			//console.log(emp, id)
			if(id==emp.empId)
				return true
		 }
		 return false
	}
	function saveValidate(e){
		console.log(e.target[0].value)
		var id = e.target[0].value
		if(exist(id)) {
			alert('Add Error: This user already exists')
			e.preventDefault()
		}		
		else{
			console.log('Does not exist with id:'+id)
		}
	}
	function updateValidate(e){
		console.log(e.target[0].value)
		var id = e.target[0].value
		if(!exist(id)) {
			alert('Update Error: This user does not already exists with id'+id)
			e.preventDefault()
		}		
		else{
			console.log('Exists with id:'+id)
		}
	}
	function deleteValidate(e){
		//console.log(e.target[0].value)
		var id = e.target[0].value
		if(!exist(id)) {
			alert('Delete Error: This user does not exist with id:'+id)
			e.preventDefault()
		}		
		else{
			console.log('Does exist with id:'+id)
		}
	}
	var prev, active=2;
	//validate before submit
	//get is special
	buttons[6].addEventListener('click',(e)=>{get(e.target.form[0].value);e.preventDefault()})
	forms[0].addEventListener('submit',(e)=>{console.log(e);saveValidate(e)})
	stuff[3].addEventListener('submit',(e)=>{console.log(e);updateValidate(e)})
	stuff[4].addEventListener('submit',(e)=>{console.log(e);deleteValidate(e)})
	//console.log(stuff)
	for(let i in stuff){
	  buttons.item(i).addEventListener('click',()=>{
		  active = i
	    stuff.reduce((_,curr,index)=>{
	     index==i?curr.classList='':curr.classList='toggle'
	     //console.log(`prev:${prev} active:${active}, index:${index}, i:${i}`)
	     if(active==index){
			 if(prev)
			 buttons.item(prev).classList.toggle('dipped')
			 prev=active
			buttons.item(active).classList.toggle('dipped')
		}
	     if(index==2)getAll()
	    },0)
	  })
	}
})