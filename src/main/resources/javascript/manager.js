window.onload = function(){

    checkUser();

  /*   document.getElementById("logout").addEventListener('click',logMeOut); */
}


/* function logMeOut(){
    const response2 = await fetch('http://localhost:9060/logout');

    let letMeOut = await response2.json();
} */

async function checkUser(){

     const response = await fetch(`http://localhost:9060/getUser`);

    let returnUser = await response.json();
//    console.log(returnUser);

    const response1 = await fetch(`http://localhost:9060/ticket/allTickets`);
    let listTicket = await response1.json();
//    console.log(listTicket);
    let table = document.getElementById("reimb-data");



   

    /* tableDOM(listTicket); */

    
    userHeader(returnUser);
    
   
   generateTable(listTicket,table ); 
}

/* DOM Manipulation */

function userHeader(userDOM){

    document.getElementById('userHeader').innerText = "Welcome"+ " " +  userDOM.firstName + " "  +userDOM.lastName;
}

function tableDOM(objectDOM){

    let txt = "";
    
    for (x in objectDOM) {
        let date = (new Date(objectDOM[x].submitted).toISOString().slice(0,10));
       
        txt += "<tr><td>" + objectDOM[x].reimbId + "</td>";
        txt += "<td>" + objectDOM[x].amount + "</td>";
        txt += "<td>" + date + "</td>";
        txt += "<td>" + objectDOM[x].userName + "</td>";
        txt += "<td>" + objectDOM[x].status + "</td>";
        txt += "<td>" + objectDOM[x].type + "</td>";
        txt += "<td>" + objectDOM[x].description + "</td></tr>";

    }
    document.getElementById("reimb-data").innerHTML = txt;
    
}

function statusId(statusDOM){
    
}

const handleLogout = () => {
    window.localStorage.clear();
    window.location.reload(true);
    window.location.replace('/');
  };


  //Testing new function
function generateTable(json, user) {
   
    let tbody = document.getElementById("reimb-data");
    for(let i = 0; i <json.length;i++){
        let row = tbody.insertRow(i);
        let cell1 = row.insertCell(0);
        let cell2 = row.insertCell(1);
        let cell3 = row.insertCell(2);
        let cell4 = row.insertCell(3);
        let cell5 = row.insertCell(4);
        let cell6 = row.insertCell(5);
        let cell7 = row.insertCell(6);
        let cell8 = row.insertCell(7);

       /*  let date = (new Date(json[i].submitted).toISOString().slice(0,10)); */
        cell1.innerHTML = json[i].reimbId;
        cell2.innerHTML = "$"+json[i].amount;
        cell3.innerHTML = json[i].submitted;
       /*  let resolved = (new Date(json[i].submitted).toLocaleString()); */
        cell4.innerHTML = json[i].resolved;
        cell5.innerHTML = json[i].userName;
        cell6.innerHTML = json[i].status;
        cell7.innerHTML = json[i].type;
        cell8.innerHTML = json[i].description;

        if(json[i].status == "Approved")
        cell6.innerHTML = json[i].status.fontcolor("green");
        
        if(json[i].status == "Denied")
        cell6.innerHTML = json[i].status.fontcolor("red");

        if(json[i].status == "Pending")
        cell6.innerHTML = json[i].status.fontcolor("FFE033");

    }
    
      }

      function myFunction() {
    
        var input, filter, thisReimTable, tableRow, a, i, txtValue;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        thisReimTable = document.getElementById("reimb-data");
        tableRow = thisReimTable.getElementsByTagName("tr");
        for (i = 0; i < tableRow.length; i++) {
            a = tableRow[i].getElementsByTagName("td")[5];
            txtValue = a.textContent || a.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tableRow[i].style.display = "";
            } else {
                tableRow[i].style.display = "none";
            }
        }
    }
  
  
  