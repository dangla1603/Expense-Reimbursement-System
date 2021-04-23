


 let form1 = document.getElementById("formUpdateTicket");
form1.onsubmit = async (e) => {
/*e.preventDefault();*/
console.log( document.getElementById("thatReimId").value)
console.log( document.getElementById("reimb-type").value)

  const response = await fetch  ('http://localhost:9060/ticket/updateTicket', {
    method: "POST",
    headers: {
        'Content-Type': 'application/json',
    },

    body: JSON.stringify({
                            reimbId: document.getElementById("thatReimId").value,
                            statusId: document.getElementById("reimb-type").value
                             })

});


}

