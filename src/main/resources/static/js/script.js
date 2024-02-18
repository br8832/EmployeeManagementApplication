/*
  This is your site JavaScript code - you can add interactivity!
*/

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
	 console.log(list)
const placement = document.getElementById("placement");
placement.innerHTML="";
var all = list.map((e)=>`<tr><td>${e.empId}</td><td>${e.salary}</td><td>${e.firstName}</td><td>${e.lastName}</td></tr>`).reduce((accum,curr)=>accum+curr)
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
	var e = r[id-1]
	if(e) {
		placement.innerHTML=`<tr><td>${e.empId}</td><td>${e.salary}</td><td>${e.firstName}</td><td>${e.lastName}</td></tr>`
		buttons.item(1).classList.toggle('dipped')
		stuff[1].className='toggle'
		stuff[2].className=''
	}
	else{ alert("Doesn't exist")}
}
function getAll(){
	placement.innerHTML="";
	var text = list.map((e)=>`<tr><td>${e.empId}</td><td>${e.salary}</td><td>${e.firstName}</td><td>${e.lastName}</td></tr>`).reduce((accum,curr)=>accum+curr)
	placement.innerHTML=text
}
var prev, active=2;
//get is special
buttons[6].addEventListener('click',(e)=>{get(e.target.form[0].value);e.preventDefault()})
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