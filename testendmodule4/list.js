showAllList()

function showAllList() {
    $.ajax({
        method: "get",
        url: "http://localhost:8080/api/land",
        success: function (data) {
            let arrLand = data.map((c, i, arr) => {
                return `
        <tr>
        <td>${c.code}</td>
        <td>${c.customer.name}</td>
        <td>${c.type}</td>
        <td>${c.date}</td>
        <td>${c.price}</td>
        <td>${c.acreage}</td>
        <td><button onclick="showformDetail(${c.id})">detail</button></td>
        
        </tr>
        `;
            });
            $("#tableland").html(arrLand.join(""))
        }
    })
}

function showformDetail(id) {
    $.ajax({
        method: "get",
        url: "http://localhost:8080/api/land/" + id,
        success: function (data) {
            $("#landDetail").html(`
            <table>
                <tr>
                    <th colSpan={2}>Details</th>

                </tr>
                <tr>
                    <td>Code</td>
                    <td>${data.code}</td>
                </tr>
                <tr>
                    <td>Type</td>
                    <td>${data.type}</td>
                </tr>
                <tr>
                    <td>Date</td>
                    <td>${data.date}</td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td>${data.price}</td>
                </tr>
                <tr>
                    <td>Acreage</td>
                    <td>${data.acreage}</td>
                </tr>
                <tr>
                    <td>Customer Name</td>
                    <td>${data.customer.name}</td>
                </tr>
                <tr>
                    <td>Customer Phone</td>
                    <td>${data.customer.phone}</td>
                </tr>
                <tr>
                    <td>Customer Email</td>
                    <td>${data.customer.email}</td>
                </tr>
                <tr>
                <td></td>
                <td><button onClick="deleteLand(${data.id})">Delete</button></td>
                    <td><button onClick="hideDetail()">Back</button></td>
                    
                </tr>
            </table>
                `)
        }
    })

}
function hideDetail(){
    $("#landDetail").hide()
}

function deleteLand(id) {
    $.ajax({
        method: "delete",
        url: "http://localhost:8080/api/land/" + id,
        success: function () {
            showAllList()
            $("#landDetail").hide()
        }
    })
}
function hideCreate(){
    $("#formcreate").hide()
}
function showFormCre() {
    $("#formcreate").show()
}

function createNewLand() {
        let code = document.getElementById("code").value;
        let customerid = document.getElementById("name").value;
        let type = document.getElementById("type").value;
        let date = document.getElementById("date").value;
        let price = document.getElementById("price").value;
        let acreage = document.getElementById("acreage").value;
        let customer = {
            "code": code,
            "customer": {
                "id": customerid

            },
            "type": type,
            "date": date,
            "price": price,
            "acreage": acreage
        }
        $.ajax({
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            method: "post",
            url: "http://localhost:8080/api/land",
            data: JSON.stringify(customer),
            success: function () {
                // showAllList()
            }
        })
}