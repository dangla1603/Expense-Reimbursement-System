function sortTable() {
    var filterTable, rows, sorted, i, x, y, sortFlag;
    filterTable = document.getElementById("reimbTable");
    sorted = true;
    while (sorted) {
       sorted = false;
       rows = filterTable.rows;
       for (i = 1; i < rows.length - 1; i++) {
          sortFlag = false;
          x = rows[i].getElementsByTagName("td")[2];
          y = rows[i + 1].getElementsByTagName("td")[2];
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
 }