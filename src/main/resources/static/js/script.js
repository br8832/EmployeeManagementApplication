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
// Me
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
buttons[6].addEventListener('click',(e)=>console.log(e))
for(let i in stuff){
  buttons.item(i).addEventListener('click',(e)=>{
    console.log(e)
    stuff.reduce((_,curr,index)=>{
      if(index==i){
          curr.classList=''
          buttons.item(i).classList.toggle('dipped')
      }else
      {
       curr.classList='toggle'
      }

    },0)
  })
}
})