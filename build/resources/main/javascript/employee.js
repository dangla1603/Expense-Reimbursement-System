
window.onload = function(){

    checkUser();

    document.getElementById('logout').addEventListener('click',logOutFunction)
  /*   document.getElementById("logout").addEventListener('click',logMeOut); */
}


/* function logMeOut(){
    const response2 = await fetch('http://localhost:9060/logout');

    let letMeOut = await response2.json();
} */

async function checkUser(){

     const response = await fetch(`http://localhost:9060/getUser`);

    let returnUser = await response.json();


    const response1 = await fetch(`http://localhost:9060/ticket/list`);
    let listTicket = await response1.json();

    let table = document.getElementById("reimbursementList");


    /* tableDOM(listTicket); */

    generateTable(listTicket,table); 
    userHeader(returnUser);


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
        txt += "<td>" + objectDOM[x].resolver + "</td>";
        txt += "<td>" + objectDOM[x].status + "</td>";
        txt += "<td>" + objectDOM[x].type + "</td>";
        txt += "<td>" + objectDOM[x].description + "</td></tr>";

    }
    document.getElementById("reimbursementList").innerHTML = txt;
    
}

function statusId(statusDOM){
    
}

const handleLogout = () => {
    window.localStorage.clear();
    window.location.reload(true);
    window.location.replace('/');
  };

   //Testing new function
function generateTable(json, table) {
   
    let tbody = document.getElementById("reimbursementList");
    for(let i = 0; i <json.length;i++){
        let row = tbody.insertRow(i);
        let cell1 = row.insertCell(0);
        let cell2 = row.insertCell(1);
        let cell3 = row.insertCell(2);
        let cell4 = row.insertCell(3);
        let cell5 = row.insertCell(4);
        let cell6 = row.insertCell(5);
        let cell7 = row.insertCell(6);

        /* let date = (new Date(json[i].submitted).toISOString().slice(0,10)); */
        cell1.innerHTML = json[i].reimbId;
        cell2.innerHTML = "$"+json[i].amount;
        cell3.innerHTML = json[i].submitted;
        cell4.innerHTML = json[i].userName;
        cell5.innerHTML = json[i].status;
        cell6.innerHTML = json[i].type;
        cell7.innerHTML = json[i].description;
        
        
        if(json[i].status == "Approved")
            cell5.innerHTML = json[i].status.fontcolor("green");
            
        if(json[i].status == "Denied")
            cell5.innerHTML = json[i].status.fontcolor("red");

            if(json[i].status == "Pending")
            cell5.innerHTML = json[i].status.fontcolor("FFE033");
        
    
}

}

function myFunction() {
    
    var input, filter, thisReimTable, tableRow, a, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    thisReimTable = document.getElementById("reimbursementList");
    tableRow = thisReimTable.getElementsByTagName("tr");
    for (i = 0; i < tableRow.length; i++) {
        a = tableRow[i].getElementsByTagName("td")[4];
        txtValue = a.textContent || a.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            tableRow[i].style.display = "";
        } else {
            tableRow[i].style.display = "none";
        }
    }
}



 /* function sortTable() {
    var filterTable, rows, sorted, i, x, y, sortFlag;
    filterTable = document.getElementById("reimbTable");
    sorted = true;
    while (sorted) {
       sorted = false;
       rows = filterTable.rows;
       for (i = 1; i < rows.length - 1; i++) {
          sortFlag = false;
          x = rows[i].getElementsByTagName("td")[0];
          y = rows[i + 1].getElementsByTagName("td")[0];
          if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
             sortFlag = true;
             break;
          }
       }
       if (sortFlag) {
          rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
          sorted = true;
       }
    }
 } */

 function logOutFunction(event){
     fetch('http://localhost:9060/logout')
    .then(
        () => location.href = "index.html"
    )
 }