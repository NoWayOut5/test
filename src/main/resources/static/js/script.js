"use sctrict";

let urlHost = window.location.origin;
if (window.location.port.length == 0) {
    urlHost = 'http://localhost:9080/';
}

// Сохраним клиента
const btnsaveClient = document.getElementById('saveClient');
if (btnsaveClient) {
    btnsaveClient.addEventListener('click', () => {

        const clientData = {
            name: document.getElementById('client').value,
        };

        try {
            fetch(`${urlHost}/client/save`, {
                    method: 'POST',
                    body: JSON.stringify(clientData),
                    headers: {
                        'Content-type': 'application/json'
                    }
                })
                .then((response) => response.json())
                .then(data => console.log(data));
            alert('Запись сохранена!');
        } catch (e) {
            alert(e);
        }
    });
}

// Сохраним звонок
const btnsaveCall = document.getElementById('saveCall');
if (btnsaveCall) {
    btnsaveCall.addEventListener('click', () => {

        const callData = {
            name: document.getElementById('caller').value,
            phone: document.getElementById('phone').value,
            clientid: '1',
            userid: '1',
        };

        try {
            fetch(`${urlHost}/call/save`, {
                    method: 'POST',
                    body: JSON.stringify(callData),
                    headers: {
                        'Content-type': 'application/json'
                    }
                })
                .then(response => response.json())
                .then(data => console.log(data));
            alert('Запись сохранена!');
        } catch (e) {
            alert(e);
        }
    });
}

// Вывести всех клиентов
const getResource = async (url) => {
    const res = await fetch(url);
    if (!res.ok) {
        throw new Error(`Could not fetch ${url}, status: ${res.status}`);
    }
    return await res.json();
};

const clientList = document.getElementById("clientList");
getResource(`${urlHost}/client/findall`)
    .then(function (data) {
        for (var i = 0; i < data.length; i++) {
            if (clientList != null && data[i].name != null) {
                let newOption = new Option(data[i].name, data[i].name);
                clientList.append(newOption);
            }
        }
    });